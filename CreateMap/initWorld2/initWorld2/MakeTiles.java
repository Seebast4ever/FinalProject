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

/*
  Solely creates an array of hexagons with proper coordinates, but only between the points 0 <= x <= 8 and 0 <= y <= 7 
 edit: added a ratio
 */


class MakeTiles extends JComponent {

  //
  static int[][] pointGrid(int ratio) {

    //-------creates a coordinate plane with each dot a 1 or 0, with 1 = verticies of hexagons ----
    //meant for 3-4-3 hex

    //makes sure ratio is an odd number so that the mod later works smoothly
    if (ratio%2 == 0) {
      ratio++;
    }

    //creates an array of points -- 1 = on, 0 = off.
    int[][] points = new int[8*ratio][9*ratio];
    //creates a grid of points, then shift specific points up/down
    for (int r = 2*ratio; r < 6*ratio; r+= ratio) {
      for (int c = 0; c < points[0].length; c += ratio) {
        //prevents unnecessary points (the 4 corners)
        if (!(c==0 && r==2*ratio||c==0 && r==5*ratio||c==8*ratio && r==2*ratio||c==8*ratio && r == 5*ratio)) {

          if ((c + r) % 2 == 0) {
            if (r == 2*ratio || r == 3*ratio) {
              //"turns on" a point above selected point (rows 1,2)
              points[r-2*ratio][c] = 1;
            } else {
              points[r][c] = 1;
            }
          } else {
            if (r == 2*ratio || r == 3*ratio) {
              points[r][c] = 1;
            } else {
              //"turns on" selected point
              points[r+2*ratio][c] = 1;
            }
          }
        }
      }
    }
    return points;
  }

  //----------RECORDS VERTECIES OF HEXAGONS------

  static Coordinate[] points(int[][] pointGrid, int xinit, int yinit) {
    //records points from left to right
    Coordinate[] cor = new Coordinate[32];
    //keeps track of index of coordinate array
    int count = 0;
    for (int i = 0; i < pointGrid.length; i++) {
      for (int j = 0; j < pointGrid[i].length; j++) {
        if (pointGrid[i][j] == 1) {
          cor[count] = new Coordinate(j+xinit, i+yinit);
          count++;
        }
      }
    }
    return cor;
  }

  //without initial (x,y) values
  static Coordinate[] points(int[][] pointGrid) {
    //records points from left to right
    Coordinate[] cor = new Coordinate[32];
    //keeps track of index of coordinate array
    int count = 0;
    for (int i = 0; i < pointGrid.length; i++) {
      for (int j = 0; j < pointGrid[i].length; j++) {
        if (pointGrid[i][j] == 1) {
          cor[count] = new Coordinate(j, i);
          count++;
        }
      }
    }
    return cor;
  }


  //requires coordinates of vertecies of hexagons
  static Hexagon[] makeHexagon(Coordinate[] points) {
    Hexagon[] hexes = new Hexagon[10];

    //the top 3 hexes
    hexes[0] = new Hexagon(points[0], points[3], points[7], points[12], points[8], points[4]);
    hexes[1] = new Hexagon(points[1], points[4], points[8], points[13], points[9], points[5]);
    hexes[2] = new Hexagon(points[2], points[5], points[9], points[14], points[10], points[6]);

    //the middle 4 hexes
    hexes[3] = new Hexagon(points[7], points[11], points[16], points[21], points[17], points[12]);
    hexes[4] = new Hexagon(points[8], points[12], points[17], points[22], points[18], points[13]);
    hexes[5] = new Hexagon(points[9], points[13], points[18], points[23], points[19], points[14]);
    hexes[6] = new Hexagon(points[10], points[14], points[19], points[24], points[20], points[15]);

    //the bottom 3 hexes
    hexes[7] = new Hexagon(points[17], points[21], points[25], points[29], points[26], points[22]);
    hexes[8] = new Hexagon(points[18], points[22], points[26], points[30], points[27], points[23]);
    hexes[9] = new Hexagon(points[19], points[23], points[27], points[31], points[28], points[24]);

    return hexes;
  }

