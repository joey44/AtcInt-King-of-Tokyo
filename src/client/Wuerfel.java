package client;

import java.util.ArrayList;
import java.util.Random;

public class Wuerfel {
	// singleton
	public int counter;

	private ArrayList<Integer> werteListe = new ArrayList<Integer>();

	public void wuerfeln() {

		Random rand = new Random();

		counter++;

		if (counter <= 3) {
			for (int i = 0; i < 6; i++) {

				werteListe.add(rand.nextInt(6) + 1);
			}
		}
	}

	public Wuerfel() {

	}
}