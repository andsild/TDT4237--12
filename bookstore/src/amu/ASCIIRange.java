package amu;

public class ASCIIRange {
	private char start, stop;
	
	public ASCIIRange(int start, int stop)
	{
		this.setStart((char)start);
		this.setStop((char)stop);
	}

	public ASCIIRange(char start, char stop)
	{
		this.setStart(start);
		this.setStop(stop);
	}
	
	public char getStart() {
		return start;
	}

	private void setStart(char start) {
		this.start = start;
		
		if(start>stop) swap();
	}

	public char getStop() {
		return stop;
	}

	private void setStop(char stop) {
		this.stop = stop;
		
		if(start>stop) swap();
	}
	
	public boolean inRange(char character)
	{
		return start <= character && stop >= character;
	}
	
	private void swap()
	{
		char temp = start;
		start = stop;
		stop = temp;
	}
}
