package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;


public class DonutOrderController {

    ObservableList<String> donutTypeList = FXCollections.observableArrayList("Yeast Donut", "Cake Donut", "Donut Holes");

    @FXML
    private Label title;

    @FXML
    private ComboBox selectType;


    @FXML
    public void initialize(){
        selectType.setItems(donutTypeList);
    }


}
