import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

class MainBreakout extends JFrame
{
 static game g = new game();

 public static void main(String[] args) 
 {
  g.gamemenu();
 }

 public void game(){
  Gameplay gamePlay = new Gameplay();
  JFrame obj = new JFrame();
  obj.setBounds(10,10,700,800);
  obj.setTitle("Breakout Ball");
  obj.setResizable(false);
  obj.setVisible(true);
  obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  obj.add(gamePlay);
 }

 public void game1(){
  Gameplay1 gamePlay1 = new Gameplay1(); 
  JFrame obj = new JFrame();
  obj.setBounds(10,10,700,800);
  obj.setTitle("Breakout Ball");
  obj.setResizable(false);
  obj.setVisible(true);
  obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  obj.add(gamePlay1);
 }

}