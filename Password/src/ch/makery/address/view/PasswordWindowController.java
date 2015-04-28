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

public class PasswordWindowController {
	@FXML
	private Label pwPrompt;
	@FXML
	private Label pw;
	@FXML
	private Label ok;
	@FXML
	private Label help;
	@FXML
	private Label message;
	
	// Reference to the main application.
    private MainApp mainApp;

    /**
     * The constructor.
     * The constructor is called before the initialize() method.
     */
    public PasswordWindowController() {
    }

    /**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
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
    	if (!pw.getText().equals("bugaboo")) {
            message.setText("Password denied.");
        } else {
            message.setText("Password confimed.");
        }
//        pw.clear();
    }
    
    @FXML
    private void handleHelp() {
    	message.setText("Help was clicked.");
    }
}
