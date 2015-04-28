package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	
	Label label = new Label("Enter the Password: ");
    Label textField = new Label("");
    
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

//    @Override
//    public void start(Stage primaryStage) throws Exception {
//    	primaryStage.setWidth(400);
//    	primaryStage.setHeight(100);
//        primaryStage.setScene(new Scene(createContent()));
//        primaryStage.show();
//    }
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(createContent(),400,100);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
