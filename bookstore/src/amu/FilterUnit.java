package amu;

import java.util.ArrayList;

//written by kwrl
//editing this file without consulting me will result in a painful death

/*
 * TODO
 * Create FilterUnitException, throw from isValid(String) or child methods
 */

public class FilterUnit 
{
	private ArrayList<String> forbiddenRegex;
	private ArrayList<ASCIIRange> legalRanges;
	
	public FilterUnit()
	{
		this.forbiddenRegex = new ArrayList<String>();
		this.legalRanges	= new ArrayList<ASCIIRange>();
	}
	
	public boolean isValid(String text)
	{
		return noIllegalCharacters(text) && noForbiddenRegex(text);
	}
	
	public boolean noForbiddenRegex(String text)
	{			
		return false;
	}
	
	public boolean noIllegalCharacters(String text)
	{
		for(char c : text.toCharArray())
			for(ASCIIRange range : legalRanges)
				if(!range.inRange(c))
					return false;
		return true;
	}
	
	public void addForbiddenRegex(String regex)
	{
		if(!regex.equals(""))
			forbiddenRegex.add(regex);
	}
	
	public void addLegalRange(ASCIIRange range)
	{
		legalRanges.add(range);
	}
}
