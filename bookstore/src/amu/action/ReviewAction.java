package amu.action;

import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.faces.facelets.tag.jsf.core.ViewHandler;

import amu.database.BookDAO;
import amu.database.RatingDAO;
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
		//TODO: if logged out when comoing here, a 500 occurs
		HttpSession session = request.getSession(true);
        Customer cCustomer = (Customer) session.getAttribute("customer");
        
        String sCustomerRating = request.getParameter("rating"),
        		sIsbn		   = request.getParameter("isbn");
		ActionResponse ar = new ActionResponse(ActionResponseType.FORWARD, "viewBook");
        
        /* is customer verified properly? Is there anyway to bypass? */
		if( sCustomerRating != null
		&&	sIsbn	 		!= null
		&&	cCustomer 		!= null)
		{
			int iRating = 0;
			try
			{
				double dRating = Double.parseDouble(sCustomerRating); //XXX: need validation?
				iRating = (int) dRating;
			}
			catch(Exception e)
			{
				iRating = 5; //DEFAULT
				throw new Exception(sCustomerRating);
			}
			Book bBook = new BookDAO().findByISBN(sIsbn);

			Rating rNewRating = new Rating(cCustomer, Integer.toString(iRating), bBook.getId());
			new RatingDAO().register(rNewRating);
			request.setAttribute("book", bBook);
			//FIXME: doesn't reload the page like I want it to...
		}
		else {
			String sOutput = sCustomerRating +  " , " + sIsbn + ", " + cCustomer.toString();
			throw new Exception("COULD NOT REGISTER" + sOutput);
		}
		
		return ar;
	}
}

// EOF