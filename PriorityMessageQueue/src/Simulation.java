/**
 * this class simulates my priority queue and java's priority queue
 */
import java.util.*;

public class Simulation {

	public static void main(String[] args)
	{
		testMyPriorityQueue();
		
		System.out.println("testing the real Priority Queue...");
		
		testPriorityQueue();
	}
	
	/**
	 * makes a priority queue of mine and makes 50 messages to add to the queue
	 * prints out the messages that have been processed
	 */
	public static void testMyPriorityQueue()
	{
		MessagePriorityQueue mpq = new MessagePriorityQueue();
		Message[] removed = new Message[100];
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
		
		
		for(double times: mpq.getAverageWaitingTimes())
			System.out.println("average wait time: " + times);
	}
	
	/**
	 * this method uses java's priority queue and takes in 50 messages
	 */
	public static void testPriorityQueue()
	{
		PriorityQueue<Message> pq = new PriorityQueue<Message>(5, new MessageComparator());
		Message[] removed = new Message[100];
		int[] waitingTimes = new int[5];
		int[] waitingTimesLength = new int[5];
		int pos = 0;
		
		for(int i = 0; i < removed.length; i++)
		{
			Message newMsg = new Message((int)(Math.random() * 5), i, "" + i);
			pq.add(newMsg);
			
			if(i >= 4)
			{
				Message msg =  pq.remove();
				Message[] temp = new Message[10];
				int index = 0;
				
				//need to make an array that stores all the values that don't work before adding them back in
				while(i - msg.getArrivalTime() < 4)
				{
					temp[index] = msg;
					msg = pq.remove();
					index++;
				}
				removed[pos] = msg;
				waitingTimes[msg.getPriority()] += i - msg.getArrivalTime();
				waitingTimesLength[msg.getPriority()]++;
				for(Message x: temp)
				{
					if(x != null) pq.add(x);
				}
				
				pos++;
			}
			
		}
		
		/*for(int i = 4; i < removed.length; i++)
		{
			removed[i - 4] = pq.remove();
			waitingTimes[removed[i - 4].getPriority()] += i - removed[i - 4].getArrivalTime();
			waitingTimesLength[removed[i - 4].getPriority()]++;
		}*/
		
		for(int i = 0; i < waitingTimes.length; i++)
			System.out.println("average waiting time: " + (waitingTimes[i] / waitingTimesLength[i]));
		
	}
}
