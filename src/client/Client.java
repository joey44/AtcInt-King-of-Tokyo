package client;

public class Client {

	public char IP;
	public String name;
	public char port;

	public void main(String[] args) {

	}

//	public String getNameByIP(char IP) {
//
//		return this.name;
//
//	}

	public Client(char IP, String name, char port, ClientLoginGUI clientLoginGUI) {

		this.IP = IP;
		this.name = name;
		this.port = port;

	}

	public char getIP() {
		return this.IP;
	}

	public void setIP(char iP) {
		this.IP = iP;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getPort() {
		return this.port;
	}

	public void setPort(char port) {
		this.port = port;
	}

}
