package amu.action;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import amu.database.BookDAO;
import amu.database.BookListDAO;
import amu.model.BookList;
import amu.model.Customer;

class AddBookToList implements Action {

	@Override
	public ActionResponse execute(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		Customer customer = (Customer) session.getAttribute("customer");

		if (customer == null) {
			ActionResponse actionResponse = new ActionResponse(
					ActionResponseType.REDIRECT, "loginCustomer");
			actionResponse.addParameter("from", "viewCustomer");
			return actionResponse;
		}
		if (request.getMethod() == "POST") {

			BookListDAO bookListDAO = new BookListDAO();
			BookDAO bookDAO = new BookDAO();
			try {
				bookListDAO.addBook(
						bookDAO.findByISBN(request.getParameter("isbn")),
						Integer.parseInt(request.getParameter("id")));
			} catch (Exception e) {
				return new ActionResponse(ActionResponseType.REDIRECT, "bookList");
			}
			

			ActionResponse r = new ActionResponse(ActionResponseType.REDIRECT,
					"viewBook");
			r.addParameter("isbn", request.getParameter("isbn"));
			return r;
		}
		return new ActionResponse(ActionResponseType.REDIRECT, "bookList");
	}
}
