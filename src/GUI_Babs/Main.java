package GUI_Babs;
	

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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


public class Main extends Application {

	
	private Label lbModeration;
	private Label lbPunkte1;
	private Label lbPunkte2;
	private Label lbPunkte0;
	private Label lbPunkte3;
	private Label lbSpieler2;
	private Label lbSpieler3;
	private Label lbLeben2;
	private Label lbLeben1;
	private Label lbLeben0;
	private Label lbLeben3;
	private Button btnWuerfeln;
	private Label lbSpieler1;
	private Label lbSpieler0;
	private Button btnSenden;
	private Button btnTokyoVerlassen;
	private Label lbTitel;
	private Scene scene;
	private Button btnWuerfel1;
	private Button btnWuerfel2;
	private Button btnWuerfel3;
	private Button btnWuerfel4;
	private Button btnWuerfel6;
	private Button btnWuerfel5;


	@Override
	public void start(Stage primaryStage) {
		
		// Generierung der Border Pane
		
		BorderPane root = new BorderPane();
	
		
		    HBox hb = new HBox();
		    Button button1 = new Button("Regeln"); // Button Regeln wird erstellt --> HyperLink noch ergänzen
		    button1.setMaxHeight(6);
		    button1.setMaxWidth(70);
		    button1.setFont(Font.font("Arial",FontWeight.BLACK,FontPosture.REGULAR,12));
		    hb.getChildren().addAll(button1);
		 
		    hb.setPadding(new Insets(10,10,10,10));
		    hb.setSpacing(3);
		    VBox vb = new VBox();
		    ImageView image = new ImageView(new Image(getClass().getResourceAsStream("/Images/KingOfTokyo1.jpg"),610,610,true,true));
			vb.getChildren().add(image);
		    vb.setPadding(new Insets(10,10,10,10));
		    vb.setSpacing(10);
		    Button btnTokyoVerlassen  = new Button("Tokyo verlassen");
		    vb.getChildren().add(btnTokyoVerlassen);
		    Label lbModeration = new Label();
		    lbModeration.setAlignment(Pos.CENTER_RIGHT);
		    vb.getChildren().add(lbModeration);
		     
		      // FlowPane mit den 6 Würfel wird estellt und in der Border Pane angeordnet
		      FlowPane fp = new FlowPane();
		      fp.setOrientation(Orientation.VERTICAL);
		      fp.setVgap(4);
		      fp.setHgap(4);
		      fp.setPadding(new Insets(5,30,5,5));
		      Button btnWuerfeln = new Button("Würfeln");
		      
			  fp.getChildren().add(btnWuerfeln);
			  Button btnWuerfel1 = new Button("Würfel1");
			  fp.getChildren().add(btnWuerfel1);
		//    ImageView image2 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Wuerfel_1_hellgruen.jpg"),40,40,true,true));
		   // ImageView image3 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Wuerfel_1_schwarz.jpg"),40,40,true,true));
		      Button btnWuerfel2 = new Button("Würfel2");
		      fp.getChildren().add(btnWuerfel2);
		  //   ImageView image4 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Wuerfel_1_hellgruen.jpg"),40,40,true,true));
		 //     fp.getChildren().add(image4);
		      Button btnWuerfel3 = new Button("Würfel3");
		      fp.getChildren().add(btnWuerfel3);
		 //     ImageView image5 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Wuerfel_1_hellgruen.jpg"),40,40,true,true));
		//      fp.getChildren().add(image5);
		      Button btnWuerfel4 = new Button("Würfel4");
		      fp.getChildren().add(btnWuerfel4);
		 //     ImageView image6 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Wuerfel_1_hellgruen.jpg"),40,40,true,true));
		 //     fp.getChildren().add(image6);
		      Button btnWuerfel5 = new Button("Würfel5");
		      fp.getChildren().add(btnWuerfel5);
		//      ImageView image7 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Wuerfel_1_hellgruen.jpg"),40,40,true,true));
		 //     fp.getChildren().add(image7);	
		      Button btnWuerfel6 = new Button("Würfel6");
		      fp.getChildren().add(btnWuerfel6);
		      
		     
		      // Die ausgewählten Spieler werden angezeigt
		      
		     
			      HBox hb2 = new HBox();
			      hb2.setPadding(new Insets(5,5,5,5));
				  hb2.setSpacing(40);
				  Text TxSpieler = new Text("Spieler");
				  TxSpieler.setFont(Font.font("Arial",FontWeight.BOLD,FontPosture.REGULAR,12));
				  hb2.getChildren().add(TxSpieler);	
				  
				  //Spieler generieren
			      
				  //Spieler 1
				  
				  VBox vb4 = new VBox();
			      ImageView image8 = new ImageView(new Image(getClass().getResourceAsStream("/Images/CyberBunny.jpg"),120,120,true,true));
			      HBox hb5 = new HBox();
			      hb5.setPadding(new Insets(0,0,5,5));
				  hb5.setSpacing(12);
			      ImageView image9 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Herz.jpeg"),30,30,true,true));
			      Label lbLeben0  = new Label();
			      ImageView image10 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Stern.jpg"),30,30,true,true));
			      Label lbPunkte0 = new Label();
			      hb5.getChildren().addAll(image9,lbLeben0,image10,lbPunkte0);
			      vb4.getChildren().addAll(image8,hb5);
			      
			      //Spieler 2
			    
				  VBox vb5 = new VBox();
			      ImageView image11 = new ImageView(new Image(getClass().getResourceAsStream("/Images/GigaZaur.jpg"),120,120,true,true));
			      HBox hb6 = new HBox();
			      hb6.setPadding(new Insets(0,0,5,5));
				  hb6.setSpacing(12);
			      ImageView image12 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Herz.jpeg"),30,30,true,true));
			      Label lbLeben1 = new Label();
			      ImageView image13 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Stern.jpg"),30,30,true,true));
			      Label lbPunkte1 = new Label();
			      hb6.getChildren().addAll(image12,lbLeben1,image13,lbPunkte1);
			      vb5.getChildren().addAll(image11,hb6);
			      
			      //Spieler 3
			      
				  VBox vb6 = new VBox();
			      ImageView imgMakaDragon = new ImageView(new Image(getClass().getResourceAsStream("/Images/MekaDragon.jpg"),120,120,true,true));
			      HBox hb7 = new HBox();
			      hb7.setPadding(new Insets(0,0,5,5));
				  hb7.setSpacing(12);
			      ImageView image15 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Herz.jpeg"),30,30,true,true));
			      Label lbLeben3 = new Label();
			      ImageView image16 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Stern.jpg"),30,30,true,true));
			      Label lbPunkte3 = new Label();
			      hb7.getChildren().addAll(image15,lbLeben3,image16,lbPunkte3);
			      vb6.getChildren().addAll(imgMakaDragon,hb7);
			      
			      //Spieler 4
			      
				  VBox vb7 = new VBox();
			      ImageView imgTheKing = new ImageView(new Image(getClass().getResourceAsStream("/Images/TheKing.jpg"),120,120,true,true));
			      HBox hb8 = new HBox();
			      hb8.setPadding(new Insets(0,0,5,5));
				  hb8.setSpacing(12);
			      ImageView image18 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Herz.jpeg"),30,30,true,true));
			      Label lbLeben4  = new Label();
			      ImageView image19 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Stern.jpg"),30,30,true,true));
			      Label lbPunkte4 = new Label();
			      hb8.getChildren().addAll(image18,lbLeben4,image19,lbPunkte4);
			      vb7.getChildren().addAll(imgTheKing,hb8);
			      
			      hb2.getChildren().addAll(vb4,vb5,vb6,vb7);
			      
			      
			      // Chat --> Rechts ausgerichtet
			      VBox vb2 = new VBox();
			      Text txChat = new Text("Chat");
			     
				  txChat.setFont(Font.font("Arial",FontWeight.NORMAL,FontPosture.REGULAR,14));
			      vb2.setPadding(new Insets(10,10,10,10));
			      vb.setSpacing(20);
			      TextArea taChat = new TextArea();
			      taChat.setPrefWidth(200); 
			      taChat.setPrefHeight(300);
			      TextField tf2Chat = new TextField();
			      Button btnSenden = new Button();
			      btnSenden.setText("Senden");
			      vb2.getChildren().addAll(txChat,taChat,tf2Chat,btnSenden);


					Scene scene = new Scene(root,950,700,Color.WHITE);
					root.setTop(hb);
					root.setLeft(vb);
					root.setCenter(fp);
					root.setBottom(hb2);
					root.setRight(vb2);
				
					scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					primaryStage.setTitle("King of Tokyo");
					primaryStage.setScene(scene);
					primaryStage.setResizable(false);
				
					primaryStage.show();
			 
	     }
			
			
			public Label getLbModeration() {
				return lbModeration;
			}

