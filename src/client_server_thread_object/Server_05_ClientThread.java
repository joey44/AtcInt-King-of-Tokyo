package client_server_thread_object;
import java.io.*;
import java.net.Socket;

import wuerfel.Wuerfel;

public class Server_05_ClientThread extends Thread {

	Socket socket;

	ObjectOutputStream out;
	ObjectInputStream in;

	public Server_05_ClientThread(Socket socket) throws Exception {
		this.socket = socket;

		this.out = new ObjectOutputStream(socket.getOutputStream());
		this.in = new ObjectInputStream(socket.getInputStream());

	}

	public void run() {
		listen();
	}

	public void listen() {
		Wuerfel w;
		try {
			while ((w = (Wuerfel) in.readObject()) != null) { // waiting

				System.out.println("server: " + w);
				out.writeObject(w);
			}
		} catch (Exception e) {
		}
	}
}
