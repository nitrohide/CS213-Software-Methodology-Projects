package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class DonutOrderController {

    ObservableList<String> donutTypeList = FXCollections.observableArrayList("Yeast Donut", "Cake Donut", "Donut Holes");
    ObservableList<String> yeast_flavorList = FXCollections.observableArrayList("Glazed", "Chocolate Sprinkled", "Vanilla Sprinkled", "Plain");
    ObservableList<String> cake_flavorList = FXCollections.observableArrayList("Blueberry", "Lemon", "Chocolate Glazed", "Vanilla Glazed");
    ObservableList<String> dnthole_flavorList = FXCollections.observableArrayList("Glazed", "Powdered", "Chocolate", "Jelly-filled");
    ObservableList<String> quantityList = FXCollections.observableArrayList("1", "2", "3", "4", "5");

    @FXML
    private Label title;

    @FXML
    private ComboBox selectType;

    @FXML
    private ComboBox selectQuantity;

    @FXML
    private ListView<String> flavorListView;

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

    @FXML
    public void initialize(){
        selectType.setItems(donutTypeList);
        selectQuantity.setItems(quantityList);
        loadListView();
    }

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



}
