package AtcIntServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import AtcIntDatenaustausch.DatenAustausch;
import AtcIntDatenaustausch.SpielerListe;
import AtcIntDatenaustausch.Wurfel;
import AtcIntServer.AtcIntServerClientThread;

public class AtcIntServer {

	private int port;
	private ArrayList<AtcIntServerClientThread> clientlist;
	private int Threadcounter = 0;
	private String Threadname;
	private ServerSocket serverSocket;
	private boolean stopServer = false;


	public AtcIntServer(int port) {
		this.port = port;
		this.clientlist = new ArrayList<AtcIntServerClientThread>();
		DatenAustausch datenAustausch = new DatenAustausch();

	}
	

	public void start() throws Exception {
		serverSocket = new ServerSocket(port);
		while (clientlist.size() <= 3) { // vier Threads sind möglich
			Socket socket = serverSocket.accept();
			this.Threadname = "Thread " + Threadcounter	+ socket.getInetAddress().toString();
			AtcIntServerClientThread clientThread = new AtcIntServerClientThread(this, socket, Threadname);
			clientThread.start();
			clientlist.add(clientThread);
			
			SpielerListe.addSpieler(Threadcounter, Threadname); //Spieler wird erstellt
			
			System.out.println("client added: " + Threadname);
			this.Threadcounter++;
			
			
			
			
		}
	}

	public void stopListening() {
		if (!this.stopServer) {
			this.stopServer = true;
			try {
				if (serverSocket != null) {
					serverSocket.close();
				}
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
	}




	public void broadcast(Wurfel w) {
		for (AtcIntServerClientThread client : clientlist) {
	
			try {
				
				//System.out.println("Server: " + w);
				
				client.sendObjekctToClient(w);
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
	}
	
	
		

	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}


	public ArrayList<AtcIntServerClientThread> getClientlist() {
		return clientlist;
	}


	public void setClientlist(ArrayList<AtcIntServerClientThread> clientlist) {
		this.clientlist = clientlist;
	}


	public int getThreadcounter() {
		return Threadcounter;
	}


	public void setThreadcounter(int threadcounter) {
		Threadcounter = threadcounter;
	}


	public String getThreadname() {
		return Threadname;
	}


	public void setThreadname(String threadname) {
		Threadname = threadname;
	}


	public ServerSocket getServerSocket() {
		return serverSocket;
	}


	public void setServerSocket(ServerSocket serverSocket) {
		this.serverSocket = serverSocket;
	}


	public boolean isStopServer() {
		return stopServer;
	}


	public void setStopServer(boolean stopServer) {
		this.stopServer = stopServer;
	}


	public static void main(String[] args) throws Exception {
		new AtcIntServer(44444).start();
	}
}
