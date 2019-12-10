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
	}
	
	public void addDisk(Disk disk)
	{
		robotArm.add(disk);
	}
	
	public void unloadRobot()
	{
		robotArm.regular();
		output.add(robotArm);
	}
	
	public void process()
	{
		while(!input.isEmpty())
		{
			if(robotArm == null)
				robotArm.add(input.remove());
			while(input.peek().getRadius() > robotArm.getTDRadius())
				robotArm.add(input.remove());
			unloadRobot();
		}
	}
	
	public Tower removeTower()
	{
		return output.remove();
	}
	
	public String toString()
	{
		Iterator<Tower> iter = output.iterator();
		String outputString = "";
		
		while(iter.hasNext())
			outputString += iter.next();
		
		return outputString;
	}
	
}
