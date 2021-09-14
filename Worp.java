package startenYathzee;

import java.util.Arrays;

public class Worp {
	static int result[] = new int[5];
	
	static String showResult() {
		String resultString = "";
		for(int i=0; i<5;i++) {
			result[i] = YathzeeSpel.dobbelstenen.get(i).value;
			resultString = resultString + result[i] + " ";
			//System.out.print(result[i]+" ");
		}
		
		//String resultString = Arrays.toString(result);
		System.out.println(resultString);
		return resultString;
		//Speler.worpHistory.add(resultString);
		
		//System.out.println(Speler.worpHistory + "Toegevoegd");
	
	}
	
}
