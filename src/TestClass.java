/**
 * @author franceska.padillacoo
 *
 */
public class TestClass {
	
	//fields
	static int test1;
	static int test2;

	/**
	 * 
	 */
	public TestClass() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1 = (int)(Math.random() * 10);
		test2 = (int)(Math.random() * 10);
		testCards();
	}
	
	public static void testCards()
	{
		Cards testing = new Cards(test1, test2);
		Cards testing1 = new Cards("Hearts", "Jack");
		Cards testing2 = new Cards("Hearts", test1);
		Cards testing3 = new Cards(test1, "Jack");
		
		Cards[] testSet = {testing, testing1, testing2, testing3};
		
		for(Cards x: testSet)
		{
			System.out.print(x.toString() + ", compareTo(testing): " + x.compareTo(testing) + ", equals: " + x.equals(testing));
			System.out.println();
		}
	}
	
	public static void testDeck(int test1, int test2)
	{
		Deck test = new Deck();
		Deck testing = new Deck(false);
		Deck testing2 = new Deck(false);
		
		Deck[] testSet = {test, testing, testing2};
		
		for(int i = 0; i < testSet.length; i++)
		{
			System.out.print(testSet[i].toString() + ", equals: " + testSet[i].equals(testing) + ", picked Card: " + testSet[i].pick());
			
			Deck[] temp = testSet[i].deal(test1, test2);
			System.out.println();
			
			testSet[i].mergeSort();
			
			System.out.println(testSet[i].toString());
		}
		
		
	}

}
