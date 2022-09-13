import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.imageio.*;

public class DrawN extends JFrame {
    JFrame frame;
    JLabel displayField, pic1, pic2;
    ImageIcon image;
    JButton b1, b2, b3, b4;
    JLabel l1, n, l3, l4;
    JTextField t1;
    String text1;
    String a, b;
    eHandler handler = new eHandler();


    public DrawN() {
        super("FLY");
        setLayout(new FlowLayout(10, 15, 15));

        b1 = new JButton("Left");
        b2 = new JButton("Right");
        b3 = new JButton("Send");
        b4 = new JButton("Clean");
        l1 = new JLabel("Push here ");
        l3 = new JLabel("Your command");
        l4 = new JLabel("Enter the command:");
        n = new JLabel();
        t1 = new JTextField("", 20);

        ImageIcon pic = new ImageIcon("pic//meow.png");
        displayField = new JLabel(pic);
        displayField.setSize(400, 400);

        add(displayField);
        add(b1);
        add(b2);
        add(l4);
        add(t1);
        add(b3);
        add(b4);
        add(l3);
        add(n);
        b1.addActionListener(handler);
        b2.addActionListener(handler);
        b3.addActionListener(handler);
        b4.addActionListener(handler);
        n.setSize(300, 300);
    }


    public class eHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String text1 = t1.getText();
            if (e.getSource()==b1 || e.getSource()==b2 || (e.getSource()==b3 & (Objects.equals(text1, "Rotate left") || Objects.equals(text1, "rotate left") || Objects.equals(text1, "Rotate right") || Objects.equals(text1, "rotate right") || Objects.equals(text1, "Rotate up") || Objects.equals(text1, "rotate up") || Objects.equals(text1, "Clean") || Objects.equals(text1, "clean" ) || Objects.equals(text1,""))) || e.getSource()==b4) {
                if (e.getSource() == b3) {
                    //String text1 = t1.getText();
                    n.setText("" + text1);
                    if (Objects.equals(text1, "Rotate left") || Objects.equals(text1, "rotate left")) {
                        ImageIcon pic1 = new ImageIcon("pic//meowLeft.png");
                        displayField.setIcon(pic1);
                    }
                    if (Objects.equals(text1, "Rotate right") || Objects.equals(text1, "rotate right")) {
                        ImageIcon pic2 = new ImageIcon("pic//meowRight.png");
                        displayField.setIcon(pic2);
                    }
                    if (Objects.equals(text1, "Rotate up") || Objects.equals(text1, "rotate up")) {
                        ImageIcon pic3 = new ImageIcon("pic//meowUp.png");
                        displayField.setIcon(pic3);
                    }
                    if (Objects.equals(text1, "Clean") || Objects.equals(text1, "clean")) {
                        t1.setText(null);
                        ImageIcon pic = new ImageIcon("pic//meow.png");
                        displayField.setIcon(pic);
                        n.setText("");
                        String message = "";
                        message += "Was cleaned";
                        JOptionPane.showMessageDialog(null, message, "Congratulations", JOptionPane.PLAIN_MESSAGE);
                    }
                }

                if (e.getSource() == b4) {
                    t1.setText(null);
                    ImageIcon pic = new ImageIcon("pic//meow.png");
                    displayField.setIcon(pic);
                    n.setText("");
                    String message = "";
                    message += "Was cleaned";
                    JOptionPane.showMessageDialog(null, message, "Congratulations", JOptionPane.PLAIN_MESSAGE);
                }

                if (e.getSource() == b1) {
                    ImageIcon pic1 = new ImageIcon("pic//meowLeft.png");
                    displayField.setIcon(pic1);
                }
                if (e.getSource() == b2) {
                    ImageIcon pic2 = new ImageIcon("pic//meowRight.png");
                    displayField.setIcon(pic2);
                }
            } else {
                String message ="";
                message+="TRY NEXT TIME";
                JOptionPane.showMessageDialog(null, message, "Oh no", JOptionPane.PLAIN_MESSAGE);
                t1.setText(null);
                ImageIcon pic = new ImageIcon("pic//meow.png");
                displayField.setIcon(pic);
                n.setText("");
            }
        }
    }
}




