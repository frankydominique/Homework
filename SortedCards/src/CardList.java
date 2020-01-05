/**
 * @author Franceska
 *
 */
public class CardList {
	
	private CardNode head;
	private CardNode tail;
	private CardNode current;
	private int pos;
	private int numNodes;
	
	public CardList()
	{
		head = null;
		tail = null;
		current = null;
		pos = -1;
		numNodes = 0;
	}
	
	//inserts the specified card at the beginning of the list
	//five minutes
	public void addFirst(Card c)
	{
		CardNode newNode = new CardNode(c);
		CardNode nextNode = null;
		if(head != null)
			nextNode = head.getNext();
		head = newNode;
		newNode.setNext(nextNode);
		nextNode.setPrevious(newNode);
		numNodes++;
	}
	
	//inserts the specificed element at the specified position
	//seven minutes
	public void add(int n, Card c)
	{
		if(n > numNodes)
			return;
		while(pos != n)
		{
			current = current.getNext();
			pos++;
		}
		CardNode newCard = new CardNode(c);
		if(n == 0)
			head = newCard;
		else if(n == numNodes)
			tail = newCard;
		CardNode previousCard = current.getPrevious();
		previousCard.setNext(newCard);
		newCard.setPrevious(previousCard);
		newCard.setNext(current);
		current.setPrevious(newCard);
		pos++;
		numNodes++;
	}
	
	//adds the card at the end of the list
	//eight minutes
	public void add(Card c)
	{
		if(tail == null)
		{
			head = new CardNode(c);
			tail = new CardNode(c);
			return;
		}
		CardNode newNode = new CardNode(c);
		tail.setNext(newNode);
		newNode.setPrevious(tail);
		tail = newNode;
	}
	
	//removes and returns the last CardNode
	//five minutes
	public CardNode remove()
	{
		CardNode removed = tail;
		tail.getPrevious().setNext(null);
		tail = tail.getPrevious();
		numNodes--;
		return removed;
	}
	
	//removes and returns the first occurence of the list
	//three minutes
	public Card removeFirst()
	{
		CardNode removed = head;
		head = head.getNext();
		head.setPrevious(null);
		return removed.getCard();
	}
	
	//removes the first occurrence of the specified element in this list
	//five
	public Card removeFirstOccurence(Card c)
	{
		while(!current.getCard().equals(c))
			current = current.getNext();
		
		CardNode removed = current;
		CardNode previous = current.getPrevious();
		CardNode next = current.getNext();
		
		previous.setNext(next);
		next.setPrevious(previous);
		
		Card value = removed.getCard();
		return value;
	}
	
	//removes and returns the last element from this list
	//two
	public Card removeLast()
	{
		Card removedCard = tail.getCard();
		tail = tail.getPrevious();
		tail.setNext(null);
		
		return removedCard;
	}
	
	//removes and returns the nth CardNode
	//eight minutes
	public CardNode remove(int n)
	{
		current = head;
		pos = 0;
		while(pos != n - 1 && pos < numNodes)
		{
			current = current.getNext();
			pos++;
		}
		
		if(head == current)
		{
			head = current.getNext();
			head.setPrevious(null);
		}
		else if(tail == current)
		{
			tail = tail.getPrevious();
			tail.setNext(null);
		} else {
			CardNode next = current.getNext();
			CardNode previous = current.getPrevious();
			
			previous.setNext(next);
			next.setPrevious(previous);
		}
		
		numNodes--;
		
		return current;
	}
	
	//removes the first occurrence of the specified element of the list
	//returns true if found, false otherwise
	//five minutes
	public boolean remove(Card c)
	{
		current = head;
		pos = 0;
		
		while(!current.equals(c) && pos < numNodes)
		{
			current = current.getNext();
			pos++;
		}
		
		if(c.equals(head) && pos == 0)
		{
			head = head.getNext();
			head.setPrevious(null);
		}
		else if(c.equals(tail) && pos == numNodes - 1)
		{
			tail = tail.getPrevious();
			tail.setNext(null);
		} else {
			CardNode next = current.getNext();
			CardNode previous = current.getPrevious();
			
			next.setPrevious(previous);
			previous.setNext(next);
		}
		
		numNodes--;
		
		return c.equals(current);
	}
	
	//removes all of the elements from this list
	public void clear()
	{
		head = null;
		tail = null;
		numNodes = 0;
		pos = 0;
		current = null;
	}
	
	//returns true if this list contains the specified element
	public boolean contains(Card c)
	{
		current = head;
		pos = 0;
		
		while(!current.equals(c) && pos < numNodes)
		{
			current = current.getNext();
			pos++;
		}
		
		return c.equals(current);
	}
	
	//returns the card at the head
	public Card peek()
	{
		return head.getCard();
	}
	
	//returns the element at the specified position in the list
	public Card get(int index)
	{
		current = head;
		pos = 0;
		
		if(index >= 0 && numNodes < numNodes)
		{
			while(pos < index && pos < numNodes)
			{
				current = current.getNext();
				pos++;
			}
		}
		
		return current.getCard();
	}
	
	//returns the first element in this list
	public Card getFirst()
	{
		return head.getCard();
	}
	
	//returns the last element in this list
	public Card getlast()
	{
		return tail.getCard();
	}
	
	//returns the index of the first occurrence of the specified element
	//in this list
	public int indexOf(Card c)
	{
		current = head;
		pos = 0;
		
		while(pos < numNodes && !current.equals(c))
			current = current.getNext();
		
		return pos;
	}
	
	//returns the index of the last occurrence of the specified element in this list
	public int lastIndexOf(Card c)
	{
		current = tail;
		pos = numNodes - 1;
		
		while(pos > 0 && !current.equals(c))
			current = current.getPrevious();
		
		return pos;
	}
}
