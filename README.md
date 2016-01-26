# FinalProject
Final Project for the first semester of APCS

~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Starting Notes~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

Hello! This is a project made by Sebastian and Chang Ju.

We made Settlers of Catan... or at least tried. In fact, much of the code is complete, but is not implemented together. Thus, our project falls a bit short.

Ideally, Settlers of Catan is a board game made of hexagonal tiles. Each hexagon has a "production number", a number in the middle of the hexagon that shows when the hexagon will produce a resource. When two die are rolled, and its sum is a hexagon's production number, that hexagon will produce a specific resource. Settlements or cities on the verticies will give that resource to its controlling player. In short, a settlement or city will produce resources for a player.

Additional rules state that one cannot build cities or settlements arbitrarily! Roads must connect an already existing settlement or city (SoC) to an empty vertex so that a player can build a SoC. 

Normally, players start with two settlements and two roads placed on strategic locations. From there, players will try to get resources they need to build SoC or roads.

The resources consist of: clay, sheep, wheat, ore, and lumber.
A settlement costs: 1 clay, 1 lumber, 1 sheep, 1 wheat.
A city costs: 3 ore, 2 wheat.
A road costs: 1 clay, 1 lumber.



~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Directions~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

This is a Settlers of Catan game on Processing!

Please open up to the CreateMap folder
From there, open the initWorld2 folder
And then open the initWorld2 folder once more.
Our main program is initWorld2.

Note: The game is not playable, as pieces of code were not integrated yet into the main product. However, that does not prevent you from seeing the features at hand!

If you run our program, you will find buttons to the right, and a hexagonal grid to the left.
The console at the bottom will indicate states of the world.

You can create settlements and cities by clicking on their respective buttons to the left. Click on a hexagon vertex to place it there! Settlements are triangles while cities are circles. You will be unable to build a settlement or city if you click too far from a vertex!
You can also roll to see what number you get. Unfortunately, you cannot retrieve material from roll results. Similarly, the end turn button, and the make road buttons are not functional.

The hexagons themselves represent the game board. The rectangles above and below are meant to represent player hand. However, we again have not been able to join code in a timely manner.


If you wish to see more features of our code, you can press: ctrl-f and search for "updatePoints" and "updateRoads". Within both of these functions are commented out code saying, points[i].set<...> or lines.get(i).setHasRoad(true). These will make every point think it has a SoC, or every line think it is a road, respectively.

There are many, many comments in this code. Many of them are quite helpful in explaining, although a few show things we needed to add and values that can be changed.



GIT LOG:

1-19-2016

Sebastian Iturregui-Shelton

	    -Updated player.java to correctly use the player object as an object and not as a main class. Functions were condensed into object functions versus object initiation functions.

1-20-2016

Sebastian Iturregui-Shelton

	    -Converted player.java to settlersOfCatan.pde, a processing file. Created each hexagon (or tile) object for mouse detection during player game piece placement. Created ArrayLists for players and tiles. Compiled and debugged so the code runs and displays a blank window, for now. 

1-21-2016

Sebastian Iturregui-Shelton

	    -Created Settlement, Road, and City object files in processing. Created ArrayLists to track these. Changed the color and dimensions of the base game board in order to fit my screen size, and so that the asthetic is both pleasing and similar to the original game board background

1-22-2016

Sebastian Iturregui-Shelton

	    -Created start menu outline, edited text arrangement and color and added a button to select two players. Selecting the button will start the main file running. 

1-25-2016

Sebastian Iturregui-Shelton

	  -Combined code with partner, tested code to make sure it compiles/runs properly and efficiently. 

Chang Ju Kim
      	  -Made a rough transition to processing. Working file is for some reason in initWorld2/initWorld2/ folder.
	   -Created the hexagon board with numbers in the middle that represents productivity.
	    -Created an easy way to make players hands (created a function that makes rectangles at desired location. Need to now connect each rectangle with a list of each player's hand and change color accordingly).


1-23/24-2016

Chang Ju Kim
      	  -Created a rectanglular button class. In my main file (initWorld2), made it easy to do something when button is pressed.
	   -Added a die simulator
	    -Created methods to add settlements/cities/roads at specific locations.
	     	       -Bugs encountered:
				-Wanted to create a helper function that removes duplicate elements in an array. However, kept getting nullPointerException error. Code can be seen in makeTiles.java .
					   	  -What I did: Simply moved the content of the function into the caller so that there were no function calls in the main function. Somehow removed the issue.


						  -Tried to create a draw hexagon function directly in the hexagon class
						         -Bugs encountered:
									     -Like above, I got a nullPointerException error.
									     	             -What I did: I gave up.
											     	           -Notable finds: For some reason making the hexagon class have .pde extension prevents processing from seeing it as an object (despite the fact that RectButton is an object, and I... [1. created a new processing file and copy-pasted the Hexagon.java file] and [2. used mv command in terminal to change the name]).# FinalProject
Final Project for the first semester of APCS

GIT LOG:

1-19-2016

Sebastian Iturregui-Shelton

	  -Updated player.java to correctly use the player object as an object and not as a main class. Functions were condensed into object functions versus object initiation functions.

1-20-2016

Sebastian Iturregui-Shelton

	  -Converted player.java to settlersOfCatan.pde, a processing file. Created each hexagon (or tile) object for mouse detection during player game piece placement. Created ArrayLists for players and tiles. Compiled and debugged so the code runs and displays a blank window, for now. 

1-21-2016

Sebastian Iturregui-Shelton

	  -Created Settlement, Road, and City object files in processing. Created ArrayLists to track these. Changed the color and dimensions of the base game board in order to fit my screen size, and so that the asthetic is both pleasing and similar to the original game board background

1-22-2016

Sebastian Iturregui-Shelton

	  -Created start menu outline, edited text arrangement and color and added a button to select two players. Selecting the button will start the main file running. 

1-25-2016

Sebastian Iturregui-Shelton

	-Combined code with partner, tested code to make sure it compiles/runs properly and efficiently. 

Chang Ju Kim
      	 -Made a rough transition to processing. Working file is for some reason in initWorld2/initWorld2/ folder.
	 -Created the hexagon board with numbers in the middle that represents productivity.
	 -Created an easy way to make players hands (created a function that makes rectangles at desired location. Need to now connect each rectangle with a list of each player's hand and change color accordingly).


1-23/24-2016

Chang Ju Kim
      	 -Created a rectanglular button class. In my main file (initWorld2), made it easy to do something when button is pressed.
	 -Added a die simulator
	 -Created methods to add settlements/cities/roads at specific locations.
	 	  -Bugs encountered:
		  	-Wanted to create a helper function that removes duplicate elements in an array. However, kept getting nullPointerException error. Code can be seen in makeTiles.java .
				-What I did: Simply moved the content of the function into the caller so that there were no function calls in the main function. Somehow removed the issue.


	-Tried to create a draw hexagon function directly in the hexagon class
	       -Bugs encountered:
	       	     -Like above, I got a nullPointerException error.
		     	   -What I did: I gave up.
			   	 -Notable finds: For some reason making the hexagon class have .pde extension prevents processing from seeing it as an object (despite the fact that RectButton is an object, and I... [1. created a new processing file and copy-pasted the Hexagon.java file] and [2. used mv command in terminal to change the name]).
>>>>>>> dd351c6fe1e934bd3de6fc25a77b04df7425fac8

