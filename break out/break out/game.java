import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
class game
{
 JFrame window;
 Container con;
 JPanel titlenamepanel,startbuttonpanel,picturePanel;
 JLabel titlenamelabel,pictureLabel;
 Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
 Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
 JButton startbutton;
 JButton startbutton1;
 static MainBreakout mb = new MainBreakout();
 private MapBreakout map;
 private MapBreakout_2 map2;
 static Color color = new Color(219,74,247);
 static Color colorb = new Color(240,81,230);

  
 public void gamemenu(){

  map = new MapBreakout(3, 7); //map
  map2 = new MapBreakout_2(5, 7); //map2

 window = new JFrame();
window.setSize(800,600);
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
window.setLayout(null);
con = window.getContentPane();

 startbuttonpanel = new JPanel();
 startbuttonpanel.setBounds(300,400,200,100);
 startbuttonpanel.setBackground(color);

 titlenamepanel = new JPanel();
   titlenamepanel.setBounds(100,100,600,150);
   titlenamepanel.setBackground(colorb);
   titlenamelabel = new JLabel("Breakout");
   titlenamelabel.setForeground(Color.white);
   titlenamelabel.setFont(titleFont);

   startbutton = new JButton("Map 1");
 startbutton.setBackground(color);
 startbutton.setForeground(Color.white);
 startbutton.setFont(normalFont);
 startbutton.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent e){
   mb.game();
  }
 });
 startbutton1 = new JButton("Map 2");
 startbutton1.setBackground(color);
 startbutton1.setForeground(Color.white);
 startbutton1.setFont(normalFont);
 startbutton1.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent e){
   mb.game1();
  }
 });

   titlenamepanel.add(titlenamelabel);
   startbuttonpanel.add(startbutton);
   startbuttonpanel.add(startbutton1);

   picturePanel = new JPanel();
   picturePanel.setBounds(0, -50, 800, 700);//you can change the size and the position as you like.
   //picturePanel.setBackground(Color.black);

   pictureLabel = new JLabel();

   ImageIcon image = new ImageIcon("game1123.jpg");
   //type the picture's name and location between the double quotations like this. If the picture is in "res" folder, you just need to change the name of the picture. PNG is also supported.

   pictureLabel.setIcon(image);
   picturePanel.add(pictureLabel);

   window.setVisible(true);
 
   con.add(titlenamepanel);
   con.add(picturePanel);
   con.add(startbuttonpanel);

 }

}

/*import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import javax.swing.JButton;
class game
{
 JFrame window;
 Container con;
 JPanel titlenamepanel,startbuttonpanel;
 JLabel titlenamelabel;
 Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
 Font normalFont = new Font("Times New Roman", Font.PLAIN, 30);
 JButton startbutton;
 public static void main(String[] args) 
 {
  new game();
 }
 public game(){
   window = new JFrame();
   window.setSize(800,600);
   window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   window.getContentPane().setBackground(Color.black);
   window.setLayout(null);
   window.setVisible(true);
   con = window.getContentPane();

   titlenamepanel = new JPanel();
   titlenamepanel.setBounds(100,100,600,150);
   titlenamepanel.setBackground(Color.black);
   titlenamelabel = new JLabel("Breakout");
   titlenamelabel.setForeground(Color.white);
   titlenamelabel.setFont(titleFont);

 startbuttonpanel = new JPanel();
 startbuttonpanel.setBounds(300,400,200,100);
 startbuttonpanel.setBackground(Color.black);

 startbutton = new JButton("Start");
 startbutton.setBackground(Color.black);
 startbutton.setForeground(Color.white);
 startbutton.setFont(normalFont); 

   titlenamepanel.add(titlenamelabel);
   startbuttonpanel.add(startbutton);

   con.add(titlenamepanel);
   con.add(startbuttonpanel);
 }
}*/