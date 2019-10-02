import javax.smartcardio.Card;

/**
 * 
 */

/**
 * @author Franceska
 *
 */
public class Deck {
	
	private static Cards[] deck = new Cards[52];
	private static int topCard = 1;

	/**
	 * @param args
	 */
	
	public Deck()
	{
		int pos = 0;
		for(int s = 1; s<4; s++)
		{
			for(int r = 1; r <= 13; r++)
			{
				deck[pos] = new Cards(s, r);
				pos++;
			}
		}
	}
	
	public Deck(boolean shuffled)
	{
		int suit, rank, pos;
		if(shuffled == false)
		{
			
		} else {
			pos = 0;
			for(int s = 1; s<4; s++)
			{
				for(int r = 1; r <= 13; r++)
				{
					deck[pos] = new Cards(s, r);
				}
			}
		}
	}
	
	public String toString()
	{
		String list = "";
		for(Cards x: deck)
			list += x.toString();
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
