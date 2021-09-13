package startenYathzee;

import java.util.Random;
import java.util.Scanner;


public class YathzeeSpel {
	public void spelen() {
		String ingevoerd = "";
		
		while (!ingevoerd.equals("q")) {
			System.out.println("In whileloop");
			
			Scanner sc = new Scanner(System.in);
			System.out.println("Press enter to start.");
			ingevoerd = sc.nextLine();
		}
	}
	
	public int werpen() {
		Random r = new Random();
		int getal = r.nextInt(6)+1;
		return getal;
	}
}
