package AtcIntServer;

import java.util.ArrayList;

import AtcIntDatenaustausch.DatenAustausch;
import AtcIntDatenaustausch.Spieler;
import AtcIntDatenaustausch.Wurfel;

public class ServerSpielLogik {

	public static final int CONSTANT_TATZE = '6';

	public static ArrayList<Spieler> angreifen(ArrayList<Spieler> spielerListe) {

		int AngrSpielerAmZug = 0;
		boolean AngrSpielerAufTokyo = false;

		// evaluieren, welcher Spieler angreifen ist und ob auf Tokyo
		for (Spieler spieler : spielerListe) {

			if (spieler.isAmZug()) {
				AngrSpielerAmZug = spieler.getSpielerID();
				AngrSpielerAufTokyo = spieler.isAufTokyo();
			}
		}

		// Leben abziehen

		for (Spieler spieler : spielerListe) {
			// Wenn Spieler nicht am Zug, Leben abziehen
			if (spieler.getSpielerID() != AngrSpielerAmZug) {

				spieler.setAnzahlLeben(spieler.getAnzahlLeben() - 1);
				if (AngrSpielerAufTokyo) {
					break;
				}
			}
		}

		return spielerListe;
	}

	public static void aufTokyoGehen() {

	}

	public static void lebenBerechnen() {

	}

	public static void ruhmpunkteBerechnen() {

	}

	public static void siegerKueren() {

	}

	public static void spielerAusschliessen() {

	}

	public static void werteListeEvaluieren(DatenAustausch datenAustausch) {

		Wurfel wurfel = datenAustausch.getWuerfel();
		int[] werte = wurfel.getWerte();

		for (int i : werte) {

			if (i == CONSTANT_TATZE) {
				datenAustausch.setSpielerListe(angreifen(datenAustausch
						.getSpielerListe()));
			} else {
				lebenBerechnen();

			}

		}

	}
}
