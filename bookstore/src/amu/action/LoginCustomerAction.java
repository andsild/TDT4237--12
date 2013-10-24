package amu.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import amu.BCrypt;
import amu.Config;
import amu.database.CustomerDAO;
import amu.model.Customer;

class LoginCustomerAction implements Action {

	@Override
	public ActionResponse execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Map<String, String> values = new HashMap<String, String>();
		request.setAttribute("values", values);
		if (ActionFactory.hasKey(request.getParameter("from"))) {
			values.put("from", request.getParameter("from"));
		}

		if (request.getMethod().equals("POST")) {

			HttpSession preSession = request.getSession();
			preSession.invalidate();
			request.getSession(true);

			Map<String, String> messages = new HashMap<String, String>();
			request.setAttribute("messages", messages);

			CustomerDAO customerDAO = new CustomerDAO();

			values.put("email", request.getParameter("email"));
			try {
				Config.VALIDATE_EMAIL.isValid(request.getParameter("email"));
				Config.VALIDATE_PASSWORD.isValid(request.getParameter("password"));
			} catch (Exception e) {
				messages.put("error", "Password or Email was incorrect.");
				return new ActionResponse(ActionResponseType.FORWARD, "loginCustomer");
			}

			Customer customer = customerDAO.findByEmail(request.getParameter("email"));

			if (customer != null) {

				if (BCrypt.checkpw(request.getParameter("password"), customer.getPassword())) {
					if (customer.getActivationToken() == null) {
						HttpSession session = request.getSession(true);
						session.setAttribute("customer", customer);
						if (ActionFactory.hasKey(request.getParameter("from"))) {
							return new ActionResponse(ActionResponseType.REDIRECT, request.getParameter("from"));
						}
					} else { // customer.getActivationToken() != null
						return new ActionResponse(ActionResponseType.REDIRECT, "activateCustomer");
					}
				} else { // Wrong password
					messages.put("error", "Password or Email was incorrect.");
				}
			} else { // findByEmail returned null -> no customer with that email
						// exists
				messages.put("error", "Password or Email was incorrect.");
			}

			// Forward to login form with error messages
			return new ActionResponse(ActionResponseType.FORWARD, "loginCustomer");
		}

		return new ActionResponse(ActionResponseType.FORWARD, "loginCustomer");
	}
}
