

/**
 * @author Franceska
 *
 */
import java.util.*;
import java.io.*;
import javax.swing.*;

public class FileReading {

	//private static String pathname = System.getProperty("user.dir")+"/";
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("What is the name of your file?");
		String fileName = input.nextLine();
		File userFile = new File(fileName);
		
		String pathname = "output.txt";
		
		PrintWriter inputText = null;
		
		try
		{
			inputText = new PrintWriter(userFile);
		}
		catch (FileNotFoundException ex)
		{
			unableToOpenFile(pathname);
			System.exit(1);
		}
		
		outputPrint(pathname, bracesBalanced(userFile));
		
		outputBlank(pathname);
		
		
	}
	
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
	
	public static boolean bracesBalanced(File x)
		throws IOException
	{
		
		BufferedReader input = new BufferedReader(new FileReader(x));
		
		int pos = 0, beginBrace = 0, endBrace = 0;
		
		//problem is here
		System.out.println(input.read());
		
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
		output.println("\n\n");
		output.close();
	}
	
	public static void outputPrint(String pathname, boolean x)
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
	
	/*public static StringBuffer completeFile (String x) 
			throws IOException
	{
		File file = new File(x);
		StringBuffer strBuffer = new StringBuffer((int)x.length());
		BufferedReader input = new BufferedReader(new FileReader(x));
		
		int ch = 0;
		while((ch = input.read()) != -1)
			strBuffer.append((char)ch);
		
		input.close();
		return strBuffer;
	} */
	
	
}

