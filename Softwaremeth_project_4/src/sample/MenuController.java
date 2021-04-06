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
    private Order order = new Order();

    @FXML
    private Label title;

    @FXML
    private ImageView Donuts;

    @FXML
    private ImageView Coffee;

    @FXML
    private Button orderDonutsButton;

    @FXML
    private Button orderCoffeeButton;

    @FXML
    private void sendtoDonutPage(ActionEvent event ) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderingDonuts.fxml"));
        Parent root = loader.load();
        DonutOrderController DonutOrderController = loader.getController();

        Stage stage = new Stage();
        stage.setScene(new Scene(root,450,300));
        stage.setTitle("Order Donuts");
        stage.show();
    }

    @FXML
    private void sendtoCoffeePage(ActionEvent event ) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderingCoffee.fxml"));
        Parent root = loader.load();
        CoffeeOrderController CoffeeOrderController = loader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(root,577,278));
        stage.setTitle("Order Coffee");
        stage.show();
    }

    @FXML
    private void sendtoCurrentOrderPage(ActionEvent event ) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CurrentorderDetail.fxml"));
        Parent root = loader.load();
        CurrentorderDetailController CurrentorderDetailController = loader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(root,600,400));
        stage.setTitle("Your Order");
        stage.show();
    }

    @FXML
    private void sendtoStoreOrdersPage(ActionEvent event ) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("StoreOrders.fxml"));
        Parent root = loader.load();
        StoreOrdersController StoreOrdersController = loader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(root,600,400));
        stage.setTitle("Store Orders");
        stage.show();
    }

    public Order getOrder() {
        return this.order;
    }

}
