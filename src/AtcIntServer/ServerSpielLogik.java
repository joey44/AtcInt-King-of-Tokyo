package AtcIntServer;

import java.util.ArrayList;
import AtcIntServer.Spieler;

public class ServerSpielLogik {

	private static ArrayList<Spieler> spielerListe = new ArrayList<Spieler>();

	public static void addSpieler(int spielerID, String spielerName) {

		Spieler spieler = new Spieler(spielerID, spielerName);

		spielerListe.add(spieler);
		

	}
	
	
	
	public static void angreifen(){

	}

	public static void aufTokyoGehen(){

	}

	public static void lebenBerechnen(){

	}

	public static void ruhmpunkteBerechnen(){

	}

	public static void siegerKueren(){

	}


	public static void spielerAusschliessen(){

	}


	public static void werteListeEvaluieren(){

	}
	
	
	

	public static ArrayList<Spieler> getSpielerListe() {
		return spielerListe;
	}
	
	

}
