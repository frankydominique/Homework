import java.util.*;
import java.io.*;
import javax.swing.*;

/**
 * @author Franceska
 *
 */
public class Knapsack {

	private static File[] files = new File[3];
	private static int[] limits = new int[10];
	private static int limitPos = 0;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File test = new File("Tester.txt");
		readBigFile(test);
		
		for(int x = 0; x < 3; x++)
			System.out.println(files[x].getName());
		
		for(File x: files)
			readFileLimit(x);
		
		for(int x: limits)
			System.out.println(x);
	}
	
	public static int knapsack(int[] w, int n, int limit)
	{
		if(limit <= 0 || n < 0)
			return 0;
		else if (w[n] > limit)
			return knapsack(w, n-1, limit);
		else
		{
			int withLast = knapsack(w, n-1, limit);
			int withoutLast = w[n] +  knapsack(w, n-1, limit - w[n]);
			if(withLast > withoutLast)
				return withLast;
			return withoutLast;
		}
	}
	
	public static int knapsackSum(int[] w, int n, int limit, List<Integer> list)
	{
		if(limit <= 0 || n < 0)
			return 0;
		else if (w[n] > limit)
		{
			int val = knapsack(w, n-1, limit);
			list.add(val);
			return val;
		}
		else
		{
			int withLast = knapsack(w, n-1, limit);
			int withoutLast = w[n] + knapsack(w, n-1, limit - w[n]);
			if(withLast > withoutLast)
			{
				list.add(withLast);
				return withLast;
			}
			list.add(withoutLast);
			return withoutLast;
		}
	}

	public static void readBigFile(File pathname)
	{
		File file = pathname;
		StringBuffer strBuffer = new StringBuffer((int)file.length());
		
		try
		{
			Scanner scanner = new Scanner(file);
			String line;
			int x = 0;
			
			while(scanner.hasNextLine())
			{
				line = scanner.nextLine();
				files[x] = new File(line);
				x++;
			}
			
			scanner.close();
		}
		catch (IOException ex)
		{
			System.out.println("Not a valid File");
		}
	}
	
	public static void readFileLimit(File pathname)
	{
		File file = pathname;
		StringBuffer strBuffer = new StringBuffer((int)file.length());
		
		try
		{
			//makes a BufferedReader to read the file
			BufferedReader input = new BufferedReader(new FileReader(file));
			
			//adds the file into a string to read
			int ch = 0;
			while((ch = input.read()) != -1)
				strBuffer.append((char)ch);
			
			input.close();
			
			Scanner scanner = new Scanner(file);
			
			limits[limitPos] = Integer.parseInt(scanner.nextLine());
			limitPos++;
		}
		catch (IOException ex)
		{
			System.out.println("Not a valid File");
		}
	}
	
	public void printFile()
	{
		
	}
	
	public String printNums(List<Integer> list)
	{
		return "";
	}
}
