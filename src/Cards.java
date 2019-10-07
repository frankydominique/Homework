/**
 * 
 */

/**
 * @author Franceska
 *
 */

public class Cards implements Comparable<Cards>{

	//fields
	private int suit;
	private int rank;
	
	//constructors
	public Cards(int s, int r)
	{
		suit = s;
		rank = r;
	}
	
	public Cards(String s, String r)
	{
		suit = convertSuitToInt(s);
		rank = convertRanksToInt(r);
	}
	
	public Cards(String s, int r)
	{
		suit = convertSuitToInt(s);
		rank = r;
	}
	
	public Cards(int s, String r)
	{
		suit = s;
		rank = convertRanksToInt(r);
	}
	
	/*
	 * converts String ranks given in constructor to int ranks
	 * 
	 * @param	s string of ranks needing conversion to int
	 */
	public static int convertRanksToInt(String s)
	{
		if(s.equalsIgnoreCase("jack"))
			return 11;
		else if(s.equalsIgnoreCase("queen"))
			return 12;
		else if(s.equalsIgnoreCase("king"))
			return 13;
		else
			return -1;
	}

	/*
	 * converts int Rank to String
	 * 
	 * @param	s int of rank going to be converted to string
	 */
	public static String convertRanksToString(int s)
	{
		if(s == 11)
			return "jack";
		else if(s == 12)
			return "queen";
		else if(s == 13)
			return "king";
		else
			return(s+ "");
	}
	
	/*
	 * converts string suit given in constructor to int suit
	 * 
	 * @param	s String of suit needing conversion to int
	 */
	public static int convertSuitToInt(String s)
	{
		if(s.equalsIgnoreCase("Spade") || s.equalsIgnoreCase("spades"))
			return 1;
		else if(s.equalsIgnoreCase("Hearts") || s.equalsIgnoreCase("heart"))
			return 2;
		else if(s.equalsIgnoreCase("Clubs") || s.equalsIgnoreCase("club"))
			return 3;
		else if(s.equalsIgnoreCase("Diamonds") || s.equalsIgnoreCase("diamond"))
			return 4;
		else
			return -1;
	}
	
	/*
	 * converts int representation of suit to string
	 * 
	 * @param	s int representation of suit needing conversion to string
	 */
	public static String convertSuitToString(int s)
	{
		if(s == 1)
			return "spade";
		else if(s == 2)
			return "hearts";
		else if(s == 3)
			return "clubs";
		else if(s == 4)
			return "diamonds";
		else
			return "" + 2;
	}
	
	//getters
	public String getSuit()
	{
		return convertSuitToString(suit);
	}
	
	public int getRank()
	{
		return rank;
	}

	public String getRankStr()
	{
		return convertRanksToString(rank);
	}
	
	public int getSuitInt()
	{
		return suit;
	}
	
	/*
	 * compares cards to see if they are identical
	 * 
	 * @param	x Card of this being compared to
	 */
	public int compareTo(Cards x)
	{
		String card1 = this.toString();
		String card2 = x.toString();
		return card1.compareTo(card2);
	}
	
	/*
	 * compares card to given object
	 * 
	 * @param	x object being compared to card
	 */
	public boolean equals(Object x)
	{
		if(x != null)
			return this.suit == ((Cards)x).getSuitInt() && this.rank == ((Cards)x).getRank();
		return false;
	}
	
	/*
	 * converts to string used within the class
	 * 
	 * @param	x card needing conversion to string
	 */
	public static String toString(Cards x)
	{
		return x.getRankStr() + x.getSuit();
	}
	
	/*
	 * converts to string outside of class
	 */
	public String toString()
	{
		return this.getRankStr() + " " + this.getSuit();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
