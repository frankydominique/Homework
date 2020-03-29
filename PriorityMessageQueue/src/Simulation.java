import java.util.*;

public class Simulation {

	public static void main(String[] args)
	{
		//testMyPriorityQueue();
		PriorityQueue<Message> pq = new PriorityQueue<Message>(5, new MessageComparator());
		Message[] removed = new Message[50];
		int pos = 0;
		
		//change count to greater than 30
		//you won't see messages that have not been processed yet because it takes four minutes to process them
		for(int i = 0; i < removed.length; i++)
		{
			Message newMsg = new Message((int)(Math.random() * 5), i, "" + i);
			pq.add(newMsg);
			
			if(i >= 4)
			{
				removed[pos] =  pq.remove();
				pos++;
			}
		}
		
		for(Message msg: removed)
			System.out.println(msg);
		
	}
	
	public static void testMyPriorityQueue()
	{
		MessagePriorityQueue mpq = new MessagePriorityQueue(new MessageComparator());
		Message[] removed = new Message[50];
		int pos = 0;
		
		//change count to greater than 30
		//you won't see messages that have not been processed yet because it takes four minutes to process them
		for(int i = 0; i < removed.length; i++)
		{
			Message newMsg = new Message((int)(Math.random() * 5), i, "" + i);
			mpq.add(newMsg);
			
			if(i >= 4)
			{
				if(mpq.peek() != null)
				{
					removed[pos] = mpq.remove(i);
					pos++;
				}
			}
		}
				
		for(Message msg: removed)
			System.out.println(msg);
		
		for(double times: mpq.getAverageWaitingTimes())
			System.out.println("average wait time: " + times);
	}
}
