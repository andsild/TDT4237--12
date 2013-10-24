package amu.action;

import amu.Config;
import amu.database.BookDAO;
import amu.model.Book;
import amu.model.Cart;
import amu.model.CartItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

class AddToCartAction implements Action
{

	@Override
	public ActionResponse execute(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		HttpSession session = request.getSession();
		Cart cart = (Cart) session.getAttribute("cart");
		String sIsbn, sQuantity;
		
		sIsbn = request.getParameter("isbn");
		sQuantity = request.getParameter("quantity");

		if (cart == null)
		{
			cart = new Cart();
			session.setAttribute("cart", cart);
		}
		ActionResponse r = new ActionResponse(ActionResponseType.REDIRECT, "viewBook");
		r.addParameter("isbn", sIsbn);
		try
		{

			if (sIsbn != null && Integer.parseInt(sQuantity) > 0)
			{
				Config.VALIDATE_NUMBERS.isValid(sIsbn);
				Config.VALIDATE_NUMBERS.isValid(sQuantity);

				BookDAO bookDAO = new BookDAO();
				Book book = bookDAO.findByISBN(sIsbn);

				cart.addItem(new CartItem(book, Integer.parseInt(sQuantity)));
			}
			else
				return r;
		} catch (Exception e)
		{
			return r;
		}

		return new ActionResponse(ActionResponseType.REDIRECT, "viewCart");
	}

}
