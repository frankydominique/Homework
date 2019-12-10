/**
 * @author Franceska
 *
 */
import java.io.*;
import java.util.*;

public class Tower {

	private Stack<Disk> pyramid;
	
	public Tower(Disk disk)
	{
		pyramid = new Stack<Disk>();
		pyramid.push(disk);
	}
	
	public Tower()
	{
		pyramid = new Stack<Disk>();
	}
	
	public void add(Disk x)
	{
		pyramid.push(x);
	}
	
	public Disk getTopDisk()
	{
		return pyramid.peek();
	}
	
	public int getTDRadius()
	{
		return pyramid.peek().getRadius();
	}
	
	public void regular()
	{
		Stack<Disk> regular = new Stack<Disk>();
		
		while(!pyramid.isEmpty())
			regular.push(pyramid.pop());
	}
	
	public String toString()
	{ 
		Iterator<Disk> iter = pyramid.iterator();
		String pyrString = "";
		
		while(iter.hasNext())
			pyrString += iter.next();
		
		return pyrString;
	}
}
