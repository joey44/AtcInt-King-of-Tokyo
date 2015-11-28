package AtcIntClientGUI;

import java.util.ArrayList;

import AtcIntDatenaustausch.DatenAustausch;
import AtcIntDatenaustausch.Spieler;


public class ClientSpielLogik {

	//ClientController controller;

	public static String lebenAnzeigen(DatenAustausch d2, int clientID) {

		//DatenAustausch d = DatenAustausch.getInstanz();

		Spieler s = d2.getSpielerByID(clientID);

		return "Leben: " + s.getAnzahlLeben();

	}

	public static String ruhmpunkteAnzeigen(DatenAustausch d2, int clientID) {

		//DatenAustausch d = DatenAustausch.getInstanz();

		Spieler s = d2.getSpielerByID(clientID);

		return "Punkte: " + s.getAnzahlRuhmpunkte();
	}
	
	public static String spielerName(DatenAustausch d2, int clientID) {

		//DatenAustausch d = DatenAustausch.getInstanz();

		Spieler s = d2.getSpielerByID(clientID);

		return "Name: " + s.getSpielerName();
	}

	public static String spielModerieren(DatenAustausch d) {

	//	DatenAustausch d = DatenAustausch.getInstanz();

		return d.getModeration();

	}

	public static String standortAnzeigen(DatenAustausch d) {

		

		return "Auf Tokyoo Spieler: " + d.getSpielerAufTokyo().getSpielerID();

	}

	public static DatenAustausch tokyoVerlassen(DatenAustausch d, int clientID) {

		//DatenAustausch d = DatenAustausch.getInstanz();

		Spieler s = d.getSpielerByID(clientID);
		
		s.setAufTokyo(false);
		
		ArrayList<Spieler> spielerListe = d.getSpielerListe();
		
		spielerListe.set(clientID, s);
		
		d.setSpielerListe(spielerListe);
		
		//d.setInstanz(d);
		
		return d;
		
		
	}

	public static DatenAustausch wurfelWurfeln(DatenAustausch d) {

		d.wurfeln();
		
		

		return d;
		
		

	}
	

	
	

}
