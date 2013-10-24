package amu.action;

import amu.Config;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jasypt.util.text.StrongTextEncryptor;

import amu.Config;
import amu.FilterUnitException;
import amu.database.CreditCardDAO;
import amu.model.CreditCard;
import amu.model.Customer;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.util.text.StrongTextEncryptor;

class AddCreditCardAction implements Action {
    
    @Override
    public ActionResponse execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(true);
        Customer customer = (Customer) session.getAttribute("customer");
        String sExpiryYear, sExpiryMonth, sCreditCardNumber, sCardholderName;
        
        sExpiryYear = request.getParameter("expiryYear");
        sExpiryMonth = request.getParameter("expiryMonth");
        sCreditCardNumber = request.getParameter("creditCardNumber");
        sCardholderName = request.getParameter("cardholderName");

        if (customer == null) {
            ActionResponse actionResponse = new ActionResponse(ActionResponseType.REDIRECT, "loginCustomer");
            actionResponse.addParameter("from", "addCreditCard");
            return actionResponse;
        }
        
        if (request.getMethod().equals("POST")) {
            Map<String, String> messages = new HashMap<String, String>();
            request.setAttribute("messages", messages);
            
            try
            {
            	Config.VALIDATE_NUMBERS.isValid(sExpiryYear);
            	Config.VALIDATE_NUMBERS.isValid(sExpiryMonth);
            	Config.VALIDATE_NUMBERS.isValid(sCreditCardNumber);
            	Config.VALIDATE_TEXT.isValid(sCardholderName);
            }
            catch(FilterUnitException e)
            {
            	messages.put("error", "Invalid input");
            	return new ActionResponse(ActionResponseType.REDIRECT, "viewProfile");
            }
            
            Calendar expiryDate = Calendar.getInstance();
            expiryDate.set(Integer.parseInt(sExpiryYear), Integer.parseInt(sExpiryMonth), 1);
            
            CreditCardDAO creditCardDAO = new CreditCardDAO();
            StrongTextEncryptor encrypt = new StrongTextEncryptor();
            encrypt.setPassword(Config.ENCRYPT_PASSWORD);
			String ccNumber = encrypt.encrypt(sCreditCardNumber);
            CreditCard creditCard = new CreditCard(
                    customer, 
                    ccNumber, 
                    expiryDate,
                    sCardholderName);
            
            //XXX: When something goes wrong, the values from the form are sent back so they are not lost, is this a security risk?
            //Map<String, String> values = new HashMap<String, String>();
            //request.setAttribute("values", values);
            //values.put("creditCardNumber", ccNumber);
            //values.put("expiryDate", request.getParameter("expiry"));
            //values.put("cardholderName", sCardholderName);
            
            if (creditCardDAO.add(creditCard)) {
                return new ActionResponse(ActionResponseType.REDIRECT, "viewCustomer");
            }
            
            messages.put("error", "An error occured.");
        }
        
        // (request.getMethod().equals("GET"))
        Calendar calendar = new GregorianCalendar();
        
        List<String> years = new ArrayList<String>();
        request.setAttribute("years", years);
        for (Integer offset = 0; offset < 10; offset++) {
            years.add(Integer.valueOf(calendar.get(Calendar.YEAR) + offset).toString());
        }

        Map<String, String> months = new HashMap<String, String>();
        request.setAttribute("months", months);
        for (Integer month = 0; month < 12; month++) {
            months.put(month.toString(), Integer.valueOf(month - 1).toString());
        }
        
        return new ActionResponse(ActionResponseType.FORWARD, "addCreditCard");
    }
}
