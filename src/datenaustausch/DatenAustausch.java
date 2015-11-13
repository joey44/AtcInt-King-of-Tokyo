package datenaustausch;

import java.io.Serializable;
import java.util.ArrayList;

import server.Spieler;
import client.Wuerfel;

public class DatenAustausch implements Serializable{

	private static Wuerfel wuerfel;
	private static String moderation;
	private static ArrayList<Spieler> SpielerListe = new ArrayList<Spieler>();

	public static String getModeration() {
		return moderation;
	}

	public static void setModeration(String moderation) {
		DatenAustausch.moderation = moderation;
	}

	public static Wuerfel getWuerfel() {
		return wuerfel;
	}

	public static void setWuerfel(Wuerfel wuerfel) {
		DatenAustausch.wuerfel = wuerfel;
	}

	public static ArrayList<Spieler> getSpielerListe() {
		return SpielerListe;
	}

	public static void setSpielerListe(ArrayList<Spieler> spielerListe) {
		SpielerListe = spielerListe;
	}
}