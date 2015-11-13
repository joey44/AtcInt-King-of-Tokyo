package client;

import java.util.ArrayList;

import datenaustausch.DatenAustausch;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ClientSpielLogik clientSpielLogik = new ClientSpielLogik();
		clientSpielLogik.wuerfelWuerfeln();
		Wuerfel wuerfel = DatenAustausch.getWuerfel();
		System.out.println( DatenAustausch.getModeration());

	}

}
