import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Franceska
 *
 */
public class TTT_HC extends Board{

	/**
	 * fields
	 */
	boolean[] winners;
	int numNoCollisions = 0;
	int initialCollisions = 0;
	int secondaryCollisions = 0;
	int multCollisions = 0;
	int[] colInTenth = new int[10];
	int[] colInQuarter = new int[4];
	
	/**
	 * constructor
	 * @param s the name of the tictactoe board
	 */
	public TTT_HC(String s)
	{
		super(s);
		winners = new boolean[2003];
		
		for(int i = 0; i < colInTenth.length; i++)
			colInTenth[i] = 0;
			
		addWinners();
	}
	
	/**
	 * my hash function that finds the last character on the board, adds 3 to its row and column,
	 * 	multiplies them together and finds the int value of the char at this position, and mods it by the winners
	 * 	array size
	 * @return the index of this TTT_HC board
	 */
	public int tttHashCode()
	{
		int index = 0;
		
		for(int r = 0; r < 3; r++)
		{
			for(int c = 0; c < 3; c++)
			{
				char current = charAt(r, c);
				index = (r + 3) * (c + 3) * (int)(current);
			}
			
		}
		index %= 2003;
		
		return index;
	}
	
	/**
	 * computes the number of types of collisions and handles the collision that occured at index
	 * @param index where the collision occurred
	 * @return a new int that corresponds to an index without collisions for this board
	 */
	public int tttHashCodeCollisions(int index)
	{
		initialCollisions++;
		
		int numCol = 0;
		for(int i = index + 1; i < winners.length; i++)
		{
			numCol++;
			if(!winners[i])
			{
				winners[i] = true;
				sortCollisionCount(numCol);
				colInTenth[i / 201] += 1;
				colInQuarter[i / 501] += 1;
				return i;
			}
		}
		
		for(int i = 0; i < index; i++)
		{
			numCol++;
			if(!winners[i])
			{
				winners[i] = true;
				sortCollisionCount(numCol);
				colInTenth[i / 201] += 1;
				colInQuarter[i / 501] += 1;
				return i;
			}
			
		}
		
		return index;
		
	}
	
	/**
	 * adds the Winners.txt file to set up the winners[] array with correct values
	 */
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
				
				if(winners[index] == true)
				{
					index = tttHashCodeCollisions(tttHashCode());
				} else
					numNoCollisions++;
				
				
				winners[index] = true;	
			}
			scanner.close();
		} catch (FileNotFoundException e)
		{
			System.out.println("Cannot find file");
		}
	}
	
	/**
	 * counts the number of collisions that happened for this board as it was being hashed
	 * @param numCol - the number of collisions calculated for this board as it was being hashed
	 */
	public void sortCollisionCount(int numCol)
	{
		if(numCol == 2) secondaryCollisions++;
		else if(numCol > 2) multCollisions++;
	}
	
	/**
	 * necessary because abstract in superclass, not used
	 */
	int myHashCode()
	{
		return -1;
	}

	/**
	 * necessary because abstract in super class, not used
	 */
	boolean isWin(String s)
	{
		return false;
	}

	/**
	 * returns whether this board is a winner or not by using tttHashCode and checking winners[]
	 */
	boolean isWin()
	{
		return winners[tttHashCode()];
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		TTT_HC board = new TTT_HC("TicTacToe");
		
		System.out.println("No Collisions: " + board.numNoCollisions);
		System.out.println("Initial Collisions: " + board.initialCollisions);
		System.out.println("Secondary Collisions: " + board.secondaryCollisions);
		System.out.println("Multiple Collisions: " + board.multCollisions);
		
		System.out.println("collisions in each quarter of array: ");
		for(int x: board.colInQuarter) System.out.print(x + " ");
		
		System.out.println();
		
		System.out.println("collisions in each tenth of array: ");
		for(int x: board.colInTenth) System.out.print(x + " ");
	}
	
}
