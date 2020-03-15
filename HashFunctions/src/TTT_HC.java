import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Franceska
 *
 */
public class TTT_HC extends Board{

	boolean[] winners;
	int numNoCollisions = 0;
	int initialCollisions = 0;
	int secondaryCollisions = 0;
	int multCollisions = 0;
	
	public TTT_HC(String s)
	{
		super(s);
		winners = new boolean[2003];
		addWinners();
	}
	
	public int tttHashCode()
	{
		int index = 0;
		
		for(int r = 0; r < 3; r++)
		{
			for(int c = 0; c < 3; c++)
			{
				char current = charAt(r, c);
				index = (r + 3) * (c + 3) * (int)(current) % 2003;
			}
			
		}
		
		System.out.println(index);
		return index;
	}
	
	//where index is where it has collided
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
				return i;
			}
			System.out.println(i + " is taken");
		}
		
		for(int i = 0; i < index; i++)
		{
			numCol++;
			if(!winners[i])
			{
				winners[i] = true;
				sortCollisionCount(numCol);
				return i;
			}
			System.out.println(i + " is taken");
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
	
	public void sortCollisionCount(int numCol)
	{
		if(numCol == 2) secondaryCollisions++;
		else if(numCol > 2) multCollisions++;
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
		return winners[tttHashCode()];
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		TTT_HC board = new TTT_HC("TicTacToe");
		
		System.out.println("No Collisions: " + board.numNoCollisions);
		System.out.println("Initial Collisions: " + board.initialCollisions);
		System.out.println("Secondary Collisions: " + board.secondaryCollisions);
		System.out.println("Multiple Collisions: " + board.multCollisions);
		
	}
	
}
