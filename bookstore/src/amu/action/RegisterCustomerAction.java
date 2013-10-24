package amu.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;
import amu.Config;
import amu.FilterUnitException;
import amu.Mailer;
import amu.database.CustomerDAO;
import amu.model.Customer;

class RegisterCustomerAction extends HttpServlet implements Action {

	@Override
	public ActionResponse execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		if (request.getMethod().equals("POST")) 
		{
			CustomerDAO customerDAO = new CustomerDAO();
			Customer customer = customerDAO.findByEmail(request.getParameter("email"));
			Map<String, String> messages = new HashMap<String, String>();
			
			
			request.setAttribute("messages", messages);

			if (customer == null) 
			{
				String remoteAddr = request.getRemoteAddr();
				ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
				reCaptcha.setPrivateKey(Config.CAPTCHA_PRIVATE_KEY);
				
				try
				{
					Config.VALIDATE_EMAIL.isValid(request.getParameter("email"));
					Config.VALIDATE_PASSWORD.isValid(request.getParameter("password"));
					Config.VALIDATE_TEXT.isValid((request.getParameter("name")));
					//Config.VALIDATE_TEXT_AND_NUMBERS.isValid(request.getParameter("recaptcha_challenge_field"));
					//Config.VALIDATE_TEXT_AND_NUMBERS.isValid(request.getParameter("recaptcha_response_field"));
				}
				catch(FilterUnitException e)
				{
					messages.put("error", "Invalid input");
					return new ActionResponse(ActionResponseType.REDIRECT,"registrationError");
				}

				String challenge = request.getParameter("recaptcha_challenge_field");
				String uresponse = request.getParameter("recaptcha_response_field");
				
				ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);

				if (reCaptchaResponse.isValid()) 
				{

					customer = new Customer();
					customer.setEmail(request.getParameter("email"));
					customer.setName(request.getParameter("name"));
					customer.setPassword(CustomerDAO.hashPassword(request.getParameter("password")));
					customer.setActivationToken(CustomerDAO.generateActivationCode());
					customer = customerDAO.register(customer);

					// TODO: tell customer when password is too long

					ActionResponse actionResponse = new ActionResponse(ActionResponseType.REDIRECT, "activateCustomer");
					actionResponse.addParameter("email", customer.getEmail());

					StringBuilder sb = new StringBuilder();
					sb.append("Welcome to Amu-Darya, the really insecure bookstore!\n\n");
					sb.append("To activate your account, click <a href='http://");
					sb.append(request.getServerName() + ":"
							+ request.getServerPort()
							+ request.getContextPath() + "/");
					sb.append(actionResponse.getURL()
							+ actionResponse.getParameterString());
					sb.append("&activationToken="
							+ customer.getActivationToken());
					sb.append("'>here</a>, or use this activation code: "
							+ customer.getActivationToken());

					Mailer.send(customer.getEmail(), "Activation required",
							sb.toString());

					return actionResponse;
				} else 
				{
					String error = reCaptchaResponse.getErrorMessage();
					if (error.equals("incorrect-captcha-sol")) {
						messages.put("error",
								"Incorrect captcha, please try again");
					} else if (error.equals("captcha-timeout")) {
						messages.put("error", "Captcha timeout");
					} else {
						messages.put("error",
								reCaptchaResponse.getErrorMessage());
					}
				}
			} else {
				return new ActionResponse(ActionResponseType.REDIRECT,
						"registrationError");
			}
		}

		// Else we show the register form
		return new ActionResponse(ActionResponseType.FORWARD,
				"registerCustomer");
	}
}
