package Listeners;

import Grafika.Personaj;
import Okno.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnAddListener implements ActionListener {
    private Main main;
    public BtnAddListener(Main main){
        this.main = main;
    }
    public void actionPerformed(ActionEvent e){
            main.txtV.getTextOut().setText("\nFox added");
            main.hater.add(new Personaj(main,(int)(Math.random()*800), (int)(Math.random()*400 +200), 160, 160));
            System.out.println(main.hater.size());
    }
}
