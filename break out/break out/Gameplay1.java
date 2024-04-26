import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;
import java.util.Random;
import javax.swing.*;
import java.awt.*;

class Gameplay1 extends JPanel implements KeyListener,ActionListener
{
 private boolean play = false;
 private int score = 0;

 private int totalBricks = 35;

 private final Timer timer;
 private final int delay = 6;

 private int playerX = 310;
 private int playerY = 750;//550
 private int bass = 15; // bass is Player's enemy 
 private int bass1 = 15;
 private int bass2 = 15;
 private int help = 8;
 private int helpY = 15;
 private int helpX = 250;
 private int bassYdir = 5;
 private MapBreakout_2 map2; //map2
 private emoji emo;

 private int ballposX = 120;
 private int ballposY = 550;
 private int ballXdir = -1;
 private int ballYdir = -4;
 static game g = new game();

 public Gameplay1(){
  map2 = new MapBreakout_2(5, 7); //map2
  emo = new emoji();
  addKeyListener(this);
  setFocusable(true);
  setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay,this);
  timer.start();
 }

 public void paint(Graphics g){

        JLabel background;
  Color ball = new Color(153,243,249);
  Color Paddle = new Color(47,225,166);

        emo.paint1((Graphics) g);
     
        //k
  g.setColor(Color.yellow); 
  g.fillRect(0,0,3,792);
  g.fillRect(0,0,692,3);
  g.fillRect(691,0,3,792);

  //Score
  g.setColor(Color.black);
  g.setFont(new Font("Tahoma", Font.BOLD, 25));
  g.drawString("Score "+score, 560,30);

  //Map

  map2.draw((Graphics2D) g); //map2
                
        //Paddle
  g.setColor(Paddle);
  g.fillRect(playerX,playerY,90,8);
                
        //Ball
  g.setColor(ball);//Color.yellow
  g.fillOval(ballposX,ballposY,20,20);

  //bass
  /*g.setColor(Color.green);
  g.fillRect(90,bass,8,50);*/
  g.setColor(Color.red);
  g.fillRoundRect(210,bass1,8,50,20,20);
  g.fillRoundRect(330,bass2,8,50,20,20);
  g.fillRoundRect(450,bass,8,50,20,20);
  g.fillRoundRect(570,bass2,8,50,20,20);
  g.fillRoundRect(90,bass,8,50,20,20);

  //help
  g.setColor(Color.green);
  //g.fillRect(helpX,helpY,20,help);
  g.fillRoundRect(helpX,helpY,20,help,10,10);

  if(totalBricks <= 0){ //totalBricks <= 0
   play = false;
   ballXdir = 0;
   ballYdir = 0;
   bass = 0;
   bass1 = 0;
   bass2 = 0;
   helpY = 0;
   g.setColor(Color.white);
      g.fillRect(0,240,800,200);
   g.setColor(Color.RED);
   g.setFont(new Font("Tahoma", Font.BOLD, 30));
      g.drawString("You Won", 230+30,300+20); // if player win will display this text

   g.setFont(new Font("Tahoma", Font.BOLD, 20));
      g.drawString("Press Enter to Restart ", 190+20,350+20);
  }

  if(ballposY > 770){
   play = false;
   ballXdir = 0;
   ballYdir = 0;
   bass = 0;
   bass1 = 0;
   bass2 = 0;
   helpY = 0;
   g.setColor(Color.white);
      g.fillRect(0,240,800,200);
   g.setColor(Color.RED);
   g.setFont(new Font("Tahoma", Font.BOLD, 30));
      g.drawString("Game Over, Score : "+score, 190,300+20); // if player lose will display this text

   g.setFont(new Font("Tahoma", Font.BOLD, 30));
      g.drawString("Press Enter to Restart ", 190,350+20);
  }
                
        g.dispose();

 }

        @Override
 public void actionPerformed(ActionEvent e){ // this method is control logic this game
            
            timer.start(); // game start
   movebass();
   movehelp();
            if(play){ // Make edge is ball, Paddle, bass
    if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, playerY, 90, 8))) {
     ballYdir = -ballYdir; 
    }
    if(new Rectangle(90,bass,8,50).intersects(new Rectangle(playerX, playerY, 90, 8))){
     ballposY = 800;
    }
    if(new Rectangle(210,bass1,8,50).intersects(new Rectangle(playerX, playerY, 90, 8))){
                    ballposY = 800;
    }
    if(new Rectangle(330,bass2,8,50).intersects(new Rectangle(playerX, playerY, 90, 8))){
                    ballposY = 800;
    }
    if(new Rectangle(450,bass,8,50).intersects(new Rectangle(playerX, playerY, 90, 8))){
                    ballposY = 800;
    }
    if(new Rectangle(570,bass2,8,50).intersects(new Rectangle(playerX, playerY, 90, 8))){
                    ballposY = 800;
    }
    if(new Rectangle(helpX,helpY,20,help).intersects(new Rectangle(playerX, playerY, 90, 8))){
                    minato();
     helpY = 800;
    }

   A: for(int i = 0; i< map2.map.length; i++){
       for(int j = 0; j < map2.map[0].length; j++){
     if(map2.map[i][j] > 0){
      int brickX = j*map2.brickWidth + 80;
      int brickY = i*map2.brickHeight + 50;
      int brickWidth = map2.brickWidth;
      int brickHeight = map2.brickHeight;

      Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
      Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);
      Rectangle brickRect = rect;

      if(ballRect.intersects(brickRect)){
       map2.setBrickValue(0, i, j);
       totalBricks--;
       score += 5;

       if(ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width){
        ballXdir = -ballXdir;
       } else {
        ballYdir = -ballYdir;
       }

       break A;
      }
     }
       }
   }
                ballposX += ballXdir; // Direction of the ball
                ballposY += ballYdir;
                if(ballposX < 0){
                    ballXdir = -ballXdir;
                }
                if(ballposY < 0){
                    ballYdir = -ballYdir;
                }
                if(ballposX > 670){
                    ballXdir = -ballXdir;
                }
            }
            repaint();
 }

 @Override
    public void keyPressed(KeyEvent e) { // Direction of the Paddle
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
   if(playerX >= 600){
    playerX = 600;
   } else {
    moveRight();
  }
 }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
   if(playerX < 10){
    playerX = 10;
   } else {
    moveLeft();
  }
 }
     if(e.getKeyCode() == KeyEvent.VK_ENTER){ // Restart game
   if(!play){
    play = true;
    ballposX = 120;
    ballposY = 550;
    ballXdir = -1;
                ballYdir = -4;
    playerX = 310;
    bass = 15;
    bass1 = 15;
    bass2 = 15;
    score = 0;
    totalBricks = 35;
    map2 = new MapBreakout_2(5, 7);

    repaint();
  }
 }
}

 @Override
 public void keyReleased(KeyEvent e) {
}

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

public void moveRight(){
 play = true;
 playerX+=20;
}

public void moveLeft(){
 play = true;
 playerX-=20;
}
public void movebass(){
 play = true;
 bass += 3;
 bass1 += 4;
 bass2 += 5;
 if(bass >= 800){
  bass = 15;

 }
 if(bass1 >= 800){
  bass1 = 15;
 }
 if(bass2 >= 800){
  bass2 = 15;
 }
 if(score >= 40){
  bass += 2;
  bass1 += 2;
  bass2 += 2;
 }
}
public void movehelp(){
 play = true;
 int [] tn = {230,420,506,700,132};
  Random rand = new Random();
        int index = rand.nextInt(tn.length);
 helpY += 1;
 if(helpY >= 800){
  helpY = 15;
 }
 if(helpY == 15){
        helpX = tn[index];
 }
}
public void minato(){ // Random ball

     Random rand = new Random();
        int n1 = rand.nextInt(700);
  ballposY = n1;
  ballposX = n1;

}
}