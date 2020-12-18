import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Franceska
 *
 */

public class RecipePage extends JPanel {

	private final GridLayout GRIDLAYOUT = new GridLayout(0, 2);;
	private JPanel leftPanel;
	private JPanel rightPanel;
	private JButton returnButton;
	private JButton changeServingSize;
	private final String[] OPTIONS = {"Imperial", "Metric"};
	private JComboBox changeUnits;
	private JTextArea ingredients;
	private JTextArea instructions;
	private JScrollPane ingredientsScroll;
	private JScrollPane instructionsScroll;
	private final Font FONT;
	private final Color COLOR = new Color(219, 245, 247);
	private Recipe recipe;
	
	public RecipePage(Recipe recipe, CardLayout cardLayout, JPanel container)
	{
		this.setLayout(GRIDLAYOUT);
		leftPanel = new JPanel();
		rightPanel = new JPanel();
		returnButton = new JButton("Return to main menu");
		changeServingSize = new JButton("Change Serving Size");
		changeUnits = new JComboBox(OPTIONS);
		ingredients = new JTextArea();
		instructions = new JTextArea();
		ingredientsScroll = new JScrollPane(ingredients, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		instructionsScroll = new JScrollPane(instructions, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		FONT = new Font("Times Italic", Font.ITALIC, 22);
		this.recipe = recipe;
		
		setUpPage(cardLayout, container);
	}

	/**
	 * @return the ingredients
	 */
	public JTextArea getIngredients() {
		return ingredients;
	}

	/**
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(JTextArea ingredients) {
		this.ingredients = ingredients;
	}

	/**
	 * @return the instructions
	 */
	public JTextArea getInstructions() {
		return instructions;
	}

	/**
	 * @param instructions the instructions to set
	 */
	public void setInstructions(JTextArea instructions) {
		this.instructions = instructions;
	}

	private void setUpPage(CardLayout cardLayout, JPanel container)
	{
		leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));

		ingredients.setFont(FONT);
		instructions.setFont(FONT);
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

		this.setLayout(GRIDLAYOUT);
		this.add(leftPanel);
		this.add(rightPanel);
	}
}

