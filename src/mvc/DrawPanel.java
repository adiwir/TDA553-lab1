import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage scaniaImage;
    BufferedImage saabImage;
    // To keep track of a singel cars position
    Point volvoPoint = new Point();
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();
    
    void moveit(Car car, int x, int y) {
        if (car.getModelName() == "Volvo240") {
            volvoPoint.x = (int)car.getCurrentPositionX();
            volvoPoint.y = (int)car.getCurrentPositionY();
        } else if (car.getModelName() == "Saab95") {
            saabPoint.x = (int)car.getCurrentPositionX();
            saabPoint.y = (int)car.getCurrentPositionY();
        } else {
            scaniaPoint.x = (int)car.getCurrentPositionX();
            scaniaPoint.y = (int)car.getCurrentPositionY();
        }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); 
        g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);
        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);
        
    }
}
