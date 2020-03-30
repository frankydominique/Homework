/**
 * This class is used to create and access a Message object with a priority, an arrival time, and a message
 * @author Franceska
 *
 */
public class Message {
	//TODO define at least two fields, priority and arrival, both integers
	/**
	 * Fields
	 * priority - how important this message is
	 * arrival - the "minute" this message arrived
	 * message - the message of this Message object
	 */
	private int priority;
	private int arrival;
	private String message;
	
	//Constructors
	
	/**
	 * this is a constructor for message
	 * @param priority - how important this message is
	 * @param arrival - the "minute" this message arrived
	 * @param message - the message of this Message object
	 */
	public Message(int priority, int arrival, String message)
	{
		this.priority = priority;
		this.arrival = arrival;
		this.message = message;
	}
	
	/**
	 * this creates a new message object with an empty message
	 * @param priority - the importance of this message object
	 * @param arrival - the "time" this object arrived
	 */
	public Message(int priority, int arrival)
	{
		this.priority = priority;
		this.arrival = arrival;
		this.message = "";
	}
	
	/**
	 * returns this message object's priority
	 * @return int of this object's priority from 0 to 4
	 */
	public int getPriority()
	{
		return priority;
	}
	
	/**
	 * returns this message's arrival "time"
	 * @return int of this message's arrival time
	 */
	public int getArrivalTime()
	{
		return arrival;
	}
	
	/**
	 * returns this message's message
	 * @return string of this message's message
	 */
	public String getMessage()
	{
		return message + "";
	}
	
	/**
	 * overrides the Object's toString() method to print out this message's message, priority, and arrival time
	 */
	public String toString()
	{
		return message + ", priority: " + priority + ", arrival time: " + arrival; 
	}
	
}
