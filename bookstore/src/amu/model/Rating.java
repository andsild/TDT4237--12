package amu.model;

public class Rating {
	private Integer iId;
	private Customer cCustomer;
	private String sRateValue;
	private int iBookID;

	public Rating(int iId, Customer cCustomer, String sRateValue, int iBookID) {
		setId(iId);
		setRating(sRateValue);
		setBookID(iBookID);
		setCustomer(cCustomer);
	}

	public Rating(Customer cCustomer, String sRateValue, int iBookID) {
		this.iId = null;
		setRating(sRateValue);
		setBookID(iBookID);
		setCustomer(cCustomer);
	}

	public String getRating() {
		return this.sRateValue;
	}

	public Customer getCustomer() {
		return this.cCustomer;
	}

	public int getId() {
		return this.iId;
	}

	public int getBookID() {
		return this.iBookID;
	}

	public void setId(Integer id) {
		if (id == null) {
			throw new NullPointerException("Id is null");
		}

		this.iId = id;
	}

	public void setBookID(Integer iBookID) {
		if (iBookID == null) {
			throw new NullPointerException("bookId is null");
		}

		this.iBookID = iBookID;
	}

	public void setRating(String sRateValue) {
		if (sRateValue == null) {
			throw new NullPointerException("ratevalue is null");
		}

		try {
			Integer i = Integer.parseInt(sRateValue);

			if (i < 0 || i > 5) {
				throw new RuntimeException("bad rate value");
			}
		} catch (Exception e) {
			this.sRateValue = "3";
		}

		this.sRateValue = sRateValue;
	}

	public void setCustomer(Customer c) {
		if (c == null) {
			throw new NullPointerException("customer is null");
		}
		this.cCustomer = c;
	}

	@Override
	public String toString() {
		String sOutput = "";
		try {
			sOutput = getRating() + "\n" + Integer.toString(getId()) + getCustomer().toString() + "\n" + Integer.toString(getBookID());
		} catch (Exception e) {
			System.out.println("rating had error");
			System.out.println(e.getMessage());
		}

		return sOutput;
	}
}

/* EOF */