package client;

import java.util.ArrayList;
import java.util.Random;

public class Wuerfel  {
//singleton
	public int counter;

	private ArrayList<Integer> werteListe = new ArrayList<Integer>();

	public ArrayList<Integer> wuerfeln() {

		Random rand = new Random();

		counter++;

		for (int i = 0; i < 6; i++) {

			werteListe.add(rand.nextInt(6) + 1);
		}

		return werteListe;

	}

	public Wuerfel() {

	}
}