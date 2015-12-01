package AtcIntClientGUI;

import AtcIntDatenaustausch.DatenAustausch;
import AtcIntDatenaustausch.Spieler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ClientController {

	private ClientView view;
	private ClientServerVerbindung clientServerVerbindung;

	private DatenAustausch datenAustausch;

	private int clientID;

	public ClientController(ClientView view) {

		this.view = view;

		clientServerVerbindung = new ClientServerVerbindung(this, view);

		view.getBtnWurfeln().setOnAction(new wurfelnEventHandler());

		view.getBtnWuerfel1().setOnAction(new wurfeln1AuswahlEventHandler());
		view.getBtnWuerfel2().setOnAction(new wurfeln2AuswahlEventHandler());
		view.getBtnWuerfel3().setOnAction(new wurfeln3AuswahlEventHandler());
		view.getBtnWuerfel4().setOnAction(new wurfeln4AuswahlEventHandler());
		view.getBtnWuerfel5().setOnAction(new wurfeln5AuswahlEventHandler());
		view.getBtnWuerfel6().setOnAction(new wurfeln6AuswahlEventHandler());

		view.getBtnTokyoVerlassen().setOnAction(
				new tokyoVerlassenEventHandler());
		view.getBtnVerbinden().setOnAction(new verbindenEventHandler());

		view.getBtnWurfeln().setDisable(true);
		view.getBtnTokyoVerlassen().setDisable(true);

		view.getBtnVerbinden().setDefaultButton(true);

	}

	public void objectFromServerSetDatenaustausch(DatenAustausch d) {

		this.datenAustausch = d;

		// DatenAustausch.setInstanz(d);

		// view.getLbModeration().setText(d.getWurfel().toString());
		// updateClientGUI();

	}

	public void updateClientGUI(DatenAustausch d, int clientID) {

		// DatenAustausch d = this.datenAustausch;

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

		view.getLbModeration().setText(ClientSpielLogik.spielModerieren(d));

		view.getLbTokyo().setText(ClientSpielLogik.standortAnzeigen(d));

		view.getBtnWurfeln().setDisable(true);
		view.getBtnTokyoVerlassen().setDisable(true);

		if (getClientID() == d.getSpielerAmZug().getSpielerID()) {
			view.getBtnWurfeln().setDisable(false);

		}

		if (getClientID() == d.getSpielerAufTokyo().getSpielerID()) {
			view.getBtnTokyoVerlassen().setDisable(false);

		}

		else if (d.getSpielerAufTokyo() == null) {
			System.out.println("kein Spieler ist auf Tokyo");
			view.getBtnTokyoVerlassen().setDisable(true);
		}

		view.getBtnWuerfel1().setSelected(d.getWurfelIsAusgewahlt(0));
		view.getBtnWuerfel2().setSelected(d.getWurfelIsAusgewahlt(1));
		view.getBtnWuerfel3().setSelected(d.getWurfelIsAusgewahlt(2));
		view.getBtnWuerfel4().setSelected(d.getWurfelIsAusgewahlt(3));
		view.getBtnWuerfel5().setSelected(d.getWurfelIsAusgewahlt(4));
		view.getBtnWuerfel6().setSelected(d.getWurfelIsAusgewahlt(5));

		view.getBtnWuerfel1().setText(d.getWurfel().getWert(0) + "");
		view.getBtnWuerfel2().setText(d.getWurfel().getWert(1) + "");
		view.getBtnWuerfel3().setText(d.getWurfel().getWert(2) + "");
		view.getBtnWuerfel4().setText(d.getWurfel().getWert(3) + "");
		view.getBtnWuerfel5().setText(d.getWurfel().getWert(4) + "");
		view.getBtnWuerfel6().setText(d.getWurfel().getWert(5) + "");

	}

	public void wurfelWurfeln() {

		DatenAustausch d = getDatenAustausch();

		d = ClientSpielLogik.wurfelWurfeln(d);

		setDatenAustausch(d);

		clientServerVerbindung.sendDatenAustauschToServer(d);

		updateClientGUI(getDatenAustausch(), getClientID());

	}

	public void wurfelAuswahl(int w) {

		getDatenAustausch().setWurfelIsAusgewahlt(w);

	}

	public void tokyoVerlasse() {

		Spieler s = getDatenAustausch().getSpielerByID(getClientID());

		s.setAufTokyo(false);

		getDatenAustausch().setSpielerByID(clientID, s);

		getDatenAustausch().setModeration(
				"Spieler " + getClientID() + " hat Tokyo verlassen");

		System.out.println("Spieler " + getClientID() + "Tokyo verlassen");

		clientServerVerbindung.sendDatenAustauschToServer(getDatenAustausch());

	}

	public int getClientID() {
		return clientServerVerbindung.getClientID();
	}

	class wurfelnEventHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			System.out.println("würflen");

			wurfelWurfeln();

		}

	}

	class wurfeln1AuswahlEventHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			System.out.println("würflenAuswahl1");

			int wID = 1;

			wurfelAuswahl(wID - 1);

		}

	}

	class wurfeln2AuswahlEventHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			System.out.println("würflenAuswahl2");

			int wID = 2;

			wurfelAuswahl(wID - 1);

		}

	}
	
	class wurfeln3AuswahlEventHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			System.out.println("würflenAuswahl2");

			int wID = 3;

			wurfelAuswahl(wID - 1);

		}

	}
	
	class wurfeln4AuswahlEventHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			System.out.println("würflenAuswahl2");

			int wID = 4;

			wurfelAuswahl(wID - 1);

		}

	}
	
	class wurfeln5AuswahlEventHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			System.out.println("würflenAuswahl2");

			int wID = 5;

			wurfelAuswahl(wID - 1);

		}

	}
	
	class wurfeln6AuswahlEventHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			System.out.println("würflenAuswahl2");

			int wID = 6;

			wurfelAuswahl(wID - 1);

		}

	}
		

	class tokyoVerlassenEventHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			System.out.println("tokyoVerlassen");

			tokyoVerlasse();

		}

	}

	class verbindenEventHandler implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {

			System.out.println("verbindenEventHandler");

			clientServerVerbindung.connect();

			view.getBtnVerbinden().setDisable(true);

			view.getLbModeration().setText("warten auf Spiel start");

		}

	}

	public DatenAustausch getDatenAustausch() {
		return datenAustausch;
	}

	public void setDatenAustausch(DatenAustausch datenAustausch) {
		this.datenAustausch = datenAustausch;
	}

}
