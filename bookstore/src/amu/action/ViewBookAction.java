package amu.action;

import amu.database.BookDAO;
import amu.database.RatingDAO;
import amu.model.Book;
import amu.model.Rating;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class ViewBookAction implements Action {

    @Override
    public ActionResponse execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	//TODO: should this page deal with the rating stuff, too?
        
        BookDAO bookDAO = new BookDAO();
        Book book = bookDAO.findByISBN(request.getParameter("isbn"));
        
        if (book != null) {
            request.setAttribute("book", book);
        }
       
        Integer iRate = new RatingDAO().getAverageRating(book.getId());
        if (iRate != null)
        	{request.setAttribute("averageRating", Integer.toString(iRate));}
        
        return new ActionResponse(ActionResponseType.FORWARD, "viewBook");
    }
}
