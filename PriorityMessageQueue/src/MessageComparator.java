import java.util.*;
public class MessageComparator implements Comparator<Message>{
	
	public MessageComparator()
	{
		
	}
	
	public int compare(Message msg1, Message msg2)
	{
		return msg1.getPriority() - msg2.getPriority();
	}
}
