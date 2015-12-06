package AtcIntClientGUI;

import javax.naming.LinkRef;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ClientView {

	private Scene scene;

	private Label lbPunkte1;
	private Label lbPunkte2;
	private Label lbPunkte0;
	private Label lbPunkte3;

	private Label lbSpieler2;
	private Label lbSpieler3;
	private Label lbSpieler1;
	private Label lbSpieler0;

	private Label lbLeben2;
	private Label lbLeben1;
	private Label lbLeben0;
	private Label lbLeben3;

	// Chat
	private Button btnSenden;
	private TextArea taChat;
	private TextField tf2Chat;

	private Text txChat;

	private Button btnVerbinden;

	private Button btnTokyoVerlassen;
	private TextArea taModeration;
	private Label lbTitel;
	private Label lbTokyo;

	private Hyperlink linkRegeln;

	private Button btnWurfeln;

	private ToggleButton btnWuerfel1;
	private ToggleButton btnWuerfel2;
	private ToggleButton btnWuerfel3;
	private ToggleButton btnWuerfel4;
	private ToggleButton btnWuerfel6;
	private ToggleButton btnWuerfel5;

	private BorderPane root;

	private Image imgWurfel1;
	private Image imgWurfel2;
	private Image imgWurfel3;
	private Image imgWurfel4;
	private Image imgWurfel5;

	public Image getWurfelImage(int i) {
		if (i == 1)
			return imgWurfel1;
		else if (i == 2)
			return imgWurfel2;
		else if (i == 3)
			return imgWurfel3;
		else if (i == 4)
			return imgWurfel4;
		else
			return imgWurfel5;
	}

	public ClientView() {

		imgWurfel1 = new Image("/Images/1.jpg");
		imgWurfel2 = new Image("/Images/2.jpg");
		imgWurfel3 = new Image("/Images/3.jpg");
		imgWurfel4 = new Image("/Images/herz.jpg");
		imgWurfel5 = new Image("/Images/tatze.jpg");

		// Generierung der Border Pane

		root = new BorderPane();

		HBox hb = new HBox();
		linkRegeln = new Hyperlink("Regeln"); // Button Regeln wird erstellt
		// linkRegeln.set // --> HyperLink noch ergÃ¤nzen
		//
		linkRegeln.setMaxHeight(6);
		linkRegeln.setMaxWidth(70);
		// linkRegeln.setFont(Font.font("Arial", FontWeight.BLACK,
		// FontPosture.REGULAR, 12));
		// hb.getChildren().addAll(linkRegeln, lbTitel);
		hb.getChildren().add(linkRegeln);

		hb.setPadding(new Insets(10, 10, 10, 10));
		hb.setSpacing(3);
		VBox vb = new VBox();
		ImageView image = new ImageView(new Image(getClass()
				.getResourceAsStream("/Images/KingOfTokyo1.jpg"), 510, 510,
				true, true));

		taModeration = new TextArea();
		taModeration.setEditable(false);
		taModeration.setWrapText(true);

		btnTokyoVerlassen = new Button("Tokyo verlassen");

		vb.getChildren().addAll(image, btnTokyoVerlassen, taModeration);
		vb.setPadding(new Insets(10, 10, 0, 10));
		vb.setSpacing(0);
		HBox hbox = new HBox(0);
		vb.getChildren().add(hbox);

		btnVerbinden = new Button("Verbinden");
		lbTokyo = new Label("Wer ist auf Tokyo?");
		// hbox.setPadding(Insets.EMPTY);
		// hbox.getChildren().addAll(btnTokyoVerlassen, btnVerbinden, lbTokyo);

		// vb.getChildren().add(taModeration);

		// FlowPane mit den 6 Würfel wird estellt und in der Border Pane
		// angeordnet
		FlowPane fp = new FlowPane();
		fp.setOrientation(Orientation.VERTICAL);
		fp.setVgap(4);
		fp.setHgap(4);
		fp.setPadding(new Insets(5, 30, 5, 5));
		btnWurfeln = new Button("Würfeln");

		fp.getChildren().add(btnWurfeln);
		btnWuerfel1 = new ToggleButton();
		btnWuerfel1.setPadding(Insets.EMPTY);
		btnWuerfel1.getStyleClass().add("wurfel");

		fp.getChildren().add(btnWuerfel1);
		// ImageView image2 = new ImageView(new
		// Image(getClass().getResourceAsStream("/Images/Wuerfel_1_hellgruen.jpg"),40,40,true,true));
		// ImageView image3 = new ImageView(new
		// Image(getClass().getResourceAsStream("/Images/Wuerfel_1_schwarz.jpg"),40,40,true,true));
		btnWuerfel2 = new ToggleButton();
		btnWuerfel2.setPadding(Insets.EMPTY);
		btnWuerfel2.getStyleClass().add("wurfel");
		// btnWuerfel2.setStyle("-fx-border-width: 30px");
		fp.getChildren().add(btnWuerfel2);
		// ImageView image4 = new ImageView(new
		// Image(getClass().getResourceAsStream("/Images/Wuerfel_1_hellgruen.jpg"),40,40,true,true));
		// fp.getChildren().add(image4);
		btnWuerfel3 = new ToggleButton();
		btnWuerfel3.setPadding(Insets.EMPTY);
		btnWuerfel3.getStyleClass().add("wurfel");
		// btnWuerfel3.setStyle("-fx-border-width: 30px");
		fp.getChildren().add(btnWuerfel3);
		// ImageView image5 = new ImageView(new
		// Image(getClass().getResourceAsStream("/Images/Wuerfel_1_hellgruen.jpg"),40,40,true,true));
		// fp.getChildren().add(image5);
		btnWuerfel4 = new ToggleButton();
		btnWuerfel4.setPadding(Insets.EMPTY);
		btnWuerfel4.getStyleClass().add("wurfel");
		// btnWuerfel4.setStyle("-fx-border-width: 30px");
		fp.getChildren().add(btnWuerfel4);
		// ImageView image6 = new ImageView(new
		// Image(getClass().getResourceAsStream("/Images/Wuerfel_1_hellgruen.jpg"),40,40,true,true));
		// fp.getChildren().add(image6);
		btnWuerfel5 = new ToggleButton();
		btnWuerfel5.setPadding(Insets.EMPTY);
		btnWuerfel5.getStyleClass().add("wurfel");
		// btnWuerfel5.setStyle("-fx-border-width: 30px");
		fp.getChildren().add(btnWuerfel5);
		// ImageView image7 = new ImageView(new
		// Image(getClass().getResourceAsStream("/Images/Wuerfel_1_hellgruen.jpg"),40,40,true,true));
		// fp.getChildren().add(image7);
		btnWuerfel6 = new ToggleButton();
		btnWuerfel6.setPadding(Insets.EMPTY);
		btnWuerfel6.getStyleClass().add("wurfel");
		// btnWuerfel6.setStyle("-fx-border-width: 30px");
		fp.getChildren().add(btnWuerfel6);

		// Buttons unter Wurfel
		fp.getChildren().addAll(btnVerbinden, lbTokyo);
		// Die ausgewÃ¤hlten Spieler werden angezeigt

		HBox hb2 = new HBox();
		hb2.setPadding(new Insets(5, 5, 5, 5));
		hb2.setSpacing(40);
		// Text TxSpieler = new Text("Spieler");
		// TxSpieler.setFont(Font.font("Arial", FontWeight.BOLD,
		// FontPosture.REGULAR, 12));
		// hb2.getChildren().add(TxSpieler);

		// Spieler generieren

		// Spieler 1

		VBox vb4 = new VBox();
		ImageView image8 = new ImageView(new Image(getClass()
				.getResourceAsStream("/Images/CyberBunny.jpg"), 120, 120, true,
				true));
		HBox hb5 = new HBox();
		hb5.setPadding(new Insets(0, 0, 5, 5));
		hb5.setSpacing(12);
		ImageView image9 = new ImageView(new Image(getClass()
				.getResourceAsStream("/Images/Herz.jpeg"), 30, 30, true, true));
		lbLeben0 = new Label();
		ImageView image10 = new ImageView(new Image(getClass()
				.getResourceAsStream("/Images/Stern.jpg"), 30, 30, true, true));
		lbPunkte0 = new Label();

		hb5.getChildren().addAll(image9, lbLeben0, image10, lbPunkte0);
		lbSpieler0 = new Label("SpielerName");
		vb4.getChildren().addAll(lbSpieler0, image8, hb5);

		// Spieler 2

		VBox vb5 = new VBox();
		ImageView image11 = new ImageView(new Image(getClass()
				.getResourceAsStream("/Images/GigaZaur.jpg"), 120, 120, true,
				true));
		HBox hb6 = new HBox();
		hb6.setPadding(new Insets(0, 0, 5, 5));
		hb6.setSpacing(12);
		ImageView image12 = new ImageView(new Image(getClass()
				.getResourceAsStream("/Images/Herz.jpeg"), 30, 30, true, true));
		lbLeben1 = new Label();
		ImageView image13 = new ImageView(new Image(getClass()
				.getResourceAsStream("/Images/Stern.jpg"), 30, 30, true, true));
		lbPunkte1 = new Label();
		hb6.getChildren().addAll(image12, lbLeben1, image13, lbPunkte1);
		lbSpieler1 = new Label("SpielerName");
		vb5.getChildren().addAll(lbSpieler1, image11, hb6);

		// Spieler 3

		VBox vb6 = new VBox();
		ImageView imgMakaDragon = new ImageView(new Image(getClass()
				.getResourceAsStream("/Images/MekaDragon.jpg"), 120, 120, true,
				true));
		HBox hb7 = new HBox();
		hb7.setPadding(new Insets(0, 0, 5, 5));
		hb7.setSpacing(12);
		ImageView image15 = new ImageView(new Image(getClass()
				.getResourceAsStream("/Images/Herz.jpeg"), 30, 30, true, true));
		lbLeben2 = new Label();
		ImageView image16 = new ImageView(new Image(getClass()
				.getResourceAsStream("/Images/Stern.jpg"), 30, 30, true, true));
		lbPunkte2 = new Label();
		hb7.getChildren().addAll(image15, lbLeben2, image16, lbPunkte2);
		lbSpieler2 = new Label("SpielerName");
		vb6.getChildren().addAll(lbSpieler2, imgMakaDragon, hb7);

		// Spieler 4

		VBox vb7 = new VBox();
		ImageView imgTheKing = new ImageView(new Image(getClass()
				.getResourceAsStream("/Images/TheKing.jpg"), 120, 120, true,
				true));
		HBox hb8 = new HBox();
		hb8.setPadding(new Insets(0, 0, 5, 5));
		hb8.setSpacing(12);
		ImageView image18 = new ImageView(new Image(getClass()
				.getResourceAsStream("/Images/Herz.jpeg"), 30, 30, true, true));
		lbLeben3 = new Label();
		ImageView image19 = new ImageView(new Image(getClass()
				.getResourceAsStream("/Images/Stern.jpg"), 30, 30, true, true));
		lbPunkte3 = new Label();
		hb8.getChildren().addAll(image18, lbLeben3, image19, lbPunkte3);
		lbSpieler3 = new Label("SpielerName");
		vb7.getChildren().addAll(lbSpieler3, imgTheKing, hb8);

		hb2.getChildren().addAll(vb4, vb5, vb6, vb7);

		// Chat --> Rechts ausgerichtet
		VBox vb2 = new VBox();
		txChat = new Text("Chat");

		txChat.setFont(Font.font("Arial", FontWeight.NORMAL,
				FontPosture.REGULAR, 14));
		vb2.setPadding(new Insets(10, 10, 10, 10));
		vb.setSpacing(20);
		taChat = new TextArea();
		taChat.setScrollLeft(0);
		taChat.setEditable(false);
		taChat.setWrapText(true);
		taChat.setFocusTraversable(false);

		taChat.setPrefWidth(200);
		taChat.setPrefHeight(300);
		tf2Chat = new TextField();
		tf2Chat.setFocusTraversable(true);
		btnSenden = new Button();
		btnSenden.setText("Senden");
		vb2.getChildren().addAll(txChat, taChat, tf2Chat, btnSenden);

		scene = new Scene(root, 950, 650, Color.WHITE);

		scene.getStylesheets().add("style/stylesheet.css");

		root.setTop(hb);
		root.setLeft(vb);
		root.setCenter(fp);
		root.setBottom(hb2);
		root.setRight(vb2);

	}

	public void setModeration(String modText) {

		this.taModeration.appendText("\n" + modText);
	}

	public Label getLbTokyo() {
		return lbTokyo;
	}

	public void setLbTokyo(Label lbTokyo) {
		this.lbTokyo = lbTokyo;
	}

	public void show(Stage stage) {
		stage.setTitle("King of Tokyo");
		stage.setScene(scene);
		stage.show();
		stage.getIcons().add(new Image("/Images/logo.png"));
		// primaryStage.setTitle("King of Tokyo");
		// primaryStage.setScene(scene);
		stage.setResizable(false);

		// primaryStage.show();

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

	public Button getBtnSenden() {
		return btnSenden;
	}

	public void setBtnSenden(Button btnSenden) {
		this.btnSenden = btnSenden;
	}

	public Text getTxChat() {
		return txChat;
	}

	public void setTxChat(Text txChat) {
		this.txChat = txChat;
	}

	// public Button getBtnRegeln() {
	// return btnRegeln;
	// }
	//
	// public void setBtnRegeln(Button btnRegeln) {
	// this.btnRegeln = btnRegeln;
	// }

	public ToggleButton getBtnWuerfel1() {
		return btnWuerfel1;
	}

	public void setBtnWuerfel1(ToggleButton btnWuerfel1) {
		this.btnWuerfel1 = btnWuerfel1;
	}

	public ToggleButton getBtnWuerfel2() {
		return btnWuerfel2;
	}

	public void setBtnWuerfel2(ToggleButton btnWuerfel2) {
		this.btnWuerfel2 = btnWuerfel2;
	}

	public ToggleButton getBtnWuerfel3() {
		return btnWuerfel3;
	}

	public void setBtnWuerfel3(ToggleButton btnWuerfel3) {
		this.btnWuerfel3 = btnWuerfel3;
	}

	public ToggleButton getBtnWuerfel4() {
		return btnWuerfel4;
	}

	public void setBtnWuerfel4(ToggleButton btnWuerfel4) {
		this.btnWuerfel4 = btnWuerfel4;
	}

	public ToggleButton getBtnWuerfel6() {
		return btnWuerfel6;
	}

	public void setBtnWuerfel6(ToggleButton btnWuerfel6) {
		this.btnWuerfel6 = btnWuerfel6;
	}

	public ToggleButton getBtnWuerfel5() {
		return btnWuerfel5;
	}

	public void setBtnWuerfel5(ToggleButton btnWuerfel5) {
		this.btnWuerfel5 = btnWuerfel5;
	}

	public TextArea getTaChat() {
		return taChat;
	}

	public void setTaChat(TextArea taChat) {
		this.taChat = taChat;
	}

	public TextField getTf2Chat() {
		return tf2Chat;
	}

	public void setTf2Chat(TextField tf2Chat) {
		this.tf2Chat = tf2Chat;
	}

	public TextArea getTaModeration() {
		return taModeration;
	}

	public void setTaModeration(TextArea taModeration) {
		this.taModeration = taModeration;
	}

}
