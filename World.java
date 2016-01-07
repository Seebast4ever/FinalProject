import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.Polygon;

public class World extends JFrame implements ActionListener {
    private Container pane;
    private JLabel j;
    private JTextField t;

    public World() {
	this.setTitle("Settlers of GUI");
	this.setSize(1000, 600);
	this.setLocation(50, 50);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

	
    }




    
    /*    public World(String title, int sizex, int sizey, int locationx, int locationy) {
	this.setTitle(title);
	this.setSize(sizex, sizey);
	this.setLocation(locationx, locationy);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));
	} */


    
    public void actionPerformed(ActionEvent e) {
	
    }
}
