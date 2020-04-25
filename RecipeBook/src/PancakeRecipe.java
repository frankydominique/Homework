/**
 * 
 */

/**
 * @author Franceska
 *
 */
public class PancakeRecipe implements Recipe{

	/*
	 * Fields
	 */
	private double flourAP;
	private double confectionerSugar;
	private double bakingPowder;
	private double kosherSalt;
	private double milk;
	private double butter;
	private double vanillaExtract;
	private int egg;
	private double creamOfTartar;
	private int servingSize;
	
	private int ORIGINAL_SERVING_SIZE = 8;
	private boolean imperial;
	
	public PancakeRecipe()
	{
		flourAP = 1.5; //c
		confectionerSugar = 3;
		bakingPowder = 2;
		kosherSalt = 0.5;
		milk = 1.25; 
		butter = 4; //c
		vanillaExtract = 0.5;
		egg = 4;
		creamOfTartar = 0.25;
		servingSize = ORIGINAL_SERVING_SIZE;
		imperial = true;
	}
	
	public boolean changeServingSize(int x)
	{
		flourAP = changeOneIngredientSize(flourAP, x);
		confectionerSugar = changeOneIngredientSize(confectionerSugar, x);
		bakingPowder = changeOneIngredientSize(bakingPowder, x);
		kosherSalt = changeOneIngredientSize(kosherSalt, x);
		milk = changeOneIngredientSize(milk, x);
		butter = changeOneIngredientSize(butter, x);
		vanillaExtract = changeOneIngredientSize(vanillaExtract, x);
		egg = (int)(egg * 1.0 / ORIGINAL_SERVING_SIZE * x);
		creamOfTartar = changeOneIngredientSize(creamOfTartar, x);
		return true;
	}
	
	public double changeOneIngredientSize(double ingredient, int newAmt)
	{
		return ingredient / ORIGINAL_SERVING_SIZE * newAmt;
	}
	
	public boolean convertUnits()
	{
		if(imperial)
		{
			flourAP = flourAP * 4.41 * 28.35;
			butter = butter / 16 * 8 * 28.35;
		} else
		{
			flourAP = flourAP / 28.35 / 4.41;
			butter = butter / 28.35 / 8 * 16;
		}
		
		return true;
	}
	
	public String getInstructions()
	{
		String step1 = "-Whisk together flour, confecitoners' sugar, baking powder and salt in large bowl";
		String step2 = "-Whisk together milk, melted butter, vanilla, and one egg yolk until combined";
		String step3 = "-Beat three egg whites and cream of tartar with electric mixer on medium high speed until stiff peaks form";
		String step4 = "-Stirk milk mix into flour mix until combined. " +
						"Stirk one third of beathen egg whites into flour-milk mix. " +
						"Gently fold remaining egg whites until just combined.";
		String step5 = "-Get skillet ready and heat over medium-low heat. Use ring molds if accessible." +
						"Put 1/2 cup of batter onto pan/ring mold. Cover skillet with lid and cook until batter rises (abt five mins)" +
						"Releasee bottom of the pancakes with spatula and carefully flip pancake. Cook for abt five mins more";
		String step6 = "-Serve with butter and a lil syrup!";
		return step1 + "\n" + step2 + "\n" + step3 + "\n" + step4 + "\n" + step5 + "\n" + step6; 
	}
	
	public String getIngredients()
	{
		return flourAP + " cups AP Flour, \n" +
				confectionerSugar + " tablespoons confectioner sugar, \n" +
				bakingPowder + " teaspoons baking powder, \n" +
				kosherSalt + " teaspoons kosher salt, \n" +
				milk + " cups milk, \n" +
				butter + " tablespoons butter, \n" +
				vanillaExtract + " teaspoon vanilla extract, \n" +
				egg + " eggs, \n" +
				creamOfTartar + " teaspoons cream of tartar";
	}
	
	/**
	 * @return the flourAP
	 */
	public double getFlourAP() {
		return flourAP;
	}



	/**
	 * @param flourAP the flourAP to set
	 */
	public void setFlourAP(double flourAP) {
		this.flourAP = flourAP;
	}



	/**
	 * @return the confectionerSugar
	 */
	public double getConfectionerSugar() {
		return confectionerSugar;
	}



	/**
	 * @param confectionerSugar the confectionerSugar to set
	 */
	public void setConfectionerSugar(double confectionerSugar) {
		this.confectionerSugar = confectionerSugar;
	}



	/**
	 * @return the bakingPowder
	 */
	public double getBakingPowder() {
		return bakingPowder;
	}



	/**
	 * @param bakingPowder the bakingPowder to set
	 */
	public void setBakingPowder(double bakingPowder) {
		this.bakingPowder = bakingPowder;
	}



	/**
	 * @return the kosherSalt
	 */
	public double getKosherSalt() {
		return kosherSalt;
	}



	/**
	 * @param kosherSalt the kosherSalt to set
	 */
	public void setKosherSalt(double kosherSalt) {
		this.kosherSalt = kosherSalt;
	}



	/**
	 * @return the milk
	 */
	public double getMilk() {
		return milk;
	}



	/**
	 * @param milk the milk to set
	 */
	public void setMilk(double milk) {
		this.milk = milk;
	}



	/**
	 * @return the butter
	 */
	public double getButter() {
		return butter;
	}



	/**
	 * @param butter the butter to set
	 */
	public void setButter(double butter) {
		this.butter = butter;
	}



	/**
	 * @return the vanillaExtract
	 */
	public double getVanillaExtract() {
		return vanillaExtract;
	}



	/**
	 * @param vanillaExtract the vanillaExtract to set
	 */
	public void setVanillaExtract(double vanillaExtract) {
		this.vanillaExtract = vanillaExtract;
	}



	/**
	 * @return the egg
	 */
	public int getEgg() {
		return egg;
	}



	/**
	 * @param egg the egg to set
	 */
	public void setEgg(int egg) {
		this.egg = egg;
	}



	/**
	 * @return the creamOfTartar
	 */
	public double getCreamOfTartar() {
		return creamOfTartar;
	}



	/**
	 * @param creamOfTartar the creamOfTartar to set
	 */
	public void setCreamOfTartar(double creamOfTartar) {
		this.creamOfTartar = creamOfTartar;
	}

	public int getServingSize()
	{
		return servingSize;
	}
	
	public void setServingSize(int x)
	{
		this.servingSize = x;
	}

	public String toString()
	{
		return "Pancake Recipe: " + "Ingredients: \n" + getIngredients() + "\n Instructions: \n " + getInstructions(); 
	}
	
	public static void main(String[] args)
	{
		PancakeRecipe recipe = new PancakeRecipe();
		
		recipe.changeServingSize(16);
		
		System.out.println(recipe);
	}
}
