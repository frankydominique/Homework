import java.util.*;

public class MessagePriorityQueue {
	//TODO implements a priority queue of messages based on the 
	//value returned by the getPriority method
	//use an arrayList of five queues, one for each priority

	private static final int DFLT_CAPACITY = 5;
	private ArrayList<ArrayList<Message>> messages;
	private int numMessages;
	private final Comparator<Message> comparator;
	private ArrayList<Message> toBeProcessed;
	private int[] waitingTime;
	private int[] waitingTimeLengths;
	
	public MessagePriorityQueue(Comparator<Message> comparator)
	{
		this(DFLT_CAPACITY, comparator);
	}
	
	public MessagePriorityQueue(int initialCap, Comparator<Message> c)
	{
		messages = new ArrayList<ArrayList<Message>>(initialCap);
		comparator = c;
		
		for(int i = 0; i < 5; i++)
		{
			messages.add(new ArrayList<Message>());
		}
	
		waitingTime = new int[5];
		waitingTimeLengths = new int[5];
		toBeProcessed = new ArrayList<Message>();
	}
	
	public boolean isEmpty()
	{
		return numMessages == 0;
	}
	
	public Message peek()
	{
		if(numMessages == 0) throw new NoSuchElementException();
		
		int priorityList = 0;
		while(priorityList < messages.size() && messages.get(priorityList).isEmpty())
			priorityList++;
		
		return messages.get(priorityList).get(0);
	}
	
	//need to fix
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
	
	public double[] getAverageWaitingTimes()
	{
		double[] averageWaitingTimes = new double[5];
		
		for(int i = 0; i < averageWaitingTimes.length; i++)
		{
			//System.out.println(waitingTime[i]);
			//System.out.println(waitingTimeLengths[i]);
			averageWaitingTimes[i] = ((double)waitingTime[i]) / waitingTimeLengths[i];
		}
		
		return averageWaitingTimes;
	}

	public String toString()
	{
		String thisString = "";
		
		for(ArrayList<Message> list: messages)
			for(Message msg : list)
				thisString += msg + "\n";
		
		return thisString;
	}
}
