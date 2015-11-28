package AtcIntClientGUI;

import AtcIntDatenaustausch.DatenAustausch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ClientController{

	private ClientView view;
	private ClientServerVerbindung clientServerVerbindung;

	private DatenAustausch datenAustausch;
	
	private int clientID;

	
	
	public ClientController(ClientView view){
		
		this.view = view;
		
		clientServerVerbindung = new ClientServerVerbindung(this, view);

		view.getBtnWurfeln().setOnAction(new wurfelnEventHandler());
		view.getBtnTokyoVerlassen().setOnAction(new tokyoVerlassenEventHandler());
		view.getBtnVerbinden().setOnAction(new verbindenEventHandler());
		
	}

	public void objectFromServerSetDatenaustausch(DatenAustausch d) {

		this.datenAustausch = d;
		

		//DatenAustausch.setInstanz(d);
		
		//view.getLbModeration().setText(d.getWurfel().toString());
		//updateClientGUI();
	

	}
	


	public void updateClientGUI(DatenAustausch d, int clientID) {

		//DatenAustausch d = this.datenAustausch;
		
		view.getLbModeration().setText("gewürfelt Client:" + clientID);
		
		
			
			view.getLbSpieler0().setText(ClientSpielLogik.spielerName(d, 0));
			view.getLbLeben0().setText(ClientSpielLogik.lebenAnzeigen(d, 0));
			view.getLbPunkte0().setText(ClientSpielLogik.ruhmpunkteAnzeigen(d, 0));
			
		

		

		view.getLbSpieler1().setText(ClientSpielLogik.spielerName(d, 1));
		view.getLbLeben1().setText(ClientSpielLogik.lebenAnzeigen(d, 1));
		view.getLbPunkte1().setText(ClientSpielLogik.ruhmpunkteAnzeigen(d, 1));

		view.getLbSpieler2().setText(ClientSpielLogik.spielerName(d, 2));
		view.getLbLeben2().setText(ClientSpielLogik.lebenAnzeigen(d, 2));
		view.getLbPunkte2().setText(ClientSpielLogik.ruhmpunkteAnzeigen(d, 2));

		view.getLbSpieler3().setText(ClientSpielLogik.spielerName(d, 3));
		view.getLbLeben3().setText(ClientSpielLogik.lebenAnzeigen(d, 3));
		view.getLbPunkte3().setText(ClientSpielLogik.ruhmpunkteAnzeigen(d, 3));

		// view.getLbModeration().setText(ClientSpielLogik.spielModerieren());

		// view.getLbTokyo().setText(ClientSpielLogik.standortAnzeigen());

	}

	public void wurfelWurfeln(DatenAustausch d) {

		//DatenAustausch d = this.datenAustausch;

		d = ClientSpielLogik.wurfelWurfeln(d);
		
		System.out.println(d.getWurfel());
		
		setDatenAustausch(d);

		clientServerVerbindung.sendDatenAustauschToServer(d);

	}

	public int getClientID() {
		return clientServerVerbindung.getClientID();
	}


	class wurfelnEventHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			System.out.println("würflen");

			wurfelWurfeln(getDatenAustausch());
			view.getLbTitel().setText(getDatenAustausch().getWurfel().toString());
			
			//updateClientGUI();
			
			

		}

	}

	class tokyoVerlassenEventHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			System.out.println("tokyoVerlassen");

			//updateClientGUI();
			
			System.out.println(getClientID());

		}

	}

	class verbindenEventHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			System.out.println("verbindenEventHandler");

			clientServerVerbindung.connect();
			
			//	view.getLbModeration().setText("angemeldet Spieler: " + clientID);
			
			
			view.getBtnVerbinden().setDisable(true);
			
			//setClientID();

		}

		

	}
	

	public DatenAustausch getDatenAustausch() {
		return datenAustausch;
	}

	public void setDatenAustausch(DatenAustausch datenAustausch) {
		this.datenAustausch = datenAustausch;
	}


}
