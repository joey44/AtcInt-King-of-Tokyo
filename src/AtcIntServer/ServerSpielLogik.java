package AtcIntServer;

import java.util.ArrayList;
import java.util.Arrays;

import bsp_wuerfel.Wuerfel;
import AtcIntDatenaustausch.DatenAustausch;
import AtcIntDatenaustausch.Spieler;
import AtcIntDatenaustausch.Wurfel;

public class ServerSpielLogik {

	public static final int CONSTANT_TATZE = 5;
	public static final int CONSTANT_HERZ = 4;

	private static void angreifen(Spieler angrSpieler) {
		// Methode evaluiert, ob angreifender Spieler auf Tokyo ist/ welche
		// Spieler angreift
		ArrayList<Spieler> spielerListe = DatenAustausch.getInstanz()
				.getSpielerListe();

		for (Spieler spieler : spielerListe) {

			if (DatenAustausch.getInstanz().getSpielerAufTokyo() == null
					&& spieler.equals(angrSpieler)) {
				spieler.setAufTokyo(true);
				break;
			}

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
		// Methode setzt Spieler auf Tokyo
		ArrayList<Spieler> spielerListe = DatenAustausch.getInstanz()
				.getSpielerListe();
		for (Spieler spieler : spielerListe) {

			if (spieler.equals(spielerAufTokyo)) {
				spieler.setAufTokyo(true);
			}
		}

		DatenAustausch.getInstanz().setSpielerListe(spielerListe);
	}

	private static void lebenBerechnen(Spieler spielerAmZug) {
		// Addiert dem Spieler Leben
		ArrayList<Spieler> spielerListe = DatenAustausch.getInstanz()
				.getSpielerListe();

		for (Spieler spieler : spielerListe) {
			if (spieler.equals(spielerAmZug)) {

				spieler.setAnzahlLeben(spieler.getAnzahlLeben() + 1);

			}
		}
		DatenAustausch.getInstanz().setSpielerListe(spielerListe);
	}

	private static void ruhmpunkteBerechnen(int punkte, Spieler spielerAmZug) {
		// Ruhmpunkte werden dem Spieler addiert und gewinner festgestellt
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

	private static void siegerKueren(Spieler spieler) {

		DatenAustausch.getInstanz().setModeration(
				spieler.getSpielerName() + " hat gewonnen");
		// spielBeenden( );
	}

	public static void spielerAusschliessen(Spieler spieler) {

	}

	public static void werteListeEvaluieren(Spieler spieler) {

		int punkte = 0;
		int[] werte = DatenAustausch.getInstanz().getWurfel().getWerte();
		Arrays.sort(werte);

		for (int j = 0; j < werte.length; j++) {

			if (werte[j] == CONSTANT_TATZE) {
				angreifen(spieler);
				continue;
			}
			if (werte[j] == CONSTANT_HERZ) {
				lebenBerechnen(spieler);
				continue;
			}

			if (j >= 1) {
				if (werte[j] == werte[j - 1]) {

					if (j >= 2) {
						if (werte[j] == werte[j - 2]) {

							punkte = punkte + werte[j];
							ruhmpunkteBerechnen(punkte, spieler);

							if (j >= 3) {
								if (werte[j] == werte[j - 3]) {

									punkte = punkte + 1;
									ruhmpunkteBerechnen(punkte, spieler);

								}
							}
						}

					}
				}
			}
			punkte = 0;
		}
	}
}
