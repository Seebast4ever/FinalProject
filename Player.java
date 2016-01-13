public class player{//creates player object
    int numBrick1 = 0;
    int numWool1 = 0;
    int numOre1 = 0;
    int numGrain1 = 0;
    int numLumber1 = 0;
    int numBrick2 = 0;
    int numWool2 = 0;
    int numOre2 = 0;
    int numGrain2 = 0;
    int numLumber2 = 0;
    int numBrick3 = 0;
    int numWool3 = 0;
    int numOre3 = 0;
    int numGrain3 = 0;
    int numLumber3 = 0;
    int numBrick4 = 0;
    int numWool4 = 0;
    int numOre4 = 0;
    int numGrain4 = 0;
    int numLumber4 = 0;
    
    String roadError = "You do not have enough materials to purchase a road! Please check your hand again and make another choice";//error message that prints when the player doesnt have enough resources to buy a road
    String settlementError = "You do not have enough materials to purchase a settlement! Please check your hand again and make another choice";//error message that prints when the player doesnt have enough resources to buy a settlement
    String cityError = "You do not have enough materials to purchase a city! Please check your hand again and make another choice";//error message that prints when the player doesnt have enough resources to buy a city
    
    int numOfPlayers = 2;//will be set to a variable coming from the button

    
    int[] hand;
    //hand[0] is Brick
    //hand[1] is Wool
    //hand[2] is Ore
    //hand[3] is Grain
    //hand[4] is Lumber
    public player(){
	hand[] = new int[5];
    }
    
    public static void main(String[]args){
	if(numOfPlayers = 2){//requires button "number of players(2)"  to set numOfPlayers to 2
	    player player1 = new player();//creates a new player, player1 with an empty hand
	    player player2 = new player();//creates a new player, player2 with an empty hand
	    
	    player1.hand[0] = numBrick1;
	    player1.hand[1] = numWool1;
	    player1.hand[2] = numOre1;
	    player1.hand[3] = numGrain1;
	    player1.hand[4] = numLumber1;
	    //sets the array indeces with the correct number of materials based on where they placed their settlements in the GUI. the vars are for player1, indicated by the 1 at the end
	    player2.hand[0] = numBrick2;
	    player2.hand[1] = numWool2;
	    player2.hand[2] = numOre2;
	    player2.hand[3] = numGrain2;
	    player2.hand[4] = numLumber2;
	    //sets the array indeces with the correct number of materials based on where they placed their settlements in the GUI. the vars are for player2, indicated by the 2 at the end
	    
	}
    }
    public boolean p1CanPurchaseRoad(){
	if(player1.hand[0] <= 1 && player1.hand[4] <= 1){
	    numBrick1 = numBrick1 - 1;
	    numLumber1 = numLumber1 - 1;
	    player1.hand[0] = numBrick1;
	    player1.hand[4] = numLumber1;
	    return true;
	}else{
	    System.out.println(roadError);//need to be printed to a GUI label, not the terminal
	    return false;
	}
    }
    public boolean p2CanPurchaseRoad(){
	if(player2.hand[0] <= 1 && player2.hand[4] <= 1){
	    numBrick2 = numBrick2 - 1;
	    numLumber2 = numLumber2 - 1;
	    player2.hand[0] = numBrick2;
	    player2.hand[4] = numLumber2;
	    return true;
	}else{
	    System.out.println(roadError);//GUI label, not terminal
	    return false;
	}
    }
    public boolean p1CanPurchaseSettlement(){
	if(player1.hand[0] >= 1 && player1.hand[1] >= 1 && player1.hand[3] >= 1 && player1.hand >= 1){
	    numBrick1 = numBrick1 - 1;
	    numWool1 = numWool1 - 1;
	    numGrain1 = numGrain1 - 1;
	    numLumber1 = numLumber1 - 1;
	    player1.hand[0] = numBrick1;
	    player1.hand[1] = numWool1;
	    player1.hand[3] = numGrain1;
	    player1.hand[4] = numLumber1;
	    return true;
	}else{
	    System.out.println(settlementError);//GUI label, not terminal
	    return false;
	}
    }
    public boolean p2CanPurchaseSettlement(){
	if(player2.hand[0] >= 1 && player2.hand[1] >= 1 && player2.hand[3] >= 1 && player2.hand >= 1){
	    numBrick2 = numBrick2 - 1;
	    numWool2 = numWool2 - 1;
	    numGrain2 = numGrain2 - 1;
	    numLumber2 = numLumber2 - 1;
	    player2.hand[0] = numBrick2;
	    player2.hand[1] = numWool2;
	    player2.hand[3] = numGrain2;
	    player2.hand[4] = numLumber2;
	    return true;
	}else{
	    System.out.println(settlementError);//GUI label, not terminal
	    return false;
	}
    }
}

