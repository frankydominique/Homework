import java.util.*;
import java.io.*;
import javax.swing.*;

/**
 * @author Franceska
 * This class has two knapsack algorithms and prints the output of one algorithm
 */
public class Knapsack {

	/**
	 * Fields
	 */
	private static File[] files;
	private static File output = new File("knapsack.txt");
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//puts in the test file
		
		Scanner input = new Scanner(System.in);
		File test;
		if(args.length > 0)
			test = new File(args[0]);
		else {
			System.out.println("Please enter file name: ");
			String path = input.nextLine();
			test = new File(path);
		}
		
		
		
		//reads the test file and divides the test file into the smaller files to be used
		readBigFile(test);
		
		printFile();
		
	}
	
	/**
	 * this finds the best combination of values within the limit but with the elements of
	 * 	the most value
	 * @param w the array with values
	 * @param n the index of the last element to be considered within the array
	 * @param limit the highest amount the values of the elements can be
	 * @return the best combination of values
	 */
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
	
	/**
	 * this finds the best combination of values within the limit but with the elements of
	 * 	the most value, prints the values used to the provided list
	 * @param w
	 * @param n
	 * @param limit
	 * @param list
	 * @return the best combination of elements still within the limit
	 */
	public static int knapsackSum(int[] w, int n, int limit, List<Integer> list)
	{
		if(limit <= 0 || n < 0)
			return 0;
		else if(w[n] > limit)
		{
			List<Integer> temp = new ArrayList<Integer>();
			int x = knapsackSum(w, n - 1, limit, temp);
			list.addAll(temp);
			return x;
		}
		else
		{
			List<Integer> withoutLastList = new ArrayList<Integer>();
			List<Integer> withLastList = new ArrayList<Integer>();
			
			withLastList.add(w[n]);
			
			int withoutLast = knapsackSum(w, n-1, limit, withoutLastList);
			int withLast = w[n] + knapsackSum(w, n-1, limit - w[n], withLastList);
			
			if(withoutLast > withLast)
			{
				
				list.addAll(withoutLastList);
				return withoutLast;
			} else
			
			list.addAll(withLastList);
			return withLast;
		}
	}

	/**
	 * gets big file and breaks the different files and adds them into files[]
	 * @param pathname the name of the file containing all of the files to be looked through
	 */
	public static void readBigFile(File file)
	{
		try
		{
			//counts how many files there are and then adds the files to file
			BufferedReader reader = new BufferedReader(new FileReader(file));
			int lines = 0;
			while (reader.readLine() != null) lines++;
			reader.close();
			files = new File[lines];
			
			//will go through each file in the document and add it to the array
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
	
	/**
	 * reads the limit of each file
	 * @param pathname the name of the file with all the values and a limit
	 */
	public static int readLimit(File file)
	{
		try
		{
			Scanner input = new Scanner(file);
			
			if(input.hasNextLine())
			{
				int limit = input.nextInt();
				return limit;
			}
			
		}
		catch (IOException ex)
		{
			System.out.println("Not a valid File: " + file.getName());
		}
		return -1;
	}
	
	/**
	 * reads the values of each file
	 * @param file the file to be read
	 * @return an int array of the possible values to be added
	 */
	public static int[] readValues(File file)
	{
		//System.out.println(file.getName());
		int[] temp;
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(file));
			int lines = 0;
			while (input.readLine() != null) lines++;
			input.close();
			
			temp = new int[lines];
			input.close();
			
			int pos = 0;
			Scanner reader = new Scanner(file);
			
			//to skip the first line
			if(reader.hasNextLine())
				reader.nextLine();
			
			int x;
			while(reader.hasNextLine() && reader.hasNextInt())
			{
				x = reader.nextInt();
				//System.out.println(x);
				temp[pos] = x;
				pos++;
			}
			
			return temp;
			
		}
		catch (IOException ex)
		{
			System.out.println("Not a valid File");
		}
		temp = new int[0];
		return temp;
	}
	
	/**
	 * prints all the top values into the output file knapsack.txt
	 */
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
			File current = files[i];
			int limit = readLimit(current);
			int[] values = readValues(current);
			
			ArrayList<Integer> usedValues = new ArrayList<Integer>();
			knapsackSum(values, values.length -1, limit, usedValues);
			
			toPrint.print(current + "\t" + limit + "\t" + printNums(usedValues)); 
			toPrint.println();
			
			for(Integer x: usedValues)
			{
				if(x != 0)
					toPrint.print(x + " pound melon \n");
			}
			
			toPrint.println();
			toPrint.println();
		}
		
		toPrint.close();
		
	}
	
	/**
	 * gathers the nums to be printed from the list generated of the values that add up
	 * @param list the list of used values corresponding with a certain file
	 * @return string representation of all the used values
	 */
	public static String printNums(List<Integer> list)
	{
		List<Integer> listUpdated = new ArrayList<Integer>();
		
		for(Integer x: list)
			if(x != 0)
				listUpdated.add(x);
			
		String temp = listUpdated.toString();
		String updated = temp.substring(1);
		String updated2 = updated.substring(0, updated.length() - 1);
		
		return updated2;
	}
}
