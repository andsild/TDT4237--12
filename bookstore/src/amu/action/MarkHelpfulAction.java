package amu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import amu.Config;
import amu.FilterUnitException;
import amu.database.HelpfulDAO;
import amu.model.Customer;

public class MarkHelpfulAction implements Action {
	@Override
	public ActionResponse execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(true);
		Customer cCustomer = (Customer) session.getAttribute("customer");

		String sIsbn = request.getParameter("isbn");
		ActionResponse ar = new ActionResponse(ActionResponseType.REDIRECT, "viewBook");
		ar.addParameter("isbn", sIsbn);

		String sHelpful = request.getParameter("helpful");
		String sCommentID = request.getParameter("commentID");

		try {
			Config.VALIDATE_NUMBERS.isValid(sIsbn);
			Config.VALIDATE_NUMBERS.isValid(sCommentID);
			Config.VALIDATE_NUMBERS.isValid(sHelpful);
		} catch (FilterUnitException e) {
			return ar;
		}

		HelpfulDAO hdao = new HelpfulDAO();

		if (sHelpful != null && sCommentID != null && cCustomer != null && sIsbn != null) {
			hdao.register(Integer.toString(cCustomer.getId()), sCommentID, sHelpful);
		} else {
			throw new Exception("could not mark as helpful");
		}

		return ar;
	}
}
