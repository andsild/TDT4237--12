package amu.action;

import amu.Config;
import amu.database.BookListDAO;
import amu.model.Customer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class BookListAction implements Action {
    
    @Override
    public ActionResponse execute(HttpServletRequest request, HttpServletResponse response) {
    	HttpSession session = request.getSession(true);
        Customer customer = (Customer) session.getAttribute("customer");
    	
       	if (request.getParameter("id") != null) {
        	try {
        		Config.VALIDATE_NUMBERS.isValid(request.getParameter("id"));
        		request.setAttribute("bookList", new BookListDAO().findByID(Integer.parseInt(request.getParameter("id"))));
				
			} catch (Exception e) {
				System.out.println("exeption thrown");
				e.printStackTrace();
				return new ActionResponse(ActionResponseType.FORWARD, "bookList");
			}
		}else if (request.getParameter("customer") != null) {
			if (customer == null) {
	            ActionResponse actionResponse = new ActionResponse(ActionResponseType.REDIRECT, "loginCustomer");
	            actionResponse.addParameter("from", "bookList");
	            return actionResponse;
	        }
			try {
        		request.setAttribute("customerLists", new BookListDAO().getBooklists((customer.getId())));
				
			} catch (Exception e) {
				System.out.println("exeption thrown");
				e.printStackTrace();
				return new ActionResponse(ActionResponseType.FORWARD, "bookList");
			}
		}
       	request.setAttribute("bookListArray", new BookListDAO().getBooklists());
        return new ActionResponse(ActionResponseType.FORWARD, "bookList");
    }
    
}