package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * Controller for the donut order page, allows users to place orders for different types of donuts
 *
 * @author Anuraj Dubey, Chenghao Lin
 */
public class DonutOrderController {
    private MenuController menuController;
    private Order order;

    ObservableList<String> donutTypeList = FXCollections.observableArrayList("Yeast Donut", "Cake Donut", "Donut Holes");
    ObservableList<String> yeast_flavorList = FXCollections.observableArrayList("Glazed", "Chocolate Sprinkled", "Vanilla Sprinkled", "Plain");
    ObservableList<String> cake_flavorList = FXCollections.observableArrayList("Blueberry", "Lemon", "Chocolate Glazed", "Vanilla Glazed");
    ObservableList<String> dnthole_flavorList = FXCollections.observableArrayList("Glazed", "Powdered", "Chocolate", "Jelly-filled");
    ObservableList<String> quantityList = FXCollections.observableArrayList("1", "2", "3", "4", "5");
    ObservableList<String> orderList = FXCollections.observableArrayList();

    @FXML
    private Label title;

    @FXML
    private ComboBox selectType;

    @FXML
    private ComboBox selectQuantity;

    @FXML
    private ListView<String> flavorListView;

    @FXML
    private ListView<String> orderListView;

    @FXML
    private Button addItem;

    @FXML
    private Button removeItem;

    @FXML
    private Label subtotal;

    @FXML
    private TextField subtotal_display;

    @FXML
    private Button addToOrder;

    /**
     * initializes the page by filling the donut type list and number of donuts able to purchase
     */
    @FXML
    public void initialize(){
        selectType.setItems(donutTypeList);
        selectQuantity.setItems(quantityList);
        loadListView();
    }

    /**
     * loads the listview with the types of flavors with their respective donuts
     */
    public void loadListView(){

        flavorListView.getItems().removeAll(flavorListView.getItems());

        if (selectType.getValue() == "Yeast Donut") {
            flavorListView.getItems().addAll(yeast_flavorList);
        }
        else if (selectType.getValue() == "Cake Donut"){
            flavorListView.getItems().addAll(cake_flavorList);
        }
        else if (selectType.getValue() == "Donut Holes") {
            flavorListView.getItems().addAll(dnthole_flavorList);
        }

    }

    /**
     * will load the current donut order selected
     */
    public void loadOrderListView() {

        if (flavorListView.getSelectionModel().getSelectedItem() == null){

        }
        else {
            String orderItem = flavorListView.getSelectionModel().getSelectedItem() + "(" + selectQuantity.getValue() + ")";
            orderListView.getItems().add(orderItem);
        }
    }

    /**
     * will remove any donuts that the user wants to remove from order
     */
    public void removeOrderListView(){

        if (orderListView.getSelectionModel().getSelectedItem() == null){

        }
        else {
            String itemtoRemove = orderListView.getSelectionModel().getSelectedItem();
            orderListView.getItems().remove(itemtoRemove);
        }
    }

    /**
     *sets reference to the menu controller
     * @param controller of the main menu
     */
    public void setMainController(MenuController controller) {
        menuController = controller;
        order = menuController.getOrder();
    }

}

