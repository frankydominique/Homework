/**
 * @author Franceska
 *
 */
import java.util.*;

public class Queen {

	/**
	 * fields
	 */
	private int x;
	private int y;
	private static List<Queen> validQueens;
	
	/**
	 * constructor: makes a new queen
	 * @param x this queen's x coordinate
	 * @param y this queen's y coordinate
	 */
	public Queen(int x, int y)
	{
		this.x = x;
		this.y = y;
		//validQueens = new ArrayList<Queen>();
	}
	
	/**
	 * returns the list of validQueens
	 * @return the list of validQueens
	 */
	public static List<Queen> getList()
	{
		if(validQueens == null)
			validQueens = new LinkedList<Queen>();
		return validQueens;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	public String toString()
	{
		return "Queen at: " + x + ", " + y;
	}
	
}
