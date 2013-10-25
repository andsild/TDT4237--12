package amu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import amu.Config;
import amu.FilterUnitException;
import amu.database.CustomerDAO;
import amu.model.Customer;

class ActivateCustomerAction implements Action {

	@Override
	public ActionResponse execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String email, activationToken;

		email = request.getParameter("email");
		activationToken = request.getParameter("activationToken");

		if (email == null)
			return new ActionResponse(ActionResponseType.FORWARD, "activateCustomer");

		if (activationToken == null)
			request.setAttribute("email", email);
		else {
			try {
				Config.VALIDATE_EMAIL.isValid(email);
				Config.VALIDATE_TEXT_AND_NUMBERS.isValid(activationToken);
			} catch (FilterUnitException e) {
				return new ActionResponse(ActionResponseType.REDIRECT, "activationError");
			}

			CustomerDAO customerDAO = new CustomerDAO();
			Customer customer = customerDAO.findByEmail(email);

			if (customer != null && customer.getActivationToken().equals(activationToken)) {
				customer = customerDAO.activate(customer);
				return new ActionResponse(ActionResponseType.REDIRECT, "activationSuccessful");
			} else {
				return new ActionResponse(ActionResponseType.REDIRECT, "activationError");
			}
		}

		return new ActionResponse(ActionResponseType.FORWARD, "activateCustomer");
	}
}