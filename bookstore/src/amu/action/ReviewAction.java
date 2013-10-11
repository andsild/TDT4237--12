package amu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import amu.database.BookDAO;
import amu.model.Book;
import amu.model.Customer;
import amu.model.Rating;

public class ReviewAction implements Action
{

	@Override
	public ActionResponse execute
	(HttpServletRequest request,
	HttpServletResponse response)
	throws Exception 
	{
		HttpSession session = request.getSession(true);
        Customer cCustomer = (Customer) session.getAttribute("customer");
        
        String sCustomerRating = request.getParameter("rating"),
        		sIsbn		   = request.getParameter("isbn");
        
        /* is customer verified properly? Is there anyway to bypass? */
		if( sCustomerRating != null
		&&	sIsbn	 		!= null
		&&	cCustomer 		!= null)
		{
			int iRating = Integer.parseInt(sCustomerRating); //XXX: need validation?
			Book bBook = new BookDAO().findByISBN(sIsbn);
			

			Rating rNewRating = new Rating(cCustomer, iRating, bBook.getId());
			
		}
		
		return null;
	}
}

// EOF