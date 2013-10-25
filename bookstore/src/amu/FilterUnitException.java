package amu;

public class FilterUnitException extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String invalidText;
	
	public String toString()
	{
		if(this instanceof IllegalRegexException)
			return "Some string contains an illegal regex";
		if(this instanceof IllegalCharacterException)
			return "Some string contains an illegal character";
		if(this instanceof FailedRegexException)
			return "Some string is not the correct format";
		if(this instanceof IllegalStringLengthException)
			return "Some string is not the correct length";
		
		return invalidText;
	}
}

class IllegalRegexException extends FilterUnitException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String regex;
	
	public IllegalRegexException(String invalidText, String regex)
	{
		this.invalidText 	= invalidText;
		this.regex 			= regex;
	}
	
	public String getRegex()
	{
		return regex;
	}
}

class IllegalCharacterException extends FilterUnitException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private char illegalChar;
	
	public IllegalCharacterException(String invalidText, char illegalChar)
	{
		this.invalidText = invalidText;
		this.illegalChar = illegalChar;
	}

	public char getIllegalChar() {
		return illegalChar;
	}
}

class FailedRegexException extends FilterUnitException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String regex;
	
	public FailedRegexException(String invalidText, String regex)
	{
		this.invalidText 	= invalidText;
		this.regex 			= regex;
	}
	
	public String getRegex()
	{
		return regex;
	}
}

class IllegalStringLengthException extends FilterUnitException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int length;
	
	public IllegalStringLengthException(String invalidText)
	{
		this.length = invalidText.length();
		this.invalidText = invalidText;
	}
	
	public int getLength()
	{
		return length;
	}
}
