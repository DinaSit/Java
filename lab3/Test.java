import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test extends JComponent implements KeyListener, ActionListener {
    int x = 0, y = 0,h = 20,w = 20;
    Rectangle rectangle = new Rectangle(x,y,w,h);

    public void paint (Graphics g){
        Graphics graph = (Graphics2D)g;
        //graph.(rectangle);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}