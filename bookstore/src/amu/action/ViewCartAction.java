package amu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import amu.model.Cart;

class ViewCartAction implements Action {

    public ViewCartAction() {
    }

    @Override
    public ActionResponse execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        
        if (cart == null)
        {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }
        
        return new ActionResponse(ActionResponseType.FORWARD, "viewCart");
    }
    
}
