/**
 * this class creates a message comparator
 */
import java.util.*;
public class MessageComparator implements Comparator<Message>{
	
	public MessageComparator()
	{
		
	}

	/**
	 * returns which message comes first, where a negative means msg1 comes first, with 0 meaning they are equal, and where a 
	 * positive means message 2 comes first
	 * @return int representing which message comes first
	 */
	public int compare(Message msg1, Message msg2)
	{
		return msg1.getPriority() - msg2.getPriority();
	}
}