			public void setLbModeration(Label lbModeration) {
				this.lbModeration = lbModeration;
			}

	//		public Label getLbTokyo() {
	//			return lbTokyo;
	//		}

	//		public void setLbTokyo(Label lbTokyo) {
	//			this.lbTokyo = lbTokyo;
	//		

		//	getBtnWurfeln().setDisable(true);
		//	getBtnTokyoVerlassen().setDisable(true);

			public Scene getScene() {
				Scene scene = null;
				return scene;
			}

			public void setScene(Scene scene) {
				this.scene = scene;
			}

			public Label getLbPunkte0() {
				Label lbPunkte0 = null;
				return lbPunkte0;
			}

			public void setLbPunkte0(Label lbPunkte0) {
				this.lbPunkte0 = lbPunkte0;
			}

			public Label getLbPunkte1() {
				Label lbPunkte1 = null;
				return lbPunkte1;
			}

			public void setLbPunkte1(Label lbPunkte1) {
				this.lbPunkte1 = lbPunkte1;
			}

			public Label getLbPunkte2() {
				Label lbPunkte2 = null;
				return lbPunkte2;
			}

			public void setLbPunkte2(Label lbPunkte2) {
				this.lbPunkte2 = lbPunkte2;
			}

			public Label getLbPunkte3() {
				Label lbPunkte3 = null;
				return lbPunkte3;
			}

