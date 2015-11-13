package xx_AtcIntWurfel;

import java.io.Serializable;
import java.util.Arrays;

public class CopyWurfel implements Serializable {

	private int[] werte = new int[6];
	private boolean[] isAusgewahlt = new boolean[6];
	private int wCounter = 0;

	@Override
	public String toString() {
		return "Wurfel [werte=" + Arrays.toString(werte) + ", isAusgewahlt="
				+ Arrays.toString(isAusgewahlt) + "]";
	}

	public CopyWurfel() {

	}

	public int[] wuerfeln() {

		if (this.wCounter == 0) {
			for (int i = 0; i < 6; i++) {
				this.werte[i] = (int) (1 + Math.random() * 5);
				this.isAusgewahlt[i] = false;
			}
			this.wCounter++;
		
		} else if (this.wCounter == 1 || this.wCounter == 2) {
			for (int i = 0; i < 6; i++) {
				if (this.isAusgewahlt[i] == false) {
					this.werte[i] = (int) (1 + Math.random() * 5);
				}

			}
			this.wCounter++;
		}
		return werte;

	}


	public void setIsAusgewahlt(int i, boolean wert) {
		this.isAusgewahlt[i] = wert;
		
	}

}
