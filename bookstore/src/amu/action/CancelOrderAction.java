package amu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import amu.database.OrderDAO;
import amu.model.Customer;
import amu.model.Order;

class CancelOrderAction implements Action {

	@Override
	public ActionResponse execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		Customer customer = (Customer) session.getAttribute("customer");
		Order order = (Order) session.getAttribute("order");
		OrderDAO orderDAO = new OrderDAO();

		if (customer == null || order == null) {
			return new ActionResponse(ActionResponseType.REDIRECT, "loginCustomer");
		}
		if (order.getStatus() == 0) {

			if (orderDAO.removeOrder(order)) {
				return new ActionResponse(ActionResponseType.REDIRECT, "cancelSuccess");
			}

		} else {
			request.getSession().setAttribute("error", "Could not cancel, order is " + order.getStatusText());
		}

		return new ActionResponse(ActionResponseType.REDIRECT, "cancelError");
	}

}
