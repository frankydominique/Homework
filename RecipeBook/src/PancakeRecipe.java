import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

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
	private double flourAP = 1.5; //c
	private double confectionerSugar = 3;
	private double bakingPowder = 2;
	private double kosherSalt = 0.5;
	private double milk = 1.25; 
	private  double butter = 4; //c
	private  double vanillaExtract = 0.5;
	private  int egg = 4;
	private  double creamOfTartar = 0.25;
	
	private  int ORIGINAL_SERVING_SIZE = 8;
	private  int servingSize = ORIGINAL_SERVING_SIZE;
	private  boolean imperial = true;
	
	public PancakeRecipe()
	{
		
	}
	
	public  boolean changeServingSize(int x)
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
		servingSize = x;
		return true;
	}
	
	public  double changeOneIngredientSize(double ingredient, int newAmt)
	{
		return ingredient / servingSize * newAmt;
	}
	
	public  boolean convertUnits()
	{
		if(imperial)
		{
			flourAP = Math.floor((flourAP * 4.41 * 28.35) * 100) / 100;
			butter = Math.floor((butter / 16 * 8 * 28.35) * 100) / 100;
			imperial = false;
		} else
		{
			flourAP = Math.round((flourAP / 28.35 / 4.41) * 100.00) / 100.00;
			butter = Math.floor((butter / 28.35 / 8 * 16) * 100) / 100;
			imperial = true;
		}
		
		return true;
	}
	
	public  String getInstructions()
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
	
	public  String getIngredients()
	{
		if(imperial)
			return flourAP + " cups AP Flour, \n" +
				confectionerSugar + " tablespoons confectioner sugar, \n" +
				bakingPowder + " teaspoons baking powder, \n" +
				kosherSalt + " teaspoons kosher salt, \n" +
				milk + " cups milk, \n" +
				butter + " tablespoons butter, \n" +
				vanillaExtract + " teaspoon vanilla extract, \n" +
				egg + " eggs, \n" +
				creamOfTartar + " teaspoons cream of tartar";
		else
			return flourAP + " grams AP Flour, \n" +
			confectionerSugar + " tablespoons confectioner sugar, \n" +
			bakingPowder + " teaspoons baking powder, \n" +
			kosherSalt + " teaspoons kosher salt, \n" +
			milk + " cups milk, \n" +
			butter + " grams butter, \n" +
			vanillaExtract + " teaspoon vanilla extract, \n" +
			egg + " eggs, \n" +
			creamOfTartar + " teaspoons cream of tartar";
	}
	
	

	public  int getServingSize()
	{
		return servingSize;
	}
	
	public  void setServingSize(int x)
	{
		servingSize = x;
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
