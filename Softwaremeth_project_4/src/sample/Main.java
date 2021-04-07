package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Main driver to run the program
 *
 * @author Anuraj Dubey, Chenghao Lin
 */
public class Main extends Application {

    /**
     * Starts application window
     * @param primaryStage is the first stage of the application, the main menu
     * @throws Exception if window does not open for any reason
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        primaryStage.setTitle("RU Café Main Menu");
        primaryStage.setScene(new Scene(root, 392, 429));
        primaryStage.show();
    }

    /**
     * main driver to run sample
     * @param args array of arguments to start program
     */
    public static void main(String[] args) {
        launch(args);
    }
}