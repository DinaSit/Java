import javax.imageio.ImageIO;
import javax.sound.sampled.Line;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
public class AnimatedImage implements Runnable {
    BufferedImage img;
    Raster [] textures;
    Line line;
    Thread thread;
    AnimatedImage(String path, int frameCount){
        try {
            img = ImageIO.read(new File(path + "0.jpg"));
        }catch (Exception e){
            img = null;
        }
        textures = new Raster[frameCount];
        for(int i = 0; i < frameCount; i++){
            try {
                textures[i] = ImageIO.read(new File(path + i + ".jpg")).getData();
            }catch (Exception e){
                textures[i] = null;
            }
        }
        new Thread(this).start();

    }

    public void run()
    {
        int i = 0;
        while (true) {

            img.setData(textures[i]);
            if(Main.frame != null)
                Main.frame.repaint();

            i++;
            i = i % textures.length;
            try {
                Thread.sleep(250);
            }catch (Exception e) {
                break;
            }
        }

    }

}
