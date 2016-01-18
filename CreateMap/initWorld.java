import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class initWorld extends JPanel implements ActionListener{
    int[][] gridPoint = MakeTiles.pointGrid(51);
    Coordinate[] points = MakeTiles.points(gridPoint, 100, 50);
    Hexagon[] hexes = MakeTiles.makeHexagon(points);

    /*
      only calls paint once... thus cannot update for new settlements/cities
      may want to call repaint in paint instead. Might make game a bit slow, but can now be updated.
    */
    public void paint(Graphics g) {
	g.setColor(Color.BLACK);
	for (int h = 0; h < hexes.length; h++) {
	    for (int l = 0; l < 6; l++) {
		Line line = hexes[h].getLine(l); 
		g.drawLine(line.getX1(), line.getY1(), line.getX2(), line.getY2());
	    }				 
	}

	for (int i = 0; i < points.length; i++) {
	    //the color scheme needs to be fixed (players need to know whose settlement is whose
	    //may instead use filled rectangles in filled rectangles to indicate cities/settlements

	    //tests
	    //points[i].setSettlement(true);
	    //points[i].setCity(true);
	    
	    //settlement = red rectangle
	    if (points[i].hasSettlement()) {
		g.setColor(Color.RED);
		g.fillRect(points[i].getX()-10, points[i].getY()-10, 20, 20);
	    }
	    //city = blue
	    if (points[i].hasCity()) {
		g.setColor(Color.BLUE);
		g.fillRect(points[i].getX()-10, points[i].getY()-10, 20, 20);
	    }
	}
    }

    //Creates buttons, world, etc.

    public void actionPerformed(ActionEvent e) {
	if (e.getSource() == buyBox) {
	    String thingToBuy = (String)((JComboBox)e.getSource()).getSelectedItem();
	    if (thingToBuy.equals("Road")) {
		//add code here
		int x = 5;
	    } else if (thingToBuy.equals("Settlement")) {
		//add code here
	    } else if (thingToBuy.equals("City")) {
		//add code here
	    } else {
		//add code here
	    }
	}
    }
    
    JButton endTurn = new JButton("End turn?");
    
    String[] choices = {"Road", "Settlement", "City"};
    JComboBox buyBox = new JComboBox(choices);
    JButton buy = new JButton("Buy!");

    

    public initWorld() {
	buyBox.addActionListener(this);
	add(endTurn);
	
    }
    
    public static void main(String[]args) {
	initWorld p = new initWorld();

	JFrame f = new JFrame();
	f.setVisible(true);
	f.setTitle("Play Settlers of Gui!!");
	f.add(p);
	f.setSize(1000, 600);
	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
