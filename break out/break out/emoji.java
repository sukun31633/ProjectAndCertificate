import java.lang.*;
import java.util.*;
import java.util.List;
import java.io.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.Container;

public class emoji extends Frame {
 static Color background = new Color(170,175,249);//219,74,247 180,214,253
 static Color background1 = new Color(232,89,37);
 static Color eye = new Color(170,175,249);//(100,149,237),(131,181,255)
 static Color eyebrow = new Color(250,128,114);//250,128,114 0,191,255 (0,206,209)
    static Color mouth = new Color(222,184,135);
 static Color earphones = new Color(127,255,212);
 static Color earphones1 = new Color(127,200,212);

    JFrame window;
    Container con;
    JPanel picturePanel;
    JLabel pictureLabel;

  public void paint(Graphics g) {
     Graphics2D ga = (Graphics2D)g;
   g.setColor(background);
  g.fillRect(0,0,5000,5000);

     ga.setPaint(Color.white);
  ga.fillArc(900-710,450-150,300,200,0,360);//900,450,300,200,0,360
  g.fillRoundRect(190,280,100,230,60,60);
  g.fillRoundRect(390,280,100,230,60,60);

   g.setColor(eye);
  ga.fillArc(260,360,50,60,0,360);
  ga.fillArc(365,360,50,60,0,360);

   g.setColor(eyebrow);
  g.fillRoundRect(250,330,70,20,50,20);
  g.fillRoundRect(360,330,70,20,50,20);

   g.setColor(earphones);
  g.fillRoundRect(155,350,50,115,30,60);
  g.fillRoundRect(475,350,50,115,30,60);
  g.fillRoundRect(170,295,20,85,10,10);
  g.fillRoundRect(1200-710,445-150,20,85,10,10);
  g.fillRoundRect(885-710,445-150,330,20,10,10);

   g.setColor(earphones1);
  g.fillRoundRect(890-710,580-150,90,20,10,10);

   ga.setPaint(Color.black);
  g.drawArc(955-710,555-150,190,95,220,100);

           
  }

  public void paint1(Graphics g) {
     Graphics2D ga = (Graphics2D)g;
   g.setColor(background1);
  g.fillRect(0,0,5000,5000);

     ga.setPaint(Color.white);
  ga.fillArc(900-710,450-150,300,200,0,360);//900,450,300,200,0,360
  g.fillRoundRect(190,280,100,230,60,60);
  g.fillRoundRect(390,280,100,230,60,60);

   g.setColor(background1);
  ga.fillArc(260,360,50,60,0,360);
  ga.fillArc(365,360,50,60,0,360);

   g.setColor(eyebrow);
  g.fillRoundRect(250,330,70,20,50,20);
  g.fillRoundRect(360,330,70,20,50,20);

   g.setColor(earphones);
  g.fillRoundRect(155,350,50,115,30,60);
  g.fillRoundRect(475,350,50,115,30,60);
  g.fillRoundRect(170,295,20,85,10,10);
  g.fillRoundRect(1200-710,445-150,20,85,10,10);
  g.fillRoundRect(885-710,445-150,330,20,10,10);

   g.setColor(earphones1);
  g.fillRoundRect(890-710,580-150,90,20,10,10);

   ga.setPaint(Color.black);
  g.drawArc(955-710,555-150,190,95,220,100);

           
  }
  
}