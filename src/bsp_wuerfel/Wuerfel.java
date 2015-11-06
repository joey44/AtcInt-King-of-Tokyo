package bsp_wuerfel;


import java.io.Serializable;
import java.util.Arrays;

public class Wuerfel implements Serializable{

	private int[] wert = new int[6];

	@Override
	public String toString() {
		return "Wuerfel [wert=" + Arrays.toString(wert) + "]";
	}

	public Wuerfel() {

	}

	public int[] wuerfeln() {
		
		for (int i = 0; i<6; i++ ){
			this.wert[i] = (int) (1 + Math.random() * 5);
		}

		

		return wert;

	}

}
