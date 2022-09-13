package Listeners;

import Grafika.Personaj;
import Okno.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BtnListener implements ActionListener {
    private Main main;
    public BtnListener(Main main){
        this.main = main;
    }
    public void actionPerformed(ActionEvent e){
            String key = main.txtV.getTextIn().getText();
            main.txtV.getTextOut().setText("\nCommand entered: " + key);
            switch (key){
                case "left": 
                    for(Personaj hater : main.hater){
                        hater.left();
                    }
                    break;
                case "right":
                    for(Personaj hater : main.hater){
                        hater.right();
                    }
                    break;
                case "up": 
                    for(Personaj hater : main.hater){
                        hater.up();
                    }
                    break;
                case "down": 
                    for(Personaj hater : main.hater){
                        hater.down();
                    }
                    break;
                case "rotate": 
                    for(Personaj hater : main.hater){
                        hater.rotate();
                    }
                    break;
                default:
                   main.txtV.getTextOut().setText("I don't know this command, try again!\n Commands: left, right, up, down, rotate");
            }
    }
}
