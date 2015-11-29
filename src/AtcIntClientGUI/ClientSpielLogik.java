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

	

		return d.getModeration();

	}

	public static String standortAnzeigen(DatenAustausch d) {

		Spieler s = d.getSpielerAufTokyo();
		
		if (s == null){
			return "kein Spieler ist auf Tokyo";
		}
		
		return "Auf Tokyoo Spieler: " + s.getSpielerID();

	}

	
	public static DatenAustausch wurfelWurfeln(DatenAustausch d) {

		d.wurfeln();
		
		d.setModeration("Spieler Nr: "+ d.getSpielerAmZug().getSpielerID()+" hat gewürfelt" + d.getwCounter()%3);
		
		if (d.getwCounter()%3 == 0){
			
			Spieler s = d.getSpielerAmZug();
			int a = s.getSpielerID();
			
			
			d.getSpielerAmZug().setAmZug(false);
			d.getSpielerByID((a+1)%4).setAmZug(true);

			d.setModeration("Spieler Nr " + a + " hat den Zug beendet" + d.getWurfel().toString());
			
			
			
		}
		

		return d;
		
		

	}
	

	
	

}
