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
		next = null;
		previous = null;
	}
	
	//do you need to go through list until a card matches previous? actually using .equals?
	public CardNode(Card card, CardNode previous)
	{
		if(previous != null)
		{
			this.card = card;
			this.previous = previous;
			this.next = previous.getNext();
			previous.getNext().setPrevious(this);
			previous.setNext(this);
		}
	}
	
	public Card getCard()
	{
		return card;
	}
	
	public CardNode getNext()
	{
		return next;
	}
	
	public CardNode getPrevious()
	{
		return previous;
	}
	
	public int getNodeNum()
	{
		return nodeNum;
	}
	
	public void setNext(CardNode next)
	{
		this.next = next;
	}
	
	public void setPrevious(CardNode previous)
	{
		this.previous = previous;
	}
	
	public void setNodeNum(int nodeNum)
	{
		this.nodeNum = nodeNum;
	}
}
