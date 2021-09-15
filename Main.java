package startenYathzee;

public class Main {
	public static void main(String[] args) {
		LisetteStart ls = new LisetteStart();
		RamonStart rs = new RamonStart();
		//ls en rs start waren aangemaakt om beide in de 'main' te kunnen werken zonder de main aan te raken ivm merge conflicten
		ls.start();
		rs.start();
		//System.out.println("Hij doet het!");
	}
}
