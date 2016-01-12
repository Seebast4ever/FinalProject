public class player{//creates player object
    int[] hand;
    //hand[0] is Brick
    //hand[1] is Wool
    //hand[2] is Ore
    //hand[3] is Grain
    //hand[4] is Lumber
    
    public static void main(String[]args){
	int numOfPlayers = 2;//will be set to a variable coming from the button
	if(numOfPlayers = 2){//requires button "number of players(2)"  to set numOfPlayers to 2
	    int[] player1 = new player[4];//creates a new player, player1 with an empty hand
	    int[] player2 = new player[4];//creates a new player, player2 with an empty hand
	    
	    player1[0] = numBrick1;
	    player1[1] = numWool1;
	    player1[2] = numOre1;
	    player1[3] = numGrain1;
	    player1[4] = numLumber1;
	    //sets the array indeces with the correct number of materials based on where they placed their settlements in the GUI. the vars are for player1, indicated by the 1 at the end
	    player2[0] = numBrick2;
	    player2[1] = numWool2;
	    player2[2] = numOre2;
	    player2[3] = numGrain2;
	    player2[4] = numLumber2;
	    //sets the array indeces with the correct number of materials based on where they placed their settlements in the GUI. the vars are for player2, indicated by the 2 at the end
	   
	}
    }
}

