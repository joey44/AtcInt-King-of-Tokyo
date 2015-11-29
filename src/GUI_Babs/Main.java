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
		    Button button3 = new Button("Tokyo verlassen");
		    vb.getChildren().add(button3);
		    TextField tf = new TextField();
		    tf.setAlignment(Pos.CENTER_RIGHT);
		    vb.getChildren().add(tf);
		     
		      // FlowPane mit den 6 Würfel wird estellt und in der Border Pane angeordnet
		      FlowPane fp = new FlowPane();
		      fp.setOrientation(Orientation.VERTICAL);
		      fp.setVgap(4);
		      fp.setHgap(4);
		      fp.setPadding(new Insets(5,0,5,0));
		      Button button2 = new Button("Würfeln");
		      
			  fp.getChildren().add(button2);
		      ImageView image2 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Wuerfel_1_hellgruen.jpg"),40,40,true,true));
		      fp.getChildren().add(image2);
		      ImageView image3 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Wuerfel_1_schwarz.jpg"),40,40,true,true));
		      fp.getChildren().add(image3);
		      ImageView image4 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Wuerfel_1_hellgruen.jpg"),40,40,true,true));
		      fp.getChildren().add(image4);
		      ImageView image5 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Wuerfel_1_hellgruen.jpg"),40,40,true,true));
		      fp.getChildren().add(image5);
		      ImageView image6 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Wuerfel_1_hellgruen.jpg"),40,40,true,true));
		      fp.getChildren().add(image6);
		      ImageView image7 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Wuerfel_1_hellgruen.jpg"),40,40,true,true));
		      fp.getChildren().add(image7);	
		      
		      
		
		      // Die ausgewählten Spieler werden angezeigt
		      
		     
			      HBox hb2 = new HBox();
			      hb2.setPadding(new Insets(5,5,5,5));
				  hb2.setSpacing(40);
				  Text text1 = new Text("Spieler");
				  text1.setFont(Font.font("Arial",FontWeight.BOLD,FontPosture.REGULAR,12));
				  hb2.getChildren().add(text1);	
				  
				  VBox vb4 = new VBox();
			      ImageView image8 = new ImageView(new Image(getClass().getResourceAsStream("/Images/CyberBunny.jpg"),120,120,true,true));
			      HBox hb5 = new HBox();
			      hb5.setPadding(new Insets(0,0,5,5));
				  hb5.setSpacing(12);
			      ImageView image9 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Herz.jpeg"),30,30,true,true));
			      Label label1 = new Label();
			      ImageView image10 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Stern.jpg"),30,30,true,true));
			      Label label2 = new Label();
			      hb5.getChildren().addAll(image9,label1,image10,label2);
			      vb4.getChildren().addAll(image8,hb5);
			   
			    
				  VBox vb5 = new VBox();
			      ImageView image11 = new ImageView(new Image(getClass().getResourceAsStream("/Images/GigaZaur.jpg"),120,120,true,true));
			      HBox hb6 = new HBox();
			      hb6.setPadding(new Insets(0,0,5,5));
				  hb6.setSpacing(12);
			      ImageView image12 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Herz.jpeg"),30,30,true,true));
			      Label label3 = new Label();
			      ImageView image13 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Stern.jpg"),30,30,true,true));
			      Label label4 = new Label();
			      hb6.getChildren().addAll(image12,label3,image13,label4);
			      vb5.getChildren().addAll(image11,hb6);
			      
				  VBox vb6 = new VBox();
			      ImageView image14 = new ImageView(new Image(getClass().getResourceAsStream("/Images/MekaDragon.jpg"),120,120,true,true));
			      HBox hb7 = new HBox();
			      hb7.setPadding(new Insets(0,0,5,5));
				  hb7.setSpacing(12);
			      ImageView image15 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Herz.jpeg"),30,30,true,true));
			      Label label5 = new Label();
			      ImageView image16 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Stern.jpg"),30,30,true,true));
			      Label label6 = new Label();
			      hb7.getChildren().addAll(image15,label5,image16,label6);
			      vb6.getChildren().addAll(image14,hb7);
			      
				  VBox vb7 = new VBox();
			      ImageView image17 = new ImageView(new Image(getClass().getResourceAsStream("/Images/TheKing.jpg"),120,120,true,true));
			      HBox hb8 = new HBox();
			      hb8.setPadding(new Insets(0,0,5,5));
				  hb8.setSpacing(12);
			      ImageView image18 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Herz.jpeg"),30,30,true,true));
			      Label label7 = new Label();
			      ImageView image19 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Stern.jpg"),30,30,true,true));
			      Label label8 = new Label();
			      hb8.getChildren().addAll(image18,label7,image19,label8);
			      vb7.getChildren().addAll(image17,hb8);
			      
			      hb2.getChildren().addAll(vb4,vb5,vb6,vb7);
			      
			      VBox vb2 = new VBox();
			      Text tx = new Text("Chat");
			     
				  tx.setFont(Font.font("Arial",FontWeight.NORMAL,FontPosture.REGULAR,14));
			      vb2.setPadding(new Insets(10,10,10,10));
			      vb.setSpacing(20);
			      TextArea ta = new TextArea();
			      ta.setPrefWidth(200);
			      ta.setPrefHeight(300);
			      TextField tf2 = new TextField();
			      Button button4 = new Button();
			      button4.setText("senden");
			      vb2.getChildren().addAll(tx,ta,tf2,button4);

		      
			
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
		
	
	private void setResizable(boolean b) {
		// TODO Auto-generated method stub
		
	}


	public static void main(String[] args) {
		launch(args);
	}
}
