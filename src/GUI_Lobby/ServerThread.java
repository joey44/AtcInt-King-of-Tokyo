package GUI_Lobby;
import java.io.*;
import java.net.Socket;

import AtcIntDatenaustausch.DatenAustausch;

//import AtcIntDatenaustausch.Wurfel;

public class ServerThread extends Thread {

	private Socket socket;
	private String Threadname;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private Server server;


	public ServerThread(Server server, Socket socket, String Threadname) throws Exception {
		this.socket = socket;
		this.Threadname = Threadname;
		this.server = server;

		this.out = new ObjectOutputStream(socket.getOutputStream());
		this.in = new ObjectInputStream(socket.getInputStream());

	}

	public void run() {
		
			listen();
		
	}
	
	public void close() {
		try {
			this.interrupt(); // Thread wird geschlossen			
			socket.close();
		} catch (IOException e) {
		System.out.println(e.getMessage());
		}
	}

	public void listen() {
		DatenAustausch w;
		try {
			while ((w = (DatenAustausch) in.readObject()) != null) { // waiting
				
				server.objectFromClientSetDatenaustausch(w);
				
				//System.out.println(server.getClientlist());
				//this.sendObjekctToClient(w);
				server.broadcast(w);


				//System.out.println("Server: " + w + this.getThreadname());
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void sendObjekctToClient(DatenAustausch w) {
		
		try {
			
			this.out.writeObject(w);
			out.flush();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void sendIDToClient(int clientID) {
		
		try {
			
			this.out.writeObject(clientID);
			out.flush();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	


	public String getThreadname() {
		return Threadname;
	}

	public void setThreadname(String threadname) {
		Threadname = threadname;
	}





	
}
