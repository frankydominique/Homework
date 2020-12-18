import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @author Franceska
 *
 */
public class MainMenuPage extends JPanel{

	private final GridLayout GRIDLAYOUT;
	private final GridLayout GRIDLAYOUT2;
	private JPanel titleScreen;
	private JTextArea title;
	private final Font FONT;
	private JButton searchBar;
	private JButton addBar;
	private final Color COLOR = new Color(219, 245, 247);
	private CardLayout cardLayout;
	private JPanel container;
	
	public MainMenuPage(CardLayout cardLayout, JPanel container)
	{
		GRIDLAYOUT = new GridLayout(5, 0);
		GRIDLAYOUT2 = new GridLayout(0, 3);
		titleScreen = new JPanel();
		title = new JTextArea("   Recipe Book");
		FONT = new Font("Serif Italic", Font.ITALIC, 48);
		searchBar = new JButton("Search for Ingredients");
		addBar = new JButton("Add Recipes");
		
		this.cardLayout = cardLayout;
		this.container = container;
		
		setUp();
	}
	
	public void setUp()
	{
		this.setLayout(GRIDLAYOUT);
		titleScreen.setLayout(GRIDLAYOUT2);
		
		title.setBackground(COLOR);
		title.setFont(FONT);
		title.setEditable(false);
		
		titleScreen.add(new ImagePanel());
		titleScreen.add(title);
		titleScreen.add(new ImagePanel());
		
		this.add(titleScreen);
		this.add(addBar);
		addBarSetUp();
		this.add(searchBar);
		searchBarSetUp();
	}
	
	public void searchBarSetUp()
	{
		searchBar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				cardLayout.show(container, "Search Page");
			}
		});
	}
	
	public void addBarSetUp()
	{
		addBar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				cardLayout.show(container, "Add Recipe");
			}
		});
	}
	
	public void addRecipeButton(Recipe recipe)
	{
		JButton newRecButton = new JButton(recipe.getName());
		
		newRecButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				cardLayout.show(container, recipe.getName());
				
			}
		});
		
		this.add(newRecButton);
		this.revalidate();
		this.repaint();
	}
	
}
