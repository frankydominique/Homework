/**
 * 
 */

/**
 * @author Franceska
 *
 */
public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		diskCheck();
	}

	public static void diskCheck()
	{
		Disk test1 = new Disk((int)(Math.random() * 10) + 1);
		Disk test2 = new Disk((int)(Math.random() * 10) + 1);
		Disk test3 = new Disk((int)(Math.random() * 10) + 1);
		
		Disk[] testArray = new Disk[3];
		
		testArray[0] = test1;
		testArray[1] = test2;
		testArray[2] = test3;
		
		for(Disk disk: testArray)
		{
			Disk comparedDisk = new Disk((int)(Math.random() * 10) + 1);
			System.out.println("TestDisk: " + disk.getRadius() + " vs GivenDisk: " + comparedDisk.toString());
			System.out.println(disk.compareTo(comparedDisk));
		}
	}
}
