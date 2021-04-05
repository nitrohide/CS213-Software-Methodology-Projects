package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


import java.io.IOException;

public class MenuController {

    @FXML
    private Label title;

    @FXML
    private ImageView Donuts;

    @FXML
    private javafx.scene.image.ImageView Coffee;

    @FXML
    private javafx.scene.control.Button orderDonutsButton;

    @FXML
    private void sendtoDonutPage(ActionEvent event ) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("DonutOrder.fxml"));
        Parent root = loader.load();
        DonutOrderController donutOrderController = loader.getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(root,450,300));
        stage.setTitle("Order Donuts");
        stage.show();
    }
}
