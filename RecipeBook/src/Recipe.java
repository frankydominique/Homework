/**
 * interface for the recipe classes
 * @author Franceska
 *
 */
import java.util.*;

public class Recipe {
	
	private String name;
	private Map<String, Double> ingredients;
	private Map<String, String> ingredMeasurements;
	private String instructions;
	private int servingSize;
	private boolean imperial;
	
	public Recipe(String name, ArrayList<String> ingredNames, ArrayList<Double> amts, int servingSize, 
			boolean imperial)
	{
		ingredients = new HashMap<String, Double>();
		ingredMeasurements = new HashMap<String, String>();
		this.name = name;
		this.servingSize = servingSize;
		this.imperial = imperial;
	}
	
	public Recipe()
	{
		ingredients = new HashMap<String, Double>();
		ingredMeasurements = new HashMap<String, String>();
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getIngredients()
	{
		Set<String> list = ingredients.keySet();
		Iterator<String> iter = list.iterator();
		String ingreds = "";
		
		while(iter.hasNext())
		{
			String ingred = iter.next();
			Double val = ingredients.get(ingred);
			
			if(ingred.equalsIgnoreCase("eggs")) ingreds += val + " " + ingred + "(s) \n";
			else ingreds += val + " " + ingredMeasurements.get(ingred) + "(s) " + ingred + "\n";
		}
		
		return ingreds;
	}
	
	public void setIngredients(ArrayList<String> name, ArrayList<Double> amt)
	{
		for(int i = 0; i < name.size(); i++)
		{
			ingredients.put(name.get(i), amt.get(i));
		}
	}
	
	public void addIngredient(String name, Double amt, String measurement)
	{
		ingredients.put(name, amt);
		ingredMeasurements.put(name, measurement);
	}
	
	public String getInstructions()
	{
		return instructions;
	}
	
	public void setInstructions(String s)
	{
		instructions = s;
	}
	
	public boolean convertUnits()
	{
		if(imperial)
		{
			if(ingredients.containsKey("flourAP"))
			{	
				Double flourAP = ingredients.get("flourAP");
				ingredients.replace("flourAP", Math.floor((flourAP * 4.41 * 28.35) * 100) / 100);
			}
			if(ingredients.containsKey("butter"))
			{	
				Double butter = ingredients.get("butter");
				ingredients.replace("butter", Math.floor((butter / 16 * 8 * 28.35) * 100) / 100);
			}
			imperial = false;
		} else
		{
			if(ingredients.containsKey("flourAP"))
			{	
				Double flourAP = ingredients.get("flourAP");
				ingredients.replace("flourAP", Math.round((flourAP / 28.35 / 4.41) * 100.00) / 100.00);
			}
			if(ingredients.containsKey("butter"))
			{	
				Double butter = ingredients.get("butter");
				ingredients.replace("butter", Math.floor((butter / 28.35 / 8 * 16) * 100) / 100);
			}
			imperial = true;
		}
		
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
	
	public boolean changeServingSize(int x)
	{
		Set<String> list = ingredients.keySet();
		Iterator<String> iter = list.iterator();
		
		while(iter.hasNext())
		{
			String ingred = iter.next();
			Double val = ingredients.get(ingred);
			
			if(ingred.equalsIgnoreCase("eggs"))
				ingredients.replace(ingred, changeOneIngredientSize(val, x));
			else
				ingredients.replace(ingred, changeOneIngredientSize(val, x));
		}
		return true;
	}
	
	public void setServingSize(int x)
	{
		servingSize = x;
	}

	//true is it is imperial, false is it is metric
	public void setImperial(boolean t)
	{
		imperial = t;
	}
}
