package bsp_client_server_simple_object;

import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

import bsp_wuerfel.Wuerfel;

public class Client{
	
	public static void main(String[] args) {
		try{
			Socket clientSocket = new Socket("127.0.0.1", 55555);
			ObjectOutputStream oos = new ObjectOutputStream (clientSocket.getOutputStream());
			
			Wuerfel w1 = new Wuerfel();
			w1.wuerfeln();

			
			oos.writeObject(w1);
			oos.flush();
			
			clientSocket.close();
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}

	}

}