			public void setLbPunkte3(Label lbPunkte3) {
				this.lbPunkte3 = lbPunkte3;
			}

			public Label getLbSpieler0() {
			    Label lbSpieler0 = null;
				return lbSpieler0;
			}

			public void setLbSpieler0(Label lbSpieler0) {
				this.lbSpieler0 = lbSpieler0;
			}

			public Label getLbSpieler1() {
				 Label lbSpieler1 = null;
				return lbSpieler1;
			}

			public void setLbSpieler1(Label lbSpieler1) {
				this.lbSpieler1 = lbSpieler1;
			}

			public Label getLbSpieler2() {
				 Label lbSpieler2 = null;
				return lbSpieler2;
			}

			public void setLbSpieler2(Label lbSpieler2) {
				this.lbSpieler2 = lbSpieler2;
			}

			public Label getLbSpieler3() {
				Label lbSpieler3 = null;
				return lbSpieler3;
			}

			public void setLbSpieler3(Label lbSpieler3) {
				this.lbSpieler3 = lbSpieler3;
			}

			public Label getLbLeben0() {
				Label lbLeben0 = null;
				return lbLeben0;
			}

			public void setLbLeben0(Label lbLeben0) {
				this.lbLeben0 = lbLeben0;
			}

			public Label getLbLeben1() {
				Label lbLeben1 = null;
				return lbLeben1;
			}

			public void setLbLeben1(Label lbLeben1) {
				this.lbLeben1 = lbLeben1;
			}

			public Label getLbLeben2() {
				Label lbLeben2 = null;
				return lbLeben2;
			}

			public void setLbLeben2(Label lbLeben2) {
				this.lbLeben2 = lbLeben2;
			}

			public Label getLbLeben3() {
				Label lbLeben3 = null;
				return lbLeben3;
			}

			public void setLbLeben3(Label lbLeben3) {
				this.lbLeben3 = lbLeben3;
			}

			public Label getLbTitel() {
				return getLbTitel();
			}

			public void setLbTitel(Label lbTitel) {
				this.lbTitel = lbTitel;
			}

			public Button getBtnWuerfeln() {
				return btnWuerfeln;
			}

			public void setBtnWuerfeln(Button btnWuerfeln) {
					this.btnWuerfeln = btnWuerfeln;
			
			}

			public Button getBtnWuerfel1() {
				return getBtnWuerfel1();
			}

			public void setBtnWuerfel1(Button btnWuerfel1) {
				this.btnWuerfel1 = btnWuerfel1;	
		
			}

			public Button getBtnWuerfel2() {
				return getBtnWuerfel2();
			}
			public void setBtnWuerfel2(Button btnWuerfel2) {
				this.btnWuerfel2 = btnWuerfel2;
			     
			}

			public Button getBtnWuerfel3() {
			return getBtnWuerfel3();
			}
			public void setBtnWuerfel3(Button btnWuerfel3) {
				this.btnWuerfel3 = btnWuerfel3;
			
			}
			public Button getBtnWuerfel4() {
			     return getBtnWuerfel4();
			}

			public void setBtnWuerfel4(Button btnWuerfel4) {
				this.btnWuerfel4 = btnWuerfel4;
			}

			public Button getBtnWuerfel5() {
				return getBtnWuerfel5();
			}
			public void setBtnWuerfel5(Button btnWuerfel5) {
				this.btnWuerfel5 = btnWuerfel5;
			}

			public Button getBtnWuerfel6() {
				return getBtnWuerfel6();
			}
		    public void setBtnWuerfel6(Button btnWuerfel6) {
						this.btnWuerfel6 = btnWuerfel6;
					}
	

		   public Button getBtnTokyoVerlassen() {
				return getBtnTokyoVerlassen();
				}

			public void setBtnTokyoVerlassen(Button btnTokyoVerlassen) {
				this.btnTokyoVerlassen = btnTokyoVerlassen;
			}
		

			public Button getBtnVerbinden() {
				return btnSenden;
			}

			public void setBtnVerbinden(Button btnSenden) {
				this.btnSenden = btnSenden;
			}


	
	private void setResizable(boolean b) {
		// TODO Auto-generated method stub

	}


	public static void main(String[] args) {
		launch(args);
	}
}
