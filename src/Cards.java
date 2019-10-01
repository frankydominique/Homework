/**
 * 
 */

/**
 * @author Franceska
 *
 */

public class Cards implements Comparable<Cards>{

	private int suit;
	private int rank;
	
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
	
	//converts String ranks given in constructor to int ranks
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

	//converts int Rank to String
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
	
	//converts string suit given in constructor to int suit
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
	
	//incomplete
	public int compareTo(Cards x)
	{
		String card1 = this.toString();
		String card2 = x.toString();
		return card1.compareTo(card2);
	}
	
	public boolean equals(Object x)
	{
		if(x != null)
			return this.suit == ((Cards)x).getSuitInt() && this.rank == ((Cards)x).getRank();
		return false;
	}
	
	public static String toString(Cards x)
	{
		return x.getRankStr() + x.getSuit();
	}
	
	public String toString()
	{
		return this.getRankStr() + x.getSuit();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
