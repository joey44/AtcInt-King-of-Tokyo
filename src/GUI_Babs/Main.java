package GUI_Babs;
	
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
import javafx.event.ActionEvent;


public class Main extends Application {
	Button button1;
	static Label label;
	Image image1;
	
	@Override
	public void start(Stage primaryStage) {
		
		BorderPane root = new BorderPane();
		
		    HBox hb = new HBox();
		    Button button1 = new Button("Regeln");
		    button1.setMaxHeight(6);
		    button1.setMaxWidth(70);
		    button1.setFont(Font.font("Arial",FontWeight.BLACK,FontPosture.REGULAR,12));
		    hb.getChildren().addAll(button1);
		 
		    hb.setPadding(new Insets(10,10,10,10));
		    hb.setSpacing(3);
		    
		    VBox vb = new VBox();
		 
		    ImageView image = new ImageView(new Image(getClass().getResourceAsStream("/Images/KingOfTokyo1.jpg"),600,600,true,true));
			vb.getChildren().add(image);
		     vb.setPadding(new Insets(10,10,10,10));
		     vb.setSpacing(30);
		    	
		     
		     FlowPane fp = new FlowPane();
		      fp.setOrientation(Orientation.VERTICAL);
		      fp.setVgap(5);
		      fp.setHgap(5);
		      Button button2 = new Button("Würfeln");
		      button2.setFont(Font.font("Arial",FontWeight.BLACK,FontPosture.REGULAR,12));
			  fp.getChildren().add(button2);
		      ImageView image2 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Wuerfel_1_hellgruen.jpg"),50,50,true,true));
		      fp.getChildren().add(image2);
		      ImageView image3 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Wuerfel_1_schwarz.jpg"),50,50,true,true));
		      fp.getChildren().add(image3);
		      ImageView image4 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Wuerfel_1_hellgruen.jpg"),50,50,true,true));
		      fp.getChildren().add(image4);
		      ImageView image5 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Wuerfel_1_hellgruen.jpg"),50,50,true,true));
		      fp.getChildren().add(image5);
		      ImageView image6 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Wuerfel_1_hellgruen.jpg"),50,50,true,true));
		      fp.getChildren().add(image6);
		      ImageView image7 = new ImageView(new Image(getClass().getResourceAsStream("/Images/Wuerfel_1_hellgruen.jpg"),50,50,true,true));
		      fp.getChildren().add(image7);	      
		     
			      HBox hb2 = new HBox();
			      hb2.setPadding(new Insets(7,7,7,7));
				  hb2.setSpacing(40);
				  Text text1 = new Text("Spieler");
				     text1.setFont(Font.font("Arial",FontWeight.BOLD,FontPosture.REGULAR,12));
					 hb2.getChildren().add(text1);	
			      ImageView image8 = new ImageView(new Image(getClass().getResourceAsStream("/Images/MekaDragon.jpg"),100,100,true,true));
			      hb2.getChildren().add(image8);
			      ImageView image9 = new ImageView(new Image(getClass().getResourceAsStream("/Images/TheKing.jpg"),100,100,true,true));
			      hb2.getChildren().add(image9);
			      ImageView image10 = new ImageView(new Image(getClass().getResourceAsStream("/Images/CyberBunny.jpg"),100,100,true,true));
			      hb2.getChildren().add(image10);
			      ImageView image11 = new ImageView(new Image(getClass().getResourceAsStream("/Images/GigaZaur.jpg"),100,100,true,true));
			      hb2.getChildren().add(image11);
			      
			
			Scene scene = new Scene(root,800,800,Color.WHITE);
			root.setTop(hb);
			root.setLeft(vb);
			root.setCenter(fp);
			root.setBottom(hb2);
			
	
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("King of Tokyo");
			primaryStage.setScene(scene);
			primaryStage.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
