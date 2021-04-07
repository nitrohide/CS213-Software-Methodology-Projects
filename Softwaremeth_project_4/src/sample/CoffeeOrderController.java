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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

/**
 * Controller for the coffee ordering page, allows users to order coffee, with choice of addins size and quantity,
 *
 * @author Anuraj Dubey, Chenghao Lin
 */
public class CoffeeOrderController implements Initializable {
    private MenuController mainController;
    private Order order;

    private static final double SHORT_COST = 1.99;
    private static final double TALL_COST = 2.49;
    private static final double GRANDE_COST = 2.99;
    private static final double VENTI_COST = 3.49;

    private static final double ADDIN_COST = 0.20;
    private static final int ONE_COFFEE = 1;
    private static final int TWO_COFFEES = 2;
    private static final int THREE_COFFEES = 3;
    private static final int FOUR_COFFEES = 4;
    private static final int FIVE_COFFEES = 5;

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
     * Populate the selectsize combomenu.
     */
    @FXML
    void populateSize() {
        selectSize.getItems().addAll("Short", "Tall", "Grande", "Venti");
    }

    /**
     * populates the selectquantity combomenu
     */
    @FXML
    void populateQuantity() {
        selectQuantity.getItems().addAll("1", "2", "3", "4", "5");
    }

    /**
     * allows user to add the current coffee selection to be added to the order
     */
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


    /**
     * references the menu controller
     * @param controller of the menu
     */
    public void setMainController(MenuController controller) {
        mainController = controller;
        order = mainController.getOrder();
    }

    /**
     * sets the textfield to the subtotal cost of the current coffee
     */
    private void setSubtotalText() {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setGroupingUsed(true);
        df.setGroupingSize(3);
        df.setMinimumFractionDigits(2);

        String subtotalString = df.format(subtotal);
        subtotalText.setText("$" + subtotalString);
    }

    /**
     * lets the program know when user checks the togglecream checkbox
     * @param actionevent when user checks the cream checkbox
     */
    public void toggleCream(ActionEvent actionevent){
        if (creamCheckbox.isSelected()) {
            boolean creamAdded = true;
            subtotal += ADDIN_COST;
            this.coffee.add("cream");

        }
        else{
            this.coffee.remove("cream");
            boolean creamAdded = false;
            subtotal -= ADDIN_COST;

        }
        setSubtotalText();
    }

    /**
     * lets the program know when the user toggles the milk checkbox
     * @param actionevent when user checks the milk checkbox
     */
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

    /**
     * lets the program know when the user toggles the whippedcream checkbox
     * @param actionevent when the user toggles the whippedcream checkbox
     */
    public void toggleWhippedCream(ActionEvent actionevent){
        if (whippedCreamCheckbox.isSelected()) {
            boolean whippedCreamAdded = true;
            subtotal += ADDIN_COST;
        }
        else{
            boolean whippedCreamAdded = false;
            subtotal -= ADDIN_COST;
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

    /**
     * lets the program know when the user toggles the caramel checkbox
     * @param actionevent when the user toggles the caramel checkbox
     */
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

    /**
     * Sets the size of the coffee being placed
     * @param actionEvent when user picks the size of the drink from the combomenu
     */
    public void setSelectSize(ActionEvent actionEvent){

        subtotal -= currSizeSelection;
        if (selectSize.getValue() == "Short"){
            subtotal += SHORT_COST;
            currSizeSelection = SHORT_COST;
            coffee.setSize("Short");
        }
        else if (selectSize.getValue() == "Tall"){
            subtotal += TALL_COST;
            currSizeSelection = TALL_COST;
            coffee.setSize("Tall");
        }
        else if (selectSize.getValue() == "Grande"){
            subtotal += GRANDE_COST;
            currSizeSelection = GRANDE_COST;
            coffee.setSize("Grande");
        }
        else if (selectSize.getValue() == "Venti"){
            subtotal += VENTI_COST;
            currSizeSelection = VENTI_COST;
            coffee.setSize("Venti");
        }
        setSubtotalText();

    }

    /**
     * sets the quantity of coffees being placed
     */
    public void  setSelectQuantity(){

        if (currQtySelection != 0) subtotal /= currQtySelection;

        if (selectQuantity.getValue() == "1"){
            subtotal *= ONE_COFFEE;
            currQtySelection = ONE_COFFEE;
            coffee.setQuantity(ONE_COFFEE);
        }
        else if (selectQuantity.getValue() == "2"){
            subtotal *= TWO_COFFEES;
            currQtySelection = TWO_COFFEES;
            coffee.setQuantity(TWO_COFFEES);
        }
        else if (selectQuantity.getValue() == "3"){
            subtotal *= THREE_COFFEES;
            currQtySelection = THREE_COFFEES;
            coffee.setQuantity(THREE_COFFEES);
        }
        else if (selectQuantity.getValue() == "4"){
            subtotal *= FOUR_COFFEES;
            currQtySelection = FOUR_COFFEES;
            coffee.setQuantity(FOUR_COFFEES);
        }
        else if (selectQuantity.getValue() == "5"){
            subtotal *= FIVE_COFFEES;
            currQtySelection = FIVE_COFFEES;
            coffee.setQuantity(FIVE_COFFEES);
        }
        setSubtotalText();
    }

    /**
     * intializes the page when the page first loads
     * @param url of path from root
     * @param resourceBundle to localize the root
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populateSize();
        populateQuantity();
        subtotalText.setText(String.valueOf(subtotal));
        setSubtotalText();
    }
}
