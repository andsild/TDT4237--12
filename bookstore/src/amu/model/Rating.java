package amu.model;

public class Rating 
{
	private Integer iId;
	private Customer cCustomer;
	private Integer iRateValue;
	private int iBookID;
	
	public Rating(int iId, Customer cCustomer, int iRateValue, int iBookID)
	{
		this.iId = iId;
		this.cCustomer = cCustomer;
		this.iRateValue = iRateValue;
		this.iBookID = iBookID;
	}
	
	public Rating(Customer cCustomer, int iRateValue, int iBookID)
	{
		this.iId = null; /* default, rely on AUTO_INCREMENT */
		this.cCustomer = cCustomer;
		this.iRateValue = iRateValue;
		this.iBookID = iBookID;
	}
	
	public int getRating() {	return this.iRateValue; }
	public Customer getCustomer() { return this.cCustomer; }
	public int getId() { return this.iId; }
	
	public void setRating(int iRateValue)
	{
			//TODO: make sure in range
			this.iRateValue = iRateValue;
	}

}

/* EOF */