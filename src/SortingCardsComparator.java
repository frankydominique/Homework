/**
 * 
 */

/**
 * @author Franceska
 * Cards Comparator based on rank
 */
import java.util.Comparator;

public class SortingCardsComparator implements Comparator<Cards>{
	
	public SortingCardsComparator(){}
	
	public int compare(Cards cards1, Cards cards2)
	{
		int diff = cards1.getRank() - cards2.getRank();
		return diff;
	}
	
}
