package startenYathzee;

import java.util.Random;
import java.awt.SystemColor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


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
		 		
		//Game Start
		String quitGame = "";
		Scanner sch = new Scanner(System.in);
		System.out.println(
				"Welcome to Yathzee!"
				+ "\n"
				+ "Made by Lisette & Ramon"
				+ "\n"
				+ "Press enter to start.");
		String startGame = sch.nextLine();
		
		//Add players
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
		//Greeting all players by name Welcome: name1, name2, and name3
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
		int x = 0;
		while (!quitGame.equals("q") || !quitGame.equals("Q") ) {
// 			'ENHANCED-FORLOOP'
//			for (Dobbelsteen number: dobbelstenen){
//				number.value = number.werpen();
//				
//			}
			
			Speler huidigeSpeler = spelers.get(x);
			System.out.println("\nIt is "+huidigeSpeler.playerName + "'s turn"
					+ "\nYou have three rounds, rolling dice!");
			
			Worp nieuweWorp = new Worp();
				
			//drie rondes per speler
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
				
				vasthouden();	
			}
			
			//Either stop by pressing q or enter te play another round
			Scanner sc = new Scanner(System.in);
			System.out.println("	----------------\n	| END OF ROUND |\n	----------------");
			System.out.println("To go to next player, press enter.\nTo quit press q ");
			quitGame = sc.nextLine();
			
			x++;
			
			if(x >= playerCount)
			{
				x=0;
				System.out.println("test");
			}
			
			for(int n=0; n<5; n++) {
				blokkeerArray[n]=0;
			}
			
			
		}
	}
	
	
	
	void vasthouden() {
		
		
		Scanner input = new Scanner(System.in);
		System.out.println("Welke dobbelstenen wil je vasthouden?");
		String userInput = input.nextLine();
		
		for(int i=0 ; i<5 ; i++) {
			char extract1 = userInput.charAt(i);
			String extract2 = String.valueOf(extract1);
			int extract3 = Integer.parseInt(extract2);
			blokkeerArray[i] = extract3;
		
		}
		
		
	}
	
	
	
}
