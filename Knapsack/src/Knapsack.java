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
	private static int[][] values = new int[10][10];
	private static int valuesXPos = 0;
	private static ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
	private static File output = new File("knapsack.txt");
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//puts in the test file
		
		File test = new File("Tester.txt");
		
		//reads the test file and divides the test file into the smaller files to be used
		readBigFile(test);
		
		//adds the limits and values to the corresponding lists
		for(File x: files)
			readLimsAndVals(x);
		
		
		
		//do knapsack - knapsack is working
		for(int i = 0; i < files.length; i++)
		{
			System.out.println(knapsackSum(values[i], values[i].length - 1, limits[i], lists.get(i)));
		}
		printFile();
		
		/*ArrayList<Integer> test = new ArrayList<Integer>();
		int[] set = {1, 2, 3, 4, 5};
		System.out.println(knapsackSum(set, set.length - 1, 6, test));
		for(Integer x: test)
			System.out.println(x);*/
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
			int val = knapsackSum(w, n-1, limit, list);
			list.add(val);
			return val;
		}
		else
		{
			//int withoutLast = knapsack(w, n-1, limit);
			List<Integer> withoutLastList = new ArrayList<Integer>();
			List<Integer> withLastList = new ArrayList<Integer>();
			withLastList.add(w[n]);
			int withoutLast = knapsackSum(w, n-1, limit, withoutLastList);
			int withLast = w[n] + knapsackSum(w, n-1, limit - w[n], withLastList);
			
			if(withoutLast > withLast)
			{
				list.add(withoutLast);
				return withoutLast;
			}
			list.addAll(withLastList);
			return withLast;
		}
	}

	//gets big file and breaks the different files and places it into files
	public static void readBigFile(File pathname)
	{
		File file = pathname;
		
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
	
	//reads the limit of each file
	public static void readLimsAndVals(File pathname)
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
			
			Scanner scanner = new Scanner(file);
			
			limits[limitPos] = Integer.parseInt(scanner.nextLine());
			limitPos++;
			
			int pos = 0;
			while(scanner.hasNextLine())
			{
				values[valuesXPos][pos] = scanner.nextInt();
				pos++;
			}
			lists.add(new ArrayList<Integer>(pos));
			valuesXPos++;
			
			scanner.close();
			input.close();
			
		}
		catch (IOException ex)
		{
			System.out.println("Not a valid File");
		}
	}
	
	//prints all the top values into the output file
	public static void printFile()
	{
		Writer append2 = null;
		
		try
		{
			append2 = new FileWriter(output, true);
		}
		catch (IOException ex)
		{
			System.out.println("Unable to open file");
		}
		
		PrintWriter toPrint = new PrintWriter(append2);
		
		for(int i = 0; i < files.length; i++)
		{
			toPrint.print(files[i] + "\t" + limits[i] + "\t" + printNums(lists.get(i))); //+ printNums(files[i]));
			toPrint.println();
			
			for(Integer x: lists.get(i))
				if(x != 0)
					toPrint.print(x + "pound melon \n");
			
			toPrint.println();
			toPrint.println();
		}
		
		toPrint.close();
		
	}
	
	//gathers the nums to be printed from the list generated of the values that add up
	public static String printNums(List<Integer> list)
	{
		StringBuffer nums = new StringBuffer();
		
		for(Integer x: list)
		{
			if(x != 0)
				nums.append(x + ", ");
		}
		
		return nums.toString();
	}
}
