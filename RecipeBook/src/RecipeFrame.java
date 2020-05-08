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
	private int status = 0; //0 = main menu, 1 = first recipe, 2 = second recipe, etc.

	//TODO make constructor with super, a setFrameOptions method, and set visible
	public RecipeFrame()
	{
		super("Recipe Book");
		setUpOpeningScreen();
		this.setPreferredSize(new Dimension(300, 400));
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
	private JPanel makeRecipePage()
	{
		JPanel recipePage = new JPanel();
		GridLayout gridLayout = new GridLayout(0, 2);
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new GridLayout(2, 0));
		JPanel rightPanel = new JPanel();
		
		JButton returnButton = new JButton("Return to main menu");
		JButton changeServingSize = new JButton("Change Serving Size");
		JButton changeUnits = new JButton("Change units");
		
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				cardLayout.show(container, "Main Menu");
			}
		});
		leftPanel.add(returnButton);
		leftPanel.add(changeServingSize);
		rightPanel.add(changeUnits);
		
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
		recipePage1 = makeRecipePage();
		recipePage2 = makeRecipePage();
		recipePage3 = makeRecipePage();
		container.add(mainMenu, "Main Menu");
		container.add(recipePage1, "Recipe 1");
		container.add(recipePage2, "Recipe 2");
		container.add(recipePage3, "Recipe 3");
		
		cardLayout.show(container, "Main Menu");
	}
	
	private JPanel makeMainMenu()
	{
		JPanel menu = new JPanel();
		GridLayout gridLayout = new GridLayout(3, 0);
		menu.setLayout(gridLayout);
		
		JButton recipe1 = new JButton("Pancake Recipe");
		JButton recipe2 = new JButton("Choco Cookie Recipe");
		JButton recipe3 = new JButton("Eggs");
		
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
		
		menu.add(recipe1);
		menu.add(recipe2);
		menu.add(recipe3);
		
		return menu;
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
