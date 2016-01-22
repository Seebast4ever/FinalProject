int[][] gridPoint = MakeTiles.pointGrid(50);
Coordinate[] points = MakeTiles.points(gridPoint, 350, 100);
Hexagon[] hexes = MakeTiles.makeHexagon(points);

void setup() {
  size(1000, 550);
  background(150);
  noStroke();

  for (int h = 0; h < hexes.length; h++) {
    for (int l = 0; l < 6; l++) {
      Line lines = hexes[h].getLine(l);
      stroke(102, 254, 0);
      line(lines.getX1(), lines.getY1(), lines.getX2(), lines.getY2());
    }
  }

  putMiddleNumber();
}

void putMiddleNumber() {
  textSize(40);
  fill(300, 50, 0);
  for (int i = 0; i < hexes.length; i++) {
    Hexagon hex = hexes[i];
    text(""+(i+1), hex.getMiddleX()-11, hex.getMiddleY()+15);
  }
}

//initialY will put the cards that distance away from the borders
//initialX is the initial x location of the first card.
void updatePlayerHand(int initialX, int initialY, int cardWidth, int cardHeight, int p1NumCards, int p2NumCards) {
  //player 1's hand (top)
  fill(0, 200, 200);
  stroke(100, 300, 0);
  for (int i = 0; i < p1NumCards; i++) {
    rect(initialX + i * (cardWidth + 10), initialY, cardWidth, cardHeight);
  }
  for (int i = 0; i < p2NumCards; i++) {
    rect(initialX + i * (cardWidth + 10), height - initialY - cardHeight, cardWidth, cardHeight);
  }
}

void draw() {
  updatePlayerHand(400, 15, 50, 65, 5, 6);
}