package startenYathzee;

import java.util.Random;

public class Dobbelsteen {	
	
	public int werpen() {
		System.out.println("Dobbelsteen aangemaakt.");
		Random r = new Random();
		int number = r.nextInt(6)+1;
		return number;
	}
}
