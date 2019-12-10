/**
 * @author Franceska
 *
 */
public class Disk implements Comparable<Disk>{
	
	//fields
	private int radius;
	
	//constructors
	public Disk(int r)
	{
		radius = r;
	}
	
	/**
	 * this method compares this disk with another disk
	 * 
	 * @param other - the disk being compared
	 * @return int an integer representing which disk is greater, negative if this disk is smaller, zero if 
	 * 	disks are the same, and positive if this disk is greater than other
	 */
	public int compareTo(Disk other)
	{
		return this.getRadius() - other.getRadius();
	}
	
	public int getRadius()
	{
		return radius;
	}
	
	public String toString()
	{
		return "Radius is " + radius;
	}
}
