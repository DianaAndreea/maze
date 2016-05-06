package Labirint;

import java.awt.*;
import java.io.*;
import java.util.Scanner;
import javax.swing.*;
import java.util.List;
import java.util.ArrayList;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Harta {

    private Scanner h;
    private String Harta[] =  new String[21];
    private Image iarba, finish, perete, stea, trap;

    
    public Harta(){
        
        ImageIcon img = new ImageIcon(getClass().getResource("/resursa/iarba.png"));
        iarba = img.getImage();
        
        img = new ImageIcon(getClass().getResource("/resursa/perete.gif"));
        perete = img.getImage();
        
        img = new ImageIcon(getClass().getResource("/resursa/crown.png"));
        finish = img.getImage();

        img = new ImageIcon (getClass().getResource("/resursa/capcana.png"));
        trap = img.getImage();
       
        openFile();
        readFile();
        closeFile();
    }
    
    public Image getIarba(){
        return iarba;
    }
    public Image getPerete(){
        return perete;
    }
    public Image getFinish(){
        return finish;
    }

    public Image getTrap(){
        return trap;
    }
    
    
    public String getHarta(int x, int y){ 
        String index = Harta[y].substring(x, x+1);
        return index;
        
    }
    
    public void openFile(){
       // File file = new File(getClass().getResourceAsStream("/resursa/Harta.txt"));
        try{
            h=new Scanner(this.getClass().getResourceAsStream("/resursa/Harta.txt"));
          
        } catch(Exception e){
            e.printStackTrace();
        }
    }
  
    public void readFile(){
        while(h.hasNext()){
            for(int i=0; i<21; i++){
                Harta[i] = h.next();
            }
        }
    }
    
    public void closeFile(){
         h.close();
    }
}
