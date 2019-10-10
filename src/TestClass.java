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
		for(int x = 0; x < 10; x++)
		{
			test1 = (int)(Math.random() * 10);
			test2 = (int)(Math.random() * 10);
			testCards();
			testDeck();
		}
		
	}
	
	public static void testCards()
	{
		Cards testing = new Cards(test1, test2);
		Cards testing1 = new Cards("Hearts", "Jack");
		Cards testing2 = new Cards("Hearts", test1);
		Cards testing3 = new Cards(test1, "Jack");
		Cards testing4 = new Cards(test2, test1);
		Cards testing5 = new Cards(test1, null);
		Cards testing6 = new Cards(null, test2);
		
		Cards[] testSet = {testing, testing1, testing2, testing3, testing4, testing5, testing6};
		
		CardComparator comp = new CardComparator();
		
		for(Cards x: testSet)
		{
			System.out.println(x.toString() + ", compareTo(testing): " + x.compareTo(testing) + ", equals: " + x.equals(testing));
			System.out.println(comp.compare(x, testing));
			System.out.println();
		}
	}
	
	public static void testDeck(int test1, int test2)
	{
		Deck test = new Deck();
		Deck testing = new Deck(false);
		Deck testing2 = new Deck(false);
		Deck testing3 = new Deck(true);
		Deck testing4 = new Deck(4);
		Deck testing5 = new Deck(0);
		Deck testing6 = new Deck();
		
		Deck[] testSet = {test, testing, testing2, testing3, testing4, testing5, testing6};
		
		for(int i = 0; i < testSet.length; i++)
		{
			System.out.println("Testing toString(), equals(), and pick(): ");
			System.out.println(testSet[i].toString() + ", equals: " + testSet[i].equals(testing) + ", picked Card: " + testSet[i].pick());
			
			System.out.println("Testing deal(): ");
			Deck[] temp = testSet[i].deal(test1, test2);
			for(Deck x: temp)
				System.out.println("hand: " + x);
			System.out.println();
			
			System.out.println("Testing mergeSort(): ");
			testSet[i].mergeSort();
			System.out.println(testSet[i].toString());
			
			System.out.println("Testing selectionSort()": );
			testSet[i].shuffle();
			testSet[i].selectionSort();
			for(Deck x: testSet)
				System.out.println("selectionSort shuffle: " + x);
		}
		
		
	}

}
