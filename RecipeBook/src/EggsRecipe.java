/**
 * 
 */

/**
 * @author Franceska
 *
 */
public class EggsRecipe implements Recipe{

	/**
	 * fields
	 */
	private int eggs = 1;
	private int servingSize = 1;
	
	/**
	 * constructors
	 */
	public EggsRecipe()
	{
		
	}
	
	/**
	 * changes the serving size
	 */
	public boolean changeServingSize(int x)
	{
		servingSize = x;
		eggs = x;
		return true;
	}
	
	/**
	 * necessary to implement, unused
	 */
	public boolean convertUnits()
	{
		return false;
	}
	
	/**
	 * returns the instructions
	 */
	public String getInstructions()
	{
		String step1 = "-Crack egg(s) into pan";
		String step2 = "-Cook them";
		return step1 + "\n" + step2; 
	}
	
	/**
	 * returns the ingredients of this recipe
	 */
	public String getIngredients()
	{
		return eggs + " eggs";
	}
	
	

	public int getServingSize()
	{
		return servingSize;
	}
	
	public void setServingSize(int x)
	{
		servingSize = x;
		eggs = x;
	}

	
	
	public String toString()
	{
		return "Eggs Recipe: " + "Ingredients: \n" + getIngredients() + "\n Instructions: \n " + getInstructions(); 
	}

}
