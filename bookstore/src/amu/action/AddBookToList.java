package amu.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import amu.Config;
import amu.database.BookDAO;
import amu.database.BookListDAO;
import amu.model.Customer;

class AddBookToList implements Action {

	@Override
	public ActionResponse execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		Customer customer = (Customer) session.getAttribute("customer");

		ArrayList<String> messages = new ArrayList<String>();
		session.setAttribute("messages", messages);

		if (customer == null) {
			ActionResponse actionResponse = new ActionResponse(ActionResponseType.REDIRECT, "loginCustomer");
			actionResponse.addParameter("from", "viewCustomer");
			return actionResponse;
		}
		if (request.getMethod() == "POST") {

			BookListDAO bookListDAO = new BookListDAO();
			BookDAO bookDAO = new BookDAO();
			try {
				Config.VALIDATE_NUMBERS.isValid(request.getParameter("isbn"));
				Config.VALIDATE_NUMBERS.isValid(request.getParameter("id"));
				if (bookListDAO.addBook(bookDAO.findByISBN(request.getParameter("isbn")), Integer.parseInt(request.getParameter("id")))) {
					messages.add("Book added");
				} else {
					messages.add("Error adding book");
				}

			} catch (Exception e) {
				messages.add(e.toString());
				return new ActionResponse(ActionResponseType.REDIRECT, "bookList");
			}

			ActionResponse r = new ActionResponse(ActionResponseType.REDIRECT, "viewBook");
			r.addParameter("isbn", request.getParameter("isbn"));
			return r;
		}
		return new ActionResponse(ActionResponseType.REDIRECT, "bookList");
	}
}
