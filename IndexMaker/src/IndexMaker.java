/**
 * @author Franceska
 *
 */

import java.util.*;
import java.io.*;
import javax.swing.*;

public class IndexMaker {

	private static File input;
	private static File input2;
	private static File input3;
	private static File output, output2, output3;
	/**
	 * @param args[0] input file
	 * @param args[1] output file
	 * 
	 * if args[1] is not given, args[1] = new file named inputfilename + word index
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		input = new File(args[0]);
		input2 = new File(args[2]);
		input3 = new File(args[3]);
		if(args[1] != null) output = new File(args[1]);
		else output = new File(args[0] + "WordIndex");
		if(args[4] != null) output2 = new File(args[4]);
		else output2 = new File(args[0] + "WordIndex");
		if(args[5] != null) output3 = new File(args[5]);
		else output3 = new File(args[0] + "WordIndex");
		
		String x = addDocument(input);
		String y = addDocument(input2);
		String z = addDocument(input3);
		
		printDocIndex(x, output);
		printDocIndex(y, output2);
		printDocIndex(z, output3);
	}
	
	/*
	 * Returns String of the DocumentIndex
	 * 
	 * @return	String representation of the DocumentIndex
	 */
	public static String addDocument(File x)
	{
		DocumentIndex test = new DocumentIndex();
		
		String[] lines = loadFile(x).toString().split("\\r?\\n");
		
		for(int i = 0; i < lines.length; i++)
			test.addAllWords(lines[i], i + 1);
		
		return test.toString();
	}
	
	/*
	 * Prints the DocumentIndex of the given string version of the file
	 * 
	 * @param x - the string version of the file
	 */
	public static void printDocIndex(String x, File y)
	{
		Writer append2 = null;
		
		try
		{
			append2 = new FileWriter(y, true);
		}
		catch (IOException ex)
		{
			System.out.println("File Doesn't Exist");
		}
		
		PrintWriter toPrint = new PrintWriter(append2);
		toPrint.println(x);
		
		toPrint.close();
	}
	
	/*
	 * Returns a StringBuffer representation of the given file
	 * 
	 * @param x - File wanted to turn into a StringBuffer
	 * @return	StringBuffer representation of the given file
	 */
	public static StringBuffer loadFile(File x)
	{
		File file = x;
		StringBuffer strBuffer = new StringBuffer((int)file.length());
		
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(file));
			
			int ch = 0;
			while((ch = input.read()) != -1)
				strBuffer.append((char)ch);
			
			input.close();
			
			return strBuffer;
		}
		catch (IOException ex)
		{
			System.out.println("Unable to Open File");
		}	
		
		return strBuffer;
	}

}
