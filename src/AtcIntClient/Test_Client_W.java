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
			//System.out.println(DatenAustausch.getInstanz());
			
			
			System.out.println("Object from server:" + w1);
			
			ArrayList<Spieler> spielerListe = w1.getSpielerListe();
			//Wurfel wurfel = w1.getWuerfel();
			String moderation = w1.getModeration();
			
			
			
			w1.wurfeln();
			
			
			
			moderation = "Spieler " + clientID + " hat gewürfelt";
			
			w1.setModeration(moderation);
			
			Spieler spielerAmZug = w1.getSpielerByID(clientID);
			
			spielerAmZug.setAmZug(true);
			spielerAmZug.setAufTokyo(true);
			
			System.out.println("am Zug: " + w1.getSpielerAmZug());
			System.out.println("auf Tokyo : " + w1.getSpielerAufTokyo());
			
			System.out.println(spielerAmZug.getAnzahlLeben());
			spielerAmZug.setAnzahlLeben(spielerAmZug.getAnzahlLeben() + 2 );
			System.out.println(spielerAmZug.getAnzahlLeben());
		
			
			w1.setRunde(w1.getRunde()+1);
			int next = w1.getRunde()%4;
			
			Spieler nextSpieler = w1.getSpielerByID(next);
			System.out.println("next Spieler am Zug " + nextSpieler.getSpielerName());
			
			
			nextSpieler.setAmZug(true);
			spielerAmZug.setAmZug(false);
			
			
			
			
			spielerListe.set(clientID, spielerAmZug);
			spielerListe.set(next, nextSpieler);
			
			w1.setSpielerListe(spielerListe);
			
			oos.writeObject(w1);
			
			//DatenAustausch w1 = new DatenAustausch();
			
			for (int i = 0; i<6; i++){
			DatenAustausch w2 = (DatenAustausch) ois.readObject();
			System.out.println("client: "+ clientID + w2);
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
