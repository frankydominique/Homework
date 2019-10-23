/**
 * @author Franceska
 *
 */
public class Deck {
	
	//fields
	private Cards[] deck;
	private static Cards[] temp;
	private int topCard;
	private final int fullDeckLength = 52;
	
	//constructors
	public Deck()
	{
		deck = new Cards[fullDeckLength];
		int pos = 0;
		for(int s = 1; s<=4; s++)
		{
			for(int r = 1; r <= 13; r++)
			{
				deck[pos] = new Cards(s, r);
				pos++;
			}
		}
		topCard = deck.length - 1;
	}
	
	/*
	 * constructs a full deck but shuffled
	 * 
	 * @param	shuffled boolean stating whether it's shuffled or not
	 */
	public Deck(boolean shuffled)
	{
		deck = new Cards[fullDeckLength];
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
		topCard = deck.length - 1;
	}
	
	
	public Deck(int x)
	{
		deck = new Cards[x];
		
		topCard = deck.length - 1;
	}
	
	/*
	 * shuffles cards in this deck
	 * 
	 * @return	void
	 */
	public void shuffle()
	{
		int switcher, pos;
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
	}
	
	/*checks if this deck is equal to given deck
	*
	*@param	x object given to compare current deck to
	*@return	boolean of whether these cards have the same value
	*/
	public boolean equals(Object x)
	{		
		if(x instanceof Deck)
		{
			String first = this.toString();
			String second = ((Deck)x).toString();
			
			return first.equals(second);
		} else
			return false;
	}
	
	/*
	 * deals out given number of hands with given number of cards per hand
	 * 
	 * @param hands number of mini decks to be created
	 * @param cardPerHand number of cards per mini deck
	 * @return	Deck[] a deck of decks representing different hands
	 */
	public Deck[] deal(int hands, int cardPerHand)
	{
		if(hands * cardPerHand > deck.length)
			return null;
		
		Cards[] removed = new Cards[hands * cardPerHand];
		
		for(int i = 0; i < removed.length; i++)
		{
			removed[i] = deck[topCard];
			deck[topCard] = null;
			topCard--;
		}
		
		int pos = 0;
		Deck[] toBeDealt = new Deck[hands];
		for(int i = 0; i < toBeDealt.length; i++)
		{
			toBeDealt[i] = new Deck(cardPerHand);
			for(int j = 0; j < toBeDealt[i].getLength(); j++)
			{
				toBeDealt[i].addCard(j, removed[pos]);
				pos++;
			}
		}
		
		return toBeDealt;
	}
	
	/*
	 * chooses a card from the deck
	 * 
	 * @return	Cards a random card picked from deck
	 */
	public Cards pick()
	{
		int randInt = (int)(Math.random() * deck.length);
		Cards picked = deck[randInt];
		for(int k = topCard + 1; k < deck.length; k++)
			deck[k - 1] = deck[k];
		return picked;
	}
	
	/*
	 * uses selection sort algorithm to sort deck
	 */
	public void selectionSort()
	{
		for(int x = deck.length; x > 1; x--)
		{
			int max = 0;
			
			for(int i = 1; i < x; i++)
			{
				if(deck[i].getSuitInt() > deck[max].getSuitInt())
					max = i;
				else if(deck[i].getSuitInt() == deck[max].getSuitInt())
					if(deck[i].getRank() > deck[max].getRank())
						max = i;
			}
			
			Cards temp = deck[max];
			deck[max] = deck[x-1];
			deck[x-1] = temp;
		}
	}
	
	/*
	 * uses merge sort algorithm to sort deck
	 */
	public void mergeSort()
	{
		int n = deck.length;
		temp = new Cards[n];
		recursiveSort(deck, 0, n-1);
	}
	
	/*
	 * splits deck into smaller and smaller pieces and orders them
	 * 
	 * @param	x array of cards given
	 * @param	from starting point of array
	 * @param	to end point of array
	 */
	private void recursiveSort(Cards[] x, int from, int to)
	{
		SortingCardsComparator check = new SortingCardsComparator();
		if(to - from < 2)
		{
			if(to > from && check.compare(deck[to], deck[from]) < 0)
			{
				Cards atemp = deck[to];
				deck[to] = deck[from];
				deck[from] = atemp;
			}
		} else {
			int mid = (from + to) / 2;
			recursiveSort(x, from, mid);
			recursiveSort(x, mid + 1, to);
			merge(x, from, mid, to);
		}

	}
	
	/*
	 * merges the arrays from recursive sort
	 * 
	 * @param	a array to be sorted
	 * @param	from starting point of array
	 * @param	mid middle of array
	 * @param	to end point of array
	 */
	private void merge(Cards[] a, int from, int mid, int to)
	{
		SortingCardsComparator check = new SortingCardsComparator();
		int i = from, j = mid + 1, k = from;
		while(i <= mid && j <= to)
		{
			if(check.compare(a[i], a[j]) < 0)
			{
				temp[k] = a[i];
				i++;
			} else {
				temp[k] = a[j];
				j++;
			}
			k++;
		}
		
		while(i <= mid)
		{
			temp[k] = a[i];
			i++;
			k++;
		}
		
		while(j <= to)
		{
			temp[k] = a[j];
			j++;
			k++;
		}
		
		for(k = from; k <= to; k++)
			a[k] = temp[k];
		
	}
	
	/*
	 * translates deck of cards into string
	 * 
	 * @return	String string of this deck
	 */
	public String toString()
	{
		String list = "";
		if(deck.length == fullDeckLength)
		{
			for(int pos = 0; pos < 13; pos++)
			{
				for(int i = pos; i < deck.length; i += 13)
				{
					list += String.format("%5s of %-8s \t", deck[i].getRankStr(), deck[i].getSuit());
				}
				list += String.format("%n");
			}
		} else {
			for(Cards x: deck)
				list += x.toString() + "\n";
		}
		
		
		return list;
	}
	
	/*
	 * returns length of deck
	 */
	public int getLength()
	{
		return deck.length;
	}
	
	/*
	 * returns current card at position x
	 * 
	 * @param	x index of card wanted
	 */
	public Cards getCard(int x)
	{
		return deck[x];
	}
	
	/*
	 * adds card to deck array
	 */
	public void addCard(int pos, Cards x)
	{
		deck[pos] = x;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("working");
		Deck tester = new Deck();
		System.out.println("working2");
		System.out.println(tester.toString());
		Deck[] testing = tester.deal(3,3);
		for(Deck x: testing)
			System.out.println("hand: " + x);
	}

}
