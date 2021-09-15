package startenYathzee;

import java.util.Arrays;

public class Worp {
	static int result[] = new int[5];
	
	//laat resultaten zien van de vijf gegooide dobbelstenen,
	//dit wordt in de for-loop een-voor-een vanuit een array aan een string toegevoegd
	//vervolgens wordt de string resultaten uitgeprint
	static String showResult() {
		String resultString = "";
		for(int i=0; i<5;i++) {
			result[i] = YathzeeSpel.dobbelstenen.get(i).value;
			resultString = resultString + result[i] + " ";
		}
		
		
		System.out.println("Die numbers:	1 2 3 4 5");
		System.out.println("-------------------------");
		System.out.println("Dice rolled:	"+resultString);
		return resultString;
		
	
	}
	
}
