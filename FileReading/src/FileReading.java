

/**
 * @author Franceska
 *
 */
import java.util.*;
import java.io.*;
import javax.swing.*;

public class FileReading {
	
	private static ArrayList<String> subWords = new ArrayList(10);
	private static File output = new File("output.txt");
	private static int partNum = 1;

	/**
	 * args[0] is for braces balanced and compares to args[1]
	 * args[2] is the story
	 * args[3] is the words
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		File userFile = new File(args[0]);
		
		outputPrintBraces(bracesBalanced(userFile));
		
		outputBlank();
		
		outputPrintIdentical(fileIdentical(args[0], args[1]));
		
		outputBlank();
		
		StringBuffer story = loadFile(args[2]);
		
		if(args.length == 4)
		{
			collectPromptsFromFile(args[3]);
		} else {
			collectPrompts(story);
		}
		
		enterPrompts(story);
		
		outputPrintPrompt(story);
		
	}
	
	
	/**
	 * Void, writes up indicator that input file cannot be reached
	 * 
	 * @param pathname of file that cannot be reached
	 */
	public static void unableToOpenFile()
	{
		Writer append2 = null;
		
		try
		{
			append2 = new FileWriter(output, true);
		}
		catch (IOException ex)
		{
			System.out.println("Neither file exists");
		}
		
		PrintWriter output = new PrintWriter(append2);
		output.println("Part " + partNum + ": Unable to Open File");
		
		partNum++;
		output.close();
		
	}
	
	/**
	 * this method counts the number of opening braces and closing braces in a file to check if the numbers
	 * equal and are balanced
	 *@param name of input file
	 * 
	 */
	public static boolean bracesBalanced(File x)
	{
		int pos = 0, beginBrace = 0, endBrace = 0;
		BufferedReader input;
		
		try
		{
			input = new BufferedReader(new FileReader(x));
			
			while((pos = input.read()) != -1)
			{
				if(endBrace > beginBrace)
					return false;
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
		catch (IOException ex)
		{
			unableToOpenFile();
		}	
		
		return false;
	}
	
	/**
	 * prints a blank line
	 * 
	 * @param pathname filename where blank line is to be posted
	 */
	public static void outputBlank()
	{
		Writer append2 = null;
		
		try
		{
			append2 = new FileWriter(output, true);
		}
		catch (IOException ex)
		{
			System.out.println("File doesn't exist");
		}
		
		PrintWriter toPrint = new PrintWriter(append2);
		toPrint.println("\n");
		toPrint.close();
	}

	
	/**
	 * Checks if braces in the given file are balanced
	 * 
	 * @param	x outcome of bracesBalanced to be printed
	 */
	public static void outputPrintBraces(boolean x)
	{
		Writer append2 = null;
		
		try
		{
			append2 = new FileWriter(output, true);
		}
		catch (IOException ex)
		{
			System.out.println("File doesn't exist");
		}
		
		PrintWriter toPrint = new PrintWriter(append2);
		if(x == true)
			toPrint.println("Braces balanced.");
		else
			toPrint.println("Braces not balanced");
		
		toPrint.close();
	}
	
	
	/**
	 * Prints outcome of fileIdentical
	 * 
	 * @param	x outcome of fileIdentical to be printed
	 */
	public static void outputPrintIdentical(boolean x)
	{
		Writer append2 = null;
		
		try
		{
			append2 = new FileWriter(output, true);
		}
		catch (IOException ex)
		{
			System.out.println("Neither File Exists");
		}
		
		PrintWriter toPrint = new PrintWriter(append2);
		if(x == true)
			toPrint.println("Files Identical");
		else
			toPrint.println("Files Not Identical");
		
		toPrint.close();
	}
	
	
	/**
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
	
	/**
	 * Creates a StringBuffer of the given file
	 * 
	 * @param	pathname name of the file wanted to turn into a StringBuffer
	 */
	public static StringBuffer loadFile(String pathname)
	{
		File file = new File(pathname);
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
			unableToOpenFile();
		}	
		
		return strBuffer;
	}
	
	/**
	 * Gets a file, finds tags in file, and asks for the user to enter words matching the tags
	 * 
	 * @param	x StringBuffer of the file wanted to be chosen from loadFile
	 */
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
	
	/**
	 * collects word substitutions from a given file and adds them to the ArrayList of words to be used as
	 * 	substitutes
	 * 
	 * @param x name of the file with the words
	 */
	public static void collectPromptsFromFile(String x)
	{
		String file = loadFile(x).toString();
		Scanner scanner = new Scanner(file);
		String line;
		
		while(scanner.hasNextLine())
		{
			line = scanner.nextLine();
			subWords.add(line);
		}
	}
	
	/**
	 * Replaces the StringBuffer of the chosen file from loadFile with the words given
	 * 	in collectPrompts from ArrayList subWords
	 * 
	 * @param x the name of the file needing updating
	 */
	public static void enterPrompts(StringBuffer x)
		throws IOException
	{
		int pos = 0;
		int subWordsElem = 1;
		
		while(pos < x.length() && subWordsElem <= subWords.size())
		{
			if(x.charAt(pos) == '<')
			{
				x.replace(pos, x.indexOf(">", pos) + 1, subWords.get(subWordsElem - 1));
				subWordsElem++;
			}
			pos++;
		}
		
	}
	
	/**
	 * prints the newly updated StringBuffer story file to output file
	 * 
	 * @param	x StringBuffer of the file that will be copied
	 */
	public static void outputPrintPrompt(StringBuffer x)
	{
		Writer append2 = null;
		
		try
		{
			append2 = new FileWriter(output, true);
		}
		catch (IOException ex)
		{
			unableToOpenFile();
		}
		
		PrintWriter toPrint = new PrintWriter(append2);
		toPrint.println(x);
		
		toPrint.close();
	}
}

