package AtcIntClientGUI;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClientView {
	
	private Scene scene;
	
	private Label lbPunkte0;
	private Label lbPunkte1;
	private Label lbPunkte2;
	private Label lbPunkte3;
	
	private Label lbSpieler0;
	private Label lbSpieler1;
	private Label lbSpieler2;
	private Label lbSpieler3;
	
	private Label lbLeben0;
	private Label lbLeben1;
	private Label lbLeben2;
	private Label lbLeben3;
	
	private Label lbTitel;
	private Label lbModeration;
	private Label lbTokyo;
	
	
	private Button btnWurfeln;
	private Button btnTokyoVerlassen;
	private Button btnVerbinden;
	
	public ClientView(){
		
	
	lbSpieler1 = new Label("Spieler 1");
	lbPunkte1 = new Label("Punkte");
	lbLeben1 = new Label("Leben");
	
	lbSpieler2 = new Label("Spieler 2");
	lbPunkte2 = new Label("Punkte");
	lbLeben2 = new Label("Leben");
	
	lbSpieler3 = new Label("Spieler 3");
	lbPunkte3 = new Label("Punkte");
	lbLeben3 = new Label("Leben");
	
	lbSpieler0 = new Label("Spieler 0");
	lbPunkte0 = new Label("Punkte");
	lbLeben0 = new Label("Leben");
	
	lbTitel = new Label ("King of Tokyo");
	lbModeration = new Label ("King of Tokyo");
	lbTokyo = new Label ("King of Tokyo");
	
	
	btnWurfeln = new Button("würfeln");
	btnTokyoVerlassen = new Button ("Tokyo verlassen / GuI update");
	btnVerbinden = new Button("verbinden");
	
	getBtnWurfeln().setDisable(true);
	getBtnTokyoVerlassen().setDisable(true);
	
	btnVerbinden.setDefaultButton(true);
	
	VBox root = new VBox();
	root.getChildren().addAll(lbTitel, lbModeration, lbTokyo,
			lbSpieler0, lbLeben0, lbPunkte0,
			lbSpieler1, lbLeben1, lbPunkte1,
			lbSpieler2, lbLeben2, lbPunkte2,
			lbSpieler3, lbLeben3, lbPunkte3,
			
			btnWurfeln, btnTokyoVerlassen,btnVerbinden);

	
	scene = new Scene(root, 500, 500);
	
	
	//stage.setScene(scene);
	
	//scene = stage.show();
	
	}
	
	public Label getLbModeration() {
		return lbModeration;
	}

	public void setLbModeration(Label lbModeration) {
		this.lbModeration = lbModeration;
	}

	public Label getLbTokyo() {
		return lbTokyo;
	}

	public void setLbTokyo(Label lbTokyo) {
		this.lbTokyo = lbTokyo;
	}

	public void show (Stage stage){
		stage.setTitle("King of Tokyo");
		stage.setScene(scene);
		stage.show();
		
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public Label getLbPunkte0() {
		return lbPunkte0;
	}

	public void setLbPunkte0(Label lbPunkte0) {
		this.lbPunkte0 = lbPunkte0;
	}

	public Label getLbPunkte1() {
		return lbPunkte1;
	}

	public void setLbPunkte1(Label lbPunkte1) {
		this.lbPunkte1 = lbPunkte1;
	}

	public Label getLbPunkte2() {
		return lbPunkte2;
	}

	public void setLbPunkte2(Label lbPunkte2) {
		this.lbPunkte2 = lbPunkte2;
	}

	public Label getLbPunkte3() {
		return lbPunkte3;
	}

	public void setLbPunkte3(Label lbPunkte3) {
		this.lbPunkte3 = lbPunkte3;
	}

	public Label getLbSpieler0() {
		return lbSpieler0;
	}

	public void setLbSpieler0(Label lbSpieler0) {
		this.lbSpieler0 = lbSpieler0;
	}

	public Label getLbSpieler1() {
		return lbSpieler1;
	}

	public void setLbSpieler1(Label lbSpieler1) {
		this.lbSpieler1 = lbSpieler1;
	}

	public Label getLbSpieler2() {
		return lbSpieler2;
	}

	public void setLbSpieler2(Label lbSpieler2) {
		this.lbSpieler2 = lbSpieler2;
	}

	public Label getLbSpieler3() {
		return lbSpieler3;
	}

	public void setLbSpieler3(Label lbSpieler3) {
		this.lbSpieler3 = lbSpieler3;
	}

	public Label getLbLeben0() {
		return lbLeben0;
	}

	public void setLbLeben0(Label lbLeben0) {
		this.lbLeben0 = lbLeben0;
	}

	public Label getLbLeben1() {
		return lbLeben1;
	}

	public void setLbLeben1(Label lbLeben1) {
		this.lbLeben1 = lbLeben1;
	}

	public Label getLbLeben2() {
		return lbLeben2;
	}

	public void setLbLeben2(Label lbLeben2) {
		this.lbLeben2 = lbLeben2;
	}

	public Label getLbLeben3() {
		return lbLeben3;
	}

	public void setLbLeben3(Label lbLeben3) {
		this.lbLeben3 = lbLeben3;
	}

	public Label getLbTitel() {
		return lbTitel;
	}

	public void setLbTitel(Label lbTitel) {
		this.lbTitel = lbTitel;
	}

	public Button getBtnWurfeln() {
		return btnWurfeln;
	}

	public void setBtnWurfeln(Button btnWurfeln) {
		this.btnWurfeln = btnWurfeln;
	}

	public Button getBtnTokyoVerlassen() {
		return btnTokyoVerlassen;
	}

	public void setBtnTokyoVerlassen(Button btnTokyoVerlassen) {
		this.btnTokyoVerlassen = btnTokyoVerlassen;
	}

	public Button getBtnVerbinden() {
		return btnVerbinden;
	}

	public void setBtnVerbinden(Button btnVerbinden) {
		this.btnVerbinden = btnVerbinden;
	}
	
	

}
