package AtcIntClient;
import java.io.*;
import java.net.Socket;

import AtcIntDatenaustausch.DatenAustausch;
import AtcIntDatenaustausch.Wurfel;

public class Test_Client {

	public static void main(String[] args) {
		try (Socket clientSocket = new Socket("localhost", 44444);
				ObjectOutputStream oos = new ObjectOutputStream(
						clientSocket.getOutputStream());

				ObjectInputStream ois = new ObjectInputStream(
						clientSocket.getInputStream());

		) {

			int clientID = (int) ois.readObject();
			DatenAustausch w0 = (DatenAustausch) ois.readObject();
			
			System.out.println("client: " + w0);

			for (int i = 0; i<4; i++){
				DatenAustausch w1 = (DatenAustausch) ois.readObject();
				
				System.out.println("client: " + w1);
			
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
