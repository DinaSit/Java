package Okno;

import Grafika.Personaj;
import Potoki.ThreadPaint;
import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame{
    private final int OKNO_W = 800, OKNO_H = 600;
    public TextView txtV;
    public static ArrayList<Personaj> hater;
    
    Main(){
        super("Приложение");
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setBounds(100, 100, OKNO_W, OKNO_H);
        super.setResizable(false);
        super.setLayout(null);
        txtV = new TextView(this);
        hater = new ArrayList<>();
        hater.add(new Personaj(this, 400, 400, 160, 160));
        new ThreadPaint(this);
        super.setVisible(true); 
    }
    public static void main(String[] args) {
        Main main = new Main();
    }

    public int getOknoW() {
        return OKNO_W;
    }

    public int getOknoH() {
        return OKNO_H;
    }    
}
