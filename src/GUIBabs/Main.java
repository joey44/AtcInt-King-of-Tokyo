package GUIBabs;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import javafx.application.Application;
import javafx.stage.Stage;

// Main Klasse Ausführen aller Würfelfunktionalitäten
public class Main extends Application{
	Stage window;
	Button button;
	Scene scene1,scene2;
	private Object checkbox3;
	@Override
	
    
	public void start(Stage primaryStage) throws Exception {
    	
		// Würfel starten
    	window = primaryStage;
    	
    	Button button = new Button(); 	// Konstructor Button
    	button.setText("Würfel werfen");
    	StackPane layout = new StackPane();
    	layout.getChildren().add(button);
    	Scene scene1 = new Scene (layout, 600, 500); // Grösse der Scene definieren
    	primaryStage.setScene(scene1);
    	button.setText("Würfel ausgewählt");
    	button.setOnAction(e -> window.setScene(scene2));
    
    	
 
        // Checkboxen mit Auswahl der Würfelergebnisse auswählen
    	
    	
    	
    	CheckBox checkbox1 = new CheckBox("Würfel 1");
		Image wuerfel1 = new Image(getClass().getResourceAsStream("Wuerfel_2_hellgruen.jpg"));
		checkbox1.setGraphic(new ImageView(wuerfel1));
	
		
		
		CheckBox checkbox2 = new CheckBox("Würfel 2");
		Image wuerfel2 = new Image(getClass().getResourceAsStream("Wuerfel_3_hellgruen.jpg"));
		checkbox2.setGraphic(new ImageView(wuerfel2));
		checkbox2.setOnAction(e -> handleButtonAction(e));
		
		CheckBox checkbox3 = new CheckBox("Würfel 3");
		Image wuerfel3 = new Image(getClass().getResourceAsStream("Wuerfel_3_hellgruen.jpg"));
		checkbox3.setGraphic(new ImageView(wuerfel3));
		checkbox3.setOnAction(e -> handleButtonAction(e));
		
		CheckBox checkbox4 = new CheckBox("Würfel 4");
		Image wuerfel4 = new Image(getClass().getResourceAsStream("Wuerfel_1_schwarz.jpg"));
		checkbox4.setGraphic(new ImageView(wuerfel4));
		checkbox4.setOnAction(e -> handleButtonAction(e));
		
		CheckBox checkbox5 = new CheckBox("Würfel 5");
		Image wuerfel5 = new Image(getClass().getResourceAsStream("Wuerfel_Blitz_schwarz.jpg"));
		checkbox5.setGraphic(new ImageView(wuerfel5));
		checkbox5.setOnAction(e -> handleButtonAction(e));
		
		CheckBox checkbox6 = new CheckBox("Würfel 6");
		Image wuerfel6 = new Image(getClass().getResourceAsStream("Wuerfel_3_schwarz.jpg"));
		checkbox6.setGraphic(new ImageView(wuerfel6));
		checkbox6.setOnAction(e -> handleButtonAction(e));
    	
    	
    	VBox layout2 = new VBox(20);
 
     	layout2.getChildren().addAll(checkbox1,checkbox2,checkbox3,checkbox4,checkbox5,checkbox6);
  
    
   
     	scene2 = new Scene(layout2,600,600);
     	window.setScene(scene1);
     	window.setTitle("Würfelnergebnis auswählen");
    	window.show();
    	
	}
    	
    	private void handleButtonAction (ActionEvent e) {
    		Image img;
    		if(event.getSource == ()) {
    			checkbox1.getImage("wuerfel1");
    		
    		if(checkbox2.isSelected()) {
        		checkbox2.getImage("wuerfel2");	
        			
        	if(checkbox3.isSelected()) {
            	 checkbox3.getImage("wuerfel3");
            	 
            if(checkbox4.isSelected()) {
                checkbox4.getImage("wuerfel4");	
                
            if(checkbox5.isSelected()) {
                checkbox5.getImage("wuerfel5");	
                
            if(checkbox6.isSelected()) {
                 checkbox6.getImage("wuerfel6");	
        			
    }
    
	// Animierter Würfel
    	 
    /*		Pane pn = new Pane();
        	pn.setTranslateX(200);
            pn.setTranslateY(200);
            pn.getChildren().addAll(pn);
            scene2 = new Scene (pn); 

        //    Box box = new Box(50,50,50);
            
/*
    box.setMaterial(new PhongMaterial(Color.BEIGE));
    box.getTransforms().add(new Rotate (10,0,0,0, Rotate.X_AXIS));
    box.getTransforms().add(new Rotate (10,0,0,0, Rotate.Y_AXIS));
    box.getTransforms().add(new Rotate (10,0,0,0, Rotate.Z_AXIS));
    pn.getChildren().add(box);
    
   

    TranslateTransition tt1 = new TranslateTransition (Duration.millis(1000),box);
    tt1.setToX(100);
    tt1.setCycleCount(2);
    tt1.setAutoReverse(true);
    tt1.play();

    RotateTransition rt2 = new RotateTransition(Duration.millis(1000),box);
    rt2.setAxis (Rotate.X_AXIS);
    rt2.setToAngle(360);
    rt2.setCycleCount(4);
    rt2.setAutoReverse(true);
    rt2.play();
    
    // Dritte Rotation um 360 ° und 4 Umdrehungen

    RotateTransition rotation3 = new RotateTransition(Duration.millis(1000),box);
    rotation3.setAxis (Rotate.Y_AXIS);
    rotation3.setToAngle(360);
    rotation3.setCycleCount(4);
    rotation3.setAutoReverse(true);
    rotation3.play();

    RotateTransition rotation4 = new RotateTransition(Duration.millis(1000),box);
    rotation4.setAxis (Rotate.Z_AXIS);
    rotation4.setToAngle(360);
    rotation4.setCycleCount(4);
    rotation4.setAutoReverse(true);
    rotation4.play(); */
	


	public static void main(String[] args) {
		launch(args);
	}
}
