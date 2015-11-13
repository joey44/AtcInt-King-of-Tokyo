package server;

import java.util.ArrayList;

public class ServerSpielLogik {

	private ArrayList<Spieler> spielerListe = new ArrayList<Spieler>();

	public void addSpieler(int spielerID, String spielerName) {

		Spieler spieler = new Spieler(spielerID, spielerName);

		spielerListe.add(spieler);

	}
}
