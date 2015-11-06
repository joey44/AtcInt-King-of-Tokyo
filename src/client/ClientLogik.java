package client;

import java.net.Socket;

import datenaustausch.DatenAustausch;

public class ClientLogik {

	public Socket socket;
	public boolean StopThread;
	public Client client;

	
	public void connect(){};
	public void disconnect(){};
	public void run(){};
	public void sendDaten( DatenAustausch datenAustausch){};
	
	public ClientLogik(Client client) {
		this.client = client;

	}
}
