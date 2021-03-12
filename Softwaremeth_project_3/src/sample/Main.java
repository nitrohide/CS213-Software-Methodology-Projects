package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage){
        try {
            BorderPane root = FXMLLoader.load(getClass().getResource("view.fxml"));
            Scene scene = new Scene(root, 600, 500);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Payroll Processing");
            primaryStage.show();
        } catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
