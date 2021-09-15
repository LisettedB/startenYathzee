package startenYathzee;

import java.util.Random;

public class Dobbelsteen {	
	int value;
	
	//In deze class zit de method 'werpen'. deze functie rolled random nummers tussen de 1 en 6 en returnd deze naar whileloop van Yathzeespel.java
	public int werpen() {
		Random r = new Random();
		int number = r.nextInt(6)+1;
		return number;
		
	}
}
