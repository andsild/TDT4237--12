package amu.action;

import amu.BCrypt;
import amu.FilterUnit;
import amu.database.CustomerDAO;
import amu.model.Customer;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class LoginCustomerAction implements Action {

	private FilterUnit passwordValidator = FilterUnit.getPasswordValidator();
	private FilterUnit mailValidator = FilterUnit.getMailValidator();
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
        	
            Map<String, String> messages = new HashMap<String, String>();
            request.setAttribute("messages", messages);

            CustomerDAO customerDAO = new CustomerDAO();
            
            
            boolean isValidMail = false;
            boolean isValidPW 	= false; 
            
            values.put("email", request.getParameter("email"));
            try {
            	isValidMail = mailValidator.isValid(request.getParameter("email"));
            	isValidPW = passwordValidator.isValid(request.getParameter("password"));
			} catch (Exception e) {
				messages.put("error", "Password or Email was incorrect.");
				return new ActionResponse(ActionResponseType.FORWARD, "loginCustomer");
			}
            
            Customer customer = customerDAO.findByEmail(request.getParameter("email"));
            
            if (customer != null && isValidMail && isValidPW) {

                if (customer.getActivationToken() == null) {
                	if (BCrypt.checkpw(request.getParameter("password"), customer.getPassword())) {
                			HttpSession session = request.getSession(true);
                			session.setAttribute("customer", customer);
                			if (ActionFactory.hasKey(request.getParameter("from"))) {
                				return new ActionResponse(ActionResponseType.REDIRECT, request.getParameter("from"));
                			}
                		}
                    else { // Wrong password
                        messages.put("error", "Password or Email was incorrect.");
                    }
                } else { // customer.getActivationToken() != null
                    return new ActionResponse(ActionResponseType.REDIRECT, "activateCustomer");
                }
            } else { // findByEmail returned null -> no customer with that email exists
                messages.put("error", "Password or Email was incorrect.");
            }

            // Forward to login form with error messages
            return new ActionResponse(ActionResponseType.FORWARD, "loginCustomer");
        }

        return new ActionResponse(ActionResponseType.FORWARD, "loginCustomer");
    }
}
