package ch.makery.address;

import java.io.IOException;

import ch.makery.address.view.PasswordPromptController;
import ch.makery.address.view.RootLayoutController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) {

		this.primaryStage = primaryStage;

		initPasswordPrompt();
	}

	public void initPasswordPrompt() {
		try {
			
			// Load password prompt.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/PasswordPrompt.fxml"));
			AnchorPane passwordPrompt = (AnchorPane) loader.load();

			// Set password prompt into the center of the scene.
//			rootLayout.setCenter(passwordWindow);
			Scene scene = new Scene(passwordPrompt);
			primaryStage.setScene(scene);
			
			// Give the controller access to the main app.
			PasswordPromptController controller = loader.getController();
			controller.setMainApp(this);
			
			primaryStage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
