package AtcIntDatenaustausch;

import java.util.ArrayList;

public class xx_SpielerListe {
	
	private static ArrayList<Spieler> spielerListe = new ArrayList<Spieler>();

	public static void addSpieler(int spielerID, String spielerName) {

		Spieler spieler = new Spieler(spielerID, spielerName);

		spielerListe.add(spieler);
		

	}
	
	

	public static ArrayList<Spieler> getSpielerListe() {
		return spielerListe;
	}
	

}
