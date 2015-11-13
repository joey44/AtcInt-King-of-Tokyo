package server;

public class Spieler {

	public static final int DEFAULT_ANZAHL_LEBEN = 20;
	public static final int DEFAULT_ANZAHL_RUHMPUNKTE = 0;
	public int anzahlLeben;
	public int anzahlRuhmpunkte;
	public boolean isAufTokyo;
	public int spielerID;
	public String spielerName;
	public boolean isAmZug;
	public boolean isSpielerAktiv;

	public Spieler(int spielerID, String spielerName) {

		this.spielerID = spielerID;
		this.spielerName = spielerName;
		this.anzahlLeben = Spieler.DEFAULT_ANZAHL_LEBEN;
		this.anzahlRuhmpunkte = Spieler.DEFAULT_ANZAHL_RUHMPUNKTE;
		this.isAufTokyo = false;
		this.isAmZug = false;
		this.isSpielerAktiv = true;
		
		ServerSpielLogik.
	}

}
