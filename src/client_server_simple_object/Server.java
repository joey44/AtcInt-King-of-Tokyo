package client_server_simple_object;

import java.io.*;
import java.net.*;

import wuerfel.Wuerfel;

public class Server{

	public static void main(String[] args) {
		try {
			ServerSocket serv = new ServerSocket(55555);
			Socket socket = serv.accept();
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

			

					
			Wuerfel w2 = (Wuerfel) ois.readObject();
			
			System.out.println(w2);

			

			socket.close();
			serv.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}

	}

}
