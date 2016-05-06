package Labirint;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Board extends JPanel implements ActionListener{
    
    private Timer timer;
    private final Harta h;
    private Jucator j;
    
    private boolean win = false;
    private String Message = "";
    private Font font = new Font("Times", Font.BOLD, 40);
  
    
    String vieti3="vieti:   I I I";
    String vieti2="vieti:   I I";
    String vieti1="vieti:   I";
    int vieti=3;
    String puncte="puncte: ";
    int scor=0;
    String nrpct="0";
    
   public Image bonus1, bonus2, bonus3, bonus4, bonus5, bonus6, bonus7, bonus8, bonus9, bonus10;
   ImageIcon img;
   boolean bonus1b = true, bonus2b = true, bonus3b = true,bonus4b=true,bonus5b=true,bonus6b=true,bonus7b=true,bonus8b=true,bonus9b=true,bonus10b=true;
   
    public Board(){
         img=new ImageIcon(getClass().getResource("/resursa/stea.png"));
         bonus1 = img.getImage();
         bonus2 = img.getImage();
         bonus3 = img.getImage();
         bonus4 = img.getImage();
         bonus5 = img.getImage();
         bonus6 = img.getImage();
         bonus7 = img.getImage();
         bonus8 = img.getImage();
         bonus9 = img.getImage();
         bonus10 = img.getImage();
        
    h = new Harta(); 
    j = new Jucator();
    
    addKeyListener(new A1());
    setFocusable(true);
    
    addMouseMotionListener(new A2());
    
    timer = new Timer(25, this);
    timer.start();
    }
    
    public void init(){

    }
    
    public void actionPerformed(ActionEvent e){
        
     if(h.getHarta(j.getTileX(), j.getTileY()).equals("f")|| vieti == 0){
            Message = "YuHuu! Ai castigat!!\n"+ nrpct;
            win = true;
        }
        repaint();
    }
    
    public void paint(Graphics g){
        super.paint(g);

        if(!win){
         for(int y = 0; y < 21; y++){
            for(int x = 0; x < 21; x++){
                if(h.getHarta(x, y).equals("f")){
                    g.drawImage(h.getFinish(), x * 32, y * 32, null);
                }
                else if(h.getHarta(x, y).equals("i")){
                    g.drawImage(h.getIarba(), x * 32, y * 32, null);
                }
                else if(h.getHarta(x, y).equals("p")){
                    g.drawImage(h.getPerete(), x * 32, y * 32, null);
                }
                else if(h.getHarta(x, y).equals("c")){
                    g.drawImage(h.getTrap(), x* 32, y * 32, null);
                }
            }
           
           g.drawImage(bonus1, 160, 32, this);
           if(j.getTileX()*32==160 && j.getTileY()*32==32)
                {  g.drawImage(h.getIarba(), 160, 32, this);
                   bonus1=h.getIarba();
                   bonus1b=false;
                }
           g.drawImage(bonus2, 352, 32, this);
           if(j.getTileX()*32==352 && j.getTileY()*32==32)
                {  g.drawImage(h.getIarba(), 352, 32, this);
                   bonus2=h.getIarba();
                   bonus2b=false;
                }
           g.drawImage(bonus3, 320, 96, this);
           if(j.getTileX()*32==320 && j.getTileY()*32==96)
                {  g.drawImage(h.getIarba(), 320, 96, this);
                   bonus3=h.getIarba();
                   bonus3b=false;
                }
           g.drawImage(bonus4, 320, 320, this);
           if(j.getTileX()*32==320 && j.getTileY()*32==320)
                {  g.drawImage(h.getIarba(), 320, 320, this);
                   bonus4=h.getIarba();
                   bonus4b=false;
                }
           g.drawImage(bonus5, 608, 224, this);
           if(j.getTileX()*32==608 && j.getTileY()*32==224)
                {  g.drawImage(h.getIarba(), 608, 224, this);
                   bonus5=h.getIarba();
                   bonus5b=false;
                }
           g.drawImage(bonus6, 544, 32, this);
           if(j.getTileX()*32==544 && j.getTileY()*32==32)
                {  g.drawImage(h.getIarba(), 544, 32, this);
                   bonus6=h.getIarba();
                   bonus6b=false;
                }
           g.drawImage(bonus7, 160, 192, this);
           if(j.getTileX()*32==160 && j.getTileY()*32==192)
                {  g.drawImage(h.getIarba(), 160, 192, this);
                   bonus7=h.getIarba();
                   bonus7b=false;
                }
           g.drawImage(bonus8, 320, 480, this);
           if(j.getTileX()*32==320 && j.getTileY()*32==480)
                {  g.drawImage(h.getIarba(), 320, 480, this);
                   bonus8=h.getIarba();
                   bonus8b=false;
                }
           g.drawImage(bonus9, 544, 544, this);
           if(j.getTileX()*32==544 && j.getTileY()*32==544)
                {  g.drawImage(h.getIarba(), 544, 544, this);
                   bonus9=h.getIarba();
                   bonus9b=false;
                }
           g.drawImage(bonus10, 480, 608, this);
           if(j.getTileX()*32==480 && j.getTileY()*32==608)
                {  g.drawImage(h.getIarba(), 320, 96, this);
                   bonus10=h.getIarba();
                   bonus10b=false;
                }

           
           
            g.drawImage(j.getJucator(), j.getTileX() * 32, j.getTileY() * 32, null);

        g.setColor(Color.white);
        g.setFont(new Font("Elephant",Font.PLAIN,15));
        g.drawString(puncte, 30, 20);
        nrpct=scor+"";
        g.drawString(nrpct, 100, 20);
        
        if(vieti==3)g.drawString(vieti3, 160, 20);
        else if(vieti==2)g.drawString(vieti2, 160, 20);
        else if(vieti==1)g.drawString(vieti1, 160, 20);
          }
       }else {
        g.setColor(Color.GREEN);
        g.setFont(new Font("Serif",Font.BOLD,60));
        g.drawString("Felicitari !", 280, 300);
        g.setColor(Color.YELLOW);
        g.setFont(new Font("Serif",Font.BOLD,30));
        g.drawString("Ai acumulat: "+nrpct+" puncte", 300, 350);
        
                 
    }
    }
    
    public class A1 extends KeyAdapter{
        
        public void keyPressed(KeyEvent e){
            
            int keycode = e.getKeyCode();
            
            if(keycode == KeyEvent.VK_UP){
                if(!h.getHarta(j.getTileX(), j.getTileY() - 1).equals("p"))
                 j.move(0, -1);
                if(h.getHarta(j.getTileX(),j.getTileY()).equals("c")){
                   vieti--;
                }
                 if((j.getTileX()*32==160 && j.getTileY()*32==32)&& bonus1b==true) scor=scor+10;
                 if((j.getTileX()*32==352 && j.getTileY()*32==32)&& bonus2b==true) scor=scor+10;
                 if((j.getTileX()*32==320 && j.getTileY()*32==96)&& bonus3b==true) scor=scor+10;
                 if((j.getTileX()*32==320 && j.getTileY()*32==320)&& bonus4b==true) scor=scor+10;
                 if((j.getTileX()*32==608 && j.getTileY()*32==224)&& bonus5b==true) scor=scor+10;
                 if((j.getTileX()*32==544 && j.getTileY()*32==32)&& bonus6b==true) scor=scor+10;
                 if((j.getTileX()*32==160 && j.getTileY()*32==192)&& bonus7b==true) scor=scor+10;
                 if((j.getTileX()*32==320 && j.getTileY()*32==480)&& bonus8b==true) scor=scor+10;
                 if((j.getTileX()*32==544 && j.getTileY()*32==544)&& bonus9b==true) scor=scor+10;
                 if((j.getTileX()*32==480 && j.getTileY()*32==608)&& bonus10b==true) scor=scor+10;
                }
            if(keycode == KeyEvent.VK_DOWN){
                if(!h.getHarta(j.getTileX(), j.getTileY() + 1).equals("p"))
                 j.move(0, 1);
               if(h.getHarta(j.getTileX(),j.getTileY()).equals("c")){
                   vieti--;
                }
                 if((j.getTileX()*32==160 && j.getTileY()*32==32)&& bonus1b==true) scor=scor+10;
                 if((j.getTileX()*32==352 && j.getTileY()*32==32)&& bonus2b==true) scor=scor+10;
                 if((j.getTileX()*32==320 && j.getTileY()*32==96)&& bonus3b==true) scor=scor+10;
                 if((j.getTileX()*32==320 && j.getTileY()*32==320)&& bonus4b==true) scor=scor+10;
                 if((j.getTileX()*32==608 && j.getTileY()*32==224)&& bonus5b==true) scor=scor+10;
                 if((j.getTileX()*32==544 && j.getTileY()*32==32)&& bonus6b==true) scor=scor+10;
                 if((j.getTileX()*32==160 && j.getTileY()*32==192)&& bonus7b==true) scor=scor+10;
                 if((j.getTileX()*32==320 && j.getTileY()*32==480)&& bonus8b==true) scor=scor+10;
                 if((j.getTileX()*32==544 && j.getTileY()*32==544)&& bonus9b==true) scor=scor+10;
                 if((j.getTileX()*32==480 && j.getTileY()*32==608)&& bonus10b==true) scor=scor+10;
            }
            if(keycode == KeyEvent.VK_LEFT){
                if(!h.getHarta(j.getTileX() - 1, j.getTileY()).equals("p"))
                 j.move(-1, 0);
               if(h.getHarta(j.getTileX(),j.getTileY()).equals("c")){
                   vieti--;
                }
                 if((j.getTileX()*32==160 && j.getTileY()*32==32)&& bonus1b==true) scor=scor+10;
                 if((j.getTileX()*32==352 && j.getTileY()*32==32)&& bonus2b==true) scor=scor+10;
                 if((j.getTileX()*32==320 && j.getTileY()*32==96)&& bonus3b==true) scor=scor+10;
                 if((j.getTileX()*32==320 && j.getTileY()*32==320)&& bonus4b==true) scor=scor+10;
                 if((j.getTileX()*32==608 && j.getTileY()*32==224)&& bonus5b==true) scor=scor+10;
                 if((j.getTileX()*32==544 && j.getTileY()*32==32)&& bonus6b==true) scor=scor+10;
                 if((j.getTileX()*32==160 && j.getTileY()*32==192)&& bonus7b==true) scor=scor+10;
                 if((j.getTileX()*32==320 && j.getTileY()*32==480)&& bonus8b==true) scor=scor+10;
                 if((j.getTileX()*32==544 && j.getTileY()*32==544)&& bonus9b==true) scor=scor+10;
                 if((j.getTileX()*32==480 && j.getTileY()*32==608)&& bonus10b==true) scor=scor+10;
            }
            if(keycode == KeyEvent.VK_RIGHT){
                if(!h.getHarta(j.getTileX() + 1, j.getTileY()).equals("p"))
                 j.move(1, 0);
                if(h.getHarta(j.getTileX(),j.getTileY()).equals("c")){
                   vieti--;
                }
                 if((j.getTileX()*32==160 && j.getTileY()*32==32)&& bonus1b==true) scor=scor+10;
                 if((j.getTileX()*32==352 && j.getTileY()*32==32)&& bonus2b==true) scor=scor+10;
                 if((j.getTileX()*32==320 && j.getTileY()*32==96)&& bonus3b==true) scor=scor+10;
                 if((j.getTileX()*32==320 && j.getTileY()*32==320)&& bonus4b==true) scor=scor+10;
                 if((j.getTileX()*32==608 && j.getTileY()*32==224)&& bonus5b==true) scor=scor+10;
                 if((j.getTileX()*32==544 && j.getTileY()*32==32)&& bonus6b==true) scor=scor+10;
                 if((j.getTileX()*32==160 && j.getTileY()*32==192)&& bonus7b==true) scor=scor+10;
                 if((j.getTileX()*32==320 && j.getTileY()*32==480)&& bonus8b==true) scor=scor+10;
                 if((j.getTileX()*32==544 && j.getTileY()*32==544)&& bonus9b==true) scor=scor+10;
                 if((j.getTileX()*32==480 && j.getTileY()*32==608)&& bonus10b==true) scor=scor+10;
            }
        }
    
        public void keyReleased(KeyEvent e){
        
        }
        
        public void keyTyped(KeyEvent e){
        
        }
    }
    
  public class A2 implements MouseMotionListener{
        
        @Override
        public void mouseDragged(MouseEvent e){
            int x, y;
            x = e.getX()/32;
            y = e.getY()/32;
            
            if(x>j.getTileX()){
                if(!h.getHarta(j.getTileX() + 1, j.getTileY()).equals("p")){
                    j.move(1, 0);
            if(h.getHarta(j.getTileX(),j.getTileY()).equals("c")){
                   vieti--;
                }
                 if((j.getTileX()*32==160 && j.getTileY()*32==32)&& bonus1b==true) scor=scor+10;
                 if((j.getTileX()*32==352 && j.getTileY()*32==32)&& bonus2b==true) scor=scor+10;
                 if((j.getTileX()*32==320 && j.getTileY()*32==96)&& bonus3b==true) scor=scor+10;
                 if((j.getTileX()*32==320 && j.getTileY()*32==320)&& bonus4b==true) scor=scor+10;
                 if((j.getTileX()*32==608 && j.getTileY()*32==224)&& bonus5b==true) scor=scor+10;
                 if((j.getTileX()*32==544 && j.getTileY()*32==32)&& bonus6b==true) scor=scor+10;
                 if((j.getTileX()*32==160 && j.getTileY()*32==192)&& bonus7b==true) scor=scor+10;
                 if((j.getTileX()*32==320 && j.getTileY()*32==480)&& bonus8b==true) scor=scor+10;
                 if((j.getTileX()*32==544 && j.getTileY()*32==544)&& bonus9b==true) scor=scor+10;
                 if((j.getTileX()*32==480 && j.getTileY()*32==608)&& bonus10b==true) scor=scor+10;
                    
                }
            }
            
            if(x<j.getTileX()){
                if(!h.getHarta(j.getTileX() - 1, j.getTileY()).equals("p")){
                    j.move(-1, 0);
                if(h.getHarta(j.getTileX(),j.getTileY()).equals("c")){
                   vieti--;
                }
                 if((j.getTileX()*32==160 && j.getTileY()*32==32)&& bonus1b==true) scor=scor+10;
                 if((j.getTileX()*32==352 && j.getTileY()*32==32)&& bonus2b==true) scor=scor+10;
                 if((j.getTileX()*32==320 && j.getTileY()*32==96)&& bonus3b==true) scor=scor+10;
                 if((j.getTileX()*32==320 && j.getTileY()*32==320)&& bonus4b==true) scor=scor+10;
                 if((j.getTileX()*32==608 && j.getTileY()*32==224)&& bonus5b==true) scor=scor+10;
                 if((j.getTileX()*32==544 && j.getTileY()*32==32)&& bonus6b==true) scor=scor+10;
                 if((j.getTileX()*32==160 && j.getTileY()*32==192)&& bonus7b==true) scor=scor+10;
                 if((j.getTileX()*32==320 && j.getTileY()*32==480)&& bonus8b==true) scor=scor+10;
                 if((j.getTileX()*32==544 && j.getTileY()*32==544)&& bonus9b==true) scor=scor+10;
                 if((j.getTileX()*32==480 && j.getTileY()*32==608)&& bonus10b==true) scor=scor+10;
                }
            }
            if(y>j.getTileY()){
                if(!h.getHarta(j.getTileX() , j.getTileY() + 1).equals("p")){
                    j.move(0, 1);
                if(h.getHarta(j.getTileX(),j.getTileY()).equals("c")){
                   vieti--;
                }
                 if((j.getTileX()*32==160 && j.getTileY()*32==32)&& bonus1b==true) scor=scor+10;
                 if((j.getTileX()*32==352 && j.getTileY()*32==32)&& bonus2b==true) scor=scor+10;
                 if((j.getTileX()*32==320 && j.getTileY()*32==96)&& bonus3b==true) scor=scor+10;
                 if((j.getTileX()*32==320 && j.getTileY()*32==320)&& bonus4b==true) scor=scor+10;
                 if((j.getTileX()*32==608 && j.getTileY()*32==224)&& bonus5b==true) scor=scor+10;
                 if((j.getTileX()*32==544 && j.getTileY()*32==32)&& bonus6b==true) scor=scor+10;
                 if((j.getTileX()*32==160 && j.getTileY()*32==192)&& bonus7b==true) scor=scor+10;
                 if((j.getTileX()*32==320 && j.getTileY()*32==480)&& bonus8b==true) scor=scor+10;
                 if((j.getTileX()*32==544 && j.getTileY()*32==544)&& bonus9b==true) scor=scor+10;
                 if((j.getTileX()*32==480 && j.getTileY()*32==608)&& bonus10b==true) scor=scor+10;
                }
            }
            if(y<j.getTileY()){
                if(!h.getHarta(j.getTileX() , j.getTileY() - 1).equals("p")){
                    j.move(0, -1);
                if(h.getHarta(j.getTileX(),j.getTileY()).equals("c")){
                   vieti--;
                }
                 if((j.getTileX()*32==160 && j.getTileY()*32==32)&& bonus1b==true) scor=scor+10;
                 if((j.getTileX()*32==352 && j.getTileY()*32==32)&& bonus2b==true) scor=scor+10;
                 if((j.getTileX()*32==320 && j.getTileY()*32==96)&& bonus3b==true) scor=scor+10;
                 if((j.getTileX()*32==320 && j.getTileY()*32==320)&& bonus4b==true) scor=scor+10;
                 if((j.getTileX()*32==608 && j.getTileY()*32==224)&& bonus5b==true) scor=scor+10;
                 if((j.getTileX()*32==544 && j.getTileY()*32==32)&& bonus6b==true) scor=scor+10;
                 if((j.getTileX()*32==160 && j.getTileY()*32==192)&& bonus7b==true) scor=scor+10;
                 if((j.getTileX()*32==320 && j.getTileY()*32==480)&& bonus8b==true) scor=scor+10;
                 if((j.getTileX()*32==544 && j.getTileY()*32==544)&& bonus9b==true) scor=scor+10;
                 if((j.getTileX()*32==480 && j.getTileY()*32==608)&& bonus10b==true) scor=scor+10;
                }
            }
        }

        @Override
        public void mouseMoved(MouseEvent e) {
           
        }
    }

}
