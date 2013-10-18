package amu.action;

import java.util.ArrayList;

import amu.database.BookDAO;
import amu.database.BookListDAO;
import amu.database.RatingDAO;
import amu.database.ReviewDAO;
import amu.model.Book;
import amu.model.Customer;
import amu.model.Rating;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class ViewBookAction implements Action {

    @Override
    public ActionResponse execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	//TODO: should this page deal with the rating stuff, too?
    	
    	HttpSession session = request.getSession(true);
        Customer cCustomer = (Customer) session.getAttribute("customer");
        
        BookDAO bookDAO = new BookDAO();
        Book book = bookDAO.findByISBN(request.getParameter("isbn"));
        
        Integer iAverageRate = null,
        		iCustRate = null;
        
        //TODO: get all reviews for THIS
        
        if (book != null) {
            request.setAttribute("book", book);
        	iAverageRate = new RatingDAO().getAverageRating(book.getId());
        }
        
        if (cCustomer != null)
        {
        	/* Get previous rating */
        	iCustRate = new RatingDAO().getRating(cCustomer.getId(), book.getId());
        	request.setAttribute("rating", iCustRate);
        }
        
        if (iAverageRate != null)
        	{request.setAttribute("averageRating", Integer.toString(iAverageRate));}
        
        return new ActionResponse(ActionResponseType.FORWARD, "viewBook");
    }
}

/* EOF */