import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Franceska
 *
 */
public class SearchPage extends JPanel{
	
	private JPanel leftPanel;
	private JPanel rightPanel;
	private final GridLayout LAYOUT;
	private final GridLayout LAYOUT1;
	private final GridLayout LAYOUT2;
	private JButton searchButton;
	private JButton returnButton;
	
	public SearchPage(CardLayout cardLayout, JPanel container)
	{
		leftPanel = new JPanel();
		rightPanel = new JPanel();
		LAYOUT = new GridLayout(0, 2);
		LAYOUT1 = new GridLayout(2, 0);
		LAYOUT2 = new GridLayout(3, 0);
		searchButton = new JButton("Search");
		returnButton = new JButton("Return to main menu");
		
		setUp(cardLayout, container);
	}
	
	public void setUp(CardLayout cardLayout, JPanel container)
	{
		this.setLayout(LAYOUT);
		leftPanel.setLayout(LAYOUT1);
		rightPanel.setLayout(LAYOUT2);
		
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
		this.add(leftPanel);
		this.add(rightPanel);
		
	}
	
}
