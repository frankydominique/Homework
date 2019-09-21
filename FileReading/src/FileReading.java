

/**
 * @author Franceska
 *
 */
import java.util.*;
import java.io.*;
import javax.swing.*;

public class FileReading {

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
			System.out.println("File doesn't exist");
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
		
		/*StringBuffer fileX = new StringBuffer()
		BufferedReader inputX = new BufferedReader(new FileReader(x));
		BufferedReader inputY = new BufferedReader(new FileReader(y));
		
		int ch = 0, ab = 0;
		boolean check = true;
		
		System.out.println("printing");
		
		while((ch = inputX.read()) != -1 && (ab = inputY.read()) != -1)
		{
			System.out.println("printing");
			if((char)ch != (char)ab)
				check = false;
		}
		
		inputX.close();
		inputY.close();
		*/
		String fileX = loadFile(x).toString();
		String fileY = loadFile(y).toString();
		
		return fileX.equals(fileY);
	}
	
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
	
}

