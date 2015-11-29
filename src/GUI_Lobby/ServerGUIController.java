package GUI_Lobby;

import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;

public class ServerGUIController {
	
	private int port=44444;
	

    @FXML
    private Button CyberBunny;
    
    @FXML
    private Button start;

    @FXML
    private Hyperlink regeln;
    
    @FXML
    private Label labelout;
    
    @FXML
    private Label portLB;

    @FXML
    void MonsterAuswahl(ActionEvent event) {
    	System.out.println("Monster ausgewählt");
    }

    @FXML
    void SpielstartenButtonClicked(ActionEvent event) {
    	start.setText("Spiel gestartet...");
    	start.setDisable(true);
    	
    	
    	try {
			new Server(port).start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	PortNummer();
    	
    }
    
    @FXML
    void PortNummer(){
    	portLB.setText("Port: " + port);
    }

}