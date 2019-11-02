/**
 * @author Franceska
 *
 */
import java.util.*;

public class DocumentIndex{

	private TreeMap<String, IndexEntry> indices;
	
	public DocumentIndex()
	{
		indices = new TreeMap<String, IndexEntry>();
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
		//do i need to check if indices is empty? what happens if i just do contains?
		if(indices.isEmpty() || !indices.containsKey(word))
			indices.put(word, new IndexEntry(word));

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
		String temp = str;
		for(int i = 0; i < str.length(); i = temp.indexOf(" " + 1))
		{
			temp = temp.substring(i, temp.indexOf(" "));
			addWord(temp, num);
		}
	}
}
