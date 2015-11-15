package AtcIntServer;

import java.util.ArrayList;

import AtcIntDatenaustausch.DatenAustausch;
import AtcIntDatenaustausch.Spieler;
import AtcIntDatenaustausch.Wurfel;

public class ServerSpielLogik {

	public static final int CONSTANT_TATZE = 6;
	public static final int CONSTANT_HERZ = 5;

	public static ArrayList<Spieler> angreifen(ArrayList<Spieler> spielerListe) {

		Spieler SpielerAmZug = null;

		// evaluieren, welcher Spieler angreifen ist und ob auf Tokyo
		for (Spieler spieler : spielerListe) {

			if (spieler.isAmZug()) {
				SpielerAmZug = spieler;
			}
		}

		// Leben abziehen

		for (Spieler spieler : spielerListe) {
			// Wenn Spieler nicht am Zug, Leben abziehen

			if (SpielerAmZug.isAufTokyo()) {
				if (!spieler.equals(SpielerAmZug)) {

					spieler.setAnzahlLeben(spieler.getAnzahlLeben() - 1);

				}
			}
			// Wenn Spieler nicht am Zug, Leben abziehen

			if (!SpielerAmZug.isAufTokyo()) {

				if (!spieler.equals(SpielerAmZug) && spieler.isAufTokyo()) {

					spieler.setAnzahlLeben(spieler.getAnzahlLeben() - 1);
				}
			}
		}

		return spielerListe;
	}

	public static void aufTokyoGehen(Spieler spielerAufTokyo,
			DatenAustausch datenAustausch) {

		ArrayList<Spieler> spielerListe = datenAustausch.getSpielerListe();
		for (Spieler spieler : spielerListe) {

			if (spieler.equals(spielerAufTokyo)) {
				spieler.setAufTokyo(true);
			}
		}

	}

	public static ArrayList<Spieler> lebenBerechnen(
			ArrayList<Spieler> spielerListe) {

		for (Spieler spieler : spielerListe) {
			// Wenn Spieler nicht am Zug, Leben abziehen

			if (spieler.isAmZug()) {

				spieler.setAnzahlLeben(spieler.getAnzahlLeben() + 1);

			}
		}
		return spielerListe;
	}

	public static void ruhmpunkteBerechnen() {

	}

	public static void siegerKueren(Spieler spieler,
			DatenAustausch datenAustausch) {

		datenAustausch
				.setModeration(spieler.getSpielerName() + " hat gewonnen");
	}

	public static void spielerAusschliessen(Spieler spieler) {

	}

	public static void werteListeEvaluieren(DatenAustausch datenAustausch) {

		Wurfel wurfel = datenAustausch.getWuerfel();
		int[] werte = wurfel.getWerte();
		ArrayList<Spieler> spielerListe = datenAustausch.getSpielerListe();

		for (int i : werte) {

			if (i == CONSTANT_TATZE) {
				datenAustausch.setSpielerListe(angreifen(datenAustausch
						.getSpielerListe()));
			}
			if (i == CONSTANT_HERZ) {
				datenAustausch.setSpielerListe(lebenBerechnen(datenAustausch
						.getSpielerListe()));

			}

		}

		for (Spieler spieler : spielerListe) {

			if (spieler.getAnzahlRuhmpunkte() == 20) {
				siegerKueren(spieler, datenAustausch);

			}
		}

	}
}
