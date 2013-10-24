package amu.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import amu.Config;
import amu.FilterUnitException;
import amu.database.CustomerDAO;
import amu.model.Customer;

class ChangeNameAction implements Action
{

	@Override
	public ActionResponse execute(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession(true);
		Customer customer = (Customer) session.getAttribute("customer");
		String sName = request.getParameter("name");

		if (customer == null)
		{
			ActionResponse actionResponse = new ActionResponse(ActionResponseType.REDIRECT, "loginCustomer");
			actionResponse.addParameter("from", "changeName");
			return actionResponse;
		}

		if (request.getMethod().equals("POST"))
		{

			Map<String, String> messages = new HashMap<String, String>();
			request.setAttribute("messages", messages);

			try
			{
				Config.VALIDATE_TEXT.isValid(sName);
			} catch (FilterUnitException e)
			{
				messages.put("name", "Invalid name.");
				return new ActionResponse(ActionResponseType.FORWARD, "changeName");
			}

			customer.setName(sName);

			CustomerDAO customerDAO = new CustomerDAO();
			if (customerDAO.edit(customer))
			{ // Customer name was successfully changed
				return new ActionResponse(ActionResponseType.REDIRECT, "viewCustomer");
			}
			else
			{
				messages.put("name", "Something went wrong here.");
				return new ActionResponse(ActionResponseType.FORWARD, "changeName");
			}
		}

		// (request.getMethod().equals("GET")) {
		return new ActionResponse(ActionResponseType.FORWARD, "changeName");
	}
}
