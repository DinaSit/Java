import javax.swing.*;

public class Main {

    static AnimatedImage anime;
    static JFrame frame;
    public static void main(String[] args) {
        int w = 600;
        int h = 500;

        Paint paint = new Paint();
        anime = new AnimatedImage("", 3);
        paint.setBounds(0, 0, w, h);
        frame = new JFrame();
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(w,h);
        frame.setLocation(200,300);
        frame.addKeyListener(paint);
        frame.setResizable(false);
        frame.add(paint);
        frame.setVisible(true);

    }
}