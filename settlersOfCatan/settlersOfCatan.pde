ArrayList<tile> allTiles = new ArrayList<tile>();//every time a new tile is created, add it to this ArrayList so we can keep track of all the tiles
ArrayList<player> allPlayers = new ArrayList<player>();//every time a new player is created, add it to this ArrayList so they will be kept track of
ArrayList<gamePiece> allGamePieces = new ArrayList<gamePiece>();//every time a new game piece is created, add it to this ArrayList so we can keep track of them
int State;
int rectX, rectY;      // Position of square button
int circleX, circleY;  // Position of circle button
int rectSize = 90;     // Diameter of rect
int circleSize = 93;   // Diameter of circle
color rectColor, circleColor, baseColor;
color rectHighlight, circleHighlight;
color currentColor;
boolean rectOver = false;
boolean circleOver = false;


void setup() {
  frameRate(30);
  size(1080, 720);
  background(0, 191, 255);
  State = 0;
  rectColor = color(255);
  rectHighlight = color(51);
  circleColor = color(255);
  circleHighlight = color(204);
  circleX = width/2+circleSize/2+10;
  circleY = height/2;
  rectX = 390;
  rectY = 430;
  //ellipseMode(CENTER);
}

void draw() {//lots of this code is in the repo I linked you
  if (State == 0) {
    textSize(100);
    fill(204, 0, 0);
    text("Settlers of GUI", 180, 100); 
    textSize(30);
    fill(0, 102, 153, 51);
    text("A digital project designed by:", 310, 160);
    text("Sebastian Iturregui-Shelton and Chang Ju Kim", 170, 200);
    text("To start, select number of players:", 278, 400); 
    text("Two Players", 400, 470);
    update(mouseX, mouseY);
    if (rectOver) {
      fill(rectHighlight);
    } else {
      fill(rectColor);
    }
    stroke(255);
    rect(rectX, rectY, 263, 90);
  }
}
void mousePressed() {
  if (rectOver) {
    System.out.println("Pressed!");
  }
}

void update(int x, int y) {
  if ( overRect(rectX, rectY, rectSize, rectSize) ) {
    rectOver = true;
    circleOver = false;
  } else {
    circleOver = rectOver = false;
  }
}

boolean overRect(int x, int y, int width, int height) {
  if (mouseX >= x && mouseX <= x+width && 
    mouseY >= y && mouseY <= y+height) {
    return true;
  } else {
    return false;
  }
}

/*
void setup() {
 size(640, 360);
 rectColor = color(0);
 rectHighlight = color(51);
 circleColor = color(255);
 circleHighlight = color(204);
 baseColor = color(102);
 currentColor = baseColor;
 circleX = width/2+circleSize/2+10;
 circleY = height/2;
 rectX = width/2-rectSize-10;
 rectY = height/2-rectSize/2;
 ellipseMode(CENTER);
 }
 
 void draw() {
 update(mouseX, mouseY);
 background(currentColor);
 
 if (rectOver) {
 fill(rectHighlight);
 } else {
 fill(rectColor);
 }
 stroke(255);
 rect(rectX, rectY, rectSize, rectSize);
 
 if (circleOver) {
 fill(circleHighlight);
 } else {
 fill(circleColor);
 }
 stroke(0);
 ellipse(circleX, circleY, circleSize, circleSize);
 }
 
 
 void update(int x, int y) {
 if ( overCircle(circleX, circleY, circleSize) ) {
 circleOver = true;
 rectOver = false;
 } else if ( overRect(rectX, rectY, rectSize, rectSize) ) {
 rectOver = true;
 circleOver = false;
 } else {
 circleOver = rectOver = false;
 }
 }
 
 
 void mousePressed() {
 if (circleOver) {
 currentColor = circleColor;
 }
 if (rectOver) {
 currentColor = rectColor;
 }
 }
 
 boolean overRect(int x, int y, int width, int height)  {
 if (mouseX >= x && mouseX <= x+width && 
 mouseY >= y && mouseY <= y+height) {
 return true;
 } else {
 return false;
 }
 }
 
 
 boolean overCircle(int x, int y, int diameter) {
 float disX = x - mouseX;
 float disY = y - mouseY;
 if (sqrt(sq(disX) + sq(disY)) < diameter/2 ) {
 return true;
 } else {
 return false;
 }
 }
 */