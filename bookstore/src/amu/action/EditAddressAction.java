package amu.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import amu.Config;
import amu.FilterUnitException;
import amu.database.AddressDAO;
import amu.model.Address;
import amu.model.Customer;

class EditAddressAction implements Action
{

	@Override
	public ActionResponse execute(HttpServletRequest request, HttpServletResponse response)
	{
		List<String> messages = new ArrayList<String>();
		HttpSession session = request.getSession(true);
		Customer customer = (Customer) session.getAttribute("customer");
		String sAddress, sId;
		
		sAddress = request.getParameter("address");
		sId = request.getParameter("id");

		try
		{
			Config.VALIDATE_ADDRESS.isValid(sAddress);
			Config.VALIDATE_NUMBERS.isValid(sId);
		} catch (FilterUnitException e)
		{
			messages.add("Invalid address");
			return new ActionResponse(ActionResponseType.FORWARD, "editAddress");
		}

		if (customer == null)
		{
			ActionResponse actionResponse = new ActionResponse(ActionResponseType.REDIRECT, "loginCustomer");
			actionResponse.addParameter("from", "viewCustomer");
			return actionResponse;
		}

		AddressDAO addressDAO = new AddressDAO();
		Address address = addressDAO.read(Integer.parseInt(sId), customer.getId());

		if (request.getMethod().equals("POST"))
		{
			request.setAttribute("messages", messages);
			address.setAddress(sAddress);

			if (addressDAO.edit(address))
				return new ActionResponse(ActionResponseType.REDIRECT, "viewCustomer");

			messages.add("An error occured.");
		}

		// (request.getMethod().equals("GET"))
		request.setAttribute("address", address);
		return new ActionResponse(ActionResponseType.FORWARD, "editAddress");
	}

}
