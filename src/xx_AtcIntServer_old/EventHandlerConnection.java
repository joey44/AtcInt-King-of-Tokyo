package xx_AtcIntServer_old;

import xx_AtcIntClient_old.Client;
import xx_AtcIntClient_old.ClientLoginGUI;
import xx_AtcIntClient_old.DBLogin;
import xx_AtcIntClient_old.DatenAustausch;

/**
 * @version 1.0
 * @created 05-Nov-2015 23:08:35
 */
public class EventHandlerConnection {

	public Client m_Client;
	public ClientLoginGUI m_ClientLoginGUI;
	public DBLogin m_DBLogin;
	public ClientConnection m_ClientConnection;
	public LobbyLogik m_LobbyLogik;
	public Listener m_Listener;

	public EventHandlerConnection(){

	}

	public void finalize() throws Throwable {

	}
	/**
	 * 
	 * @param ClientGUI
	 */
	public EventHandlerConnection(ClientGUI ClientGUI){

	}

	/**
	 * 
	 * @param ActionEvent
	 */
	public void actionPerformed(ActionEvent ActionEvent){

	}

	/**
	 * 
	 * @param ClientConnection
	 */
	public void addClient(ClientConnection ClientConnection){

	}

	/**
	 * 
	 * @param DatenAustausch
	 */
	public void broadcast(DatenAustausch DatenAustausch){

	}

	/**
	 * 
	 * @param ClientConnection
	 */
	public void removeClient(ClientConnection ClientConnection){

	}

	public void startServer(){

	}

	public void stopServer(){

	}
}//end EventHandlerConnection