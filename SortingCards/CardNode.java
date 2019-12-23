/**
 * @author Franceska
 *
 */
public class CardNode {

	private static int nextNode = 1;
	private Card card;
	private CardNode next;
	private CardNode previous;
	private int nodeNum;
	
	public CardNode(Card card)
	{
		this.card = card;
	}
	
	//do you need to go through list until a card matches previous? actually using .equals?
	public CardNode(Card card, Card previous)
	{
		this.card = card;
		
	}
}
