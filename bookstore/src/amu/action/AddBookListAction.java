package amu.action;
	
import amu.database.BookListDAO;
import amu.model.BookList;
import amu.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

class AddBookListAction implements Action {

	@Override
	public ActionResponse execute(HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		Customer customer = (Customer) session.getAttribute("customer");

		// Handle referrals
		Map<String, String> values = new HashMap<String, String>();
		request.setAttribute("values", values);
		if (ActionFactory.hasKey(request.getParameter("from"))) {
			values.put("from", request.getParameter("from"));
		}

		if (customer == null) {
			ActionResponse actionResponse = new ActionResponse(
					ActionResponseType.REDIRECT, "loginCustomer");
			actionResponse.addParameter("from", "addBookList");
			return actionResponse;
		}
		// Non-idempotent add address request
		if (request.getMethod().equals("POST")) {
			List<String> messages = new ArrayList<String>();
			request.setAttribute("messages", messages);

			String remoteAddr = request.getRemoteAddr();
			ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
			reCaptcha.setPrivateKey("6LcwqOgSAAAAAL45ayNkEqKhWvAD7PDzFUtoBDim");

			String challenge = request
					.getParameter("recaptcha_challenge_field");
			String uresponse = request.getParameter("recaptcha_response_field");
			ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(
					remoteAddr, challenge, uresponse);

			if (reCaptchaResponse.isValid()) {

				System.out.println("Valid captcha");
				BookListDAO bookListDAO = new BookListDAO();
				BookList bookList = new BookList(0,
						request.getParameter("title"),
						request.getParameter("description"));
				bookList.setCustomer(customer);
				System.out.println("Booklist created");
				if (bookListDAO.add(bookList)) {
					System.out.println("booklist added to database");
					return new ActionResponse(ActionResponseType.REDIRECT,
							"bookList");
				}
				request.setAttribute("bookList", bookList);
				messages.add("An error occured.");

			} else {
				String s = reCaptchaResponse.getErrorMessage();
				if (s.equals("incorrect-captcha-sol")) {
					messages.add("Incorrect captcha, please try again");
				} else if (s.equals("captcha-timeout")) {
					messages.add("Captcha timeout");
				} else {
					messages.add(reCaptchaResponse.getErrorMessage());
				}
			}

			
		}
		

		// (request.getMethod().equals("GET"))
		return new ActionResponse(ActionResponseType.FORWARD, "addBookList");
	}
}