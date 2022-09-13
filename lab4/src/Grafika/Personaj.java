package Grafika;

import Okno.Main;
import Potoki.ThreadRefresh;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Personaj extends JLabel{
    private BufferedImage picture;
    private final int speed = 10;
    private int x, y, w, h;
    private int angle = 0;
    private int viewWidth, viewHeight;
    
    public Personaj(Main main,int x, int y, int w, int h){
        this.w = w;
        this.h = h;
        this.x = x;
        this.y = y;
        viewWidth = main.getWidth();
        viewHeight = main.getHeight() - 200;
        setBounds(0,200, viewWidth, viewHeight);
        main.add(this);
        try {
            picture = ImageIO.read(new File("Fox/fox0.png"));
        } catch (Exception e){
                System.out.println("Error");
            }
        new ThreadRefresh(this);
    }
    
    public void rotate(){
        this.angle += 90;
        this.angle %= 360;
    }
    
    public void up(){
        if(y - speed > this.getY())
            y -= speed;
        else
            y = this.getY();
    }
    public void down(){
        if(y + speed - h <= viewHeight)
            y += speed;
        else
            y = viewHeight+h;
    }
    public void left(){
        if(x - speed > -1)
            x -= speed;
        else
            x = 0;
    }
    public void right(){
        if(x + speed <= viewWidth)
            x += speed;
        else
            x = viewWidth;
    }
    
    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        AffineTransform affine = new AffineTransform();   
        affine.rotate(Math.toRadians(angle), x + picture.getWidth()*3, 
               y + picture.getHeight()*3);
        g2.setTransform(affine);
            g2.drawImage(picture, x, y,w,h,this);
    }

    public BufferedImage getPicture() {
        return picture;
    }

    public void setPicture(BufferedImage picture) {
        this.picture = picture;
    }

     
}
