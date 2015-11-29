package AtcIntDatenaustausch;

import java.io.Serializable;
import java.util.ArrayList;

//import AtcIntServer.ServerSpielLogik;
//import bsp_client_server_simple_object.Server;

//import ServerSpielLogik;

public class DatenAustausch implements Serializable {

	private static DatenAustausch InstanzDatenAustausch;
	private Wurfel wurfel;
	private String moderation;
	private ArrayList<Spieler> spielerListe;
	private int runde = 0;
	private int clientID;
	

	private DatenAustausch() {

	}

	public static DatenAustausch getInstanz() {
		// Singletonprinzip
		if (DatenAustausch.InstanzDatenAustausch == null) {
			DatenAustausch.InstanzDatenAustausch = new DatenAustausch();
			InstanzDatenAustausch.wurfel = Wurfel.getInstanz();
			InstanzDatenAustausch.moderation = "";
			InstanzDatenAustausch.spielerListe = new ArrayList<Spieler>();
		}
		return DatenAustausch.InstanzDatenAustausch;
	}
	
	public static void setInstanz(DatenAustausch w){
		DatenAustausch.InstanzDatenAustausch = w;
	}

	public void addSpieler(int spielerID, String spielerName) {

		Spieler spieler = new Spieler(spielerID, spielerName);

		this.spielerListe.add(spieler);

	}

	public void wurfeln() {

		this.wurfel.setWerte(this.wurfel.wuerfeln());
		this.setWurfel(this.wurfel);
		
	}

	public Spieler getSpielerAmZug() {

		Spieler spielerAmZug = null;
		for (Spieler spieler : this.spielerListe) {

			if (spieler.isAmZug()) {
				spielerAmZug = spieler;
			}
		}
		return spielerAmZug;
	}

	public Spieler getSpielerAufTokyo() {

		Spieler spielerAufTokyo = null;
		for (Spieler spieler : this.spielerListe) {

			if (spieler.isAufTokyo()) {
				spielerAufTokyo = spieler;
			}
		}
		return spielerAufTokyo;
	}

	public Spieler getSpielerByID(int spielerID) {

		Spieler Spieler = null;
		for (Spieler s : this.spielerListe) {

			if (s.getSpielerID() == spielerID) {
				Spieler = s;
			}
		}
		return Spieler;
	}

	

	@Override
	public String toString() {
		return "DatenAustausch [wurfel=" + wurfel + ", moderation="
				+ moderation + ", spielerListe=" + spielerListe + ", runde="
				+ runde + ", clientID=" + clientID + "]";
	}

	public Wurfel getWurfel() {
		return wurfel;
	}
	
	public int getwCounter() {
		return this.wurfel.getwCounter();
	}

	public void setWurfel(Wurfel wurfel) {
		this.wurfel = wurfel;
	}

	public String getModeration() {
		return moderation;
	}

	public void setModeration(String moderation) {
		this.moderation = moderation;
	}

	public ArrayList<Spieler> getSpielerListe() {
		return spielerListe;
	}

	public void setSpielerListe(ArrayList<Spieler> spielerListe) {
		this.spielerListe = spielerListe;
	}

	public int getRunde() {
		return runde;
	}

	public void setRunde(int runde) {
		this.runde = runde;
	}

	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}
	
	

}
