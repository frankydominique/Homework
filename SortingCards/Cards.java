/**
 * 
 */

/**
 * @author Franceska
 * Card Class
 * DECSII
 * Mrs. Kelly
 */

public class Cards implements Comparable<Cards>{

	//fields
	private int suit;
	private int rank;
	
	//constructors
	public Cards(int s, int r)
	{
		if(s > 0 && r > 0 && s < 5 && r < 14)
		{
			suit = s;
			rank = r;
		} else throw new IllegalArgumentException("Suit must be 1 to 4 and Rank must be 1 to 13");
	}
	
	public Cards(String s, String r)
	{
		if (s == null || r == null)
			throw new IllegalArgumentException("Invalid Input");
		suit = convertSuitToInt(s);
		rank = convertRanksToInt(r);
	}
	
	public Cards(String s, int r)
	{
		if(r > 0 && r < 14)
		{
			suit = convertSuitToInt(s);
			rank = r;
		} else throw new IllegalArgumentException("Suit must be 1 to 4 and Rank must be 1 to 13");
		
	}
	
	public Cards(int s, String r)
	{
		if(s > 0 && s < 14)
		{
			suit = s;
			rank = convertRanksToInt(r);
		} else throw new IllegalArgumentException("Suit must be 1 to 4 and Rank must be 1 to 13");
		
	}
	
	/*
	 * converts String ranks given in constructor to int ranks
	 * 
	 * @param	s string of ranks needing conversion to int
	 */
	public static int convertRanksToInt(String s)
	{
		String[] ranksStr = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
				"Nine", "Ten", "Jack", "Queen", "King"};
		
		for(int i = 0; i < ranksStr.length; i++)
		{
			if(s.equalsIgnoreCase(ranksStr[i]))
				return i + 1;
		}
		return -1;
	}

	/*
	 * converts int Rank to String
	 * 
	 * @param	s int of rank going to be converted to string
	 * @return	String equivalent of integer param
	 */
	public String convertRanksToString(int s)
	{
		String[] ranksStr = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight",
				"Nine", "Ten", "Jack", "Queen", "King"};
		if(s > -1 && s < ranksStr.length + 1)
			return ranksStr[s - 1];
		else
			return(s+ "");
	}
	
	/*
	 * converts string suit given in constructor to int suit
	 * 
	 * @param	s String of suit needing conversion to int
	 * @param	int returns integer equivalent of a suit
	 * @return	int equivalent of given suit as String
	 */
	public int convertSuitToInt(String s)
	{
		if(s.equalsIgnoreCase("Spade"))
			return 1;
		else if(s.equalsIgnoreCase("Hearts"))
			return 2;
		else if(s.equalsIgnoreCase("Clubs"))
			return 3;
		else if(s.equalsIgnoreCase("Diamonds"))
			return 4;
		else
			return -1;
	}
	
	/*
	 * converts int representation of suit to string
	 * 
	 * @param	s int representation of suit needing conversion to string
	 * @return	String equivalent of int parameter
	 */
	public static String convertSuitToString(int s)
	{
		if(s == 1)
			return "Spade";
		else if(s == 2)
			return "Hearts";
		else if(s == 3)
			return "Clubs";
		else if(s == 4)
			return "Diamonds";
		else
			return "";
	}
	
	/*
	 * returns suit of this object
	 * 
	 * @return	suit of this card
	 */
	public String getSuit()
	{
		return convertSuitToString(suit);
	}
	
	/*
	 * @return	rank of this card
	 */
	public int getRank()
	{
		return rank;
	}

	/*
	 * @return	String equivalent of this card's rank
	 */
	public String getRankStr()
	{
		return convertRanksToString(rank);
	}
	
	/*
	 * @return	int equivalent of this card's suit
	 */
	public int getSuitInt()
	{
		return suit;
	}
	
	/*
	 * compares cards to see if they are identical
	 * 
	 * @param	x Card of this being compared to
	 * @return	int representing the precedence of this 
	 */
	public int compareTo(Cards x)
	{
		return this.getRank() - x.getRank();
	}
	
	/*
	 * compares card to given object
	 * 
	 * @param	x object being compared to card
	 * @return	boolean of whether or not this card is equal to given card
	 */
	
	public boolean equals(Object x)
	{
		if(x != null && x instanceof Cards)
			return this.suit == ((Cards)x).getSuitInt() && this.rank == ((Cards)x).getRank();
		return false;
	}
	
	/*
	 * converts to string outside of class
	 * @return	string of this card
	 */
	public String toString()
	{
		return this.getRankStr() + " of " + this.getSuit();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
