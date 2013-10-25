package amu;

import java.util.ArrayList;
import java.util.regex.Pattern;

//written by kwrl and 
//please do not modify any of the existing code
//feel free to add static members like asciiranges and regexes

/*
 * 
 *   
 */

public class FilterUnit 
{
	private ArrayList<Pattern> forbiddenRegex;		//Matching one of these patterns will throw an exception
	private ArrayList<Pattern> requiredRegex;		//Not matching one of these patterns will throw an exception
	private ArrayList<ASCIIRange> legalRanges;		//Set of all legal characters
	private int minimumLength;						//
	private int maximumLength; 						//
	
	public FilterUnit()
	{
		this.forbiddenRegex = new ArrayList<Pattern>();
		this.requiredRegex 	= new ArrayList<Pattern>();
		this.legalRanges	= new ArrayList<ASCIIRange>();
		this.minimumLength 	= Integer.MIN_VALUE; 
		this.maximumLength 	= Integer.MAX_VALUE;		
	}
	
	public void setMinimumLength(int minimunLength) {
		this.minimumLength = minimunLength;
	}

	public void setMaximumLength(int maximumLength) {
		this.maximumLength = maximumLength;
	}

	public boolean isValid(String text) throws FilterUnitException
	{
		return noIllegalCharacters(text) && noForbiddenRegex(text) && matchesRequiredRegex(text) && legalLength(text);
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
	
	public boolean legalLength(String text) throws IllegalStringLengthException
	{
		if(text.length() <= maximumLength && text.length() >= minimumLength)
			return true;
		
		throw new IllegalStringLengthException(text);
	}
	
	public void addForbiddenRegex(String regex)
	{
		if(!regex.equals(""))
			forbiddenRegex.add(Pattern.compile(regex));
	}
	
	public void addSeveralForbiddenRegex(ArrayList<String> regex)
	{
		for(String s : regex)
			this.addForbiddenRegex(s);
	}
	
	public void addRequiredRegex(String regex)
	{
		if(!regex.equals(""))
			requiredRegex.add(Pattern.compile(regex));
	}
	
	public void addSeveralRequiredRegex(ArrayList<String> regex)
	{
		for(String s : regex)
			this.addRequiredRegex(s);
	}
	
	public void addLegalRange(ASCIIRange range)
	{
		legalRanges.add(range);
	}
	
	public void addSeveralLegalRanges(ArrayList<ASCIIRange> ranges)
	{
		for(ASCIIRange r : ranges)
			this.addLegalRange(r);
	}

	public static final String 		MAIL_REGEX 				= "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public static final ASCIIRange 	UPPERCASE_LETTERS		= new ASCIIRange('A', 'Z');
	public static final ASCIIRange	LOWERCASE_LETTERS		= new ASCIIRange('a','z');
	
	public static final ASCIIRange	NUMBERS					= new ASCIIRange('0','9');
	
	public static final ASCIIRange	UPPERCASE_AE			= new ASCIIRange('Æ','Æ');
	public static final ASCIIRange	LOWERCASE_AE			= new ASCIIRange('æ', 'æ');
	public static final ASCIIRange	UPPERCASE_OE			= new ASCIIRange('Ø','Ø');
	public static final ASCIIRange	LOWERCASE_OE			= new ASCIIRange('ø', 'ø');
	public static final ASCIIRange	UPPERCASE_AA			= new ASCIIRange('Å','Å');
	public static final ASCIIRange	LOWERCASE_AA			= new ASCIIRange('å', 'å');
	public static final ASCIIRange 	DOT						= new ASCIIRange('.','.');
	public static final ASCIIRange 	AT						= new ASCIIRange('@','@');
	public static final ASCIIRange	SPACE					= new ASCIIRange(' ',' ');
	public static final ASCIIRange	COMMA					= new ASCIIRange(',',',');
	public static final ASCIIRange 	DASH					= new ASCIIRange('-','-');
	public static final ASCIIRange 	CONTRACTION				= new ASCIIRange('\'','\'');
	//public static final ASCIIRange 	
	
	public static final int 		PASSWORD_MINIMUM_LENGTH	= 8;  
	public static final int 		PASSWORD_MAXIMUM_LENGTH	= 59;  
	
	
	public static ArrayList<ASCIIRange> getEnglishAlphabet()
	{
		ArrayList<ASCIIRange> ranges = new ArrayList<ASCIIRange>();
		ranges.add(UPPERCASE_LETTERS);
		ranges.add(LOWERCASE_LETTERS);
		
		return ranges;
	}
	
	public static ArrayList<ASCIIRange> getNorwegianAlphabet()
	{
		ArrayList<ASCIIRange> ranges = getEnglishAlphabet();
		ranges.add(UPPERCASE_AE);
		ranges.add(LOWERCASE_AE);
		ranges.add(UPPERCASE_OE);
		ranges.add(LOWERCASE_OE);
		ranges.add(UPPERCASE_AA);
		ranges.add(LOWERCASE_AA);
		
		return ranges;
	}
	
	public static FilterUnit getMailValidator()
	{
		FilterUnit filter = new FilterUnit();
		
	//	filter.addRequiredRegex(MAIL_REGEX);
		filter.addSeveralLegalRanges(getEnglishAlphabet());
		filter.addLegalRange(NUMBERS);
		filter.addLegalRange(DOT);
		filter.addLegalRange(AT);
		
		return filter;
	}
	

	public static FilterUnit getPasswordValidator()
	{
		FilterUnit filter = new FilterUnit();
		
		filter.addSeveralLegalRanges(getEnglishAlphabet());
		filter.addLegalRange(NUMBERS);
		filter.addLegalRange(DOT);
		
		filter.setMinimumLength(PASSWORD_MINIMUM_LENGTH);
		filter.setMaximumLength(PASSWORD_MAXIMUM_LENGTH);
		
		return filter;
	}
	
	//NO XSS OR SQL	
	public static FilterUnit getTextAndNumberValidator()
	{
		FilterUnit filter = new FilterUnit(); 
		
		filter.addSeveralLegalRanges(getNorwegianAlphabet());
		filter.addLegalRange(NUMBERS);
		
		return filter; 
	}
	
	public static FilterUnit getTextValidator()
	{
		FilterUnit filter = new FilterUnit(); 
		
		filter.addSeveralLegalRanges(getNorwegianAlphabet());
		
		return filter; 	
	}
	
	public static FilterUnit getAddressValidator()
	{
		FilterUnit filter = new FilterUnit();
		
		filter.addSeveralLegalRanges(getNorwegianAlphabet());
		filter.addLegalRange(NUMBERS);
		filter.addLegalRange(SPACE);
		filter.addLegalRange(DOT);
		filter.addLegalRange(COMMA);
		filter.addLegalRange(DASH);
		
		return filter;
	}

	public static FilterUnit getNumberValidator() {
		FilterUnit filter = new FilterUnit();
		
		filter.addLegalRange(NUMBERS);
		filter.addLegalRange(SPACE);
		filter.addLegalRange(DOT);
		filter.addLegalRange(COMMA);
		
		return filter;
	}
	
	public static FilterUnit getCreditcardNumberValidatior()
	{
		FilterUnit filter = new FilterUnit();
		
		filter.addLegalRange(NUMBERS);
		filter.setMaximumLength(16);
		filter.setMinimumLength(16);
		
		return filter;
	}
	
	public static FilterUnit getNameValidator()
	{
		FilterUnit filter = new FilterUnit();
		
		filter.addSeveralLegalRanges(getNorwegianAlphabet());
		filter.addLegalRange(DASH);
		filter.addLegalRange(CONTRACTION);
		
		return filter;
	}
}
