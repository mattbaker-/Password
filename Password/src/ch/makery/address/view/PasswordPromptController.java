package ch.makery.address.view;

import ch.makery.address.MainApp;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PasswordPromptController {
	@FXML
	private Label promptLabel;
	@FXML
	private PasswordField password;
	@FXML
	private Button ok;
	@FXML
	private Button help;
	@FXML
	private Label message;
	
	// Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PasswordPromptController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	message = new Label("");
    }
    
    /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
    }
    
    @FXML
    private void handleOK() {
    	if (!password.getText().equals("bugaboo")) {
            message.setText("Password denied.");
        } else {
            message.setText("Password confimed.");
        }
        password.clear();
    }
    
    @FXML
    private void handleHelp() {
    	message.setText("Help was clicked.");
    }
}
