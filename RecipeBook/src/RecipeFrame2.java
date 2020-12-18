/* @author Franceska
 *
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecipeFrame2 extends JFrame{
	
	/**
	 * fields
	 */
	private CardLayout cardLayout;
	private JPanel container;
	private MainMenuPage mainMenu;
	//Need recipe pages
	//PROBLEM: YOU END UP MAKING SEVERAL BUTTONS FOR THE SAME RECIPES INSTEAD OF SENDING IN DIFFERENT 
	//RECIPES
	private SearchPage searchPage;
	private AddPage addPage;
	private Color COLOR = new Color(219, 245, 247);

	/**
	 * constructors
	 */
	public RecipeFrame2()
	{
		super("Recipe Book");
		setUpOpeningScreen();
		this.setPreferredSize(new Dimension(1200, 1200));
		this.add(container);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	/**
	 * makes the page outline for the given recipe and enters the appropriate information
	 * @param recipe - the recipe type
	 * @return - a panel containing the recipe's information subbed in
	 */
	/*public JPanel makeRecipePage(Recipe recipe)
	{
		JPanel recipePage = new JPanel();
		GridLayout gridLayout = new GridLayout(0, 2);
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		
		JButton returnButton = new JButton("Return to main menu");
		JButton changeServingSize = new JButton("Change Serving Size");
		String[] options = {"Imperial", "Metric"};
		JComboBox changeUnits = new JComboBox(options);
		JTextArea ingredients = new JTextArea();
		JTextArea instructions = new JTextArea();
		JScrollPane ingredientsScroll = new JScrollPane(ingredients, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JScrollPane instructionsScroll = new JScrollPane(instructions, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		Font font = new Font("Times Italic", Font.ITALIC, 22);
		ingredients.setFont(font);
		instructions.setFont(font);
		instructions.setSize(rightPanel.getWidth(), rightPanel.getHeight() - changeUnits.getHeight());
		instructions.setLineWrap(true);
		instructions.setWrapStyleWord(true);
		
		ingredients.setText(recipe.getIngredients());
		instructions.setText(recipe.getInstructions());
		ingredients.setEditable(false);
		instructions.setEditable(false);
		ingredients.setBackground(COLOR);
		instructions.setBackground(COLOR);
		
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				cardLayout.show(container, "Main Menu");
			}
		});
		changeUnits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				recipe.convertUnits();
				ingredients.setText(recipe.getIngredients());
			}
		});
		changeServingSize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				try {
				String servingSizeInput = JOptionPane.showInputDialog(this, "Wanted serving size: ");
				recipe.changeServingSize(Integer.valueOf(servingSizeInput));
				ingredients.setText(recipe.getIngredients());
				} catch (NumberFormatException x){
					
				}
			}
		});
		leftPanel.add(returnButton);
		leftPanel.add(ingredientsScroll);
		leftPanel.add(changeServingSize);
		
		rightPanel.add(instructionsScroll);
		rightPanel.add(changeUnits);
		
		leftPanel.setBackground(COLOR);
		rightPanel.setBackground(COLOR);
		
		recipePage.setLayout(gridLayout);
		recipePage.add(leftPanel);
		recipePage.add(rightPanel);
		
		return recipePage;
	}*/
	
	/**
	 * makes the page where someone can search for an ingredient
	 * @return a jPanel that allows someone to search for an ingredient
	 */
	/*private JPanel makeSearchPage()
	{
		JPanel searchPanel = new JPanel();
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		GridLayout layout = new GridLayout(0, 2);
		GridLayout layout1 = new GridLayout(2, 0);
		GridLayout layout2 = new GridLayout(3, 0);
		searchPanel.setLayout(layout);
		leftPanel.setLayout(layout1);
		rightPanel.setLayout(layout2);
		
		JButton searchButton = new JButton("Search");
		JButton returnButton = new JButton("Return to main menu");
		
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				cardLayout.show(container, "Main Menu");
			}
		});
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				rightPanel.removeAll();
				rightPanel.revalidate();
				rightPanel.repaint();
				
				String wantedIngredient = JOptionPane.showInputDialog(this, "Wanted ingredient: ");
				
				PancakeRecipe pancakes = new PancakeRecipe();
				ChocolateChipCookieRecipe chocoCookie = new ChocolateChipCookieRecipe();
				EggsRecipe eggs = new EggsRecipe();
				
				if(wantedIngredient != null)
				{
					if(pancakes.getIngredients().indexOf(wantedIngredient) >= 0)
					{
						JButton recipe = new JButton("Pancake Recipe");
						recipe.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent event)
							{
								cardLayout.show(container, "Recipe 1");
							}
						});
						rightPanel.add(recipe);
						rightPanel.revalidate();
						rightPanel.repaint();
					}
					
					if(chocoCookie.getIngredients().indexOf(wantedIngredient) >= 0)
					{
						JButton recipe = new JButton("Chocolate Chip Cookie Recipe");
						recipe.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent event)
							{
								cardLayout.show(container, "Recipe 2");
							}
						});
						rightPanel.add(recipe);
						rightPanel.revalidate();
						rightPanel.repaint();
					}
					
					if(eggs.getIngredients().indexOf(wantedIngredient) >= 0)
					{
						JButton recipe = new JButton("Eggs Recipe");
						recipe.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent event)
							{
								cardLayout.show(container, "Recipe 3");
							}
						});
						rightPanel.add(recipe);
						rightPanel.revalidate();
						rightPanel.repaint();
					}
				}
			}
		});
		
		leftPanel.add(returnButton);
		leftPanel.add(searchButton);
		searchPanel.add(leftPanel);
		searchPanel.add(rightPanel);
		
		return searchPanel;
	}*/
	
	/**
	 * fills in the opening screen of the recipe book and fills in which recipes then shows the screen
	 */
	private void setUpOpeningScreen()
	{
		container = new JPanel();
		cardLayout = new CardLayout();
		container.setLayout(cardLayout);
		
		mainMenu = new MainMenuPage(cardLayout, container);//makeMainMenu();
		searchPage = new SearchPage(cardLayout, container); //makeSearchPage();
		addPage = new AddPage(cardLayout, container, mainMenu); //makeAddPage();
		
		container.add(mainMenu, "Main Menu");
		container.add(searchPage, "Search Page");
		container.add(addPage, "Add Recipe");
		
		cardLayout.show(container, "Main Menu");
	}
	
	private JPanel makeAddPage()
	{/*
		//panels
		JPanel mainPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		JPanel leftPanel = new JPanel();
		
		//layouts
		mainPanel.setLayout(new GridLayout(0, 2));
		leftPanel.setLayout(new GridLayout(7, 0));
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		
		JTextArea ingredients = new JTextArea();
		JScrollPane ingredientsScroll = new JScrollPane(ingredients, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		Font font = new Font("Times Italic", Font.ITALIC, 22);
		ingredients.setFont(font);
		ingredients.setWrapStyleWord(true);
		ingredients.setEditable(false);
		ingredients.setBackground(COLOR);
		
		Recipe newRecipe = new Recipe();
		
		//buttons
		JButton returnButton = new JButton("Return to main menu");
		JButton nameButton = new JButton("Name");
		JButton ingredientsButton = new JButton("Ingredients");
		JButton instructButton = new JButton("Instructions");
		JButton sizeButton = new JButton("Serving Size");
		String[] options = {"Imperial", "Metric"};
		JComboBox unitButton = new JComboBox(options);
		JButton completeButton = new JButton("Send in Recipe");
		
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				cardLayout.show(container, "Main Menu");
			}
		});
		nameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				String name = JOptionPane.showInputDialog(this, "Name: ");
				newRecipe.setName(name);
			}
		});
		ingredientsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				rightPanel.revalidate();
				rightPanel.repaint();
				
				String newIngredient = JOptionPane.showInputDialog(this, "What ingredient do you want to add?");
				
				String[] options = {"cups", "tsp", "tbsp", "bag", "oz", "grams", "kilograms", "n/a"};
				int x = JOptionPane.showOptionDialog(null, "Returns the position of your choice on the array",
		                "Click a button",
		                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
				String choice = options[x];
				
				Double ingredValue = Double.parseDouble(JOptionPane.showInputDialog(this, "How much of this ingredient? (Double)"));
			
				newRecipe.addIngredient(newIngredient, ingredValue, choice);
				
				ingredients.setText(newRecipe.getIngredients());
			}
		});
		instructButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				String instructions = JOptionPane.showInputDialog(this, "What are the instructions?");
				newRecipe.setInstructions(instructions);	
			}
		});
		sizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				Integer servingSize = Integer.parseInt(JOptionPane.showInputDialog(this, "What is the serving size?"));
				newRecipe.setServingSize(servingSize);
			}
		});
		unitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				JComboBox box = (JComboBox)event.getSource();
				String choice = (String)box.getSelectedItem();
				if(choice.equalsIgnoreCase("Imperial"))
					newRecipe.setImperial(true);
				else
					newRecipe.setImperial(false);
			}
		});
		completeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				container.add(new RecipePage(newRecipe, cardLayout, container), newRecipe.getName());
				
				JButton newRecButton = new JButton(newRecipe.getName());
				
				newRecButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent event)
					{
						cardLayout.show(container, newRecipe.getName());
						
					}
				});

				mainMenu.add(newRecButton);
				mainMenu.revalidate();
				mainMenu.repaint();
			}
		});
		
		rightPanel.add(returnButton);
		rightPanel.add(ingredients);
		leftPanel.add(nameButton);
		leftPanel.add(ingredientsButton);
		leftPanel.add(instructButton);
		leftPanel.add(sizeButton);
		leftPanel.add(unitButton);
		leftPanel.add(completeButton);
		
		mainPanel.add(rightPanel);
		mainPanel.add(leftPanel);
		
		return mainPanel;*/
		return null;
	}
	
	/**
	 * makes the main menu page/opening screen with the title and buttons
	 * @return the JPanel of the opening screen
	 */
	private JPanel makeMainMenu()
	{
		/*JPanel menu = new JPanel();
		GridLayout gridLayout = new GridLayout(5, 0);
		GridLayout gridLayout2 = new GridLayout(0, 3);
		JPanel titleScreen = new JPanel();
		menu.setLayout(gridLayout);
		titleScreen.setLayout(gridLayout2);
		
		JTextArea title = new JTextArea("   Recipe Book");
		title.setBackground(COLOR);
		Font font = new Font("Serif Italic", Font.ITALIC, 48);
		title.setFont(font);
		title.setEditable(false);
		
		JButton searchBar = new JButton("Search for Ingredients");
		JButton addBar = new JButton("Add Recipes");
		
		titleScreen.add(new ImagePanel());
		titleScreen.add(title);
		titleScreen.add(new ImagePanel());
		
		
		
		searchBar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				cardLayout.show(container, "Search Page");
			}
		});
		addBar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				cardLayout.show(container, "Add Recipe");
			}
		});
		
		menu.add(titleScreen);
		menu.add(addBar);
		menu.add(searchBar);
		
		return menu;*/
		return null;
	}
	
	/**
	 * prints the string of this JFrame
	 */
	public String toString()
	{
		return "Recipe";
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecipeFrame2 test = new RecipeFrame2();
	}

}

