package AtcIntClient;

import java.util.ArrayList;

import AtcIntDatenaustausch.DatenAustausch;
import AtcIntDatenaustausch.Spieler;
import AtcIntDatenaustausch.Wurfel;

public class ClientSpielLogik {

	public void lebenAnzeigen() {
	}

	public void ruhmpunkteAnzeigen() {
	}

	public void spielModerieren(String moderation) {
	}

	public void standortAnzeigen() {
	}

	public void tokyoVerlassen(Spieler spielerVerlassen,
			DatenAustausch datenAustausch) {

		ArrayList<Spieler> spielerListe = datenAustausch.getSpielerListe();

		for (Spieler spieler : spielerListe) {

			if (spieler.equals(spielerVerlassen)) {
				spieler.setAufTokyo(false);

			}

		}
		datenAustausch.setSpielerListe(spielerListe);
	}

	public void wuerfelWuerfeln() {

//		DatenAustausch datenAustausch = DatenAustausch.instanz;
//		datenAustausch.wurfeln();
	}
	//
	// public ClientSpielLogik() {
	// }
}
