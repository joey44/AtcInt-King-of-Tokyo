package AtcIntClient;

import AtcIntDatenaustausch.DatenAustausch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class EventHandlerClient implements EventHandler<ActionEvent> {

	public EventHandlerClient() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle(ActionEvent event) {
		// TODO Auto-generated method stub
		Button x = (Button) event.getSource();
		if ( x.getId() == "wurfeln" ){
		DatenAustausch.getInstanz().wurfeln();
		}
	}

}
