/**
 * @author Franceska
 * Mrs. Kelly
 * DECSII
 * This class creates a "production line" of towers
 */
import java.io.*;
import java.util.*;

public class ProductionLine {

	/**
	 * fields
	 */
	private Queue<Disk> input;
	private Queue<Tower> output;
	private Tower robotArm;
	
	/**
	 * constructors
	 */
	public ProductionLine()
	{
		input = new LinkedList<Disk>();
		output = new LinkedList<Tower>();
		robotArm = new Tower();
	}
	
	/**
	 * adds the given disk to the input line
	 * @param disk is the disk wanted to be added to the input line
	 */
	public void addToInput(Disk disk)
	{
		input.add(disk);
	}
	
	/**
	 * adds given disk to robot arm
	 * @param disk is the disk to be added to the robot arm
	 */
	public void addDisk(Disk disk)
	{
		robotArm.add(disk);
	}
	
	/**
	 * flips the inverted tower right-side up and then adds the now regular tower to output
	 * 	also creates a new tower
	 */
	public void unloadRobot()
	{
		robotArm.regular();
		output.add(robotArm);
		
		robotArm = new Tower();
	}
	
	/**
	 * checks if input has elements in it, removes nonexistent disks (w radius zero), checks if the disk can be added to the robot line
	 * 	if can be added to the robot line, it removes it from input and places it on the robot arm
	 * 	Completed disks are unloaded to the output line
	 */
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
	
	/**
	 * removes the tower from output
	 * @return Tower is the first tower in the output queue
	 */
	public Tower removeTower()
	{
		return output.remove();
	}
	
	/**
	 * returns the string interpretation of the input line
	 * @return String the representation of the input line
	 */
	public String inputToString()
	{
		Iterator<Disk> iter = input.iterator();
		String outputString = "";
		
		while(iter.hasNext())
			outputString += iter.next() + " ";
		
		return outputString;
	}
	
	/**
	 * returns the string representation of all of the output line
	 * @return String the representation of the output line
	 */
	public String toString()
	{
		Iterator<Tower> iter = output.iterator();
		String outputString = "";
		
		while(iter.hasNext())
			outputString += iter.next() + " \n";
		
		return outputString;
	}
	
}
