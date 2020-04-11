/**
 * @author Franceska
 *
 */
import java.awt.Color;
import java.awt.GridLayout;
import java.util.*;

import javax.swing.*;

public class EightQueensBoard {
	
	/**
	 * Fields
	 */
	private static final int SIZE = 7;
	private static JFrame window;
	private static ChessSquarePanel[][] panels;

	/**
	 * constructor
	 */
	public EightQueensBoard()
	{
		panels = new ChessSquarePanel[8][8];
		setUpBoard();
		window.setVisible(true);
	}

	/**
	 * recursively finds a solution for the board with the first coordinate being (0,0)
	 * @param list the list of queens' positions
	 * @return whether this combination has a solution or not
	 */
	public boolean addQueens(List<Queen> list)
	{
		if(list.size() > 8)
			return false;
		else if(list.size() == 8)
			return true;
		else if(list.isEmpty())
		{
			list.add(new Queen(0,0));
			updateBoard(list);
			return addQueens(list);
		} else {
			Queen previous = list.get(list.size() - 1);
			Queen addition = new Queen(previous.getX() + 1, 0);
			
			while(!isLegal(addition, list))
			{
				if(addition.getY() < SIZE)
					addition.setY(addition.getY() + 1);
				else
				{
					addition = list.remove(list.size() - 1);
					addition.setY(addition.getY() + 1);
				}
			}
			list.add(addition);
			updateBoard(list);
			return addQueens(list);
		}
	}

	/**
	 * recursively finds a solution for the board, used for having the starting position go down the rows
	 * @param list the list of queens' positions
	 * @param r the starting point for the row
	 * @param c the starting point for the column
	 * @return whether this combination has a solution or not
	 */
	public boolean addQueens(List<Queen> list, int r, int c)
	{
		if(list.size() > 8)
			return false;
		else if(list.size() == 8)
			return true;
		else if(list.isEmpty())
		{
			list.add(new Queen(r,0));
			updateBoard(list);
			return addQueens(list,r, c);
		} else {
			Queen previous = list.get(list.size() - 1);
			Queen addition = new Queen(0, previous.getY() + 1);
			
			while(!isLegal(addition, list))
			{
				if(addition.getX() < SIZE)
					addition.setX(addition.getX() + 1);
				else
				{
					addition = list.remove(list.size() - 1);
					addition.setX(addition.getX() + 1);
				}
			}
			list.add(addition);
			updateBoard(list);
			return addQueens(list, r, c);
		}
	}
	
	/**
	 * recursively finds a solution for the board, used for having the starting position go across the columns
	 * @param list the list of queens' positions
	 * @param c the starting point for the column
	 * @return whether this combination has a solution or not
	 */
	public boolean addQueens(List<Queen> list, int c)
	{
		if(list.size() > 8)
			return false;
		else if(list.size() == 8)
			return true;
		else if(list.isEmpty())
		{
			list.add(new Queen(0,c));
			updateBoard(list);
			return addQueens(list,c);
		} else {
			Queen previous = list.get(list.size() - 1);
			Queen addition = new Queen(previous.getX() + 1, 0);
			
			while(!isLegal(addition, list))
			{
				if(addition.getY() < SIZE)
					addition.setY(addition.getY() + 1);
				else
				{
					addition = list.remove(list.size() - 1);
					addition.setY(addition.getY() + 1);
				}
			}
			list.add(addition);
			updateBoard(list);
			return addQueens(list, c);
		}
	}
	
	/**
	 * returns whether this position on the board is legal
	 * @param queen the queen to be added (w its x and y coordinates)
	 * @param list the list of queens currently being used
	 * @return whether this position on the board is legal
	 */
	public boolean isLegal(Queen queen, List<Queen> list)
	{
		if(queen.getX() > 7 || queen.getY() > 7)
			return false;
		
		for(Queen other: list)
		{
			//checks if the other queens are on the same row
			if(other.getX() == queen.getX())
				return false;
			//checks if the other queens are on the same column
			if(other.getY() == queen.getY())
				return false;
			//checks if the other queens are on the same diagonal
			if(Math.abs(other.getY() - queen.getY()) ==
					Math.abs(other.getX() - queen.getX()))
				return false;
		}
		return true;
	}

	/**
	 * sets up a clear board with no queens
	 */
	public static void setUpBoard()
	{
		window = new JFrame("EightQueensBoard");
		window.setBounds(100, 100, 400, 400);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel setup = new JPanel();
		GridLayout test = new GridLayout(8, 8);
		setup.setLayout(test);
		
		
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				
				if((i + j) % 2 == 0)
				{
					ChessSquarePanel panel = new ChessSquarePanel(Color.BLACK, false);
					panels[i][j] = panel;
					setup.add(panel);
				}
				else
				{
					ChessSquarePanel panel = new ChessSquarePanel(Color.WHITE, false);
					panels[i][j] = panel;
					setup.add(panel);
				}
			}
		}
		window.add(setup);
		//window.setVisible(true);
	}

	/**
	 * updates a queen at a certain position
	 * @param queen the queen to put at a certain position
	 * @param b the new value of the flag
	 */
	public static void update(Queen queen, boolean b)
	{
		for(ChessSquarePanel panel: panels[queen.getX()])
			panel.updateFlag(false);
		
		for(int i = 0; i < 8; i++)
			panels[i][queen.getY()].updateFlag(false);
		
		panels[queen.getX()][queen.getY()].updateFlag(b);
	}
	
	/**
	 * updates the board with the current list of queens in their positions
	 * @param list the current list of queens in their positions
	 */
	public static void updateBoard(List<Queen> list)
	{
		for(Queen queen: list)
			update(queen, true);
	}
	
	public static void main(String[] args)
	{
		ArrayList<Queen> firstList = new ArrayList<Queen>();
		EightQueensBoard board = new EightQueensBoard();
		board.addQueens(firstList);
		
		ArrayList<ArrayList<Queen>> bigList = new ArrayList<ArrayList<Queen>>();
		for(ArrayList<Queen> list: bigList)
			list = new ArrayList<Queen>();
		
		for(int i = 0; i < 8; i++)
		{
			ArrayList<Queen> temp = new ArrayList<Queen>();
			EightQueensBoard newBoard = new EightQueensBoard();
			if(newBoard.addQueens(temp, i))
				bigList.add(temp);
			
			ArrayList<Queen> temp2 = new ArrayList<Queen>();
			EightQueensBoard newBoard2 = new EightQueensBoard();
			if(newBoard2.addQueens(temp2, i, 0))
				bigList.add(temp2);
		}
		
		System.out.println(bigList.size());
	}
	
	
	
}