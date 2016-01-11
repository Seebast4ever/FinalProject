import java.awt.*; 
import java.awt.event.*;
import java.awt.geom.Line2D;
import javax.swing.JApplet;
import javax.swing.JFrame;

public class Test1 extends JApplet {
   public void init() {
       //setBackground(Color.white);
       //setForeground(Color.white);
   }

    
   public void paint(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;
      
      
      //g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
      //RenderingHints.VALUE_ANTIALIAS_ON);

      //sets color of line
       g2.setPaint(Color.red);   

      //IMPORTANT
      int x = 5;
      int y = 7;
      g2.draw(new Line2D.Double(x, y, 5, 200));
      g2.drawString("Line", x, 250);
      }
    
   public static void main(String s[]) {
      JFrame f = new JFrame("Line");
      
      //basically CLOSE_ON_EXIT
      f.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent e) {
            System.exit(0);
         }
	  });

      //JApplet class
      JApplet applet = new Test1();

      //will not draw line without this
      f.getContentPane().add("Center", applet);

      //unsure
      applet.init();
      
      f.pack();
      f.setSize(new Dimension(300, 300));
      f.setVisible(true);
   }
}