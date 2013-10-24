package amu.model;

public class HelpfulReview 
{
	private int thumbsUp, thumbsDown;
	private int id;
	private String text;
	
	public HelpfulReview(int iReviewID, String sText, int iThumbsUp, int iThumbsDown)
	{
		this.id = iReviewID;
		this.thumbsDown = iThumbsDown;
		this.thumbsUp = iThumbsUp;
		this.text = sText;
	}
		
	public int getThumbsUp() {
		return thumbsUp;
	}

	public int getThumbsDown() {
		return thumbsDown;
	}

	public String getText() { return this.text; }
	
	public int getId() { return this.id; }
}

/* EOF */