  //returns a line list meant for adding roads
  static ArrayList<Line> lines(Hexagon[] hexes) {
    //60 lines, but with 19 duplicates. In no particular order.
    ArrayList<Line> lines = new ArrayList<Line>(41);
    boolean lineExists = false;
    for (int h = 0; h < hexes.length; h++) {
      for (int hexl = 0; hexl < 6; hexl++) {
        //checks if the line is recorded yet
        for (int l = 0; l < lines.size()  && !lineExists; l++) {
          Line hexLine = hexes[h].getLine(hexl);
          Line line = lines.get(l);
          if (hexLine.getX1() == line.getX1() && hexLine.getY1() == line.getY1() && hexLine.getX2() == line.getX2() && hexLine.getY2() == line.getY2()) {
            lineExists = true;
          }
        }
        if (!lineExists) {
         lines.add(hexes[h].getLine(hexl)); 
        }
      }
    }
    return lines;

    //    return removeDuplicates(lines);
  }

  static ArrayList<Line> removeDuplicates(Line[] lines) {
    //line list without duplicates
    ArrayList<Line> newLines = new ArrayList<Line>(41);
    boolean hasDuplicate = false;
    //line to be tested
    for (int i = 0; i < lines.length; i++) {

      //lines already recorded
      //if it doesn't have a duplicate yet, keep looking through recorded lines
      for (int j = 0; j < newLines.size() && !hasDuplicate; j++) {
        //if that line already exists in the answer
        Line l = lines[i];
        Line newl = newLines.get(j);
        l.getC1().printCor();
        l.getC2().printCor();
        System.out.println(newl.getX1());
        System.out.println(newl.getY1());
        System.out.println(newl.getX2());
        System.out.println(newl.getY2());
        if (l.getX1() == newl.getX1() && l.getY1() == newl.getY1() && l.getX2() == newl.getX2() && l.getY2() == newl.getY2()) {
          hasDuplicate = true;
        }
      }
      //if that line is not recorded yet
      if (!hasDuplicate) {
        newLines.add(lines[i]);
      }
    }
    return newLines;
  }

  static void printHexCoordinates(Hexagon hex) {
    Line line0 = hex.getLine(0);
    Line line1 = hex.getLine(1);
    Line line2 = hex.getLine(2);
    Line line3 = hex.getLine(3);
    Line line4 = hex.getLine(4);
    Line line5 = hex.getLine(5);

    Coordinate C0 = line0.getC1();
    Coordinate C1 = line1.getC1();
    Coordinate C2 = line2.getC1();
    Coordinate C3 = line3.getC1();
    Coordinate C4 = line4.getC1();
    Coordinate C5 = line5.getC1();

    C0.printCor();
    C1.printCor();
    C2.printCor();
    C3.printCor();
    C4.printCor();
    C5.printCor();
  }
  /*
  static void main(String[]args) {
   int ratio = 1;
   int[][] pointAry = pointGrid(ratio);
   String ans = "[";
   for (int i = 0; i < pointAry.length; i+= ratio) {
   ans += "\n[ ";
   for (int j = 0; j < pointAry[i].length; j+= ratio) {
   ans += pointAry[i][j]+", ";
   }
   ans += "]";
   }
   System.out.println(ans + "\n]");
   
   Coordinate[] corArray = points(pointAry);
   System.out.print("[");
   for (int i = 0; i < corArray.length; i++) {
   System.out.print(i+": ");
   corArray[i].printCor();
   }
   
   System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
   
   Hexagon[] hexArray = makeHexagon(corArray);
   
   
                      /*	System.out.print("[");
   	for (int i = 0; i < hexArray.length; i++) {
   	    System.out.print(hexArray[i]+", ");
   	}
   	System.out.println("]");*/
  /*
    
   printHexCoordinates(hexArray[0]);
   }
   */
}