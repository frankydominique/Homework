/**
 * @author Franceska
 *
 */

//TODO Make sure you remove all of the TODO comments from this file before turning it in

public class TicTacToeHashCode extends Board {

	boolean[] winners; // True if the hash string that maps to this index is a winner, false otherwise

	TicTacToeHashCode(String s) {
		super(s);
      //TODO Instantiate winners array
		}

	@Override
	public int myHashCode() {
      // TODO write your hashcode function
		return 0;
	}

	@Override
	//complete
	public boolean isWin(String s) {
      // TODO write an isWin method that takes in a String.  This should not change the board.  Board has an additional charAt 
      // TODO method to facilitate this
		TicTacToeHashCode input = new TicTacToeHashCode(s);
		return winners[input.myHashCode()];
      }
      
	@Override
	//complete
	public boolean isWin() {
      // TODO write an isWin method that uses boardString
		String s = this.getBoardString();
		return isWin(s);
      }
      
	public static void main(String[] args) throws InterruptedException {
		TicTacToeHashCode board = new TicTacToeHashCode("Tic Tac Toe");
		 while (true) {
		   board.displayRandomString();
		   Thread.sleep(4000);
		 }
	}

}

