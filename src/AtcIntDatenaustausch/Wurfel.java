package AtcIntDatenaustausch;

import java.io.Serializable;
import java.util.Arrays;


public class Wurfel implements Serializable {

	private int[] werte = new int[6];
	private boolean[] isAusgewahlt = new boolean[6];
	private int wCounter = 0;

	
	public String toString() {
		return "Wurfel [werte=" + Arrays.toString(werte) + ", isAusgewahlt="
				+ Arrays.toString(isAusgewahlt) + ", wCounter=" + wCounter
				+ "]";
	}


	public int[] wuerfeln() {

		if (this.wCounter == 0) {
			for (int i = 0; i < 6; i++) {
				this.werte[i] = (int) (1 + Math.random() * 5);
				this.isAusgewahlt[i] = false;
			}
			
		} 
		else if (this.wCounter == 1 || this.wCounter == 2) {
			for (int i = 0; i < 6; i++) {
				if (this.isAusgewahlt[i] == false) {
					this.werte[i] = (int) (1 + Math.random() * 5);
				}

			}
		}
		
		this.wCounter++;
		if (this.wCounter == 3) {
			// nächster Spieler kommt an den Zug
			this.wCounter =0;
		}
		
		return werte;

	}


	public void setIsAusgewahlt(int i, boolean wert) {
		this.isAusgewahlt[i] = wert;
		
	}
}
