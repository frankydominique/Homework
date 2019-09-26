/**
 * 
 */

/**
 * @author Franceska
 *
 */
public class Cards {

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
		rank = convertRankToInt(r);
	}
	
	public Cards(String s, int r)
	{
		suit = convertSuitToInt(s);
		rank = r;
	}
	
	public Cards(int s, String r)
	{
		suit = s;
		rank = convertRankToInt(r);
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
		return convertSuitToInt(suit);
	}
	
	//incomplete
	public int compareTo(String s)
	{
		
	}
	
	public boolean equals(Object x)
	{
		return this.suit == x.getSuitInt() && this.rank == x.getRank();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
