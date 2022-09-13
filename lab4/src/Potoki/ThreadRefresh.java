package Potoki;

import Grafika.Personaj;
import java.awt.image.Raster;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class ThreadRefresh extends Thread{
    private ArrayList<Raster> spriteHater;
    private Personaj hater;
    private static final int COUNT = 56;
    private int thisFrame =0;
    
    public ThreadRefresh(Personaj hater){
        this.hater = hater;
        spriteHater = new ArrayList();
        for(int i=0; i<COUNT; i++){
            try {
                spriteHater.add(ImageIO.read(new File("Fox/fox"+i+".png")).getRaster());
            }
            catch (Exception e){
                System.out.println("Error" + (i+1));
            }
        }  
        start();
    }
    
    public void run(){
        while (true){
            thisFrame++;
            thisFrame = thisFrame % spriteHater.size();
            hater.getPicture().setData(spriteHater.get(thisFrame));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
