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

	public Line(Coordinate c1, Coordinate c2) {
	    this.c1 = c1;
	    this.c2 = c2;
	}

	public Line(int x1, int y1, int x2, int y2) {
	    c1.setXY(x1, y1);
	    c2.setXY(x2, y2);
		
	}
    }
    
    //stores structure of each hexagon
    public static class Hexagon {
	private ArrayList<Line> lineList;

	public Hexagon(Coordinate c1, Coordinate c2, Coordinate c3, Coordinate c4, Coordinate c5, Coordinate c6) {
	    this(new Line(c1, c2), new Line(c2, c3), new Line(c3, c4),
		 new Line(c4, c5), new Line(c5, c6), new Line(c6, c1));
	}

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


	//-------CREATES A GRID OF 1 AND 0, 1 = VERTICIES OF HEXAGONS ----
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

	//----------RECORDS VERTECIES OF HEXAGONS------

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


    //requires coordinates of vertecies of hexagons
    public static Hexagon[] makeHexagon(Coordinate[] points) {
	Hexagon[] hexes = new Hexagon[10];
	hexes[0] = new Hexagon(points[0], points[3], points[4], points[7], points[8], points[11]);
	hexes[1] = new Hexagon(points[1], points[4], points[5], points[8], points[9], points[12]);
	hexes[2] = new Hexagon(points[2], points[5], points[6], points[9], points[10], points[13]);
	
	hexes[3] = new Hexagon(points[7], points[11], points[12], points[16], points[17], points[21]);
	hexes[4] = new Hexagon(points[8], points[12], points[13], points[17], points[18], points[22]);
	hexes[5] = new Hexagon(points[9], points[13], points[14], points[18], points[19], points[23]);
	hexes[6] = new Hexagon(points[10], points[14], points[15], points[19], points[20], points[24]);

	hexes[7] = new Hexagon(points[17], points[21], points[22], points[25], points[26], points[29]);
	hexes[8] = new Hexagon(points[18], points[22], points[23], points[26], points[27], points[30]);
	hexes[9] = new Hexagon(points[19], points[23], points[24], points[27], points[28], points[31]);
	
	return hexes;
    }
}
