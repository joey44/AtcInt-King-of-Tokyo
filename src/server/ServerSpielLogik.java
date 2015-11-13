package server;

import java.util.ArrayList;

import datenaustausch.DatenAustausch;

public class ServerSpielLogik {

	private ArrayList<Spieler> spielerListe = new ArrayList<Spieler>();

	public void addSpieler(int spielerID, String spielerName) {

		Spieler spieler = new Spieler(spielerID, spielerName);

		spielerListe.add(spieler);

		DatenAustausch.setSpielerListe(spielerListe);

	}
}
