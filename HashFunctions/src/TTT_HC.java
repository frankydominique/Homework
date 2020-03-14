/**
 * @author Franceska
 *
 */
public class TTT_HC extends Board{

	boolean[] winners;
	
	public TTT_HC(String s)
	{
		super(s);
		winners = new boolean[(int)Math.pow(3,9)];
	}
	
	public int tttHashCode()
	{
		int rowTotal  = 0;
		int rowNum = 0;
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
		return false;
	}
	
	public static void main(String[] args)
	{
		
	}
	
}
