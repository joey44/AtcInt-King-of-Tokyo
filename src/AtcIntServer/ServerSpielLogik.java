package AtcIntServer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import AtcIntDatenaustausch.DatenAustausch;
import AtcIntDatenaustausch.Spieler;

public class ServerSpielLogik {

	public static final int CONSTANT_TATZE = 5;
	public static final int CONSTANT_HERZ = 4;

	private static void angreifen(int punkte, Spieler angrSpieler) {
		// Methode evaluiert, ob angreifender Spieler auf Tokyo ist/ welche
		// Spieler angreift
		ArrayList<Spieler> spielerListe = DatenAustausch.getInstanz()
				.getSpielerListe();

		for (Spieler spieler : spielerListe) {

			if (DatenAustausch.getInstanz().getSpielerAufTokyo() == null
					&& spieler.equals(angrSpieler)) {
				spieler.setAufTokyo(true);
				angrSpieler.setAufTokyo(true);

			}

			if (angrSpieler.isAufTokyo() && !spieler.isAufTokyo()) {

				spieler.setAnzahlLeben(spieler.getAnzahlLeben() - punkte);
			}

			if (!angrSpieler.isAufTokyo() && spieler.isAufTokyo()) {
				DatenAustausch.getInstanz().setSpielerAufTokyoAngegrifen(true);
				spieler.setAnzahlLeben(spieler.getAnzahlLeben() - punkte);
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

	private static void lebenBerechnen(int punkte, Spieler spielerAmZug) {
		// Addiert dem Spieler Leben
		ArrayList<Spieler> spielerListe = DatenAustausch.getInstanz()
				.getSpielerListe();

		for (Spieler spieler : spielerListe) {
			if (spieler.equals(spielerAmZug)) {

				spieler.setAnzahlLeben(spieler.getAnzahlLeben() + punkte);

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
		int[] lokalWerte = DatenAustausch.getInstanz().getWurfel().getWerte();

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < lokalWerte.length; i++) {

			if (map.containsKey(lokalWerte[i]))
				map.put(lokalWerte[i], map.get(lokalWerte[i]) + 1);
			else
				map.put(lokalWerte[i], 1);
		}

		for (Integer i : map.keySet()) {

			punkte = 0;
			if (i == CONSTANT_HERZ) {
				punkte = map.get(i);
				lebenBerechnen(punkte, spieler);
				continue;
			}

			if (i == CONSTANT_TATZE) {
				punkte = map.get(i);
				angreifen(punkte, spieler);
				continue;
			}

			if (map.get(i) >= 3) {
				punkte = (punkte + i) + (map.get(i) - 3);
				ruhmpunkteBerechnen(punkte, spieler);
			}

		}
	}
}
