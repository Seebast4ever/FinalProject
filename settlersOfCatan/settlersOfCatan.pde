ArrayList<tile> allTiles = new ArrayList<tile>();//every time a new tile is created, add it to this ArrayList so we can keep track of all the tiles
ArrayList<player> allPlayers = new ArrayList<player>();//every time a new player is created, add it to this ArrayList so they will be kept track of
ArrayList<gamePiece> allGamePieces = new ArrayList<gamePiece>();//every time a new game piece is created, add it to this ArrayList so we can keep track of them
int State;

void setup(){
  frameRate(30);
  size(1080, 720);
  background(0, 191, 255);
  State = 0;
}
void draw(){//lots of this code is in the repo I linked you
  if (State == 0){
    textSize(100);
    fill(204, 0, 0);
    text("Settlers of GUI", 160, 100); 
    textSize(30);
    fill(0, 102, 153, 51);
    text("A digital project designed by:\nSebastian Iturregui-Shelton and Chang Ju Kim", 160, 150);
    /*
    text("word", 10, 90); 
    */
  }
}
void mousePressed(){
  
}