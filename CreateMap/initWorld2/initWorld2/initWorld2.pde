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
  textSize(50);
  fill(300,50,0);
  for (int i = 0; i < hexes.length; i++) {
    Hexagon hex = hexes[i];
    text(""+(i+1));
    
  }
}

void draw() {
}