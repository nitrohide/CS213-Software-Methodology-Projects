package sample;

import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CoffeeOrderController {
    ObservableList<String> sizeList = FXCollections.observableArrayList("Short", "Tall", "Grande", "Venti");
    ObservableList<String> quantityList = FXCollections.observableArrayList("1", "2", "3", "4", "5");

    @FXML
    private ComboBox selectSize;

    @FXML
    private Label title;

    @FXML
    private ComboBox selectQuantity;

    @FXML
    private Label subtotal;

    @FXML
    private Button addToOrder;

    @FXML
    private TextField subtotal_display;

    @FXML
    public void initialize(){
        selectSize.setItems(sizeList);
        selectQuantity.setItems(quantityList);
    }

}
