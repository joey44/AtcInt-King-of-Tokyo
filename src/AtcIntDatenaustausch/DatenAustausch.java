package AtcIntDatenaustausch;

import java.io.Serializable;
import java.util.ArrayList;

public class DatenAustausch implements Serializable {

	public static DatenAustausch instanz;
	private Wurfel wurfel;
	private String moderation;
	private ArrayList<Spieler> spielerListe;

	public DatenAustausch() {
		this.wurfel = new Wurfel();
		this.moderation = "";
		this.spielerListe = new ArrayList<Spieler>();
		DatenAustausch.instanz = this;
	}

	public void addSpieler(int spielerID, String spielerName) {

		Spieler spieler = new Spieler(spielerID, spielerName);

		this.spielerListe.add(spieler);

	}

	public void wurfeln() {

		this.wurfel.setWerte(this.wurfel.wuerfeln());
		this.setWurfel(this.wurfel);

	}

	public String toString() {
		return "DatenAustausch [wurfel=" + wurfel + ", moderation="
				+ moderation + ", spielerListe=" + spielerListe + "]";
	}

	public Wurfel getWurfel() {
		return wurfel;
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
		spielerListe = spielerListe;
	}

	public void setDatenAustausch(DatenAustausch datenAustausch) {

		instanz = datenAustausch;
	}
}
