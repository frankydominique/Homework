import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Franceska
 *
 */
public class AddPage extends JPanel{

	private JPanel rightPanel;
	private JPanel leftPanel;
	private final GridLayout LAYOUT1;
	private final GridLayout LAYOUT2;
	private JTextArea ingredients;
	private JScrollPane ingredientsScroll;
	private final Font FONT;
	private JButton returnButton;
	private JButton nameButton;
	private JButton ingredientsButton;
	private JButton instructButton;
	private JButton sizeButton;
	private String[] options = {"Imperial", "Metric"};
	private JComboBox unitButton;
	private JButton completeButton;
	private final Color COLOR = new Color(219, 245, 247);
	private CardLayout cardLayout;
	private JPanel container;
	private MainMenuPage mainMenu;
	private Recipe newRecipe;
	
	public AddPage(CardLayout cardLayout, JPanel container, MainMenuPage mainMenu)
	{
		rightPanel = new JPanel();
		leftPanel = new JPanel();
		LAYOUT1 = new GridLayout(0, 2);
		LAYOUT2 = new GridLayout(7, 0);
		ingredients = new JTextArea();
		ingredientsScroll = new JScrollPane(ingredients, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		FONT = new Font("Times Italic", Font.ITALIC, 22);
		
		returnButton = new JButton("Return to main menu");
		nameButton = new JButton("Name");
		ingredientsButton = new JButton("Ingredients");
		instructButton = new JButton("Instructions");
		sizeButton = new JButton("Serving Size");
		unitButton = new JComboBox(options);
		completeButton = new JButton("Send in Recipe");
	
		this.cardLayout = cardLayout;
		this.container = container;
		newRecipe = new Recipe();
		this.mainMenu = mainMenu;
	
		setUp();
		
		this.add(rightPanel);
		this.add(leftPanel);
	
	}
	
	public void setUp()
	{
		this.setLayout(LAYOUT1);
		leftPanel.setLayout(LAYOUT2);
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		
		rightPanel.add(returnButton);
		leftPanel.add(nameButton);
		leftPanel.add(ingredientsButton);
		leftPanel.add(instructButton);
		leftPanel.add(sizeButton);
		leftPanel.add(unitButton);
		leftPanel.add(completeButton);
		
		setUpReturnButton();
		setUpNameButton();
		setUpIngredientsButton();
		setUpInstructButton();
		setUpSizeButton();
		setUpUnitButton();
		setUpCompleteButton();
		
		ingredients.setFont(FONT);
		ingredients.setWrapStyleWord(true);
		ingredients.setEditable(false);
		ingredients.setBackground(COLOR);
	}
	
	public void setUpReturnButton()
	{
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				cardLayout.show(container, "Main Menu");
			}
		});
		
	}
			
	public void setUpNameButton()
	{
		nameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				String name = JOptionPane.showInputDialog(this, "Name: ");
				newRecipe.setName(name);
			}
		});
		
	}
			
	public void setUpIngredientsButton()
	{
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
		
		rightPanel.add(ingredients);
	}
	
	public void setUpInstructButton()
	{
		instructButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				String instructions = JOptionPane.showInputDialog(this, "What are the instructions?");
				newRecipe.setInstructions(instructions);	
			}
		});
		
	}
			
	public void setUpSizeButton()
	{
		sizeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				Integer servingSize = Integer.parseInt(JOptionPane.showInputDialog(this, "What is the serving size?"));
				newRecipe.setServingSize(servingSize);
			}
		});
		
	}
			
	public void setUpUnitButton()
	{
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
	
	}
	
	public void setRecipe()
	{
		newRecipe = new Recipe();
	}
	
	public JTextArea getJTextArea()
	{
		return ingredients;
	}
	
	public void setJTextArea(String newIngredientPrint)
	{
		ingredients.selectAll();
		ingredients.replaceSelection(newIngredientPrint);
	}
	
	public void setUpCompleteButton()
	{
		AddPage thisPage = this;
		completeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				container.add(new RecipePage(newRecipe, cardLayout, container), newRecipe.getName());
				
				mainMenu.addRecipeButton(newRecipe);
				
				thisPage.setRecipe();
				
				thisPage.setJTextArea("");
			}
		});
		
	}
				
}
