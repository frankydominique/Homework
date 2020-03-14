import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Franceska
 *
 */
public class TTT_HC extends Board{

	boolean[] winners;
	int numCollisions = 0;
	int numNoCollisions = 1400;
	int winnersIndex = 0;
	
	public TTT_HC(String s)
	{
		super(s);
		winners = new boolean[1400];
		addWinners();
	}
	
	public int tttHashCode()
	{
		int rowTotal  = 0;
		int rowNum = 1;
		int[] totals = new int[3];
		
		for(int r = 0; r < 3; r++)
		{
			for(int c = 0; c < 3; c++)
			{
				char current = charAt(r, c);
				if('x' == current) rowTotal+= 2;
				else if('o' == current) rowTotal += 1;
			}
			totals[r] = rowTotal * rowNum;
			rowTotal = 0;
			rowNum++;
		}
		
		int index = totals[0] + totals[1] + totals[2];
		
		return index;
	}
	
	public int tttHashCodeCollisions()
	{
		
		numCollisions++;
		
		int rowTotal  = 0;
		int[] totals = new int[3];
		
		for(int r = 0; r < 3; r++)
		{
			for(int c = 0; c < 3; c++)
			{
				char current = charAt(r, c);
				if('x' == current) rowTotal+= 2;
				else if('o' == current) rowTotal += 1;
			}
			totals[r] = rowTotal;
			rowTotal = 0;
		}
		
		int index = 0;
		if(numCollisions % 11 == 0)
			index =  2 * totals[0] + totals[1] + 3 * totals[2];
		else if (numCollisions % 3 == 0)
			index =  3 * totals[0] + 2 * totals[1] + totals[2];
		else if(numCollisions % 2 == 0)
			index =  totals[0] + 3 * totals[1] + 2 * totals[2];
		else
		{
			winnersIndex++;
			return winnersIndex - 1;
		}
		
		return index;
	}
	
	public void addWinners()
	{
		System.out.println("adding winners...");
		try
		{
			Scanner scanner = new Scanner(new File("Winners.txt"));
			String line;
			
			while(scanner.hasNextLine())
			{
				line = scanner.nextLine();
				
				setBoardString(line);
				int index = tttHashCode();
				System.out.println(index);
				
				if(winners[index] != true)
					numNoCollisions--;
				
				while(winners[index] == true)
				{
					index = tttHashCodeCollisions();
				}
				
				System.out.println(index + " is taken");
				winners[index] = true;	
			}
			
		} catch (FileNotFoundException e)
		{
			System.out.println("Cannot find file");
		}
	}
	
	int myHashCode()
	{
		return -1;
	}

	boolean isWin(String s)
	{
		return false;
	}

	boolean isWin()
	{
		if(tttHashCode() > 1399)
			return false;
		
		return winners[tttHashCode()];
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		TTT_HC board = new TTT_HC("TicTacToe");
		
		System.out.println("Collisions: " + board.numCollisions);
		System.out.println("No Collisions: " + board.numNoCollisions);
		
	}
	
}
