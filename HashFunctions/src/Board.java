/**
 * @author Franceska
 *
 */
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

abstract class Board extends JFrame implements ActionListener {

	/**
	 * Fields
	 * JButton buttons - a button object array
	 * JLabel lblHashCode - holds the hashcode for the given board
	 * JLabel lblWinTitle - holds the string that says whether the board is a string or not
	 * 
	 * boardString - the tictactoe order of the board
	 */
	private JButton buttons[][];
	private JLabel lblHashCode;
	private JLabel lblWinTitle;

	private String boardString = "";

	/**
	 * Constructor for this TicTacToe board
	 * @param title the name of this TicTacToe board
	 */
	public Board(String title) {
		super(title);
		setupFrame();
	}

	/**
	 * sets lblHashCode to the hashcode of this board
	 * @param hashcode the hashcode of this board using TicTacToeHashCode.myHashCode()
	 */
	public void setHashCodeLabel(int hashcode) {
		lblHashCode.setText("" + hashcode);
	}

	/**
	 * sets lblWinTitle to whether this board is a win or not
	 * @param result String version of the board's value in winners[]
	 */
	public void setWinnerLabel(String result) {
		lblWinTitle.setText(result);
	}

	/**
	 * sets lblWinTitle to whether this board is a win or not
	 * @param result boolean version of the board's value in winners[]
	 */
	public void setWinnerLabel(boolean result) {
		if (result)
			setWinnerLabel("Winner");
		else
			setWinnerLabel("Loser");
	}

	// required because of abstract method, but not used
	@Override
	/**
	 * overrides the actionPerformed in JFrame to accept if the board has been tampered with/changed
	 * checks if there was cursor action and changes board to accommodate cursor action
	 */
	public void actionPerformed(ActionEvent e) {
	}

	JPanel setupPanelOne() {
		JPanel panel = new JPanel();
		JLabel lblHCTitle = new JLabel("Hash Code");
		;
		lblHashCode = new JLabel("" + myHashCode());
		lblWinTitle = new JLabel(""); // Will say either Winner or Loser
		setWinnerLabel(TicTacToe.isWin(boardString));
		panel.setLayout(new FlowLayout());
		panel.add(lblHCTitle);
		panel.add(lblHashCode);
		panel.add(lblWinTitle);
		return panel;
	}

	/**
	 * uses a general format from JPanel to make an even graphic and sets the values to display them on the board
	 * makes them interactive with cursor
	 * @return a changed JPanel accommodating the change brought on by the cursor
	 */
	private JPanel setupPanelTwo() {
		JButton b;
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(TicTacToe.ROWS, TicTacToe.COLS));
		buttons = new JButton[TicTacToe.ROWS][TicTacToe.COLS];

		int count = 1;

		for (int r = 0; r < TicTacToe.ROWS; r++)
			for (int c = 0; c < TicTacToe.COLS; c++) {
				char ch = randomXO();
				b = new JButton("" + ch);
				boardString += ch;
				b.setActionCommand("" + r + ", " + c);
				b.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton btn = (JButton) e.getSource();
						btn.setText("" + cycleValue(btn.getText().charAt(0)));
						resetBoardString();
						setHashCodeLabel(myHashCode());
						setWinnerLabel(isWin());

					}
				});
				panel.add(b);
				buttons[r][c] = b;
			}

		return panel;
	}

	/**
	 * returns a new character to switch out the old character with
	 * @param ch old character
	 * @return new character replacing the old character
	 */
	private static char cycleValue(char ch) {
		switch (ch) {
		case 'x':
			return 'o';
		case 'o':
			return ' ';
		default:
			return 'x';
		}
	}

	/**
	 * sets up the entire Board frame onto the monitor/screen
	 */
	private void setupFrame() {
		JPanel panel2 = new JPanel();

		// Setup Frame
		super.setSize(250, 200);
		super.setLocationRelativeTo(null);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));

		// Setup Panels
		panel2 = setupPanelTwo(); // panelOne displays a value that requires panelTwo to be ready
		super.add(setupPanelOne());
		super.add(panel2);

		super.setVisible(true);
	}

	/**
	 * returns a random x, o, or ' ' using Math.random()
	 * @return a random character of x, o, or ' '
	 */
	private char randomXO() {
		int rnd = (int) (Math.random() * TicTacToe.CHAR_POSSIBILITIES);
		switch (rnd) {
		case 1:
			return 'x';
		case 2:
			return 'o';
		default:
			return ' ';
		}
	}

	abstract int myHashCode();

	abstract boolean isWin(String s);

	abstract boolean isWin();

	/**
	 * finds the character at the given position of this boardString as if it were on the 3x3 board
	 * @param row the row to find this character
	 * @param col the column to find this character
	 * @return the character at this position of the boardString
	 */
	public char charAt(int row, int col) {
		String value = buttons[row][col].getText();
		if (value.length() > 0)
			return value.charAt(0);
		else
			return '*';
	}
   
	/**
	 * finds the character that would have been in a certain row and column of the 3x3 board without
	 * 	updating the board and uses just the String of the tictactoe layout
	 * @param s the string representation of the tictactoe
	 * @param row the row to find this char
	 * @param col the column to find this char
	 * @return the char at the specified row and column of this string if it was in a 3x3 board
	 */
   public char charAt(String s, int row, int col) {
     int pos = row * TicTacToe.COLS + col;
     if (s.length() >= pos)
       return s.charAt(pos);
     else
       return '*';   
   }

   /**
    * adds the boardString or string representation of the board to the board and displays it
    * @param s the string representation of the tictactoe sequence
    */
	public void show(String s) {
		int pos = 0;
		String letter;
		for (int r = 0; r < TicTacToe.ROWS; r++)
			for (int c = 0; c < TicTacToe.COLS; c++) {
				char ch = s.charAt(pos);
				switch (ch) {
				case '1':
					letter = "x";
					break;
				case '2':
					letter = "o";
					break;
				case '0':
					letter = " ";
					break;
				default:
					letter = "" + ch;
				}
				buttons[r][c].setText(letter);
				pos++;
			}
	}

	/**
	 * clears out the board and boardString's value
	 */
	public void resetBoardString() {
   boardString = "";
		for (int r = 0; r < TicTacToe.ROWS; r++)
			for (int c = 0; c < TicTacToe.COLS; c++) {
				boardString += buttons[r][c].getText();
			}
	}

	/**
	 * sets boardString to s and places the string on the board to display using show(s)
	 * @param s the string of the tictactoe sequence
	 */
	public void setBoardString(String s) {
		boardString = s;
		show(s);
	}

	/**
	 * returns the boardString of this board
	 * @return boardString of this board
	 */
	public String getBoardString() {
		return boardString;
	}

	/**
	 * makes a random tictactoe sequence and places it on the board
	 */
	public void displayRandomString() {
		for (int r = 0; r < TicTacToe.ROWS; r++)
			for (int c = 0; c < TicTacToe.COLS; c++) {
				char ch = randomXO();
				boardString += ch;
				buttons[r][c].setText("" + ch);
			}
		setHashCodeLabel(myHashCode());
		setWinnerLabel(isWin());
	}

}
