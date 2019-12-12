/**
 * @author Franceska
 *
 */
import java.io.*;
import java.util.*;

public class ProductionLine {

	private Queue<Disk> input;
	private Queue<Tower> output;
	private Tower robotArm;
	
	public ProductionLine()
	{
		input = new LinkedList<Disk>();
		output = new LinkedList<Tower>();
		robotArm = new Tower();
	}
	
	public void addToInput(Disk disk)
	{
		input.add(disk);
	}
	
	public void addDisk(Disk disk)
	{
		robotArm.add(disk);
	}
	
	public void unloadRobot()
	{
		robotArm.regular();
		output.add(robotArm);
		
		robotArm = new Tower();
	}
	
	public void process()
	{
		while(!input.isEmpty())
		{
			if(input.peek().getRadius() <= 0)
				input.remove();
				
			/*if(robotArm.isEmpty() && input.peek() != null && input.peek().getRadius() > 0)
			{
				robotArm.add(input.remove());
			}
			*/
			
			while(input.peek() != null && ((robotArm.isEmpty()  && input.peek().getRadius() > 0) || 
					(!robotArm.isEmpty() && input.peek().compareTo(robotArm.getTopDisk()) > 0 )))	
			{
				robotArm.add(input.remove());
			}
			
			unloadRobot();
		}
	}
	
	public Tower removeTower()
	{
		return output.remove();
	}
	
	public String inputToString()
	{
		Iterator<Disk> iter = input.iterator();
		String outputString = "";
		
		while(iter.hasNext())
			outputString += iter.next() + " ";
		
		return outputString;
	}
	
	public String toString()
	{
		Iterator<Tower> iter = output.iterator();
		String outputString = "";
		
		while(iter.hasNext())
			outputString += iter.next() + " \n";
		
		return outputString;
	}
	
}
