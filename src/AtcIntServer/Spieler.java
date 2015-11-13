package AtcIntServer;

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

	}

	public int getAnzahlLeben() {
		return anzahlLeben;
	}

	public void setAnzahlLeben(int anzahlLeben) {
		this.anzahlLeben = anzahlLeben;
	}

	public int getAnzahlRuhmpunkte() {
		return anzahlRuhmpunkte;
	}

	public void setAnzahlRuhmpunkte(int anzahlRuhmpunkte) {
		this.anzahlRuhmpunkte = anzahlRuhmpunkte;
	}

	public boolean isAufTokyo() {
		return isAufTokyo;
	}

	public void setAufTokyo(boolean isAufTokyo) {
		this.isAufTokyo = isAufTokyo;
	}

	public int getSpielerID() {
		return spielerID;
	}

	public void setSpielerID(int spielerID) {
		this.spielerID = spielerID;
	}

	public String getSpielerName() {
		return spielerName;
	}

	public void setSpielerName(String spielerName) {
		this.spielerName = spielerName;
	}

	public boolean isAmZug() {
		return isAmZug;
	}

	public void setAmZug(boolean isAmZug) {
		this.isAmZug = isAmZug;
	}

	public boolean isSpielerAktiv() {
		return isSpielerAktiv;
	}

	public void setSpielerAktiv(boolean isSpielerAktiv) {
		this.isSpielerAktiv = isSpielerAktiv;
	}

	
	public String toString() {
		return "Spieler [anzahlLeben=" + anzahlLeben + ", anzahlRuhmpunkte="
				+ anzahlRuhmpunkte + ", isAufTokyo=" + isAufTokyo
				+ ", spielerID=" + spielerID + ", spielerName=" + spielerName
				+ ", isAmZug=" + isAmZug + ", isSpielerAktiv=" + isSpielerAktiv
				+ "]";
	}

}
