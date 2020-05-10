/**
 * 
 */

/**
 * @author Franceska
 *
 */
public class EggsRecipe implements Recipe{

	private int eggs = 1;
	private int servingSize = 1;
	
	public EggsRecipe()
	{
		
	}
	
	public boolean changeServingSize(int x)
	{
		servingSize = x;
		eggs = x;
		return true;
	}
	
	public boolean convertUnits()
	{
		return false;
	}
	
	public String getInstructions()
	{
		String step1 = "-Crack egg(s) into pan";
		String step2 = "-Cook them";
		return step1 + "\n" + step2; 
	}
	
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
