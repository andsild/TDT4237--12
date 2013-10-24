package amu.action;

import amu.BCrypt;
import amu.Config;
import amu.FilterUnit;
import amu.database.CustomerDAO;
import amu.model.Customer;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class LoginCustomerAction implements Action
{
	@Override
	public ActionResponse execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Map<String, String> messages = new HashMap<String, String>();
		Map<String, String> values = new HashMap<String, String>();
		request.setAttribute("values", values);
		String sFrom, sPassword, sEmail;

		sFrom = request.getParameter("from");
		sPassword = request.getParameter("password");
		sEmail = request.getParameter("email");

		try
		{
			Config.VALIDATE_EMAIL.isValid(sEmail);
			Config.VALIDATE_PASSWORD.isValid(sPassword);
		} catch (Exception e)
		{
			messages.put("error", "Password or Email was incorrect.");
			return new ActionResponse(ActionResponseType.FORWARD, "loginCustomer");
		}

		if (ActionFactory.hasKey(request.getParameter("from")))
			values.put("from", request.getParameter("from"));

		if (request.getMethod().equals("POST"))
		{
			HttpSession preSession = request.getSession();
			preSession.invalidate();

			request.setAttribute("messages", messages);

			CustomerDAO customerDAO = new CustomerDAO();

			values.put("email", sEmail);

			Customer customer = customerDAO.findByEmail(sEmail);

			if (customer != null)
				if (customer.getActivationToken() == null)
					if (BCrypt.checkpw(sPassword, customer.getPassword()))
					{
						HttpSession session = request.getSession(true);
						session.setAttribute("customer", customer);
						if (ActionFactory.hasKey(request.getParameter("from")))
							return new ActionResponse(ActionResponseType.REDIRECT, sFrom);
					}
					else
						messages.put("error", "Password or Email was incorrect.");
				else
					return new ActionResponse(ActionResponseType.REDIRECT, "activateCustomer");
			else
				messages.put("error", "Password or Email was incorrect.");

			// Forward to login form with error messages
			return new ActionResponse(ActionResponseType.FORWARD, "loginCustomer");
		}

		return new ActionResponse(ActionResponseType.FORWARD, "loginCustomer");
	}
}
