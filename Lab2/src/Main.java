import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        DrawN draw = new DrawN();
        draw.pack();
        draw.setVisible(true);
        draw.setSize(300, 500);
        draw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        draw.setResizable(false);
        draw.setLocationRelativeTo(null);


    }
}