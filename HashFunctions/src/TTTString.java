/**
 * 
 */

/**
 * @author Franceska
 *
 */
public class TTTString {

	int hash;
	private String string;
	
	public TTTString(String s)
	{
		string = s;
	}
	
	@Override
	public int hashCode()
	{
		int index = 0;
		
		for(int r = 0; r < 3; r++)
		{
			for(int c = 0; c < 3; c++)
			{
				char current = charAt(string, r, c);
				index += (r + 3) * (c + 3) * (int)(current);
			}
			
		}
		
		index %= 2003;
		
		hash = index;
		
		return index;
	}
	
	public char charAt(String s, int row, int col) {
	     int pos = row * TicTacToe.COLS + col;
	     if (s.length() >= pos)
	       return s.charAt(pos);
	     else
	       return '*';   
	   }
	
	@Override
	public boolean equals(Object x)
	{
		TTTString temp = (TTTString)x;
		return this.hashCode() == temp.hashCode();
	}
	
	@Override
	public String toString()
	{
		return string;
	}
}
