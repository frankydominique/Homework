/**
 * 
 */

/**
 * @author Franceska
 *
 */
public class TestCardsAndDeck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("testing");
		Deck test = new Deck(false);
		System.out.println("Created");
		System.out.println(test.toString());
		test.selectionSort();
		System.out.println(test.toString());
		Deck test1 = new Deck();
		Deck test2 = new Deck();
		System.out.println(test1.toString());
		System.out.println(test2.toString());
		System.out.println(test1.equals(test2));
		Cards testing = test.pick();
		
		test.mergeSort();
		System.out.println("complete");
		System.out.println(test.toString());
		
		Deck[] testHand = test.deal(5, 2);
		for(Deck x: testHand)
			System.out.println(x.toString());
	}

}
