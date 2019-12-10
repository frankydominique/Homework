/**
 * @author Franceska
 *
 */
public class Disk implements Comparable<Disk>{

	private int radius;
	
	public Disk(int r)
	{
		radius = r;
	}
	
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
