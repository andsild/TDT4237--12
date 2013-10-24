package amu.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import amu.Config;
import amu.FilterUnitException;
import amu.database.CreditCardDAO;
import amu.model.Cart;
import amu.model.CreditCard;
import amu.model.Customer;

class SelectPaymentOptionAction implements Action {

	@Override
	public ActionResponse execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		Customer customer = (Customer) session.getAttribute("customer");
		String creditCardID = request.getParameter("creditCardID");

		if (cart == null) {
			return new ActionResponse(ActionResponseType.REDIRECT, "viewCart");
		}

		if (customer == null) {
			ActionResponse actionResponse = new ActionResponse(ActionResponseType.REDIRECT, "loginCustomer");
			actionResponse.addParameter("from", "selectPaymentOption");
			return actionResponse;
		}

		if (cart.getShippingAddress() == null) {
			return new ActionResponse(ActionResponseType.REDIRECT, "selectShippingAddress");
		}

		CreditCardDAO creditCardDAO = new CreditCardDAO();

		// Handle credit card selection submission
		if (request.getMethod().equals("POST")) {
			try {
				Config.VALIDATE_NUMBERS.isValid(creditCardID);
			} catch (FilterUnitException e) {
				return new ActionResponse(ActionResponseType.REDIRECT, "reviewOrder");
			}
			cart.setCreditCard(creditCardDAO.read(Integer.parseInt(creditCardID)));
			return new ActionResponse(ActionResponseType.REDIRECT, "reviewOrder");
		}

		List<CreditCard> creditCards = creditCardDAO.browse(customer);
		request.setAttribute("creditCards", creditCards);

		// Else GET request
		return new ActionResponse(ActionResponseType.FORWARD, "selectPaymentOption");
	}

}
