/**
 * @author Franceska
 *
 */
import java.util.*;

public class IndexEntry {
	
	private String word;
	private TreeSet<Integer> lineNums;
	
	/*
	 * Constructs a new IndexEntry for a word and a new tree set of lines if word doesn't
	 *	exist already 
	 * 
	 * @param word - given word
	 */
	public IndexEntry(String word)
	{
		this.word = word;
		
		if(lineNums == null)
			lineNums = new TreeSet<Integer>();
	}
	
	/*
	 * adds a integer to lineNums if lineNums doesn't contain it already
	 * 
	 *@param num - integer give to store in lineNums 
	 */
	public void add(int num)
	{
		if(lineNums.contains(num))
			return;
		lineNums.add(num);
	}
	
	/*
	 * returns the word of the IndexEntry
	 * 
	 * @return String of the word
	 */
	public String getWord()
	{
		return word;
	}
	
	/*
	 * returns a string representation of the IndexEntry for a class
	 * 
	 *@return String of the class 
	 */
	public String toString()
	{
		String x = word + " ";
		for(Integer y: lineNums)
		{
			x+= y + " ";
		}
		return x;
	}
	
}
