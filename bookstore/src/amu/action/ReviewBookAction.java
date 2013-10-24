package amu.action;

import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;
import amu.database.BookDAO;
import amu.database.ReviewDAO;
import amu.model.Book;
import amu.model.Cart;
import amu.model.Customer;
import amu.model.Review;

public class ReviewBookAction implements Action {
	@Override
    public ActionResponse execute(HttpServletRequest request, HttpServletResponse response)
	throws Exception
	{
		HttpSession session = request.getSession(true);
		Customer cCustomer = (Customer) session.getAttribute("customer");
		
		String sIsbn = request.getParameter("isbn");
		ActionResponse ar = new ActionResponse(ActionResponseType.REDIRECT,
				"viewBook");
		ar.addParameter("isbn", sIsbn);
		
		String sReview = request.getParameter("review");
		Map<String, String> messages = new HashMap<String, String>();
		
		if (sReview != null
		&& cCustomer != null
		&& sIsbn != null)
		{
		
			String remoteAddr = request.getRemoteAddr();
            ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
            reCaptcha.setPrivateKey("6LcwqOgSAAAAAL45ayNkEqKhWvAD7PDzFUtoBDim");

            String challenge = request.getParameter("recaptcha_challenge_field");
            String uresponse = request.getParameter("recaptcha_response_field");
            
            if (challenge == null || uresponse == null)
            {
            	//throw new RuntimeException("dwad");
            	System.out.println("CAUGHT NULL");
            	return ar;
            }
            ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);
            
            if (reCaptchaResponse.isValid()) {
    			Book bBook = new BookDAO().findByISBN(sIsbn);
    			Review rNewReview = new Review(cCustomer, sReview, bBook.getId());
    			new ReviewDAO().register(rNewReview);
            }
            
            else
            {
            	System.out.println("fwadaw");
	            String s = reCaptchaResponse.getErrorMessage();
	        	if (s.equals("incorrect-captcha-sol")) {
					messages.put("error", "Incorrect captcha, please try again");
				}
	        	else if (s.equals("captcha-timeout")) {
	        		messages.put("error", "Captcha timeout");
				}else{
					messages.put("error", reCaptchaResponse.getErrorMessage());
				}
            }

		}
		else
		{
			throw new Exception("could not register review");
		}
	
		return ar;
    }
    
}

/* EOF */