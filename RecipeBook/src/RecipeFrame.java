/**
 * @author Franceska
 *
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecipeFrame extends JFrame{
	
	private CardLayout cardLayout;
	private JPanel container;
	private JPanel mainMenu;
	private JPanel recipePage1;
	private JPanel recipePage2;
	private JPanel recipePage3;
	private Color COLOR = new Color(219, 245, 247);
	private int status = 0; //0 = main menu, 1 = first recipe, 2 = second recipe, etc.

	//TODO make constructor with super, a setFrameOptions method, and set visible
	public RecipeFrame()
	{
		super("Recipe Book");
		setUpOpeningScreen();
		this.setPreferredSize(new Dimension(1200, 800));
		this.add(container);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
	
	//TODO in set frame options make a basic recipe screen with a title
	//	two buttons for the recipe's units and the recipe's serving size
	//	and the screen divided up into two different sides, one with the instructions and the other
	//	with the ingredients
	//	include a back button to go back to the main menu
	//idea: each recipe should have this method and return the jpanel, make it static
	//implements the recipe interface, gonna have to make instances
	public JPanel makeRecipePage(Recipe recipe)
	{
		//PancakeRecipe recipe = new PancakeRecipe();
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
	
	//TODO make a main menu screen with the list of recipes and that allows you to go back and forth
	//add some decorations
	private void setUpOpeningScreen()
	{
		container = new JPanel();
		cardLayout = new CardLayout();
		container.setLayout(cardLayout);
		
		mainMenu = makeMainMenu();
		recipePage1 = makeRecipePage(new PancakeRecipe());
		recipePage2 = makeRecipePage(new ChocolateChipCookieRecipe());
		recipePage3 = makeRecipePage(new EggsRecipe());
		container.add(mainMenu, "Main Menu");
		container.add(recipePage1, "Recipe 1");
		container.add(recipePage2, "Recipe 2");
		container.add(recipePage3, "Recipe 3");
		
		cardLayout.show(container, "Main Menu");
	}
	
	private JPanel makeMainMenu()
	{
		JPanel menu = new JPanel();
		GridLayout gridLayout = new GridLayout(4, 0);
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
		
		menu.add(titleScreen);
		menu.add(recipe1);
		menu.add(recipe2);
		menu.add(recipe3);
		
		return menu;
	}
	
	public String toString()
	{
		return "Recipe";
	}
	
	//TODO extra: try to do a search on the main menu that pulls up recipes that have an ingredient
	//	you searched for
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecipeFrame test = new RecipeFrame();
	}

}
