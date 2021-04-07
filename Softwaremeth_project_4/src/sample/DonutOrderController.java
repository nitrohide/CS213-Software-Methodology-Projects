package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.text.DecimalFormat;
import java.util.StringTokenizer;


public class DonutOrderController {

    private static final double YEAST_PRICE = 1.39;
    private static final double CAKE_PRICE = 1.59;
    private static final double DONUTHOLE_COST = 0.33;
    private double subtotal = 0;
    private double individual_cost = 0;

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
    private Label subtotalLabel;

    @FXML
    private TextField subtotalText;

    @FXML
    private Button addToOrder;

    @FXML
    public void initialize(){
        selectType.setItems(donutTypeList);
        selectQuantity.setItems(quantityList);
        loadListView();
    }

    private void setSubtotalText() {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setGroupingUsed(true);
        df.setGroupingSize(3);
        df.setMinimumFractionDigits(2);

        String subtotalString = df.format(subtotal);
        subtotalText.setText("$" + subtotalString);
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


    public void loadOrderListView() {



        if (flavorListView.getSelectionModel().getSelectedItem() == null){

        }
        else {
            String orderItem = flavorListView.getSelectionModel().getSelectedItem() + "(" + selectQuantity.getValue() + ")";
            orderListView.getItems().add(orderItem);
        }


        if (selectType.getValue() == "Yeast Donut"){
            individual_cost = YEAST_PRICE;
        }
        else if (selectType.getValue() == "Cake Donut"){
            individual_cost = CAKE_PRICE;
        }
        else if (selectType.getValue() == "Donut Holes"){
            individual_cost = DONUTHOLE_COST;
        }
        individual_cost *= Double.parseDouble((String) selectQuantity.getValue());
        subtotal += individual_cost;
        setSubtotalText();

    }

    public void removeOrderListView(){

        if (orderListView.getSelectionModel().getSelectedItem() == null){

        }
        else {
            String itemtoRemove = orderListView.getSelectionModel().getSelectedItem();
            orderListView.getItems().remove(itemtoRemove);
            subtractFromSubtotal(itemtoRemove);
        }


    }

    public void subtractFromSubtotal(String itemtoRemove){


        double costofType = 0;
        double costToRemove = 0;
        StringTokenizer str = new StringTokenizer(itemtoRemove, "(");
        String token1 = str.nextToken();
        String token2 = str.nextToken();
        double qty = (double) (token2.charAt(0) - '0');



        if (token1.equals("Glazed") || token1.equals("Chocolate Sprinkled") || token1.equals("Vanilla Sprinkled")
                ||token1.equals("Plain")){
            costofType = YEAST_PRICE;

        }
        else if (token1.equals("Blueberry") || token1.equals("Lemon") || token1.equals("Chocolate Glazed")
                ||token1.equals("Vanilla Glazed")){
            costofType = CAKE_PRICE;

        }
        else if (token1.equals("Glazed") || token1.equals("Powdered") || token1.equals("Chocolate")
                ||token1.equals("Jelly-filled")){
            costofType = DONUTHOLE_COST;
        }



        costofType = costofType * qty;
        subtotal = subtotal - costofType;
        setSubtotalText();


    }






}
