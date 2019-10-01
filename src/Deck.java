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
