package AtcIntServer;
import java.io.*;
import java.net.Socket;

import AtcIntWuerfel.Wurfel;

public class Test_Client {

	public static void main(String[] args) {
		try (Socket clientSocket = new Socket("localhost", 44444);
				ObjectOutputStream oos = new ObjectOutputStream(
						clientSocket.getOutputStream());

				ObjectInputStream ois = new ObjectInputStream(
						clientSocket.getInputStream());

		) {

			//Wuerfel w1 = new Wuerfel();
			//w1.wuerfeln();
			//oos.writeObject(w1);

			for (int i = 0; i<4; i++){
			Wurfel w2 = (Wurfel) ois.readObject();
			System.out.println("client: " + w2);
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
