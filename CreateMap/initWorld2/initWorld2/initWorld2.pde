//CHANGE: easy ctrl-f letting coder change certain aspects of code
//ADD: easy ctrl-f telling coder to add features

ArrayList<player> allPlayers = new ArrayList<player>();//every time a new player is created, add it to this ArrayList so they will be kept track of
int currentPlayer = 0;

int numOfPlayers = 2;

boolean makingS = false;
boolean makingC = false;
boolean makingR = false;

int numBrick = 10;
int numWool = 10;
int numOre = 10;
int numGrain = 10;
int numLumber = 10;

//Creates the location of vertecies and hexagons.
//Modify this parameter to change the size of the board itself (will also modify its location)
int[][] gridPoint = MakeTiles.pointGrid(50);
//Change the parameters to modify the (x,y) of the board
Coordinate[] points = MakeTiles.points(gridPoint, 350, 100);
Hexagon[] hexes = MakeTiles.makeHexagon(points);

ArrayList<Line> lines = MakeTiles.lines(hexes);

//checks if mouse was clicked
boolean clicked = false;

RectButton rollButton;
RectButton settlementButton;
RectButton cityButton;
RectButton roadButton;
RectButton endTurnButton;


void setup() {

  //~~~~~~~~~~~Game Board
  //CHANGE: Game size
  size(1000, 550);
  background(150);
  noStroke();

  //loops through the lines of the hexagons, and draws each line based on its coordinate
  for (int h = 0; h < hexes.length; h++) {
    for (int l = 0; l < 6; l++) {
      Line lines = hexes[h].getLine(l);
      //change color of lines
      //CHANGE: hexagon line colors
      stroke(102, 254, 0);
      line(lines.getX1(), lines.getY1(), lines.getX2(), lines.getY2());
    }
  }
  //puts the middle number of a hexagon
  putMiddleNumber();

  if (numOfPlayers == 2) {
    //requires button "number of players(2)"  to set numOfPlayers to 2
    player player1 = new player();
    //creates a new player, player1 with an empty hand
    player player2 = new player();
    //creates a new player, player2 with an empty hand

    allPlayers.add(player1);
    allPlayers.add(player2);
  }

  //~~~~~~~~~Buttons
  //CHANGE: Location of buttons
  rollButton = new RectButton(30, 50, 150, 30, "Roll!", 10);
  settlementButton = new RectButton(30, 100, 150, 30, "Make a settlement!", 10);
  cityButton = new RectButton(30, 150, 150, 30, "Make a city!", 10);
  roadButton = new RectButton(30, 200, 150, 30, "Make a road!", 10);
  endTurnButton = new RectButton(30, 350, 150, 30, "End your turn!", 10);
}

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Game board and Player hand~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//puts a middle number in each hexagon. Currently puts 1 to 10
void putMiddleNumber() {
  //change size of text
  //CHANGE: Size of middle number in hexagons
  textSize(40);
  //change color of the number
  //CHANGE: color of the number
  fill(300, 50, 0);
  for (int i = 0; i < hexes.length; i++) {
    Hexagon hex = hexes[i];
    //puts location of the text. modify -11, +15 to adjust and ensure proper middle-ness
    //CHANGE: look above comment :D
    text(""+(i+1), hex.getMiddleX()-11, hex.getMiddleY()+15);
  }
}

