package AtcIntClient;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

import AtcIntDatenaustausch.DatenAustausch;
import AtcIntDatenaustausch.Spieler;
import AtcIntDatenaustausch.Wurfel;

public class Test_Client_W {

	public static void main(String[] args) {
		try (Socket clientSocket = new Socket("localhost", 44444);
				ObjectOutputStream oos = new ObjectOutputStream(
						clientSocket.getOutputStream());

				ObjectInputStream ois = new ObjectInputStream(
						clientSocket.getInputStream());

		) {
			
			int clientID = (int) ois.readObject();
			
			DatenAustausch w0 = (DatenAustausch) ois.readObject();
			System.out.println(w0);
			
			DatenAustausch w1 = (DatenAustausch) ois.readObject();
			
			
			
			System.out.println("Object from server:" + w1);
			
			ArrayList<Spieler> spielerListe = w1.getSpielerListe();
			//Wurfel wurfel = w1.getWuerfel();
			String moderation = w1.getModeration();
			
			
			
			w1.wurfeln();
			
			
			
			moderation = "Spieler " + clientID + " hat gew�rfelt";
			
			w1.setModeration(moderation);
			
			Spieler spieler = w1.getSpielerByID(clientID);
			
			System.out.println("am Zug: " + w1.getSpielerAmZug());
			System.out.println("auf Tokyo : " + w1.getSpielerAufTokyo());
			
			System.out.println(spieler.getAnzahlLeben());
			spieler.setAnzahlLeben(spieler.getAnzahlLeben() + 2 );
			System.out.println(spieler.getAnzahlLeben());
			
			spielerListe.set(clientID, spieler);
			
			w1.setSpielerListe(spielerListe);
			
			oos.writeObject(w1);
			
			//DatenAustausch w1 = new DatenAustausch();
			
			for (int i = 0; i<6; i++){
			DatenAustausch w2 = (DatenAustausch) ois.readObject();
			System.out.println("client: " + w2);
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
