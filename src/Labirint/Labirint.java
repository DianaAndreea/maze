package Labirint;

import javax.swing.*;

public class Labirint {
    public static void main(String[] args){
    new Labirint();
        
    }
    public Labirint(){
    JFrame f = new JFrame();
    f.setTitle("Aplicatie 3 - Labirint");
    f.add(new Board());
    f.setSize(680,710);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
