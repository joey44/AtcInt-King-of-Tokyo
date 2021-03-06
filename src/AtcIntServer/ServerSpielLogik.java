package AtcIntServer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import AtcIntDatenaustausch.DatenAustausch;
import AtcIntDatenaustausch.Spieler;

public class ServerSpielLogik {

	private static final int CONSTANT_TATZE = 5;
	private static final int CONSTANT_HERZ = 4;
	private static boolean isErsteRundeTokyo = true;

	private static void angreifen(int punkte, Spieler angrSpieler) {
		// Methode evaluiert, ob angreifender Spieler auf Tokyo ist/ welche
		// Spieler angreift
		int totCounter = 0;

		ArrayList<Spieler> spielerListe = DatenAustausch.getInstanz().getSpielerListe();

		for (Spieler spieler : spielerListe) {

			if (spieler.isSpielerAktiv()) {
				if (DatenAustausch.getInstanz().getSpielerAufTokyo() == null

				&& spieler.equals(angrSpieler)) {
					DatenAustausch.getInstanz().getSpielerByID(spieler.getSpielerID()).setAufTokyo(true);
					
					DatenAustausch.getInstanz().setModeration(DatenAustausch.getInstanz().getModeration()
							+ "\n" + (spieler.getSpielerName() + " geht auf Tokyo"));
				
					ruhmpunkteBerechnen(1, spieler);
					isErsteRundeTokyo = false;
					return;
				}
			}
		}

		if (angrSpieler.isAufTokyo() && !isErsteRundeTokyo) {
			
			DatenAustausch.getInstanz().setModeration(DatenAustausch.getInstanz().getModeration()
					+ "\n" + ("eine Runde auf Tokyo �berlebt"));
		
			
			// Wenn mind. eine Runde auf Tokyo �berlebt hat
			ruhmpunkteBerechnen(2, angrSpieler);
		}

		for (Spieler spieler : spielerListe) {
			if (spieler.isSpielerAktiv()) {

				if (angrSpieler.isAufTokyo() && !spieler.isAufTokyo()) {
					

					DatenAustausch.getInstanz().getSpielerByID(spieler.getSpielerID())
							.setAnzahlLeben(spieler.getAnzahlLeben() - punkte);

					DatenAustausch.getInstanz().setSpielerAngriffID(angrSpieler.getSpielerID());

				}
				if (!angrSpieler.isAufTokyo() && spieler.isAufTokyo()) {

					DatenAustausch.getInstanz().setSpielerAufTokyoAngegrifen(true);

					DatenAustausch.getInstanz().getSpielerByID(spieler.getSpielerID())
							.setAnzahlLeben(spieler.getAnzahlLeben() - punkte);

					// SpielerID setzen des Angreiffers, f�r das Nachr�cken auf
					// Tokyo
					DatenAustausch.getInstanz().setSpielerAngriffID(angrSpieler.getSpielerID());
				}

				//Spieler ist tot
				if (spieler.getAnzahlLeben() <= 0) {
					
					DatenAustausch.getInstanz().setTotSpielerCounter(DatenAustausch.getInstanz().getTotSpielerCounter() + 1);
					
					totCounter++;
					// && spieler.isAufTokyo()) {

					if (spieler.isAmZug()) {
						int IDcounter = 1;

						int a = spieler.getSpielerID();

						DatenAustausch.getInstanz().getSpielerAmZug().setAmZug(false);

						while (!(DatenAustausch.getInstanz().getSpielerByID((a + IDcounter) % 4).isSpielerAktiv())) {
							IDcounter++;
							if (IDcounter == 3) {
								break;
							}
						}
						DatenAustausch.getInstanz().getSpielerByID((a + IDcounter) % 4).setAmZug(true);

						// DatenAustausch.getInstanz().setModeration(DatenAustausch.getInstanz()
						// .getModeration() + ("Spieler Nr " + a + " wurde
						// get�tet"));

						// if (totCounter >= 2) {
						// // wenn mehrere Spieler in einem Zug get�tet werden
						// DatenAustausch
						// .getInstanz()
						// .setModeration(
						// (DatenAustausch.getInstanz()
						// .getModeration())
						// + (" und Spieler Nr " + a + " wurde get�tet"));
						// }
					}
					DatenAustausch.getInstanz().getSpielerByID(spieler.getSpielerID()).setAnzahlLeben(0);

					DatenAustausch.getInstanz().getSpielerByID(spieler.getSpielerID()).setSpielerAktiv(false);

					if (spieler.isAufTokyo()) {
						DatenAustausch.getInstanz().getSpielerByID(spieler.getSpielerID()).setAufTokyo(false);
						DatenAustausch.getInstanz().getSpielerByID(angrSpieler.getSpielerID()).setAufTokyo(true);
						isErsteRundeTokyo = true;

					}

					DatenAustausch.getInstanz().setModeration(DatenAustausch.getInstanz().getModeration()
							+ "\n" + (spieler.getSpielerName() + " wurde get�tet"));
					
					//checken ob Spieler gewonnen hat
					siegerKueren(angrSpieler);
				}
			}

		}
	}

