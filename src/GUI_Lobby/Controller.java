package GUI_Lobby;

import javafx.scene.control.Label;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;

public class Controller {

    @FXML
    private Button CyberBunny;
    
    @FXML
    Button start;

    @FXML
    private Hyperlink regeln;
    
    @FXML
    Label labelout;

    @FXML
    void MonsterAuswahl(ActionEvent event) {
    	System.out.println("Monster ausgewählt");
    }

    @FXML
    void SpielstartenButtonClicked(ActionEvent event) {
    	start.setText("Spiel gestartet...");
    	
    }

}