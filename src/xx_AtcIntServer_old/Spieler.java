package xx_AtcIntServer_old;


/**
 * @author Nato
 * @version 1.0
 * @created 05-Nov-2015 23:08:39
 */
public class Spieler {

	private int anzahlLeben;
	private int anzahlRuhmpunkte;
	private boolean isAufTokyo;
	private int spielerID;
	private int spielerName;
	private boolean isAmZug;
	private boolean isSpielerAktiv;
	public ServerSpielLogik m_ServerSpielLogik;

	public Spieler(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param clentConnection
	 */
	public Spieler(clientConnection clentConnection){

	}
}//end Spieler