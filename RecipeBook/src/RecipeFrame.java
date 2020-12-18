/**
 * @author Franceska
 *
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecipeFrame extends JFrame{
	
	/**
	 * fields
	 */
	private CardLayout cardLayout;
	private JPanel container;
	private JPanel mainMenu;
	private JPanel recipePage1;
	private JPanel recipePage2;
	private JPanel recipePage3;
	private JPanel searchPage;
	private Color COLOR = new Color(219, 245, 247);

	/**
	 * constructors
	 */
	public RecipeFrame()
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
	public JPanel makeRecipePage(Recipe recipe)
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
	}
	
	/**
	 * makes the page where someone can search for an ingredient
	 * @return a jPanel that allows someone to search for an ingredient
	 */
	private JPanel makeSearchPage()
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
	}
	
	/**
	 * fills in the opening screen of the recipe book and fills in which recipes then shows the screen
	 */
	private void setUpOpeningScreen()
	{
		container = new JPanel();
		cardLayout = new CardLayout();
		container.setLayout(cardLayout);
		
		mainMenu = makeMainMenu();
		//recipePage1 = makeRecipePage(new PancakeRecipe());
		//recipePage2 = makeRecipePage(new ChocolateChipCookieRecipe());
		//recipePage3 = makeRecipePage(new EggsRecipe());
		searchPage = makeSearchPage();
		container.add(mainMenu, "Main Menu");
		container.add(recipePage1, "Recipe 1");
		container.add(recipePage2, "Recipe 2");
		container.add(recipePage3, "Recipe 3");
		container.add(searchPage, "Search Page");
		
		cardLayout.show(container, "Main Menu");
	}
	
	/**
	 * makes the main menu page/opening screen with the title and buttons
	 * @return the JPanel of the opening screen
	 */
	private JPanel makeMainMenu()
	{
		JPanel menu = new JPanel();
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
		JButton recipe1 = new JButton("Pancake Recipe");
		JButton recipe2 = new JButton("Choco Cookie Recipe");
		JButton recipe3 = new JButton("Eggs");
		JButton searchBar = new JButton("Search for Ingredients");
		
		titleScreen.add(new ImagePanel());
		titleScreen.add(title);
		titleScreen.add(new ImagePanel());
		
		recipe1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				cardLayout.show(container, "Recipe 1");
			}
		});
		
		recipe2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				cardLayout.show(container,  "Recipe 2");
			}
		});
		
		recipe3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				cardLayout.show(container,  "Recipe 3");
			}
		});
		
		searchBar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				cardLayout.show(container, "Search Page");
			}
		});
		
		menu.add(titleScreen);
		menu.add(recipe1);
		menu.add(recipe2);
		menu.add(recipe3);
		menu.add(searchBar);
		
		return menu;
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
		RecipeFrame test = new RecipeFrame();
	}

}
