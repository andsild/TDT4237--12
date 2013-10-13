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
		
		sort();
	}
	
	public char getStart() {
		return start;
	}

	private void setStart(char start) {
		this.start = start;
	}

	public char getStop() {
		return stop;
	}

	private void setStop(char stop) {
		this.stop = stop;
	}
	
	public boolean inRange(char character)
	{
		System.out.println((int) start);
		System.out.println((int) character);
		System.out.println((int) stop);
		System.out.println(start <= character && stop >= character);
		return start <= character && stop >= character;
	}
	
	public void sort()
	{
		if(start>stop)swap();
	}
	
	private void swap()
	{
		char temp = start;
		start = stop;
		stop = temp;
	}
}
