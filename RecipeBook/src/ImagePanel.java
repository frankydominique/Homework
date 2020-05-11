import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
//created by Brendan Cashman, described on StackOverflow link: https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel

public class ImagePanel extends JPanel{

    private BufferedImage image;
    private BufferedImage image2;

    public ImagePanel() {
       try {                
          image = ImageIO.read(new File("cookingGirl.jpg"));
       } catch (IOException ex) {
            // handle exception...
    	   System.out.println("error");
       }
       this.setBackground(new Color(219, 245, 247));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this); // see javadoc for more info on the parameters            
    }

}