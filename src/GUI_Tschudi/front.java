package GUI_Tschudi;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class front extends Application {

	public static void main(String[] args) {
		// Startet die JavaFX Anwendung
		launch(args);
	}

	@Override
	// Überschreiben der start()-Methode
	public void start(Stage primaryStage) {

		// Spiel
		Button okButton = new Button("Spiel starten");
		// Positionierung innerhalb Inhalt
		HBox spielen = new HBox(okButton);
		spielen.setAlignment(Pos.CENTER_LEFT);
		spielen.setPadding(new Insets(100));
		spielen.setSpacing(100);

		// Monster Auswahl
		// FlowPane als root node
		// Vertikale und horizontale Abstände = 20 Pixel
		// Länge
		FlowPane rootNode = new FlowPane(20,20);
		// Scene erzeugen
		Scene myScene = new Scene(rootNode);

		Label response;

		// Monsterauswahl mit Fenster verknüpfen
		primaryStage.setScene(myScene);

		// Lebel erzeugen
		response = new Label("Monster wählen");

		// Vier Buttons erzeugen
		Button cb = new Button();
		Image monster1 = new Image(getClass().getResourceAsStream("CyberBunny.jpg"));
		cb.setGraphic(new ImageView(monster1));
			
		Button gz = new Button();
		Image monster2 = new Image(getClass().getResourceAsStream("GigaZaur.jpg"));
		gz.setGraphic(new ImageView(monster2));
		
		Button md = new Button();
		Image monster3 = new Image(getClass().getResourceAsStream("MekaDragon.jpg"));
		md.setGraphic(new ImageView(monster3));
		
		Button tk = new Button();
		Image monster4 = new Image(getClass().getResourceAsStream("TheKing.jpg"));
		tk.setGraphic(new ImageView(monster4));

		// Action event für Monsterauswahl
		cb.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				response.setText("Cyber Bunny ausgewählt");
			}
		});

		gz.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				response.setText("Giga Zaur ausgewählt");
			}
		});

		md.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				response.setText("Meka Dragen ausgewählt");
			}
		});

		tk.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent ae) {
				response.setText("The King ausgewählt");
			}
		});

		// Label und Buttons zum Scene Graph hinzufügen
		rootNode.getChildren().addAll(cb, gz, md, tk, response);

		// Positionierung der Monster innerhalb Inhalt
		HBox monster = new HBox(rootNode);
		monster.setAlignment(Pos.CENTER);
		monster.setPadding(new Insets(100));
		monster.setSpacing(100);

		// Logo King of Tokyo
		Image image = new Image(getClass().getResourceAsStream("Lobby.png"));
		Label rightLabel = new Label("", new ImageView(image));

		// Positionierung innerhalb Inhalt
		HBox logo = new HBox(rightLabel);
		logo.setAlignment(Pos.CENTER_RIGHT);
		logo.setPadding(new Insets(0,200,50,0));

		// Erstellung Positionierung für Inhalte
		BorderPane root = new BorderPane();
		root.setPadding(new Insets(20, 20, 20, 20));

		Label label = new Label("Regeln");
		root.setTop(label);

		Label port = new Label("PortNr: ");
		root.setBottom(port);

		// Positionierung der Inhalte im Fenster
		root.setRight(logo);
		root.setLeft(spielen);
		root.setCenter(monster);

		// Damit die Positionierung ersichtlich wird
		Scene scene = new Scene(root);
		// Titel setzen
		primaryStage.setTitle("Lobby");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
