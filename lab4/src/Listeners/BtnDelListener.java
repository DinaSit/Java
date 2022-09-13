package Listeners;

import Grafika.Personaj;
import Okno.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnDelListener implements ActionListener {
    private Main main;
    public BtnDelListener(Main main){
        this.main = main;
    }
    public void actionPerformed(ActionEvent e){
            main.txtV.getTextOut().setText("\nFoxes deleted");
            for(Personaj hater : main.hater){
                main.remove(hater);
            }
            main.hater.removeAll(main.hater);
            System.out.println(main.hater.size());
    }
}
