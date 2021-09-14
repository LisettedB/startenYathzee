package startenYathzee;

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;


public class YathzeeSpel {
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
		
		while (!quitGame.equals("q")) {
			System.out.println("In whileloop");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Press enter to start.");
			quitGame = sc.nextLine();
		}
	}
	
	
}
