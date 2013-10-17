package amu.action;

import amu.database.BookDAO;
import amu.database.BookListDAO;
import amu.database.RatingDAO;
import amu.model.Book;
import amu.model.Customer;
import amu.model.Rating;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class ViewBookAction implements Action {

	@Override
	public ActionResponse execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO: should this page deal with the rating stuff, too?
		HttpSession session = request.getSession(true);
		Customer customer = (Customer) session.getAttribute("customer");

		BookDAO bookDAO = new BookDAO();
		Book book = bookDAO.findByISBN(request.getParameter("isbn"));

		if (book != null) {
			request.setAttribute("book", book);
		}
		if (customer != null) {

			try {
				request.setAttribute("customerLists",
						new BookListDAO().getBooklists((customer.getId())));

			} catch (Exception e) {
				System.out.println("exeption thrown");
				e.printStackTrace();
				return new ActionResponse(ActionResponseType.FORWARD,
						"bookList");
			}

		}

		Integer iRate = new RatingDAO().getAverageRating(book.getId());
		if (iRate != null) {
			request.setAttribute("averageRating", Integer.toString(iRate));
		}

		return new ActionResponse(ActionResponseType.FORWARD, "viewBook");
	}
}
