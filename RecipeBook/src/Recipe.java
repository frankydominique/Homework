/**
 * interface for the recipe classes
 * @author Franceska
 *
 */
public interface Recipe {
	
	public String getIngredients();
	public String getInstructions();
	public boolean convertUnits();
	public boolean changeServingSize(int x);
	
}
