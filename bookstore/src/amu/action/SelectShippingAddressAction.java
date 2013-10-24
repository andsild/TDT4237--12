package amu.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import amu.Config;
import amu.FilterUnitException;
import amu.database.AddressDAO;
import amu.model.Address;
import amu.model.Cart;
import amu.model.Customer;

class SelectShippingAddressAction implements Action {

	@Override
	public ActionResponse execute(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		Customer customer = (Customer) session.getAttribute("customer");
		String id = request.getParameter("id");

		if (cart == null) {
			return new ActionResponse(ActionResponseType.REDIRECT, "viewCart");
		}

		if (customer == null) {
			ActionResponse actionResponse = new ActionResponse(ActionResponseType.REDIRECT, "loginCustomer");
			actionResponse.addParameter("from", "selectShippingAddress");
			return actionResponse;
		}

		AddressDAO addressDAO = new AddressDAO();

		// Handle shipping address selection submission
		if (id != null) {
			try {
				Config.VALIDATE_NUMBERS.isValid(id);
			} catch (FilterUnitException e) {
				return new ActionResponse(ActionResponseType.REDIRECT, "selectPaymentOption");
			}

			cart.setShippingAddress(addressDAO.read(Integer.parseInt(id), customer.getId()));
			return new ActionResponse(ActionResponseType.REDIRECT, "selectPaymentOption");
		}

		List<Address> addresses = addressDAO.browse(customer);
		request.setAttribute("addresses", addresses);

		// Else GET request
		return new ActionResponse(ActionResponseType.FORWARD, "selectShippingAddress");
	}
}
