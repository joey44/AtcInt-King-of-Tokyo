package AtcIntServer;

import java.util.ArrayList;

public class ServerSpielLogik {

	private static ArrayList<Spieler> spielerListe = new ArrayList<Spieler>();

	public static void addSpieler(int spielerID, String spielerName) {

		Spieler spieler = new Spieler(spielerID, spielerName);

		spielerListe.add(spieler);
		

	}

	public static ArrayList<Spieler> getSpielerListe() {
		return spielerListe;
	}

	public static void setSpielerListe(ArrayList<Spieler> spielerListe) {
		ServerSpielLogik.spielerListe = spielerListe;
	}
}
