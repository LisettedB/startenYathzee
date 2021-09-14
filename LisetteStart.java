package startenYathzee;
import java.util.Scanner;

public class LisetteStart {
	public void start() {
		System.out.println("Start in Lisette");
		
		YathzeeSpel spel = new YathzeeSpel();
		spel.spelen();
		System.out.println("Buiten Whileloop");
		
	}
}