	public void aufTokyoGehen(Spieler spielerAufTokyo) {
		// Methode setzt Spieler auf Tokyo
		ArrayList<Spieler> spielerListe = DatenAustausch.getInstanz().getSpielerListe();
		for (Spieler spieler : spielerListe) {

			if (spieler.equals(spielerAufTokyo)) {

				DatenAustausch.getInstanz().getSpielerByID(spieler.getSpielerID()).setAufTokyo(true);
				isErsteRundeTokyo = true;

			}
		}

	}

	private static void lebenBerechnen(int punkte, Spieler spielerAmZug) {
		// Addiert dem Spieler Leben
		ArrayList<Spieler> spielerListe = DatenAustausch.getInstanz().getSpielerListe();

		// Ein Monster kann nie mehr als 10 haben

		for (Spieler spieler : spielerListe) {

			if (spieler.equals(spielerAmZug)) {
				DatenAustausch.getInstanz().getSpielerByID(spieler.getSpielerID())
						.setAnzahlLeben(spieler.getAnzahlLeben() + punkte);
				
				DatenAustausch.getInstanz().setModeration(DatenAustausch.getInstanz().getModeration()
						+ "\n" + (spieler.getSpielerName() + " bekommt " + punkte + " Leben"));
				

				// nicht mehr als 10 PUnkte m�glich
				if (spieler.getAnzahlLeben() > 10) {
					DatenAustausch.getInstanz().getSpielerByID(spieler.getSpielerID()).setAnzahlLeben(10);
					
					DatenAustausch.getInstanz().setModeration(DatenAustausch.getInstanz().getModeration()
							+ "\n" + ("Es sind aber maximal 10 Leben m�glich"));

				}
			}
		}
	}

	private static void ruhmpunkteBerechnen(int punkte, Spieler spielerAmZug) {
		// Ruhmpunkte werden dem Spieler addiert und gewinner festgestellt
		ArrayList<Spieler> spielerListe = DatenAustausch.getInstanz().getSpielerListe();

		for (Spieler spieler : spielerListe) {

			if (spieler.equals(spielerAmZug)) {
				DatenAustausch.getInstanz().getSpielerByID(spieler.getSpielerID())
						.setAnzahlRuhmpunkte(spieler.getAnzahlRuhmpunkte() + punkte);
				
				DatenAustausch.getInstanz().setModeration(DatenAustausch.getInstanz().getModeration()
						+ "\n" + (spieler.getSpielerName() + " bekommt " + punkte + " Ruhmpunkte"));
			
				
				//checken ob Spieler gewonnen hat
				if (DatenAustausch.getInstanz().getSpielerByID(spieler.getSpielerID()).getAnzahlRuhmpunkte() >= 20) {
					siegerKueren(spieler);
				}

			}
		}

	}

	private static void siegerKueren(Spieler spieler) {
		
		if (spieler.getAnzahlRuhmpunkte() >= 20 || DatenAustausch.getInstanz().getTotSpielerCounter() == 3){
			
			DatenAustausch.getInstanz().setModeration(DatenAustausch.getInstanz().getModeration() + "\n" + spieler.getSpielerName() + " hat gewonnen");
			
			DatenAustausch.getInstanz().setSpielEnde(true);
			// spielBeenden( );
		}

	
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

			if (i == CONSTANT_HERZ && !spieler.isAufTokyo()) {
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
