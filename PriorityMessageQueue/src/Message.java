public class Message {
	//TODO define at least two fields, priority and arrival, both integers
	private int priority;
	private int arrival;
	private String message;
	
	public Message(int priority, int arrival, String message)
	{
		this.priority = priority;
		this.arrival = arrival;
		this.message = message;
	}
	
	public Message(int priority, int arrival)
	{
		this.priority = priority;
		this.arrival = arrival;
		this.message = "";
	}
	
		//TODO have a getPriority method that returns an integer from 0 to 4 (0 being highest priority)
	public int getPriority()
	{
		return priority;
	}
	
	public int getArrivalTime()
	{
		return arrival;
	}
	
	public String getMessage()
	{
		return message + "";
	}
	
	public String toString()
	{
		return message + ", priority: " + priority + ", arrival time: " + arrival; 
	}
	
}
