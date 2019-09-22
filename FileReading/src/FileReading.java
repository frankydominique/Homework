

/**
 * @author Franceska
 *
 */
import java.util.*;
import java.io.*;
import javax.swing.*;

public class FileReading {
	
	private static ArrayList<String> subWords = new ArrayList(10);

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("What is the name of your first file?");
		String fileName = input.nextLine();
		File userFile = new File(fileName);
		
		String pathname = "output.txt";
		
		outputPrintBraces(pathname, bracesBalanced(userFile));
		
		outputBlank(pathname);
		
		outputPrintIdentical(pathname, fileIdentical(fileName, "test.txt"));
		
		outputBlank(pathname);
		
		StringBuffer story = loadFile("ShortStory.txt");
		
		collectPrompts(story);
		
		enterPrompts(story);
		
		outputPrintPrompt(pathname, story);
		
	}
	
	/*
	 * Void, writes up indicator that input file cannot be reached
	 * 
	 * @param pathname of file that cannot be reached
	 */
	public static void unableToOpenFile(String pathname)
	{
		Writer append2 = null;
		
		try
		{
			append2 = new FileWriter(pathname, true);
		}
		catch (IOException ex)
		{
			System.out.println("Neither file exists");
		}
		
		PrintWriter output = new PrintWriter(append2);
		output.println("Part 1: Unable to open file");
		output.close();
		
	}
	
	//this method counts the number of opening braces and closing braces in a file to check if the numbers
	//	equal and are balanced
	//@param name of input file
	public static boolean bracesBalanced(File x)
		throws IOException
	{
		
		BufferedReader input = new BufferedReader(new FileReader(x));
		
		int pos = 0, beginBrace = 0, endBrace = 0;
		
		while((pos = input.read()) != -1)
		{
			if((char)pos == '{')
			{
				beginBrace++;
			}
			else if ((char)pos == '}')
			{
				endBrace++;
			}
		}		
		
		return beginBrace == endBrace;
	}
	
	/*
	 * prints a blank line
	 * 
	 * @param pathname filename where blank line is to be posted
	 */
	public static void outputBlank(String pathname)
	{
		Writer append2 = null;
		
		try
		{
			append2 = new FileWriter(pathname, true);
		}
		catch (IOException ex)
		{
			System.out.println("File doesn't exist");
		}
		
		PrintWriter output = new PrintWriter(append2);
		output.println("\n");
		output.close();
	}

	
	/*
	 * Checks if braces in the given file are balanced
	 * 
	 * @param	pathname name of file being printed to
	 * @param	x outcome of bracesBalanced to be printed
	 */
	public static void outputPrintBraces(String pathname, boolean x)
	{
		Writer append2 = null;
		
		try
		{
			append2 = new FileWriter(pathname, true);
		}
		catch (IOException ex)
		{
			System.out.println("File doesn't exist");
		}
		
		PrintWriter output = new PrintWriter(append2);
		if(x == true)
			output.println("Braces balanced.");
		else
			output.println("Braces not balanced");
		
		output.close();
	}
	
	
	/*
	 * Prints outcome of fileIdentical
	 * 
	 * @param	pathname name of file being printed to
	 * @param	x outcome of fileIdentical to be printed
	 */
	public static void outputPrintIdentical(String pathname, boolean x)
	{
		Writer append2 = null;
		
		try
		{
			append2 = new FileWriter(pathname, true);
		}
		catch (IOException ex)
		{
			System.out.println("Part 2: Unable to Open File");
		}
		
		PrintWriter output = new PrintWriter(append2);
		if(x == true)
			output.println("Files Identical");
		else
			output.println("Files Not Identical");
		
		output.close();
	}
	
	
	/*
	 * Returns boolean representing whether the two given files are the identical or not
	 * 
	 * @param	x pathname of file1 being compared
	 * @param	y pathname of file2 being compared
	 */
	public static boolean fileIdentical (String x, String y) 
			throws IOException
	{

		String fileX = loadFile(x).toString();
		String fileY = loadFile(y).toString();
		
		return fileX.equals(fileY);
	}
	
	/*
	 * Creates a StringBuffer of the given file
	 * 
	 * @param	pathname name of the file wanted to turn into a StringBuffer
	 */
	public static StringBuffer loadFile(String pathname)
		throws IOException
	{
		File file = new File(pathname);
		StringBuffer strBuffer = new StringBuffer((int)file.length());
		BufferedReader input = new BufferedReader(new FileReader(file));
		
		int ch = 0;
		while((ch = input.read()) != -1)
			strBuffer.append((char)ch);
		
		input.close();
		
		return strBuffer;
	}
	
	
	public static void collectPrompts(StringBuffer x)
	{
		int pos = 1;
		
		Scanner input = new Scanner(System.in);
		String choice = "";
		
		while(pos <= x.length())
		{
			if(x.charAt(pos - 1) == '<')
			{
				System.out.println("Please enter a " + x.substring(pos, x.indexOf(">", pos))); //must be index of char from current index or else it will be going backwards
				choice = input.nextLine();
				subWords.add(choice);
			}
			pos++;
		}
	}
	
	public static void enterPrompts(StringBuffer x)
		throws IOException
	{
		int pos = 0;
		int subWordsElem = 1;
		
		while(pos < x.length())
		{
			if(x.charAt(pos) == '<')
			{
				x.replace(pos, x.indexOf(">", pos) + 1, subWords.get(subWordsElem - 1));
				subWordsElem++;
			}
			pos++;
		}
		
	}
	
	public static void outputPrintPrompt(String pathname, StringBuffer x)
	{
		Writer append2 = null;
		
		try
		{
			append2 = new FileWriter(pathname, true);
		}
		catch (IOException ex)
		{
			System.out.println("Part 3: Unable to Open File");
		}
		
		PrintWriter output = new PrintWriter(append2);
		output.println(x);
		
		output.close();
	}
}

