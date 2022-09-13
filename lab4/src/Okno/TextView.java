package Okno;

import Listeners.BtnAddListener;
import Listeners.BtnDelListener;
import Listeners.BtnListener;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TextView {
    private JTextField textIn;
    private JTextArea textOut;
    private JButton btn, btnDel, btnAdd;
    private int textW=700, btnW=100;  
    private int heights=50;

    public TextView(Main main){
        main.setFocusable(true);

        textIn = new JTextField();
        textIn.setBounds((main.getWidth()-textW)/2, 20, textW, heights/2);
        main.add(textIn);
        
        textOut = new JTextArea();
        textOut.setBounds((main.getWidth()-textW)/2, heights, textW, heights);
        textOut.setEnabled(false);
        textOut.setText("Commands: left, right, up, down, rotate");
        main.add(textOut);

        btn = new JButton("Input");
        btn.setBounds((main.getWidth()-btnW)/2, 2*heights, btnW, heights);
        btn.addActionListener(new BtnListener(main));
        main.add(btn);
        
        btnAdd = new JButton("Add fox");
        btnAdd.setBounds(100, 2*heights, btnW, heights);
        btnAdd.addActionListener(new BtnAddListener(main));
        main.add(btnAdd);
        
        btnDel = new JButton("Del fox");
        btnDel.setBounds(main.getWidth()-100 - btnW, 2*heights, btnW, heights);
        btnDel.addActionListener(new BtnDelListener(main));
        main.add(btnDel);
        
        

    }

    public JTextField getTextIn() {
        return textIn;
    }

    public JTextArea getTextOut() {
        return textOut;
    }
    
}