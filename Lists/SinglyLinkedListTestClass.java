/**
 * @author Franceska
 *
 */
public class SinglyLinkedListTestClass {
	
	private static String[] source = {"Barry", "Iris", "Cisco"};
	private static SinglyLinkedList list1 = new SinglyLinkedList();
	private static SinglyLinkedList list2 = new SinglyLinkedList(source);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//tests toString method
		System.out.println(list1.toString());
		System.out.println(list2.toString());
		
		testMethod(list1);
		testMethod(list2);
	}

	public static void testMethod(SinglyLinkedList x)
	{
		System.out.println(x.isEmpty());
		
		System.out.println(x.size());
		
		Object test = "Caitlin";
		System.out.println(x.contains(test));
		
		int y = x.indexOf(test);
		System.out.println(y);
		
		System.out.println(x.add(test));
		
		System.out.println(x.remove("Caitlin"));
		
		System.out.println(x.get(x.indexOf("Caitlin")));
		
		System.out.println(x.set(x.indexOf("Caitlin"), "Joe"));
	}
}