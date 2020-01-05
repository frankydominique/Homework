/**
 * @author Franceska
 * Cards Comparator based on rank
 */
import java.util.Comparator;

public class SortingCardComparator {
		public SortingCardComparator(){}
		
		public int compare(Card cards1, Card cards2)
		{
			int diff = cards1.getRank() - cards2.getRank();
			return diff;
		}
		
	}
