package amu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import amu.model.Cart;
import amu.model.Customer;

class ReviewOrderAction implements Action {

	@Override
	public ActionResponse execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		Customer customer = (Customer) session.getAttribute("customer");

		if (cart == null) {
			return new ActionResponse(ActionResponseType.REDIRECT, "viewCart");
		}

		if (customer == null) {
			ActionResponse actionResponse = new ActionResponse(ActionResponseType.REDIRECT, "loginCustomer");
			actionResponse.addParameter("from", "reviewOrder");
			return actionResponse;
		}

		if (cart.getShippingAddress() == null) {
			return new ActionResponse(ActionResponseType.REDIRECT, "selectShippingAddress");
		}

		if (cart.getCreditCard() == null) {
			return new ActionResponse(ActionResponseType.REDIRECT, "selectPaymentOption");
		}

		return new ActionResponse(ActionResponseType.FORWARD, "reviewOrder");
	}

}
