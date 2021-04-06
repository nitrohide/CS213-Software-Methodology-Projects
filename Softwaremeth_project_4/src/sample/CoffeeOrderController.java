package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;


public class CoffeeOrderController implements Initializable {
    private MenuController mainController;
    private Order order;
    private static final double MIN_COST = 1.99;
    private static final double SIZE_INCREASE_COST = 0.50;
    private static final double SHORT_COST = 1.99;
    private static final double TALL_COST = 2.49;
    private static final double GRANDE_COST = 2.99;
    private static final double VENTI_COST = 3.49;

    private static final double ADDIN_COST = 0.20;
    private static final double ONE_COFFEE = 1;
    private static final double TWO_COFFEES = 2;
    private static final double THREE_COFFEES = 3;
    private static final double FOUR_COFFEES = 4;
    private static final double FIVE_COFFEES = 5;


    // used to store all the quantity dropdowns
    private ArrayList<ComboBox<String>> addInQuantities = new ArrayList<>();
    private double subtotal = 0;
    private double currSizeSelection = 0;
    private double currQtySelection = 0;
    private Coffee coffee = new Coffee();
    private DecimalFormat df = new DecimalFormat("0.00");

    boolean creamAdded = false;
    boolean milkAdded = false;
    boolean whippedCreamAdded = false;
    boolean syrupAdded = false;
    boolean caramelAdded = false;

    @FXML
    private ComboBox selectSize;

    @FXML
    private ComboBox selectQuantity;

    @FXML
    private TextArea subtotalText;

    @FXML
    private CheckBox creamCheckbox, milkCheckbox, whippedCreamCheckbox, syrupCheckbox, caramelCheckbox;

    @FXML
    private Button addToOrderButton;

    /**
     * Populate the size dropdown.
     */
    @FXML
    void populateSize() {
        selectSize.getItems().addAll("Short", "Tall", "Grande", "Venti");
    }

    @FXML
    void populateQuantity() {
        selectQuantity.getItems().addAll("1", "2", "3", "4", "5");
    }

    @FXML
    void addToOrder() {
        if (subtotal <= 0) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Coffee Selected");
            alert.setHeaderText("You don't have any coffee to be added!");
            alert.setContentText("Please select a coffee first to place an order.");
            alert.showAndWait();
        }
        else {
            order.add(coffee);

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Order Added");
            alert.setHeaderText("Order has been added!");
            alert.setContentText("This window will now close.");
            alert.showAndWait();

            Stage stage = (Stage) addToOrderButton.getScene().getWindow();
            stage.close();
        }
    }

    public void setMainController(MenuController controller) {
        mainController = controller;
        order = mainController.getOrder();
    }

    private void setSubtotalText() {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setGroupingUsed(true);
        df.setGroupingSize(3);
        df.setMinimumFractionDigits(2);

        String subtotalString = df.format(subtotal);
        subtotalText.setText("$" + subtotalString);
    }

    public void toggleCream(ActionEvent actionevent){
        if (creamCheckbox.isSelected()) {
            boolean creamAdded = true;
            subtotal += ADDIN_COST;

        }
        else{
            boolean creamAdded = false;
            subtotal -= ADDIN_COST;

        }
        setSubtotalText();
    }

    public void toggleMilk(ActionEvent actionevent){
        if (milkCheckbox.isSelected()) {
            boolean milkAdded = true;
            subtotal +=ADDIN_COST;
        }
        else{
            boolean milkAdded = false;
            subtotal -=ADDIN_COST;
        }
        setSubtotalText();
    }

    public void toggleWhippedCream(ActionEvent actionevent){
        if (whippedCreamCheckbox.isSelected()) {
            boolean whippedCreamAdded = true;
            subtotal +=ADDIN_COST;
        }
        else{
            boolean whippedCreamAdded = false;
            subtotal -=ADDIN_COST;
        }
        setSubtotalText();
    }
    public void toggleSyrup(ActionEvent actionevent){
        if (syrupCheckbox.isSelected()) {
            boolean syrupAdded = true;
            subtotal += ADDIN_COST;
        }
        else{
            boolean syrupAdded = false;
            subtotal -= ADDIN_COST;
        }
        setSubtotalText();
    }

    public void toggleCaramel(ActionEvent actionevent) {
        if (caramelCheckbox.isSelected()) {
            boolean caramelAdded = true;
            subtotal += ADDIN_COST;
        } else {
            boolean caramelAdded = false;
            subtotal -= ADDIN_COST;
        }
        setSubtotalText();
    }

    public void setSelectSize(ActionEvent actionEvent){

        subtotal -= currSizeSelection;
        if (selectSize.getValue() == "Short"){
            subtotal += SHORT_COST;
            currSizeSelection = SHORT_COST;
        }
        else if (selectSize.getValue() == "Tall"){
            subtotal += TALL_COST;
            currSizeSelection = TALL_COST;
        }
        else if (selectSize.getValue() == "Grande"){
            subtotal += GRANDE_COST;
            currSizeSelection = GRANDE_COST;
        }
        else if (selectSize.getValue() == "Venti"){
            subtotal += VENTI_COST;
            currSizeSelection = VENTI_COST;
        }
        setSubtotalText();

    }

    public void  setSelectQuantity(){

        if (currQtySelection != 0) subtotal /= currQtySelection;

        if (selectQuantity.getValue() == "1"){
            subtotal *= ONE_COFFEE;
            currQtySelection = ONE_COFFEE;
        }
        else if (selectQuantity.getValue() == "2"){
            subtotal *= TWO_COFFEES;
            currQtySelection = TWO_COFFEES;
        }
        else if (selectQuantity.getValue() == "3"){
            subtotal *= THREE_COFFEES;
            currQtySelection = THREE_COFFEES;
        }
        else if (selectQuantity.getValue() == "4"){
            subtotal *= FOUR_COFFEES;
            currQtySelection = FOUR_COFFEES;
        }
        else if (selectQuantity.getValue() == "5"){
            subtotal *= FIVE_COFFEES;
            currQtySelection = FIVE_COFFEES;
        }
        setSubtotalText();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populateSize();
        populateQuantity();
        subtotalText.setText(String.valueOf(subtotal));
        setSubtotalText();
    }
}
