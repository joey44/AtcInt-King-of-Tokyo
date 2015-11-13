package datenaustausch;

import java.io.Serializable;
import java.util.ArrayList;

import server.Spieler;
import client.Wuerfel;

public class DatenAustausch implements Serializable {

	private Wuerfel wuerfel = new Wuerfel();;
	private String moderation = "";
	private ArrayList<Spieler> SpielerListe = new ArrayList<Spieler>();

	public DatenAustausch getDatenaustausch() {

		return this;
	}

	public String toString() {
		return "DatenAustausch [wuerfel=" + wuerfel + ", moderation="
				+ moderation + ", SpielerListe=" + SpielerListe + "]";
	}

	public Wuerfel getWuerfel() {
		return wuerfel;
	}

	public void setWuerfel(Wuerfel wuerfel) {
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
