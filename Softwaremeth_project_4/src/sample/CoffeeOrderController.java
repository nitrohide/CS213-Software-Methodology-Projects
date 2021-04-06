package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CoffeeOrderController {

    ObservableList<String> sizeList = FXCollections.observableArrayList("Short", "Tall", "Grande", "Venti");
    ObservableList<String> quantityList = FXCollections.observableArrayList("1", "2", "3", "4", "5");

    @FXML
    private Label title;

    @FXML
    private ComboBox selectSize;

    @FXML
    private ComboBox selectQuantity;

    @FXML
    private Label subtotal;

    @FXML
    private Button addToOrder;

    @FXML
    public void initialize(){
        selectSize.setItems(sizeList);
        selectQuantity.setItems(quantityList);
    }





}
