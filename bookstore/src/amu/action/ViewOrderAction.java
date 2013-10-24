package amu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import amu.Config;
import amu.FilterUnitException;
import amu.database.OrderDAO;
import amu.model.Customer;
import amu.model.Order;

class ViewOrderAction implements Action {

    public ViewOrderAction() {
    }

    @Override
    public ActionResponse execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        OrderDAO orderDAO = new OrderDAO();
        Order order = null;
        
        if (customer == null)
        {
        	return new ActionResponse(ActionResponseType.REDIRECT, "loginCustomer");
        }
        
        
        if (request.getParameter("id") != null) 
        {
        	try
        	{
        		Config.VALIDATE_NUMBERS.isValid("id");
        	}
        	catch(FilterUnitException e)
        	{
        		return new ActionResponse(ActionResponseType.REDIRECT, "viewCustomer");
        	}
        	
			try {
				order = orderDAO.getOrder(customer, Integer.parseInt(request.getParameter("id")));
				session.setAttribute("cart", order.getCart());
				session.setAttribute("order", order);
			} catch (Exception e) {
				return new ActionResponse(ActionResponseType.REDIRECT, "viewCustomer");
			}
		}
        
        return new ActionResponse(ActionResponseType.FORWARD, "viewOrder");
    }
    
}
