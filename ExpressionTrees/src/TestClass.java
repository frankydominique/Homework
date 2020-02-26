import java.util.*;
import java.io.*;

public class TestClass {

	/**
	 * fields
	 */
	private static File testFile;
	private static final String backUpFile = "postFixExpressions.txt";
	private static String[] expressions;
	private static final File output = new File("Franky_Expressions.txt");
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//makes the file to be read
		if(args.length > 0)
			enterInputFile(args[0]);
		else
			enterInputFile(backUpFile);
		
		enterExpressions();
		
		for(String x: expressions)
			test(x);
	}
	

	public static void enterInputFile(String file)
	{
		Scanner prompt = new Scanner(System.in);
		
		try
		{
			File testerFile = new File(file);
			FileReader reader = new FileReader(testerFile);
			testFile = testerFile;
		}
		catch (IOException ex)
		{
			System.out.println("Please enter a new file name: ");
			testFile = new File(prompt.nextLine());
			prompt.close();
		}
	}
	
	public static void enterExpressions()
	{
		try
		{
			//counts how many files there are and then adds the files to file
			BufferedReader reader = new BufferedReader(new FileReader(testFile));
			int lines = 0;
			while (reader.readLine() != null) lines++;
			reader.close();
			expressions = new String[lines];
			
			Scanner scanner = new Scanner(testFile);
			String line;
			int x = 0;
			
			while(scanner.hasNextLine())
			{
				line = scanner.nextLine();
				expressions[x] = line;
				x++;
			}
			
			scanner.close();
		}
		catch (IOException ex)
		{
			System.out.println("Error");
		}

	}
	
	public static void test(String x)
	{
		//builds the string array of characters to send in
		if(x.length() <= 0)
			System.out.println("error");
		
		String current;
		int count = 0;
		
		for(int i= 0; i < x.length(); i++)
		{
			current = x.charAt(i) + "";
			if(!current.equals(" "))
			{
				count++;
			}
		}
		
		String[] brokenExpression = new String[count];
		int pos = 0;
		
		for(int i= 0; i < x.length(); i++)
		{
			current = x.charAt(i) + "";
			if(!current.equals(" "))
			{
				brokenExpression[pos] = current;
				pos++;
			}
		}
		
		printOutput(brokenExpression);
	}
	
	public static void printOutput(String[] expression)
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
		
		ExpressionTree test = (ExpressionTree)ExpressionTree.buildTree(expression);
		
		toPrint.println(test.evalTree());
		toPrint.println(test.toPrefixNotation());
		toPrint.println(test.toInfixNotation());
		toPrint.println(test.toPostfixNotation());
		toPrint.println(test.postfixEval(expression));
			
		toPrint.println();
		toPrint.println();
		
		toPrint.close();
		
	}

}
