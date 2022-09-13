package Potoki;

import Okno.Main;

public class ThreadPaint extends Thread{
    private Main main;
    public ThreadPaint(Main main){
        this.main = main;
        start();
    }
    public void run(){
        while(true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            main.repaint();
        }
    }
}

