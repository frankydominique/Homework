/**
 * @author Franceska
 *
 */
import java.util.*;
import java.io.*;

//TODO Make sure you remove all of the TODO comments from this file before turning it in

public class TicTacToeHashCode extends Board {

	boolean[] winners; // True if the hash string that maps to this index is a winner, false otherwise

	TicTacToeHashCode(String s) {
		super(s);
      //TODO Instantiate winners array
		winners = new boolean[(int)Math.pow(3, 9)];
		addWinners();
	}

	@Override
	//complete
	public int myHashCode() {
      // TODO write your hashcode function
		
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

	//i added this method
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
	public boolean isWin(String s) {
      // TODO write an isWin method that takes in a String.  This should not change the board.  Board has an additional charAt 
      // TODO method to facilitate this
		
		
		return true;
      }
      
	@Override
	//complete
	public boolean isWin() {
      // TODO write an isWin method that uses boardString
		//String s = getBoardString();
		
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

