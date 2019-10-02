import javax.smartcardio.Card;

/**
 * 
 */

/**
 * @author Franceska
 *
 */
public class Deck {
	
	private Cards[] deck = new Cards[52];
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
	
	public boolean equals (Deck[] x)
	{
		boolean wholeDeck = true;
		for(int i = 0; i < deck.length; i++)
		{
			if(deck[i] != x[i])
				wholeDeck = false;
		}
		return wholeDeck;
	}
	
	public Deck[] deal(int hands, int cardPerHand)
	{
		Card[] removed = new Card[hands * cardPerHand]
	}
	
	public Card pick()
	{
		int randInt = new (int)(Math.random()*52)
		Card picked = deck[randInt];
		while(randInt < deck.length)
		{
			deck[randInt] = deck[randInt - 1];
			randInt++;
		}
		deck[randInt] = null;
		return picked;
	}
	
	//incomplete, must add formatting
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
