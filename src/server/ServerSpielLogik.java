package server;

import java.util.ArrayList;

import AtcIntDatenaustausch.DatenAustausch;

public class ServerSpielLogik {

	private ArrayList<Spieler> spielerListe = new ArrayList<Spieler>();
	private DatenAustausch datenAustausch;

	public void addSpieler(int spielerID, String spielerName) {

		Spieler spieler = new Spieler(spielerID, spielerName);

		spielerListe.add(spieler);

		this.datenAustausch.setSpielerListe(spielerListe);

	}

	public void createDatenAustausch() {
		this.datenAustausch = new DatenAustausch();
	}
}
