package AtcIntServer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;

public class Controller {
	
    @FXML
    private Button CyberBunny;

    @FXML
    private Hyperlink regeln;

    @FXML
    void MonsterAuswahl(ActionEvent event) {
    	System.out.println("Monster ausgewählt");
    }


    @FXML
    void SpielstartenButtonClicked(ActionEvent event) {
    	System.out.println("Spiel wird gestartet...");
    }

}