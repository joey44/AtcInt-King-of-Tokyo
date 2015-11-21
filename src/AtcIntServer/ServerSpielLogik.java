package AtcIntServer;

import java.sql.Date;
import java.util.ArrayList;

import AtcIntDatenaustausch.DatenAustausch;
import AtcIntDatenaustausch.Spieler;
import AtcIntDatenaustausch.Wurfel;

public class ServerSpielLogik {

	public static final int CONSTANT_TATZE = 5;
	public static final int CONSTANT_HERZ = 4;

	public static void angreifen(Spieler angrSpieler) {

		ArrayList<Spieler> spielerListe = DatenAustausch.getInstanz()
				.getSpielerListe();

		for (Spieler spieler : spielerListe) {

			if (angrSpieler.isAufTokyo() && !spieler.isAufTokyo()) {

				spieler.setAnzahlLeben(spieler.getAnzahlLeben() - 1);
			}

			if (!angrSpieler.isAufTokyo() && spieler.isAufTokyo()) {

				spieler.setAnzahlLeben(spieler.getAnzahlLeben() - 1);
				break;
			}
		}

		DatenAustausch.getInstanz().setSpielerListe(spielerListe);
	}

	public void aufTokyoGehen(Spieler spielerAufTokyo) {

		ArrayList<Spieler> spielerListe = DatenAustausch.getInstanz()
				.getSpielerListe();
		for (Spieler spieler : spielerListe) {

			if (spieler.equals(spielerAufTokyo)) {
				spieler.setAufTokyo(true);
			}
		}

		DatenAustausch.getInstanz().setSpielerListe(spielerListe);
	}

	public static void lebenBerechnen(Spieler spielerAmZug) {

		ArrayList<Spieler> spielerListe = DatenAustausch.getInstanz()
				.getSpielerListe();

		for (Spieler spieler : spielerListe) {
			if (spieler.equals(spielerAmZug)) {

				spieler.setAnzahlLeben(spieler.getAnzahlLeben() + 1);

			}
		}
		DatenAustausch.getInstanz().setSpielerListe(spielerListe);
	}

	public static void ruhmpunkteBerechnen(int punkte, Spieler spielerAmZug) {

		ArrayList<Spieler> spielerListe = DatenAustausch.getInstanz()
				.getSpielerListe();

		for (Spieler spieler : spielerListe) {

			if (spieler.equals(spielerAmZug)) {
				spieler.setAnzahlRuhmpunkte(spieler.getAnzahlRuhmpunkte()
						+ punkte);

				if (spieler.getAnzahlRuhmpunkte() >= 20) {
					siegerKueren(spieler);

				}
				DatenAustausch.getInstanz().setSpielerListe(spielerListe);

			}
		}
	}

	public static void siegerKueren(Spieler spieler) {

		DatenAustausch.getInstanz().setModeration(
				spieler.getSpielerName() + " hat gewonnen");
	}

	public static void spielerAusschliessen(Spieler spieler) {

	}

	public static void werteListeEvaluieren(Spieler spieler) {

		int[] werte = DatenAustausch.getInstanz().getWurfel().getWerte();

		for (int i : werte) {

			if (i == CONSTANT_TATZE) {
				angreifen(spieler);
			}
			if (i == CONSTANT_HERZ) {
				lebenBerechnen(spieler);
			}
			if (i <= CONSTANT_HERZ) {
				ruhmpunkteBerechnen(i, spieler);
			}

		}

	}
}
