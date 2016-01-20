public class player{//creates player object
    String howToPlay = "Welcome to Settlers of GUI, a version of the board game Settlers of Catan created by Sebastian Iturregui-Shelton and Chang Ju Kim of Stuyvesant High School. The game starts by Player 1 placing their first two settlement and roads down on corners of the hexagons. ";
    int numBrick = 0;
    int numWool = 0;
    int numOre = 0;
    int numGrain = 0;
    int numLumber = 0;

    int victoryPoints = 2;//sets the number of Victory Points to two, as each player places two settlements to begin the game. Players need 10 Victory Points to win, with Settlements adding 1 point per construction and Cities being worth 2 points, though they replace existing Settlements and as such only add one to the current amount of points
    
    String roadError = "You do not have enough materials to purchase a road! Please check your hand again and make another choice";//error message that prints when the player doesnt have enough resources to buy a road
    String settlementError = "You do not have enough materials to purchase a settlement! Please check your hand again and make another choice";//error message that prints when the player doesnt have enough resources to buy a settlement
    String cityError = "You do not have enough materials to purchase a city! Please check your hand again and make another choice";//error message that prints when the player doesnt have enough resources to buy a city
    
    String p1Win = "Player 1 has won! Good game!";//Win message for Player 1
    String p2Win = "Player 2 has won! Good game!";//Win message for Player 2
    String p3Win = "Player 3 has won! Good game!";//Win message for Player 3
    String p4Win = "Player 4 has won! Good game!";//Win message for Player 4
    
    int numOfPlayers = 2;//will be set to a variable coming from the button

    
    int[] hand;
    //hand[0] is Brick
    //hand[1] is Wool
    //hand[2] is Ore
    //hand[3] is Grain
    //hand[4] is Lumber
    public player(){
  hand = new int[5];
    }
    
    public void main(String[]args){
  if(numOfPlayers == 2){
      //requires button "number of players(2)"  to set numOfPlayers to 2
      player player1 = new player();
      //creates a new player, player1 with an empty hand
      player player2 = new player();
      //creates a new player, player2 with an empty hand
      
      player1.hand[0] = numBrick;
      player1.hand[1] = numWool;
      player1.hand[2] = numOre;
      player1.hand[3] = numGrain;
      player1.hand[4] = numLumber;
      //sets the array indeces with the correct number of materials based on where they placed their settlements in the GUI. the vars are for player1, indicated by the 1 at the end
      player2.hand[0] = numBrick;
      player2.hand[1] = numWool;
      player2.hand[2] = numOre;
      player2.hand[3] = numGrain;
      player2.hand[4] = numLumber;
      //sets the array indeces with the correct number of materials based on where they placed their settlements in the GUI. the vars are for player2, indicated by the 2 at the end
      
  }
    }
    public boolean victoryPoints(){
  if(victoryPoints >= 10){
      return true;
  }
    }
    public boolean canPurchaseRoad(){
  if(hand[0] <= 1 && hand[4] <= 1){
      hand[0] = numBrick;
      hand[4] = numLumber;
      numBrick = numBrick - 1;
      numLumber = numLumber - 1;
      hand[0] = numBrick;
      hand[4] = numLumber;
      return true;
  }else{
      System.out.println(roadError);//GUI label, not terminal
      return false;
  }
    }
    public boolean canPurchaseSettlement(){
  if(hand[0] >= 1 && hand[1] >= 1 && hand[3] >= 1 && hand >= 1){
      numBrick = numBrick - 1;
      numWool = numWool - 1;
      numGrain = numGrain - 1;
      numLumber = numLumber - 1;
      hand[0] = numBrick;
      hand[1] = numWool;
      hand[3] = numGrain;
      hand[4] = numLumber;
      victoryPoints += 1;
      if(victoryPoints() == true){
    System.out.println(p1Win);
      }
      return true;
  }else{
      System.out.println(settlementError);//GUI label, not terminal
      return false;
      }
   }
 
    public boolean canPurchaseCity(){
  if(hand[2] >= 3 && hand[3] >= 2){
      numOre = numOre - 3;
      numGrain = numGrain - 2;
      hand[2] = numOre;
      hand[3] = numGrain;
      victoryPoints += 1;
      if(victoryPoints() == true){
    System.out.println(p1Win);
      }
      return true;
  }else{
      System.out.println(cityError);
      return false;
      }
   }   
}