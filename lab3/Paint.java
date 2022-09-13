import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.geom.AffineTransform;


public class Paint extends JComponent implements KeyListener, ActionListener{
        int w=30;
        int h=30;
        int Rx, Ry;
        Image water = new ImageIcon("").getImage();
        Image fire = new ImageIcon("").getImage();
        Rectangle rectangle = new Rectangle(100 ,0,100,100);
        Timer t = new Timer(5,this);
        BufferedImage fir;
        BufferedImage Apple = LoadImage("");
        int x;

    {
        try {
            fir = ImageIO.read(new File(""));
        } catch (IOException e) {
            fir = null;
        }
    }


     BufferedImage LoadImage(String FileName) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(FileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return img;
    }

        public void paintComponent(Graphics g) {

            Graphics2D g2d = (Graphics2D) g;

            g2d.drawImage(water, 0, 0, 600, 500, null);
            g2d.drawImage(fire, 0, 0, 100, 100, null);

            g.drawImage(Main.anime.img, 0, 0, 600, 500, null);

            AffineTransform at = g2d.getTransform();
            at.rotate(Math.toRadians(0 + x), 50, 50);

            g2d.setStroke(new BasicStroke(4));
            g2d.fill(rectangle);

            t.start();

                g2d.setTransform(at);
               // g2d.drawLine(250, 250, 300, 0);
                g2d.drawImage(Apple, 0, 0, 100, 100, null);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode()==KeyEvent.VK_RIGHT){
                if(rectangle.x<500) {
                    rectangle.setLocation(rectangle.x + 100, rectangle.y);
                    Rx += 1;
                }
            }
            if (e.getKeyCode()==KeyEvent.VK_LEFT){
                if (rectangle.x>99) {
                    rectangle.setLocation(rectangle.x - 100, rectangle.y);
                }
            }
            if (e.getKeyCode()==KeyEvent.VK_UP){
                if (rectangle.y>99) {
                    rectangle.setLocation(rectangle.x, rectangle.y - 100);
                }
            }
            if (e.getKeyCode()==KeyEvent.VK_DOWN){
                if (rectangle.y<400) {
                    rectangle.setLocation(rectangle.x, rectangle.y + 100);
                }
            }
            if (e.getKeyCode()==KeyEvent.VK_A){
                x=x+10;
            }
            if (e.getKeyCode()==KeyEvent.VK_D){
                x=x-10;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
