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
	private int topCard = 1;

	/**
	 * @param args
	 */
	
	public Deck()
	{
		int pos = 0;
		for(int s = 1; s<=4; s++)
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
		int switcher, pos;
		if(shuffled == false)
		{
			pos = 0;
			for(int s = 1; s <= 4; s++)
			{
				for(int r = 1; r <= 13; r++)
				{
					deck[pos] = new Cards(s, r);
					switcher = (int)(Math.random() * pos);
					Cards temp = deck[pos];
					deck[pos] = deck[switcher];
					deck[switcher] = temp;
					pos++;
				}
			}
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
	
	//incomplete
	public boolean equals(Deck x)
	{
		boolean wholeDeck = true;
		for(int i = 0; i < deck.length; i++)
		{
			//if(deck[i] != x[i])
				wholeDeck = false;
		}
		return wholeDeck;
	}
	
	//incomplete
	/*public Deck[] deal(int hands, int cardPerHand)
	{
		Card[] removed = new Card[hands * cardPerHand];
	}
	*/
	
	public Cards pick()
	{
		int randInt = (int)(Math.random()*52);
		Cards picked = deck[randInt];
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
		for(int pos = 0; pos < 13; pos++)
		{
			for(int i = pos; i < deck.length; i += 13)
			{
				list += String.format("%5s of %-8s", deck[i].getRankStr(), deck[i].getSuit());
			}
			list += String.format("%n");
		}
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
