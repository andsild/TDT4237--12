package amu.model;

public class Review {
	private Integer iId;
	private Customer cCustomer;
	private String sReview;
	private int iBookID;

	public Review(int iId, Customer cCustomer, String sReview, int iBookID) {
		setId(iId);
		setReview(sReview);
		setBookID(iBookID);
		setCustomer(cCustomer);
	}

	public Review(Customer cCustomer, String sReview, int iBookID) {
		this.iId = null;
		setReview(sReview);
		setBookID(iBookID);
		setCustomer(cCustomer);
	}

	public String getReview() {
		return this.sReview;
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

	public void setReview(String sReview) {
		if (sReview == null) {
			throw new NullPointerException("ratevalue is null");
		}

		this.sReview = sReview;
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
			sOutput = getReview() + "\n" + Integer.toString(getId()) + getCustomer().toString() + "\n" + Integer.toString(getBookID());
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sOutput;
	}
}

/* EOF */