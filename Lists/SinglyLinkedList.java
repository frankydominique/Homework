// Implements a singly-linked list.

import java.util.Iterator;

public class SinglyLinkedList implements Iterable<Object>
{
  private ListNode head;
  private int nodeCount;

  // Constructor: creates an empty list
  public SinglyLinkedList()
  {
    head = null;
    nodeCount = 0;
  }

  // Constructor: creates a list that contains
  // all elements from the array values, in the same order
  public SinglyLinkedList(Object[] values)
  {
    ListNode tail = null;
    for (Object value : values) // for each value to insert
    {
      ListNode node = new ListNode(value, null);
      if (head == null)
        head = node;
      else
        tail.setNext(node);
      tail = node;    // update tail
    }

    nodeCount = values.length;
  }

  // Returns true if this list is empty; otherwise returns false.
  public boolean isEmpty()
  {
    return head ==null;
  }

  // Returns the number of elements in this list.
  public int size()
  {
    return nodeCount;
  }

  // Returns true if this list contains an element equal to obj;
  // otherwise returns false.
  public boolean contains(Object obj)
  {
    ListNode node = head;
    while(node != obj && node != null)
    {
    	if(node.equals(obj))
    	{
    		return true;
    	}
    	node = node.getNext();
    }
    return false;
  }

  // Returns the index of the first element in equal to obj;
  // if not found, retunrs -1.
  public int indexOf(Object obj)
  {
	int count = 0;
    for(ListNode node = head; node != null; node = node.getNext())
    {
    	if(node.equals(obj))
    	{
    		return count;
    	}
    	count++;
    }
    return -1;
  }

  // Adds obj to this collection.  Returns true if successful;
  // otherwise returns false.
  public boolean add(Object obj)
  {
    int x = (int)(Math.random() * 5);
    
    try { add(x, obj);}
    catch(NullPointerException n)
    {
    	return false;
    }
    return true;
  }

  // Removes the first element that is equal to obj, if any.
  // Returns true if successful; otherwise returns false.
  public boolean remove(Object obj)
  {
	  int x = indexOf(obj);
	  return obj.equals(remove(x));
  }

  // Returns the i-th element.
  public Object get(int i)
  {
	int pos = 0;
	for(ListNode node = head; node != null; node = node.getNext())
	{
		if(pos == i) return node;
		pos++;
	}
	
	return null;
  }

  // Replaces the i-th element with obj and returns the old value.
  public Object set(int i, Object obj)
  {
	int pos = 0;
	ListNode thrownOut = null;
    for(ListNode node = head; node != null; node = node.getNext())
    {
    	if(pos == i)
    	{
    		thrownOut = node;
    		node.setValue(obj);
    	}
    	pos++;
    }
    
    return thrownOut;
  }

  // Inserts obj to become the i-th element. Increments the size
  // of the list by one.
  public void add(int i, Object obj)
  {
    int pos = 0;
    for(ListNode node = head; node != null; node = node.getNext())
    {
    	if(pos == i)
    	{
    		node.setValue(obj);
    		nodeCount++;
    	}
    	pos++;
    }
  }

  // Removes the i-th element and returns its value.
  // Decrements the size of the list by one.
  public Object remove(int i)
  {
	  int pos = 0;
	  Object theReturn = null;
	  for(ListNode node = head; node != null; node = node.getNext())
	  {
		  if(pos == i - 1)
		  {
			  theReturn = node.getNext().getValue();
			  if(node.getNext().getNext() != null)
			  {
				ListNode temp = node.getNext().getNext();
			    node.setNext(temp);
			    nodeCount--;
			  } else {
				node.setNext(null);
				nodeCount--;
			  }
	    	
		  }
		  pos++;
	  }
	  
	  return theReturn;
  }

  // Returns a string representation of this list.
  public String toString()
  {
    String compilation = "";
    for(ListNode node = head; node != null; node = node.getNext())
    {
    	compilation += node.getValue() + " ";
    }
    return compilation;
  }

  // Returns an iterator for this collection.
  public Iterator<Object> iterator()
  {
    return new SinglyLinkedListIterator(head);
  }
}

