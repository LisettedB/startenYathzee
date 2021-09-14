package startenYathzee;

import java.util.Random;
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
		System.out.println("Press enter to start.");
		String startGame = sch.nextLine();
		
		//Add players
		ArrayList<Speler> spelers = new ArrayList<Speler>();
		System.out.println("How many players?");
		Scanner playerAmount = new Scanner(System.in);
		int playerCount = playerAmount.nextInt(); 
		
		for(int i = 0; i< playerCount; i++) {
			System.out.println("Name?");
			Scanner nameInput = new Scanner(System.in);
			String inputString = nameInput.nextLine();
			Speler nieuweSpeler = new Speler();
			spelers.add(nieuweSpeler);
			spelers.get(i).playerName = inputString;
			
			
		}
		
		int x = 0;
		while (!quitGame.equals("q")) {
// 			'ENHANCED-FORLOOP'
//			for (Dobbelsteen number: dobbelstenen){
//				number.value = number.werpen();
//				
//			}
			
			
			
			
			
			Speler huidigeSpeler = spelers.get(x);
			System.out.println(huidigeSpeler.playerName + "'s Turn");
			
			//drie rondes per speler
			for(int j =0; j<3;j++) {
				int roundCount = j+1;
				System.out.println("ronde = " + );
				
				for(int i=0; i<5; i++) {
					if(blokkeerArray[i] == 0) {
					dobbelstenen.get(i).value = dobbelstenen.get(i).werpen();
					}
				}
				
				Worp nieuweWorp = new Worp();
				huidigeSpeler.worpHistory.add(nieuweWorp.showResult());
				System.out.println(huidigeSpeler.worpHistory);
				
				vasthouden();
		
				
				
				//Either stop by pressing q or enter te play another round
				Scanner sc = new Scanner(System.in);
				System.out.println("To Roll again, press enter.\nTo quit press q ");
				quitGame = sc.nextLine();
			}
			
			x++;
			if(x >= playerCount)
			{
				x=0;
				System.out.println("test");
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
