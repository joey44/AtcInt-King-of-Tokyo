package xxAtcIntClient;

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

	public void tokyoVerlassen(Spieler spielerVerlassen) {

		ArrayList<Spieler> spielerListe = DatenAustausch.getInstanz()
				.getSpielerListe();

		for (Spieler spieler : spielerListe) {

			if (spieler.equals(spielerVerlassen)) {
				spieler.setAufTokyo(false);

			}

		}
		DatenAustausch.getInstanz().setSpielerListe(spielerListe);
	}

	public void wuerfelWuerfeln() {

		DatenAustausch.getInstanz().wurfeln();

	}
}
