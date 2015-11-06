package bsp_client_server_thread_object;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server_05 {

	int port;

	public Server_05(int port) {
		this.port = port;
	}

	public void start() throws Exception {
		ServerSocket serverSocket = new ServerSocket(port);
		while (true) {
			Socket socket = serverSocket.accept();
			Server_05_ClientThread clientThread = new Server_05_ClientThread(
					socket);
			clientThread.start();
		}
	}

	public static void main(String[] args) throws Exception {
		new Server_05(44444).start();
	}
}
