package amu.action;

import amu.database.BookListDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class BookListAction implements Action {
    
    @Override
    public ActionResponse execute(HttpServletRequest request, HttpServletResponse response) {

       	if (request.getParameter("id") != null) {
        	try {
        		request.setAttribute("bookList", new BookListDAO().findByID(Integer.parseInt(request.getParameter("id"))));
				
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