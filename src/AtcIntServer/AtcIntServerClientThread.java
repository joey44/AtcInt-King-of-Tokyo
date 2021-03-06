package AtcIntServer;
import java.io.*;
import java.net.Socket;

import AtcIntDatenaustausch.Chat;
import AtcIntDatenaustausch.DatenAustausch;

//import AtcIntDatenaustausch.Wurfel;

public class AtcIntServerClientThread extends Thread {

	private Socket socket;
	private String Threadname;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private AtcIntServer server;


	public AtcIntServerClientThread(AtcIntServer server, Socket socket, String Threadname) throws Exception {
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
		Chat c;
		Object x;
	
		
		try {
			while ((x = in.readObject()) != null) { // waiting
				
				
				
				if(x instanceof DatenAustausch){
					
					w = (DatenAustausch) x;
					
					server.objectFromClientSetDatenaustausch(w);
					server.broadcast(w);
					
					
				}
				
				else if(x instanceof Chat){	
					
				c = (Chat) x;
					
					
					server.broadcastChat(c);


				
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	public void sendObjekctToClient(DatenAustausch w) {
		
		try {
			
			//int a = w.getSpielerListe().size();
			//System.out.println(a);
			
			this.out.writeObject(w);
			out.flush();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void sendChatObjekctToClient(Chat c) {
	try {
				
			this.out.writeObject(c);
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
	
	
	

	
	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	public String getThreadname() {
		return Threadname;
	}

	public void setThreadname(String threadname) {
		Threadname = threadname;
	}

	public ObjectOutputStream getOut() {
		return out;
	}

	public void setOut(ObjectOutputStream out) {
		this.out = out;
	}

	public ObjectInputStream getIn() {
		return in;
	}

	public void setIn(ObjectInputStream in) {
		this.in = in;
	}

	public AtcIntServer getServer() {
		return server;
	}

	public void setServer(AtcIntServer server) {
		this.server = server;
	}


	
	public String toString() {
		return "AtcIntServerClientThread [socket=" + socket + ", Threadname="
				+ Threadname + ", out=" + out + ", in=" + in + ", server="
				+ server + "]";
	}



	
}
