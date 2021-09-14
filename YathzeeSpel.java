package startenYathzee;

import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;










public class YathzeeSpel {
	int blokkeerArray[] = {0,0,0,0,0}; 
	ArrayList<Dobbelsteen> dobbelstenen = new ArrayList<Dobbelsteen>();
	
	YathzeeSpel() {
		for(int i=0; i<5; i++) {
			Dobbelsteen dobbelsteen1 = new Dobbelsteen();
			dobbelstenen.add(dobbelsteen1);
			System.out.println(dobbelstenen);
		}
	}
	
	void spelen() {
				
		String quitGame = "";
		Scanner sch = new Scanner(System.in);
		System.out.println("Press enter to start.");
		String startGame = sch.nextLine();
		
		while (!quitGame.equals("q")) {

			
// 			'ENHANCED-FORLOOP'
//			for (Dobbelsteen number: dobbelstenen){
//				number.value = number.werpen();
//				
//			}
			for(int i=0; i<5; i++) {
				if(blokkeerArray[i] == 0) {
				dobbelstenen.get(i).value = dobbelstenen.get(i).werpen();
				}
			}
			
			vasthouden();
	
			
			
			
			Scanner sc = new Scanner(System.in);
			System.out.println("To Roll again, press enter.\nTo quit press q ");
			quitGame = sc.nextLine();
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
