package AtcIntClientGUI;

import javafx.application.Application;
import javafx.stage.Stage;

public class MainClient extends Application {

	private ClientView view;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage stage) throws Exception {

		view = new ClientView();

		ClientController c = new ClientController(view);

		view.show(stage);

	}

}
