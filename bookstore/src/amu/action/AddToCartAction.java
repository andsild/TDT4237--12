package amu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import amu.Config;
import amu.database.BookDAO;
import amu.model.Book;
import amu.model.Cart;
import amu.model.CartItem;

class AddToCartAction implements Action {

	@Override
	public ActionResponse execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String sIsbn, sQuantity;

		sIsbn = request.getParameter("isbn");
		sQuantity = request.getParameter("quantity");

		Cart cart = (Cart) session.getAttribute("cart");

		if (cart == null) {
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		ActionResponse r = new ActionResponse(ActionResponseType.REDIRECT, "viewBook");
		r.addParameter("isbn", sIsbn);
		try {

			if (sIsbn != null && Integer.parseInt(request.getParameter("quantity")) > 0) {
				Config.VALIDATE_NUMBERS.isValid(sIsbn);
				Config.VALIDATE_NUMBERS.isValid(sQuantity);

				BookDAO bookDAO = new BookDAO();
				Book book = bookDAO.findByISBN(sIsbn);

				cart.addItem(new CartItem(book, Integer.parseInt(request.getParameter("quantity"))));
			} else {
				return r;
			}
		} catch (Exception e) {
			return r;
		}

		return new ActionResponse(ActionResponseType.REDIRECT, "viewCart");
	}

}
