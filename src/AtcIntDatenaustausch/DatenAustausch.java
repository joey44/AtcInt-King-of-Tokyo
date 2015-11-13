package AtcIntDatenaustausch;

import java.io.Serializable;
import java.util.ArrayList;

import AtcIntServer.Spieler;
import AtcIntWurfel.Wurfel;



public class DatenAustausch implements Serializable {

	private Wurfel wuerfel = new Wurfel();
	private String moderation = "";
	private ArrayList<Spieler> SpielerListe = new ArrayList<Spieler>();

	public DatenAustausch getDatenaustausch() {

		return this;
	}

	public String toString() {
		return "DatenAustausch [wuerfel=" + wuerfel + ", moderation="
				+ moderation + ", SpielerListe=" + SpielerListe + "]";
	}

	public Wurfel getWuerfel() {
		return wuerfel;
	}

	public void setWuerfel(Wurfel wuerfel) {
		this.wuerfel = wuerfel;
	}

	public String getModeration() {
		return moderation;
	}

	public void setModeration(String moderation) {
		this.moderation = moderation;
	}

	public ArrayList<Spieler> getSpielerListe() {
		return SpielerListe;
	}

	public void setSpielerListe(ArrayList<Spieler> spielerListe) {
		SpielerListe = spielerListe;
	}

}
