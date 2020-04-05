/**
 * @author Franceska
 *This class creates a chess square panel, one panel in the board of 8x8 panels and displays a solution board for eight queens
 */
import java.awt.Graphics;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChessSquarePanel extends JPanel{
	
	Color background;
	boolean flag;
	
	public ChessSquarePanel(Color background, boolean flag)
	{
		super();
		this.background = background;
		this.flag = flag;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int w = getWidth();
		int h = getHeight();
		this.setBackground(background);
		g.setColor(Color.RED);
		if(flag) g.drawString("Q", w/2, h/2);
	}
	
	public static void main(String[] args)
	{
		JFrame window = new JFrame("ChessSquarePanel");
		window.setBounds(100, 100, 400, 400);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridLayout test = new GridLayout(8, 8);
		window.setLayout(test);
		int[] pos = {2, 5, 1, 6, 0, 3, 7, 4};
		boolean value = false;
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				if(j == pos[i]) value = true;
				else value = false;
				
				if((i + j) % 2 == 0)
					window.add(new ChessSquarePanel(Color.BLACK, value));
				else
					window.add(new ChessSquarePanel(Color.WHITE, value));
			}
		}
		window.setVisible(true);
	}
	
}
