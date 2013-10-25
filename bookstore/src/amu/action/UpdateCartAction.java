package amu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import amu.Config;
import amu.FilterUnitException;
import amu.database.BookDAO;
import amu.model.Book;
import amu.model.Cart;
import amu.model.CartItem;

class UpdateCartAction implements Action {

	@Override
	public ActionResponse execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		Cart cart = (Cart) session.getAttribute("cart");

		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}

		String[] isbn = request.getParameterValues("isbn");
		String[] quantity = request.getParameterValues("quantity");

		try {
			for (String s : isbn)
				Config.VALIDATE_NUMBERS.isValid(s);
			for (String s : quantity)
				Config.VALIDATE_NUMBERS.isValid(s);
		} catch (FilterUnitException e) {
			return new ActionResponse(ActionResponseType.REDIRECT, "viewCart");
		}

		if (isbn != null && quantity != null && isbn.length == quantity.length) {

			for (int i = 0; i < isbn.length; i++) {
				CartItem item = cart.getItemByISBN(isbn[i]);
				if (item == null) {
					BookDAO bookDAO = new BookDAO();
					Book book = bookDAO.findByISBN(isbn[i]);
					cart.addItem(new CartItem(book, Integer.parseInt(request.getParameter("quantity"))));
				} else {
					item.setQuantity(Integer.parseInt(quantity[i]));
					cart.updateItem(item);
				}
			}
		}

		return new ActionResponse(ActionResponseType.REDIRECT, "viewCart");
	}
}
