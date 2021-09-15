package startenYathzee;

import java.util.Random;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;



public class YathzeeSpel {
	int blokkeerArray[] = {0,0,0,0,0};
	static ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<Dobbelsteen>();
	
	YathzeeSpel() {
		for(int i=0; i<5; i++) {
			Dobbelsteen dobbelsteen1 = new Dobbelsteen();
			dobbelstenen.add(dobbelsteen1);
		}
	}
	
	void spelen() {
		 		
		//Game Start//////////////////////////////////////////////
		String quitGame = "";
		Scanner sch = new Scanner(System.in);
		System.out.println(
				"Welcome to Yathzee!"
				+ "\n"
				+ "Made by Lisette & Ramon"
				+ "\n"
				+ "Press enter to start.");
		String startGame = sch.nextLine();
		
		//Add players//////////////////////////////////////////////
		ArrayList<Speler> spelers = new ArrayList<Speler>();
		System.out.println("How many players are going to play?\n"
				+ "Please fill in the number below");
		Scanner playerAmount = new Scanner(System.in);
		int playerCount = playerAmount.nextInt(); 
		
		for(int i = 0; i< playerCount; i++) {
			int playerNum = i+1;
			System.out.println("Player " + playerNum + ", what is your name?");
			Scanner nameInput = new Scanner(System.in);
			String inputString = nameInput.nextLine();
			Speler nieuweSpeler = new Speler();
			spelers.add(nieuweSpeler);
			spelers.get(i).playerName = inputString;	
		}
		///////////////////////////////////////////////////////////
		//Greets players by name Welcome: name1, name2, and name3//
		///////////////////////////////////////////////////////////
		System.out.print("Welcome ");
		if(playerCount>1) {
			for (int i=0; i < (playerCount-1); i++ ) {
				System.out.print(spelers.get(i).playerName + " ");
			}
				System.out.print("and " + spelers.get(playerCount-1).playerName);
				System.out.println("");
		} else {
			System.out.print(spelers.get(0).playerName);
			System.out.println("");

		}
		// var x made for counter the number of rounds in the while-loop. x is reset to 0 when x > 3
		int x = 0;
		
		//////////////////////////////////////////////////////////////////////////////////////
		//The game runs in this loop and is stopped when Q is pressed at the end of the turn//
		//////////////////////////////////////////////////////////////////////////////////////
		while (!quitGame.equals("q")) {
// 			'ENHANCED-FORLOOP'
//			for (Dobbelsteen number: dobbelstenen){
//				number.value = number.werpen();
//				
//			}
			//huidigeSpeler, current player, is the same as spelers.get(x) but easier to read.
			Speler huidigeSpeler = spelers.get(x);
			System.out.println("\nIt is "+huidigeSpeler.playerName + "'s turn"
					+ "\nYou have three rounds, rolling dice!");
			Worp nieuweWorp = new Worp();
			/////////////////////////////////////////////////////////////////////////////////
			//3 rounds per player are played											   //
			//J-forloop is 3 rounds per turn											   //
			//I-forloop is the actuall roll of the die werpen() is called for each 5 dice  //
			//With workHistory.add(X) the last roll is added to the players history		   //	
			/////////////////////////////////////////////////////////////////////////////////
			for(int j =0; j<3;j++) {
				
				int roundCount = j+1;
				System.out.println("	-----------\n	| ROUND " + roundCount + " |\n	-----------");
				
				for(int i=0; i<5; i++) {
					if(blokkeerArray[i] == 0) {
					dobbelstenen.get(i).value = dobbelstenen.get(i).werpen();
					}
				}
				huidigeSpeler.worpHistory.add(nieuweWorp.showResult());
				System.out.println("\n"+huidigeSpeler.playerName+"'s history: "+huidigeSpeler.worpHistory);
				for(int n=0; n<5; n++) {
					blokkeerArray[n]=0;
				}
				vasthouden();
				
				
			}
			
			//Either stop by pressing q or enter to play another round
			Scanner sc = new Scanner(System.in);
			System.out.println("	----------------\n	| END OF ROUND |\n	----------------");
			System.out.println("To go to next player, press enter.\nTo quit press 'q' "
						  +"\n\n------------------------------------------------------------");
			quitGame = sc.nextLine();
			
			// increments x after the 3 rounds(the turn) this allows the next player-object to be used
			x++;
			
			//When c exceeds the playerCount x will be reset to 0 to return the the first player-object
			if(x >= playerCount)
			{
				x=0;
			}
			
			//at the end of the round the blockeerArray is reset back to {0,0,0,0,0,} for the next player
			for(int n=0; n<5; n++) {
				blokkeerArray[n]=0;
			}
			
			
		}
		//End of the game, it stops the while-loop, thus the game. it also prints the history of every player 
		System.out.println("End of game");
		for(int i=0;i<playerCount;i++) {
			System.out.println("\n"+spelers.get(i).playerName+"'s history: "+spelers.get(i).worpHistory);

		}
	}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	//method which holds the dice that are carried to the next round							 //
	//checkArr = the reference/template array where the input of the user is matched to			 //
	//forloop-J extracts each number from the userInput and converts it to a single digit integer//
	//forloop-I checks if the userinput matches the reference array and changes the blokkeerArray// 
	//from a 0 to a 1 if the user wishes to hold the die										 //
	///////////////////////////////////////////////////////////////////////////////////////////////
	void vasthouden() {
		Scanner input = new Scanner(System.in);
		System.out.println("\nEnter the die number's you would like to hold");
		String userInput = input.nextLine();
		int checkArr[] = {1,2,3,4,5};
		
		for(int j=0; j<userInput.length(); j++) {
			char extract1 = userInput.charAt(j);
			String extract2 = String.valueOf(extract1);
			int extract3 = Integer.parseInt(extract2);
			
			for(int i=0; i<5; i++) {
				if(checkArr[i] == extract3) {
					blokkeerArray[(extract3-1)] = 1; 
				}
			}
			
			
		}
		
		
	}
	
	
	
}
