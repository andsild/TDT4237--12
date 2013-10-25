package amu.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;
import amu.Config;
import amu.Mailer;
import amu.model.Customer;

class CustomerSupportAction implements Action {

    @Override
    public ActionResponse execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(true);
        Customer customer = (Customer) session.getAttribute("customer");
        String email;

        if (customer == null) {
            ActionResponse actionResponse = new ActionResponse(ActionResponseType.REDIRECT, "loginCustomer");
            actionResponse.addParameter("from", "customerSupport");
            return actionResponse;
        }
        if (request.getParameter("department") == "sales") {
			email = Config.EMAIL_SALES;
		}
        else if (request.getParameter("department")== "techSupport") {
			email = Config.EMAIL_TECH;
		}
        else{
        	email = Config.EMAIL_FROM_ADDR;
        }
        if (request.getMethod().equals("POST")) {
        	Map<String, String> messages = new HashMap<String, String>();
            request.setAttribute("messages", messages);
            String remoteAddr = request.getRemoteAddr();
        	ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
            reCaptcha.setPrivateKey("6LcwqOgSAAAAAL45ayNkEqKhWvAD7PDzFUtoBDim");

            String challenge = request.getParameter("recaptcha_challenge_field");
            String uresponse = request.getParameter("recaptcha_response_field");
            ReCaptchaResponse reCaptchaResponse = reCaptcha.checkAnswer(remoteAddr, challenge, uresponse);
            
            if (reCaptchaResponse.isValid()) {
				
			
        	
            Mailer.send(email, 
                    request.getParameter("subject"), 
                    request.getParameter("content"), 
                    request.getParameter("fromAddr"), 
                    request.getParameter("fromName"));
            return new ActionResponse(ActionResponseType.REDIRECT, "customerSupportSuccessful");
            }
            else {
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

        return new ActionResponse(ActionResponseType.FORWARD, "customerSupport");
    }
}
