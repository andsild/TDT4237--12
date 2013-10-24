package amu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import amu.database.BookDAO;

public class ListBookAction implements Action{

	@Override
    public ActionResponse execute(HttpServletRequest request, HttpServletResponse response) {
        BookDAO bookDAO = new BookDAO();
        
        request.setAttribute("books", bookDAO.getListBooks());
        
        return new ActionResponse(ActionResponseType.FORWARD, "listBooks");       
	}
	
}
