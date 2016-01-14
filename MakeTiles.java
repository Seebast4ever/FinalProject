import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawHex extends JComponent {

    public static int[][] pointGrid() {

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
	return points;
    }

	//----------RECORDS VERTECIES OF HEXAGONS------

    public static Coordinate[] points(int[][] pointGrid) {
	//records points from left to right
	Coordinate[] cor = new Coordinate[30];
	//keeps track of index of coordinate array
	int count = 0;
	for (int i = 0; i < pointGrid.length; i++) {
	    for (int j = 0; j < pointGrid[i].length; j++) {
		if (pointGrid[i][j] == 1) {
		    cor[count] = new Coordinate(i, j);
		}
	    }
	}
	return cor;
    }


    //requires coordinates of vertecies of hexagons
    public static Hexagon[] makeHexagon(Coordinate[] points) {
	Hexagon[] hexes = new Hexagon[10];

	//the top 3 hexes
	hexes[0] = new Hexagon(points[0], points[3], points[4], points[7], points[8], points[11]);
	hexes[1] = new Hexagon(points[1], points[4], points[5], points[8], points[9], points[12]);
	hexes[2] = new Hexagon(points[2], points[5], points[6], points[9], points[10], points[13]);

	//the middle 4 hexes
	hexes[3] = new Hexagon(points[7], points[11], points[12], points[16], points[17], points[21]);
	hexes[4] = new Hexagon(points[8], points[12], points[13], points[17], points[18], points[22]);
	hexes[5] = new Hexagon(points[9], points[13], points[14], points[18], points[19], points[23]);
	hexes[6] = new Hexagon(points[10], points[14], points[15], points[19], points[20], points[24]);

	//the bottom 3 hexes
	hexes[7] = new Hexagon(points[17], points[21], points[22], points[25], points[26], points[29]);
	hexes[8] = new Hexagon(points[18], points[22], points[23], points[26], points[27], points[30]);
	hexes[9] = new Hexagon(points[19], points[23], points[24], points[27], points[28], points[31]);
	
	return hexes;
    }
}
