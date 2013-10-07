package amu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import amu.model.Customer;

public class LogoutCustomerAction implements Action{

	@Override
	public ActionResponse execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute("customer");
		
		if(customer != null){
			session.invalidate();
			
		}
		ActionResponse actionResponse = new ActionResponse(ActionResponseType.REDIRECT, "loginCustomer");
		return actionResponse;
		
	}

}
