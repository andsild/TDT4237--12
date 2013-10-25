package amu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import amu.Config;
import amu.FilterUnitException;
import amu.database.BookDAO;
import amu.database.RatingDAO;
import amu.model.Book;
import amu.model.Customer;
import amu.model.Rating;

public class RateAction implements Action {

	@Override
	public ActionResponse execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(true);
		Customer cCustomer = (Customer) session.getAttribute("customer");
		String sCustomerReview = request.getParameter("rating");
		String sIsbn = request.getParameter("isbn");

		if (cCustomer == null) {
			return new ActionResponse(ActionResponseType.REDIRECT, "loginCustomer");
		}

		ActionResponse ar = new ActionResponse(ActionResponseType.REDIRECT, "viewBook");
		ar.addParameter("isbn", sIsbn);

		try {
			Config.VALIDATE_NUMBERS.isValid(sIsbn);
			Config.VALIDATE_NUMBERS.isValid(sCustomerReview);
		} catch (FilterUnitException e) {
			return ar;
		}

		if (sCustomerReview != null && sIsbn != null && cCustomer != null) {
			Book bBook = new BookDAO().findByISBN(sIsbn);

			Rating rNewRating = new Rating(cCustomer, sCustomerReview, bBook.getId());
			new RatingDAO().register(rNewRating);
			request.setAttribute("book", bBook);
		}
		return ar;
	}
}

/* EOF */
