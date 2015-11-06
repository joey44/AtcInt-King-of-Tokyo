package client_server_thread_object;
import java.io.*;
import java.net.Socket;

import wuerfel.Wuerfel;

public class Client_05 {

	public static void main(String[] args) {
		try (Socket clientSocket = new Socket("localhost", 44444);
				ObjectOutputStream oos = new ObjectOutputStream(
						clientSocket.getOutputStream());

				ObjectInputStream ois = new ObjectInputStream(
						clientSocket.getInputStream());

		) {

			Wuerfel w1 = new Wuerfel();
			w1.wuerfeln();
			oos.writeObject(w1);

			Wuerfel w2 = (Wuerfel) ois.readObject();
			System.out.println("client: " + w2);

		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
