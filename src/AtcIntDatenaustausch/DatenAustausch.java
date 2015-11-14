package AtcIntDatenaustausch;

import java.io.Serializable;
import java.util.ArrayList;

public class DatenAustausch implements Serializable {

	private Wurfel wurfel;
	private String moderation;
	private ArrayList<Spieler> spielerListe;


	public DatenAustausch(){
		this.wurfel = new Wurfel();
		this.moderation = "";
		this.spielerListe = new ArrayList<Spieler>();
	}
	
	public DatenAustausch getDatenaustausch() {

		return this;
	}
		
	
	public void addSpieler(int spielerID, String spielerName) {

		Spieler spieler = new Spieler(spielerID, spielerName);

		this.spielerListe.add(spieler);
		

	}
	
	public void wurfeln() {

		this.wurfel.wuerfeln();

	}
	

	

	
	public String toString() {
		return "DatenAustausch [wurfel=" + wurfel + ", moderation="
				+ moderation + ", spielerListe=" + spielerListe + "]";
	}

	public Wurfel getWuerfel() {
		return wurfel;
	}

	public void setWuerfel(Wurfel wuerfel) {
		this.wurfel = wuerfel;
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
		spielerListe = spielerListe;
	}

}
