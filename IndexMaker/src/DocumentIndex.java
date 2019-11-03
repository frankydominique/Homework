/**
 * @author Franceska
 *
 */
import java.util.*;

public class DocumentIndex{

	private TreeMap<String, IndexEntry> indices;
	
	public DocumentIndex()
	{
		indices = new TreeMap<String, IndexEntry>(new Comparator<String>()
				{public int compare(String x, String y)
				{
					return x.compareToIgnoreCase(y);
				}
				}
		);
	}
	
	/*
	 * Adds num to the IndexEntry for word using IndexEntry's add(num) method
	 * If indices doesn't contain this word, adds key to indices
	 * 
	 *@param word - word found in document that has an index
	 *@param num - the newly found index of the word 
	 */
	public void addWord(String word, int num)
	{
		IndexEntry temp;
		
		if(indices.isEmpty() || !indices.containsKey(word))
		{
			indices.put(word, new IndexEntry(word));
		}
		
		temp = indices.get(word);
		temp.add(num);
	}
	
	/*
	 * Extracts all the words from str and for each word calls addWord(word, num)
	 * 
	 * @param str - line from a certain document
	 * @param num - line number from document
	 */
	public void addAllWords(String str, int num)
	{
		String[] words = str.split(" ");
		
		for(int i = 0; i < words.length; i++)
		{
			char[] chars = words[i].toCharArray();
			for(char x: chars)
				if(!Character.isLetter(x))
					words[i] = words[i].replace(x, '\b');
		}
		
		for(String x: words)
			addWord(x.toUpperCase(), num);
	}
	
	/*
	 * Returns a string representation of this DocumentIndex object
	 * 
	 * @return	String representation of DocumentIndex object
	 */
	public String toString()
	{
		String doc = "";
		for(String x: indices.keySet())
		{
			IndexEntry temp = indices.get(x);
			doc+= temp.toString() + "\n";
		}
		return doc;
	}

}
