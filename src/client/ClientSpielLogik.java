package client;

import datenaustausch.DatenAustausch;
import server.Spieler;

public class ClientSpielLogik {

	public void lebenAnzeigen() {
	}

	public void ruhmpunkteAnzeigen() {
	}

	public void spielModerieren(String moderation) {
	}

	public void standortAnzeigen() {
	}

	public void tokyoVerlassen(Spieler spieler) {
	}

	public void wuerfelWuerfeln() {
		Wuerfel wuerfel = new Wuerfel();
		wuerfel.wuerfeln();
		DatenAustausch.setWuerfel(wuerfel);
		DatenAustausch.setModeration("Arschloch hat gewürfelt");
	}

	public ClientSpielLogik() {
	}
}
