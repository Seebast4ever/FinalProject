//Creates the location of vertecies and hexagons.
//Modify this parameter to change the size of the board itself (will also modify its location)
int[][] gridPoint = MakeTiles.pointGrid(50);
//Change the parameters to modify the (x,y) of the board
Coordinate[] points = MakeTiles.points(gridPoint, 350, 100);
Hexagon[] hexes = MakeTiles.makeHexagon(points);

ArrayList<Line> lines = MakeTiles.lines(hexes);

//checks if mouse was clicked
boolean clicked = false;

RectButton settlementButton;
RectButton cityButton;
RectButton roadButton;
RectButton endTurnButton;


void setup() {

  //~~~~~~~~~~~Game Board
  size(1000, 550);
  background(150);
  noStroke();

  //loops through the lines of the hexagons, and draws each line based on its coordinate
  for (int h = 0; h < hexes.length; h++) {
    for (int l = 0; l < 6; l++) {
      Line lines = hexes[h].getLine(l);
      //change color of lines
      stroke(102, 254, 0);
      line(lines.getX1(), lines.getY1(), lines.getX2(), lines.getY2());
    }
  }
  //puts the middle number of a hexagon
  putMiddleNumber();


  //~~~~~~~~~Buttons
  settlementButton = new RectButton(30, 100, 150, 30, "Make a settlement!", 10);
  cityButton = new RectButton(30, 150, 150, 30, "Make a city!", 10);
  roadButton = new RectButton(30, 200, 150, 30, "Make a road!", 10);
  endTurnButton = new RectButton(30, 350, 150, 30, "End your turn!", 10);
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Game board and Player hand~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//puts a middle number in each hexagon. Currently puts 1 to 10
void putMiddleNumber() {
  //change size of text
  textSize(40);
  //change color of the number
  fill(300, 50, 0);
  for (int i = 0; i < hexes.length; i++) {
    Hexagon hex = hexes[i];
    //puts location of the text. modify -11, +15 to adjust and ensure proper middle-ness
    text(""+(i+1), hex.getMiddleX()-11, hex.getMiddleY()+15);
  }
}

//initialY will put the cards that distance away from the borders
//initialX is the initial x location of the first card.
void updatePlayerHand(int initialX, int initialY, int cardWidth, int cardHeight, int p1NumCards, int p2NumCards) {
  //player 1's hand (top)

  //color of shaded 
  fill(0, 200, 200);
  //color of border
  stroke(300, 100, 0);
  for (int i = 0; i < p1NumCards; i++) {
    //cardWidth + x ensures that there is a distance of x apart from each card.
    rect(initialX + i * (cardWidth + 10), initialY, cardWidth, cardHeight);
  }
  for (int i = 0; i < p2NumCards; i++) {
    rect(initialX + i * (cardWidth + 10), height - initialY - cardHeight, cardWidth, cardHeight);
  }
}

void updateBoard() {
  updatePoints();
  updateRoads();
}

void updatePoints() {
  for (int i = 0; i < points.length; i++) {
    points[i].setSettlement(true);
    points[i].setCity(true);
    if (points[i].hasSettlement()) {
      drawSettlement(points[i], 8);
    }
    if (points[i].hasCity()) {
      drawCity(points[i], 8);
    }
  }
}

//creates a circle for a city
void drawCity(Coordinate c, int offset) {
  //makes offset the radius of the circle instead
  offset = offset * 2;
  int x = c.getX();
  int y = c.getY();
  ellipse(x, y, 16, 16);


  /*  Hexagon h = new Hexagon(x-5, y+5, x, y+10, x+5, y+5, x+5, y-5, x, y-10, x-5, y-5);
   for (int i = 0; i < 6; i++) {
   Line line = h.getLine(i);
   line(line.getX1(), line.getY1(), line.getX2(), line.getY2());
   }
   */
}

//draws a triangle for a settlement
void drawSettlement(Coordinate c, int offset) {
  int x = c.getX();
  int y = c.getY();
  triangle(x - offset, y+offset, x + offset, y + offset, x, y - offset);
}

void updateRoads() {
  for (int i = 0; i < lines.size(); i++) {
    lines.get(i).setHasRoad(true);
    if (lines.get(i).hasRoad()) {
      drawRoad(lines.get(i), 5);
    }
  }
}

void drawRoad(Line l, int offset) {
  //note: x is increasing from left to right
  //      y is increasing from top to bottom

  //if the line looks like: \
  if (l.getSlope() == 1) {

    //I use min/max because the order for X1 and X2 are mixed up
    //extra subtraction/addition is to prevent roads from being too close to points
    int x1 = min(l.getX1(), l.getX2()) + 10;
    int y1 = min(l.getY1(), l.getY2()) + 10;
    int x2 = max(l.getX1(), l.getX2()) - 10;
    int y2 = max(l.getY1(), l.getY2()) - 10;
    quad(x1, y1 + offset, x1 + offset, y1, x2, y2 - offset, x2 - offset, y2);
  }
  //if the line looks like: /
  if (l.getSlope() == -1) {
    int x1 = min(l.getX1(), l.getX2()) + 10;
    int y1 = max(l.getY1(), l.getY2()) - 10;
    int x2 = max(l.getX1(), l.getX2()) - 10;
    int y2 = min(l.getY1(), l.getY2()) + 10;
    quad(x1, y1 - offset, x1 + offset, y1, x2, y2 + offset, x2 - offset, y2);
  }
  //if the line looks like: |
  //note: in Line.java, I made the slope = 0 if undefined.
  if (l.getSlope() == 0) {
    //x1 and x2 are equal
    int x1 = l.getX1();
    int y1 = min(l.getY1(), l.getY2()) + 6;
    int x2 = l.getX2();
    int y2 = max(l.getY1(), l.getY2()) - 6;
    quad(x1 - offset, y1 + offset, x1 + offset, y1 + offset, x2 + offset, y2 - offset, x2 - offset, y2 - offset);
  }
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Mouse click~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

void mouseClicked() {
  clicked = true;
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Rolling die/Random~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
int rollDie() {
  //returns the result of rolling two die
  return (int)random(1, 7) + (int)random(1, 7);
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Draw function~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

void draw() {
  if (clicked) {
    if (settlementButton.updateMouseOver()) {
      System.out.println("built a settlement!!");
      //makes sure one mouse-click isn't misread as several
      clicked = false;
    }

    if (cityButton.updateMouseOver()) {
      System.out.println("built a city!!");
      clicked = false;
    }

    if (roadButton.updateMouseOver()) {
      System.out.println("built a road!!");
      clicked = false;
    }

    if (endTurnButton.updateMouseOver()) {
      System.out.println("Ended turn!!");
      clicked = false;
    }
  }
  updateBoard();
  updatePlayerHand(400, 15, 50, 65, 5, 6);
  //  System.out.println("Mouse: ("+mouseX+", "+mouseY+")");
}