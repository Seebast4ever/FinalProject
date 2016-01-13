import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawHex extends JComponent {

    public static class Coordinate {
	private int x, y;
	
	public Coordinate() {
	    x = 0;
	    y = 0;
	}

	public Coordinate(int x, int y) {
	    this.x = x;
	    this.y = y;
	}

	public int getX() {return x;}
	public int getY() {return y;}

	public void setX(int x) {this.x = x;}
	public void setY(int y) {this.y = y;}
	public void setXY(int x, int y) {this.x = x; this.y = y;}
    }
    
    //stores structure of each line
    public static class Line {
	private Coordinate c1;
	private Coordinate c2;

	public Line(int x1, int y1, int x2, int y2) {
	    c1.setXY(x1, y1);
	    c2.setXY(x2, y2);
		
	}
    }
    
    //stores structure of each hexagon
    public static class Hexagon {
	private ArrayList<Line> lineList;

	public Hexagon(Line L1, Line L2, Line L3, Line L4, Line L5, Line L6) {
	    lineList = new ArrayList<Line>(6);
	    lineList.add(L1);
	    lineList.add(L2);
	    lineList.add(L3);
	    lineList.add(L4);
	    lineList.add(L5);
	    lineList.add(L6);
	}

	public Hexagon(ArrayList<Line> lineList) {
	    this.lineList = lineList;
	}

	public Hexagon(int x1, int y1, int x2, int y2, int x3, int y3,
		       int x4, int y4, int x5, int y5, int x6, int y6) {
	    this(new Line(x1, y1, x2, y2), new Line(x2, y2, x3, y3), new Line(x3, y3, x4, y4), new Line(x4, y4, x5, y5), new Line(x5, y5, x6, y6), new Line(x6, y6, x1, y1));
	}
    }

    public static void main(String[]args) {

	//the map itself -- 10 hexagons
	ArrayList<Hexagon> hexagonGrid = new ArrayList<Hexagon>(10);
    
	//Record points of all hexagons
	/*    c01 = new Coordinate(3, 1);
	      c02 = new Coordinate(5, 1);
	      c03 = new Coordinate(7, 1);
	      c04 = new Coordinate(2, 2);
	      c05 = new Coordinate(4, 2);
	      c06 = new Coordinate(6, 2);
	      c07 = new Coordinate(8, 2);
	      c08 = new Coordinate(, );
	      c09 = new Coordinate(, );
	      c10 = new Coordinate(, );
	      c11 = new Coordinate(, );
	      c12 = new Coordinate(, );
	      c13 = new Coordinate(, );
	      c14 = new Coordinate(, );
	      c15 = new Coordinate(, );*/


	//---------------CREATES A GRID OF 1 AND 0, 1 = VERTICIES OF HEXAGONS ----
	//for a 3-4-3 hex

	//creates an array of points -- 1 = on, 0 = off.
	int[][] points = new int[8][9];
	//creates a grid of points, then shift specific points up/down
	for (int r = 2; r < 6; r++) {
	    for (int c = 0; c < points[0].length; c++) {
		//prevents unnecessary points (the 4 corners)
		if (!(c==0 && r==2||c==0 && r==5||c==8 && r==2||c==8 && r == 5)) {
			
		    if ((c + r) % 2 == 0) {
			if (r == 2 || r == 3) {
			    //"turns on" a point above selected point (rows 1,2)
			    points[r-2][c] = 1;
			} else {
			    points[r][c] = 1;
			}
		    } else {
			if (r == 2 || r == 3) {
			    points[r][c] = 1;
			} else {
			    //"turns on" selected point
			    points[r+2][c] = 1;
			}
		    }
	    
		}
	    }
	}

	//----------LOOKS AT ABOVE GRID AND MATCHES TO ARRAY OF COORDINATES------

	//records points from left to right
	Coordinate[] cor = new Coordinate[30];
	//keeps track of index of coordinate array
	int count = 0;
	for (int i = 0; i < points.length; i++) {
	    for (int j = 0; j < points[i].length; j++) {
		if (points[i][j] == 1) {
		    cor[count] = new Coordinate(i, j);
		}
	    }
	}
    
    }
}
