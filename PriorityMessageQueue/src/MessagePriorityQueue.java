/**
 * Franky Padilla Coo
 */
import java.util.*;

public class MessagePriorityQueue {

	/**
	 * fields
	 * dflt_capacity - the default capactiy of my message priority queue
	 * messages - my priority queue
	 * numMessages - number of messages in my priority queue
	 * toBeProcessed - the waitlist for messages that can be processed
	 * waitingTime - an array that gathers all the waiting times of messages of certain priorities
	 * waitingTimeLengths - an array that will be used to help find the average waiting times
	 */
	private static final int DFLT_CAPACITY = 5;
	private ArrayList<ArrayList<Message>> messages;
	private int numMessages;
	private ArrayList<Message> toBeProcessed;
	private int[] waitingTime;
	private int[] waitingTimeLengths;
	
	//Constructors
	
	/**
	 * creates a new message priority queue with two array lists
	 */
	public MessagePriorityQueue()
	{
		messages = new ArrayList<ArrayList<Message>>(DFLT_CAPACITY);
		
		for(int i = 0; i < 5; i++)
		{
			messages.add(new ArrayList<Message>());
		}
	
		waitingTime = new int[5];
		waitingTimeLengths = new int[5];
		toBeProcessed = new ArrayList<Message>();
	}
	
	/**
	 * returns whether this priority queue is empty
	 * @return boolean of whether this priority queue is empty
	 */
	public boolean isEmpty()
	{
		return numMessages == 0;
	}
	
	/**
	 * @return the first message of this queue
	 */
	public Message peek()
	{
		if(numMessages == 0) throw new NoSuchElementException();
		
		int priorityList = 0;
		while(priorityList < messages.size() && messages.get(priorityList).isEmpty())
			priorityList++;
		
		return messages.get(priorityList).get(0);
	}
	
	/**
	 * adds the message to be processed and if four "minutes" have passed already, then it adds the first message in toBeProcessed
	 * to the queue to be processed
	 * @param msg the message being added
	 * @return whether the message being added has been added or put in a queue
	 */
	public boolean add(Message msg)
	{
		toBeProcessed.add(msg);
		if(toBeProcessed.size() >= 4)
		{
			numMessages++;
			
			Message entry = toBeProcessed.remove(0); 
			//System.out.println(entry);
			int priorityList = entry.getPriority();
			messages.get(priorityList).add(entry);
			
			return true;
		} else return false;
		
	}
	
	/**
	 * removes the first message of this priority queue and adds the statistics before returning the message that was removed
	 * @param removalTime the time this message is being removed
	 * @return the first message of this priority queue
	 */
	public Message remove(int removalTime)
	{
		int priorityList = 0;
		
		
		while(messages.get(priorityList).isEmpty() && priorityList < messages.size())
			priorityList++;
		
		Message msg = messages.get(priorityList).remove(0);
		
		//System.out.println(msg + ", removal: " + removalTime + ", processing time: " + (removalTime - msg.getArrivalTime()));
		waitingTime[priorityList] += removalTime - msg.getArrivalTime();
		waitingTimeLengths[priorityList]++;
		
		return msg;
	}
	
	/**
	 * returns a double array of all the average waiting/processing times for each priority
	 * @return a double array of all the average waiting/processing times for each priority
	 */
	public double[] getAverageWaitingTimes()
	{
		double[] averageWaitingTimes = new double[5];
		
		for(int i = 0; i < averageWaitingTimes.length; i++)
		{
			averageWaitingTimes[i] = ((double)waitingTime[i]) / waitingTimeLengths[i];
		}
		
		return averageWaitingTimes;
	}

	/**
	 * overrides toString in the Object method and prints out the string version of this priorityqueue
	 */
	public String toString()
	{
		String thisString = "";
		
		for(ArrayList<Message> list: messages)
			for(Message msg : list)
				thisString += msg + "\n";
		
		return thisString;
	}
}
