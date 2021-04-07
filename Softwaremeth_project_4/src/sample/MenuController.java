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
/**
 * Controller for the menu javafx file, users can order donuts or coffee, check current order, or all past orders
 *
 * @author Anuraj Dubey, Chenghao Lin
 */
public class MenuController {
    private Order order = new Order();
    private int orderNumber = 0;
    public static StoreOrders storeOrders = new StoreOrders();
    public static boolean orderExist = false;

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

    /**
     * sends the user to the orderingDonuts page to order donuts
     * @param event when user clicks the order donuts button
     * @throws IOException if the order donuts menu does not open
     */
    @FXML
    private void sendtoDonutPage(ActionEvent event ) throws IOException{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderingDonuts.fxml"));
        Parent root = loader.load();
        DonutOrderController DonutOrderController = loader.getController();
        DonutOrderController.setMainController(this);
        Stage stage = new Stage();
        stage.setScene(new Scene(root,450,300));
        stage.setTitle("Order Donuts");
        stage.show();
    }

    /**
     * sends the user to the orderingCoffee page
     * @param event when user clicks the order coffee button
     * @throws IOException if the order coffee menu does not open
     */
    @FXML
    private void sendtoCoffeePage(ActionEvent event ) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OrderingCoffee.fxml"));
        Parent root = loader.load();
        CoffeeOrderController CoffeeOrderController = loader.getController();
        CoffeeOrderController.setMainController(this);
        Stage stage = new Stage();
        stage.setScene(new Scene(root,577,278));
        stage.setTitle("Order Coffee");
        stage.show();
    }

    /**
     * sends the user to the currentorder page where users can see all donuts and coffee orders taken
     * @param event when user clicks my orders button
     * @throws IOException if the window does not open
     */
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

    /**
     *  sends the user to the store orders page where they can view all orders placed
     * @param event when user clicks the store orders button
     * @throws IOException if the window does not open
     */
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

    /**
     * gets the current order that has been taken but not placed
     * @return current order
     */
    public Order getOrder() {
        return this.order;
    }


}