//initialY will put the cards that distance away from the borders
//initialX is the initial x location of the first card.
void updatePlayerHand(int initialX, int initialY, int cardWidth, int cardHeight, int p1NumCards, int p2NumCards) {
  //player 1's hand (top)

  //ADD: Production card (log,sheep,clay...) indicator using filled colors
  //CHANGE: Border color
  //ADD: show amount of each card in players hand, using numbers underneath

  //color of shaded 
  fill(0, 200, 200);
  //color of border
  stroke(300, 100, 0);

  //CHANGE: <cardWidth + x> space between cards
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
    //    points[i].setSettlement(true);
    //    points[i].setCity(true);
    //CHANGE: Size of the settlement/city
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
  ellipse(x, y, offset, offset);


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
      //CHANGE: size of road
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


//every click action should end with "clicked = false" so that a player needs to click somewhere again.
void mouseClicked() {
  clicked = true;

  //~~~~~~~~~~~~~~~~~~~~~ROLL DIE~~~~~~~~~~~~~~~~~~

  if (rollButton.updateMouseOver() && clicked == true) {
    int rolledNumber = rollDie();
    System.out.println("You rolled: "+rolledNumber);
  }

  //~~~~~~~~~~~~~~~~~~~~~~SETTLEMENT~~~~~~~~~~~~~

  //ADD: When clicked, check if can build etc
  if (!makingS && settlementButton.updateMouseOver() && clicked == true) {
    if (allPlayers.get(currentPlayer).canPurchaseSettlement()) {
      makingS = true;
      System.out.println("Click where you would like to build a settlement");
    } else {
      //need to test
      System.out.println("You don't have enough material!");
      clicked = false;
    }
    clicked = false;
  }

  //TO SEBASTIANNN: okay here's the code. It'll loop through all the vertexes and if it has a settlement, puts that as true.
  //You don't need to automatically update it since the draw command does that.

  //Do the same for city (it's basically the same, but setCity to true).
  //Also I added a feature to mouseClicked() -- clicked = true/false. What this does is that it will prevent several code from running at once.
  //e.g. Each *if* will check if clicked is true, and they will all make clicked false when done. Therefore, when mouseClicked is looking at the other if statements,
  //it won't trigger them as clicked is now false. (Think of it as each click should do only one action.)

  if (makingS && clicked == true) {
    boolean pressedNearPoint = false;
    for (int i = 0; i < points.length; i++) {
      if (points[i].isClose(mouseX, mouseY, 7) && !points[i].hasSettlement() && !points[i].hasCity()) {
        points[i].setSettlement(true);
        pressedNearPoint = true;
        System.out.println("Built!");
      }
    }
    if (!pressedNearPoint) {
      System.out.println("You did not click on a valid place!"); 
      allPlayers.get(currentPlayer).undoPurchaseSettlement();
    }
    makingS = false;
    clicked = false;
    //ADD: we need a function to check if the mouse is over a place a settlement can be built
    //NEEDS TO BE DONE FOR ROADS AND CITIES TOO
    //if(correctCoordinateForSettlement(mouseX, mouseY)){
    //allPlayers.get(currentPlayer).createSettlement(); 
    //}
  }

  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~CITY~~~~~~~~~~~~~~~~~~~~~~~~~~

  if (!makingC && cityButton.updateMouseOver() && clicked == true) {
    if (allPlayers.get(currentPlayer).canPurchaseCity()) {
      makingC = true;
      System.out.println("Click where you would like to build a city");
    } else {
      //need to test
      System.out.println("You don't have enough material!");
      clicked = false;
    }
    clicked = false;
  }

  if (makingC && clicked == true) {
    boolean pressedNearPoint = false;
    for (int i = 0; i < points.length; i++) {
      if (points[i].isClose(mouseX, mouseY, 7) && !points[i].hasSettlement() && !points[i].hasCity()) {
        points[i].setCity(true);
        pressedNearPoint = true;
        System.out.println("Built!");
      }
    }
    if (!pressedNearPoint) {
      System.out.println("You did not click on a valid place!"); 
      allPlayers.get(currentPlayer).undoPurchaseCity();
    }
    makingC = false;
    clicked = false;
  }

  /*
    //this should be good for the road code
   if (roadButton.updateMouseOver() && clicked == true) {
   System.out.println("built a road!!");
   
   
   */
  /*
    for (int i = 0; i < lines.size(); i++) {
   if (lines.get(i).isClose(mouseX, mouseY, 10)) {
   lines.get(i).setHasRoad(true);
   }
   }
   */

  /*      
   clicked = false;
   }
   */
  //ADD: end turn feature

  if (endTurnButton.updateMouseOver()) {
    System.out.println("Ended turn!!");
  }
}

  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Rolling die/Random~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  int rollDie() {
    //returns the result of rolling two die
    return (int)random(1, 6) + (int)random(1, 6);
  }

  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Draw function~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

  void draw() {
    allPlayers.get(0).hand[0] = numBrick;
    allPlayers.get(0).hand[1] = numWool;
    allPlayers.get(0).hand[2] = numOre;
    allPlayers.get(0).hand[3] = numGrain;
    allPlayers.get(0).hand[4] = numLumber;
    //sets the array indeces with the correct number of materials based on where they placed their settlements in the GUI. the vars are for player1, indicated by the 1 at the end
    //player2.hand[0] = numBrick;
    //player2.hand[1] = numWool;
    //player2.hand[2] = numOre;
    //player2.hand[3] = numGrain;
    //player2.hand[4] = numLumber;
    //sets the array indeces with the correct number of materials based on where they placed their settlements in the GUI. the vars are for player2, indicated by the 2 at the end


    updateBoard();
    //CHANGE: ??? (down)
    updatePlayerHand(400, 15, 50, 65, 5, 6);
    //  System.out.println("Mouse: ("+mouseX+", "+mouseY+")");
  }