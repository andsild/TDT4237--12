package amu;

import java.util.ArrayList;
import java.util.regex.Pattern;

//written by kwrl
//please do not modify any of the existing code
//feel free to add static members like asciiranges and regexes

/*
 * TODO
 * Create FilterUnitException, throw from isValid(String) or child methods
 */

public class FilterUnit 
{
	private ArrayList<Pattern> forbiddenRegex;		//Matching one of these patterns will throw an exception
	private ArrayList<Pattern> requiredRegex;		//Not matching one of these patterns will throw an exception
	private ArrayList<ASCIIRange> legalRanges;		//Set of all legal characters
	
	public FilterUnit()
	{
		this.forbiddenRegex = new ArrayList<Pattern>();
		this.requiredRegex 	= new ArrayList<Pattern>();
		this.legalRanges	= new ArrayList<ASCIIRange>();
	}
	
	public boolean isValid(String text) throws FilterUnitException
	{
		return noIllegalCharacters(text) && noForbiddenRegex(text) && matchesRequiredRegex(text);
	}
	
	public boolean noForbiddenRegex(String text) throws IllegalRegexException
	{		
		for(Pattern p : forbiddenRegex)
			if(p.matcher(text).matches())
				throw new IllegalRegexException(text,p.toString());
			
		return true;
	}
	
	public boolean noIllegalCharacters(String text) throws IllegalCharacterException
	{
		boolean temp;
		
		for(char c : text.toCharArray())
		{
			temp = false;
			for(ASCIIRange range : legalRanges)
				if(range.inRange(c))
					temp = true;
			if(!temp)
				throw new IllegalCharacterException(text, c);
		}
		return true;
	}
	
	public boolean matchesRequiredRegex(String text) throws FailedRegexException
	{
		for(Pattern p : requiredRegex)
			if(!p.matcher(text).matches())
				throw new FailedRegexException(text, p.toString());
		return true;
	}
	
	public void addForbiddenRegex(String regex)
	{
		if(!regex.equals(""))
			forbiddenRegex.add(Pattern.compile(regex));
	}
	
	public void addRequiredRegex(String regex)
	{
		if(!regex.equals(""))
			requiredRegex.add(Pattern.compile(regex));
	}
	
	public void addLegalRange(ASCIIRange range)
	{
		legalRanges.add(range);
	}

	public static final String 		MAIL_REGEX 			= "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public static final ASCIIRange 	UPPERCASE_LETTERS	= new ASCIIRange('A', 'A');
	public static final ASCIIRange	LOWERCASE_LETTERS	= new ASCIIRange('a','z');
	
	public static final ASCIIRange	NUMBERS				= new ASCIIRange('0','9');
	
	public static final ASCIIRange	UPPERCASE_AE		= new ASCIIRange('Æ','Æ');
	public static final ASCIIRange	LOWERCASE_AE		= new ASCIIRange('æ', 'æ');
	public static final ASCIIRange	UPPERCASE_OE		= new ASCIIRange('Ø','Ø');
	public static final ASCIIRange	LOWERCASE_OE		= new ASCIIRange('ø', 'ø');
	public static final ASCIIRange	UPPERCASE_AA		= new ASCIIRange('Å','Å');
	public static final ASCIIRange	LOWERCASE_AA		= new ASCIIRange('å', 'å');
	public static final ASCIIRange 	DOT					= new ASCIIRange('.','.');
	public static final ASCIIRange 	AT					= new ASCIIRange('@','@');
	
	
	public static FilterUnit getMailValidator()
	{
		FilterUnit filter = new FilterUnit();
		
		filter.addRequiredRegex(MAIL_REGEX);
		filter.addLegalRange(LOWERCASE_LETTERS);
		filter.addLegalRange(UPPERCASE_LETTERS);
		filter.addLegalRange(DOT);
		filter.addLegalRange(AT);
		
		return filter;
	}
	
	public static FilterUnit getPasswordValidator()
	{
		FilterUnit filter = new FilterUnit();
		
		filter.addLegalRange(LOWERCASE_LETTERS);
		filter.addLegalRange(UPPERCASE_LETTERS);
		filter.addLegalRange(NUMBERS);
		
		return filter;
	}
	
}
