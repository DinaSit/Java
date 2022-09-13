import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.geom.AffineTransform;


public class Pale extends JPanel {

    public void paintComponent(Graphics g){
        AffineTransform at = AffineTransform.getTranslateInstance(100,100);
        at.rotate(Math.toRadians(45));
        BufferedImage fish = LoadImage("");
        Graphics2D g2d = (Graphics2D) g;
       // g2d.drawImage
    }

    BufferedImage LoadImage(String FileName) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(""));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return img;
    }
}


