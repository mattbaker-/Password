package ch.makery.address;

import java.io.IOException;

import ch.makery.address.view.PasswordWindowController;
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
		
//		Scene scene = new Scene(createContent(), 400, 100);
//		primaryStage.setScene(scene);
//		primaryStage.show();
		
		this.primaryStage = primaryStage;
		
		initLayout();
		
		showPasswordWindow();
	}
	
public Parent createContent() {
    	
        final Label message = new Label("");
        message.setAlignment(Pos.CENTER);
        
        VBox vb = new VBox();
//        vb.setPadding(new Insets(10, 0, 0, 10));
        vb.setSpacing(10);
        vb.setAlignment(Pos.CENTER);
        
        HBox hb = new HBox();
        hb.setSpacing(10);
        hb.setAlignment(Pos.CENTER);
        
        VBox vb2 = new VBox();
        vb.setSpacing(10);
        
        Label label = new Label("Enter the password: ");
        final PasswordField pw = new PasswordField();
        
        Button b1 = new Button("Okay");
        b1.setAlignment(Pos.TOP_CENTER);
        
        Button b2 = new Button("Help");
        b2.setAlignment(Pos.BOTTOM_CENTER);
        
        b1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (!pw.getText().equals("bugaboo")) {
                    message.setText("Password denied.");
                } else {
                    message.setText("Password confirmed.");
                }
                pw.clear();
            }
        });
        
        b2.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent e) {
        		message.setText("Help was clicked.");
        	}
        });
        
        vb2.getChildren().addAll(b1, b2);
        hb.getChildren().addAll(label, pw, vb2);
        vb.getChildren().addAll(hb, message);
        return vb;
    }
	
	public void initLayout() {
		try {
            
	            //Load root layout from fxml file.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
	            rootLayout = (BorderPane) loader.load();
	            
	            // Show the scene containing the root layout.
	            Scene scene = new Scene(rootLayout);
	            primaryStage.setScene(scene);
	            
	            // Give the controller access to the main app.
	            RootLayoutController controller = loader.getController();
	            controller.setMainApp(this);

	            primaryStage.show();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	public void showPasswordWindow() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PasswordWindow.fxml"));
            AnchorPane passwordWindow = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(passwordWindow);

            // Give the controller access to the main app.
            PasswordWindowController controller = loader.getController();
            controller.setMainApp(this);

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
