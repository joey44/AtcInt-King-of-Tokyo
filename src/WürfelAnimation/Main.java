package WürfelAnimation;
	
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.builders.RectangleBuilder;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.scene.transform.*;
import javafx.util.Duration;

public class Main extends Application {
	public static void main(String[] args) {
        launch(args);
    }
 
    public void start (Stage hauptFenster) {
    	
 
		Pane pn = new Pane();
    	pn.setTranslateX(200);
        pn.setTranslateY(200);
     
Box box = new Box(50,50,50);

box.setMaterial(new PhongMaterial(Color.BLUE));
box.getTransforms().add(new Rotate (10,0,0,0, Rotate.X_AXIS)); // Rotation der X-Achse
box.getTransforms().add(new Rotate (10,0,0,0, Rotate.Y_AXIS)); // Rotation der Y-Achse
box.getTransforms().add(new Rotate (10,0,0,0, Rotate.Z_AXIS)); // Roation der Z-Achse
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

RotateTransition rt3 = new RotateTransition(Duration.millis(1000),box);
rt3.setAxis (Rotate.Y_AXIS);
rt3.setToAngle(360);
rt3.setCycleCount(4);
rt3.setAutoReverse(true);
rt3.play();

RotateTransition rt4 = new RotateTransition(Duration.millis(1000),box);
rt4.setAxis (Rotate.Z_AXIS);
rt4.setToAngle(360);
rt4.setCycleCount(4);
rt4.setAutoReverse(true);
rt4.play();


SequentialTransition sq = new SequentialTransition();
sq.getChildren().addAll(tt1,rt2,rt3,rt4);
sq.play();



	
hauptFenster.setTitle("Wuerfeln");
hauptFenster.setScene(new Scene(pn, 500, 400));
hauptFenster.show();
    }
    
}
 




