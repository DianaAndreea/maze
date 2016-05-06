package Labirint;

import java.awt.Image;
import javax.swing.ImageIcon;


public class Jucator {
    
    private int tileX, tileY;
    private Image jucator;
    
    public Jucator(){
        
        ImageIcon img = new ImageIcon(getClass().getResource("/resursa/girl.png"));
        jucator = img.getImage();
        
        tileX = 1;
        tileY = 1;
    }
    
    public Image getJucator(){
        return jucator;
    }
    
    public int getTileX(){
        return tileX;
    }
    public int getTileY(){
        return tileY;
    }
    
    public void move(int dx, int dy){

        tileX +=dx;
        tileY +=dy;
    }
    
    public void remove(){
       tileX = 0;
       tileY = 0;
    }
}
