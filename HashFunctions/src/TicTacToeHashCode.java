/**
 * @author Franceska
 *
 */
import java.util.*;
import java.io.*;

public class TicTacToeHashCode extends Board {

	/**
	 * Field
	 * winners - boolean array containing whether a board is a win or using
	 * 	the board's hashCode() as the index
	 */
	boolean[] winners; // True if the hash string that maps to this index is a winner, false otherwise

	/**
	 * Constructor, constructs a TicTacToeHashCode object
	 * @param s - the name of the TicTacToe Board
	 */
	TicTacToeHashCode(String s) {
		super(s);
      //TODO Instantiate winners array
		winners = new boolean[(int)Math.pow(3, 9)];
		addWinners();
	}

	@Override
	/**
	 * myHashCode - traverses through the elements on the board and generates an index for winners[]
	 * 	index for winners[] is made by multiplying the char's value by 3^(whatever index of the string)
	 * 	' ' is zero, x is 1, and o is two
	 */
	public int myHashCode() {
		
		char current;
		int[] digits = new int[9];
		int pos = 0;
		
		for(int row = 0; row < 3; row++)
		{
			for(int col = 0; col < 3; col++)
			{
				current = charAt(row, col);
				if(' ' == current)
				{
					digits[pos] = 0;
					pos++;
				}
				else if('x' == current) 
				{
					digits[pos] = 1;
					pos++;
				} else
				{
					digits[pos] = 2;
					pos++;
				}
			}
		}
		
		int objIndex = 0;
		int pow = 0;
		
		for(int x: digits)
		{
			objIndex += x * ((int)Math.pow(3, pow));
			pow++;
		}
		
		return objIndex;
	}

	/**
	 * another version of the hashCode above that takes in a string instead
	 * @param s the tictactoe string
	 * @return the index of the given tictactoe string for winners using the above function
	 */
	public int myHashCode(String s) {
			char current;
			int[] digits = new int[9];
			int pos = 0;
			
			for(int row = 0; row < 3; row++)
			{
				for(int col = 0; col < 3; col++)
				{
					current = charAt(s, row, col);
					if(' ' == current)
					{
						digits[pos] = 0;
						pos++;
					}
					else if('x' == current) 
					{
						digits[pos] = 1;
						pos++;
					} else
					{
						digits[pos] = 2;
						pos++;
					}
				}
			}
			
			int objIndex = 0;
			int pow = 0;
			
			for(int x: digits)
			{
				objIndex += x * ((int)Math.pow(3, pow));
				pow++;
			}
			
			return objIndex;
		}
	
	/**
	 * hashes the strings in Winners.txt to winners[] array and sets those indeces to true
	 */
	public void addWinners()
	{
		try
		{
			Scanner scanner = new Scanner(new File("Winners.txt"));
			String line;
			
			while(scanner.hasNextLine())
			{
				line = scanner.nextLine();
				
				setBoardString(line);
				winners[myHashCode()] = true;
			}
		} catch (FileNotFoundException e)
		{
			System.out.println("Cannot find file");
		}
		
	}
	
	@Override
	/**
	 * determines if the given string is a win or not
	 */
	public boolean isWin(String s) {
		int index = myHashCode(s);
		
		return winners[index];
      }
      
	@Override
	/**
	 * determines if this TicTacToeHashCode board is a win or not
	 */
	public boolean isWin() {
		TicTacToeHashCode t = new TicTacToeHashCode(getBoardString());
		t.myHashCode();
		
		return winners[myHashCode()];
      }
      
	public static void main(String[] args) throws InterruptedException {
		TicTacToeHashCode board = new TicTacToeHashCode("Tic Tac Toe");
		int numTests = 0; //addition
		 while (numTests < 10) { //previously set to true
		   board.displayRandomString();
		   Thread.sleep(4000);
		   numTests++; //addition
		 }
		
		 System.out.println("Displaying Franky's tests: ");
		 
		 try
		 {
			 Scanner scanner = new Scanner(new File("TTT_Tests.txt"));
			 String line;
			 
			 while(scanner.hasNextLine())
			 {
				 line = scanner.nextLine();
				 board.show(line);
				 board.setHashCodeLabel(board.myHashCode());
				 board.setWinnerLabel(board.isWin());
				 Thread.sleep(4000);
			 }
		 } catch (FileNotFoundException e)
		 {
			 System.out.println("File not found");
		 }
	}

}

