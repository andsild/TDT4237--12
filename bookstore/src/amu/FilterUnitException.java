package amu;

public class FilterUnitException extends Exception 
{
	protected String invalidText;
	
	public String getInvalidText()
	{
		return invalidText;
	}
}

class IllegalRegexException extends FilterUnitException
{
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
	private int length;
	
	public IllegalStringLengthException(String invalidText)
	{
		this.length = length;
	}
	
	public int getLength()
	{
		return length;
	}
}
