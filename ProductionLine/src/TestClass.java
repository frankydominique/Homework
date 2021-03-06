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
		System.out.println("Disk check: ");
		diskCheck();
		System.out.println("Tower check: ");
		towerCheck();
		System.out.println("Production Line check: ");
		for(int i = 0; i < 5; i++)
			productionLineCheck();
	}

	/**
	 * test all the methods within Disk by randomly assigning three disks radii
	 */
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
	
	/**
	 * test all the methods within Tower by randomly assigning two towers no starting disk and two other towers a starting disk
	 */
	public static void towerCheck()
	{
		Tower test1 = new Tower();
		Tower test2 = new Tower();
		Tower test3 = new Tower(new Disk((int)(Math.random() * 10)));
		Tower test4 = new Tower(new Disk((int)(Math.random() * 10) + 1));
		
		Tower[] testArray = new Tower[4];
		
		testArray[0] = test1;
		testArray[1] = test2;
		testArray[2] = test3;
		testArray[3] = test4;
		
		for(Tower tower: testArray)
		{
			System.out.println("Current Tower from test: " + tower.toString());
			
			int numDisks = (int)(Math.random() * 5);
			System.out.println("Num disks to be added: " + numDisks);
			for(;numDisks > 0; numDisks--)
			{
				Disk disk = new Disk((int)(Math.random() * 5));
				tower.add(disk);
			}
			
			System.out.println(tower.toString());
			tower.regular();
			System.out.println("Reversed to regular: " + tower.toString() + " ");
		}
	}
	
	/**
	 * tests ProductionLine and all its methods by assigning disks with randomly generated radii to the input line to create a tower
	 */
	public static void productionLineCheck()
	{
		ProductionLine test = new ProductionLine();
		
		Disk diskToAdd;
		
		Disk[] testArray = new Disk[(int)(Math.random() * 10)];
		
		System.out.println("Length: " + testArray.length + " Adding disks...");
		for(int i = 0; i < testArray.length; i++)
		{
			diskToAdd = new Disk((int)(Math.random() * 10));
			System.out.println(diskToAdd.toString());
			testArray[i] = diskToAdd;
		}
		
		//adds to input
		System.out.println("Adding disks to production line...");
				
		for(Disk disk: testArray)
		{
			test.addToInput(disk);
		}
		
		System.out.println(test.inputToString());
		
		//processes the disks on the input line and adds to output line
		System.out.println("Processing disks to output...");
		test.process();
		
		System.out.println("Printing towers from production line with lines between each tower. \nTowers are printed as their "
				+ "actual forms, with the biggest radius at the bottom and smallest at the top");
		System.out.println(test.toString());
	}
}
