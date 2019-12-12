/**
 * @author Franceska
 *
 */
import java.io.*;
import java.util.*;

public class Tower {

	private Stack<Disk> pyramid;
	
	/**
	 * constructor for disk
	 * @param disk starting disk of tower
	 */
	public Tower(Disk disk)
	{
		pyramid = new Stack<Disk>();
		pyramid.push(disk);
	}
	
	/**
	 * no args constructor of tower
	 */
	public Tower()
	{
		pyramid = new Stack<Disk>();
	}
	
	/**
	 * adds disk to pyramid stack
	 * @param x the disk to be added to pyramid
	 */
	public void add(Disk x)
	{
		pyramid.push(x);
	}
	
	/**
	 * peeks at pyramid stack and returns the top disk
	 * @return top disk in the pyramid stack
	 */
	public Disk getTopDisk()
	{
		return pyramid.peek();
	}
	
	/**
	 * finds the top disk of the pyramid stack and returns its radius, if there is no top disk or the stack is 
	 * empty, prints "Pyramid is empty"
	 * @return radius of top disk of pyramid as an int
	 */
	public int getTDRadius()
	{
		int x = 0;
		
		try
		{
			x = pyramid.peek().getRadius();
		}
		catch (EmptyStackException | NullPointerException ex)
		{
			System.out.println("Pyramid is empty");
		}
		return x;
	}
	
	/**
	 * checks if pyramid is empty using Stack's isEmpty() method
	 * @return
	 */
	public boolean isEmpty()
	{
		return pyramid.isEmpty();
	}
	
	/**
	 * flips the inverted pyramid stack upside down
	 */
	public void regular()
	{
		Stack<Disk> regular = new Stack<Disk>();
		
		while(!pyramid.isEmpty())
			regular.push(pyramid.pop());
		
		pyramid = regular;
	}
	
	/**
	 * returns the string representation of this pyramid tower
	 * @return String representation of this tower
	 */
	public String toString()
	{ 
		if(pyramid.isEmpty())
			return "null";
		
		Iterator<Disk> iter = pyramid.iterator();
		StringBuffer pyrString = new StringBuffer();
		
		while(iter.hasNext())
		{
			pyrString.insert(0, iter.next() + "\n");
		}
		
		return pyrString.toString();
	}
	
}
