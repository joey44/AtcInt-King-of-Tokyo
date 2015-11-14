package AtcIntServer;
import java.io.*;
import java.net.Socket;

import AtcIntDatenaustausch.DatenAustausch;
//import AtcIntDatenaustausch.Wurfel;

public class Test_Client_W {

	public static void main(String[] args) {
		try (Socket clientSocket = new Socket("localhost", 44444);
				ObjectOutputStream oos = new ObjectOutputStream(
						clientSocket.getOutputStream());

				ObjectInputStream ois = new ObjectInputStream(
						clientSocket.getInputStream());

		) {
			
			DatenAustausch w1 = (DatenAustausch) ois.readObject();
			System.out.println("first Object from server:" + w1);
			
			
			
			w1.wurfeln();
			
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
