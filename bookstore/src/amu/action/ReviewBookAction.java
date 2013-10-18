package amu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import amu.database.BookDAO;
import amu.database.ReviewDAO;
import amu.model.Book;
import amu.model.Cart;
import amu.model.Customer;
import amu.model.Review;

public class ReviewBookAction implements Action
{
	@Override
    public ActionResponse execute(HttpServletRequest request, HttpServletResponse response)
	throws Exception
	{
		HttpSession session = request.getSession(true);
		Customer cCustomer = (Customer) session.getAttribute("customer");
		
		String sIsbn = request.getParameter("isbn");
		ActionResponse ar = new ActionResponse(ActionResponseType.REDIRECT,
				"viewBook");
		ar.addParameter("isbn", sIsbn);
		
		String sReview = request.getParameter("review");
		
		if (sReview != null
		&& cCustomer != null
		&& sIsbn != null)
		{
			Book bBook = new BookDAO().findByISBN(sIsbn);
			Review rNewReview = new Review(cCustomer, sReview, bBook.getId());
			new ReviewDAO().register(rNewReview);
		}
		else
		{
			throw new Exception("could not register review");
		}
	
		return ar;
    }
    
}

/* EOF */