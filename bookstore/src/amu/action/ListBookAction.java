package amu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import amu.database.BookDAO;

public class ListBookAction implements Action{

	@Override
    public ActionResponse execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        
        BookDAO bookDAO = new BookDAO();
        
        request.setAttribute("books", bookDAO.getListBooks());
        
        return new ActionResponse(ActionResponseType.FORWARD, "listBooks");       
	}
	
}
