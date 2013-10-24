package amu;

public class FilterUnitException extends Exception 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String invalidText;
	
	public String getInvalidText()
	{
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
	}
	
	public int getLength()
	{
		return length;
	}
}
