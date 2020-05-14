/**
 * 
 */

/**
 * @author Franceska
 *
 */
public class ChocolateChipCookieRecipe implements Recipe{

	/**
	 * fields
	 */
	private double butter;
	private double whiteSugar;
	private double brownSugar;
	private double vanilla;
	private double bakingSoda;
	private double hotWater;
	private double salt;
	private double APFlour;
	private double chocolateChips;
	private  int eggs;
	private  int servingSize;
	private boolean imperial;
	
	/**
	 * constructors
	 */
	public ChocolateChipCookieRecipe()
	{
		butter = 1;
		whiteSugar = 1;
		brownSugar = 1;
		eggs = 2;
		vanilla = 2;
		bakingSoda = 1;
		hotWater = 2;
		salt = 0.5;
		APFlour = 3;
		chocolateChips = 2;
		servingSize = 48;
		imperial = true;
	}
	
	/**
	 * changes the ingredients to accommodate the serving size
	 * @return true when this method completes its purpose
	 */
	public  boolean changeServingSize(int x)
	{
		butter = changeOneIngredientSize(butter, x);
		whiteSugar = changeOneIngredientSize(whiteSugar, x);
		brownSugar = changeOneIngredientSize(brownSugar, x);
		eggs = (int)(eggs * 1.0 / servingSize * x);
		vanilla = changeOneIngredientSize(vanilla, x);
		bakingSoda = changeOneIngredientSize(bakingSoda, x);
		hotWater = changeOneIngredientSize(hotWater, x);
		salt = changeOneIngredientSize(salt, x);
		APFlour = changeOneIngredientSize(APFlour, x);
		chocolateChips = changeOneIngredientSize(chocolateChips, x);
		servingSize = x;
		imperial = true;
		
		return true;
	}
	
	/**
	 * adjust the individual ingredient amount to accommodate the new serving size
	 * @param ingredient the current amount of the ingredient
	 * @param newAmt the new serving size
	 * @return the new amount needed to provide for the new serving size
	 */
	public double changeOneIngredientSize(double ingredient, int newAmt)
	{
		return ingredient / servingSize * newAmt;
	}
	
	/**
	 * converts the units to the different measuring unit, either imperial or metric
	 */
	public  boolean convertUnits()
	{
		if(imperial)
		{
			APFlour = Math.floor((APFlour * 4.41 * 28.35) * 100) / 100;
			imperial = false;
		} else
		{
			APFlour = Math.round((APFlour / 28.35 / 4.41) * 100.00) / 100.00;
			imperial = true;
		}
		
		return true;
	}
	
	/**
	 * @returns the instructions
	 */
	public  String getInstructions()
	{
		String step1 = "-Preheat oven to 350 degrees F (175 degrees C)";
		String step2 = "-Cream together the butter, white sugar, and brown sugar"
				+ "		until smooth. Beat in the eggs one at a time, then stir"
				+ "		the vanilla. Dissolve baking soda in hot water. Add to"
				+ "		batter along with salt. Stir in flour and chocolate chips."
				+ "		Drop by large spoonfuls onto ungreased pans";
		String step3 = "-Bake for about 10 min in preheated oven, until edges are"
				+ "lightly browned";
		return step1 + "\n" + step2 + "\n" + step3; 
	}
	
	/**
	 * @return the ingredients according to whether they need to be imperial or metric
	 */
	public  String getIngredients()
	{
		if(imperial)
			return butter + " cup butter, softened, \n"
				+ whiteSugar + " cup white sugar\n"
				+ brownSugar + " cup packed brown sugar \n"
				+ eggs + " eggs \n"
				+ vanilla + " teaspoon(s) vanilla extract\n"
				+ bakingSoda + " teaspoon(s) bakingSoda\n"
				+ hotWater + " teaspoon(s) hot water\n"
				+ salt + " teaspoon(s) salt\n"
				+ APFlour + " cups AP flour\n"
						+ chocolateChips + " cups chocolate chips";
		else
			return butter + " cup butter, softened, \n"
			+ whiteSugar + " cup white sugar\n"
			+ brownSugar + " cup packed brown sugar \n"
			+ eggs + " eggs \n"
			+ vanilla + " teaspoon(s) vanilla extract\n"
			+ bakingSoda + " teaspoon(s) bakingSoda\n"
			+ hotWater + " teaspoon(s) hot water\n"
			+ salt + " teaspoon(s) salt\n"
			+ APFlour + " grams AP flour\n"
					+ chocolateChips + " cups chocolate chips";
	}

	/**
	 * returns the current serving size
	 * @return
	 */
	public  int getServingSize()
	{
		return servingSize;
	}	
	
	/**
	 * returns the string of this recipe class
	 */
	public String toString()
	{
		return "Chocolate Chip Cookies Recipe: " + "Ingredients: \n" + getIngredients() + "\n Instructions: \n " + getInstructions(); 
	}

}
