package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class Controller {

    @FXML
    private RadioButton csButton;

    @FXML
    private ToggleGroup departmentGroup;

    @FXML
    private RadioButton itButton;

    @FXML
    private RadioButton eceButton;

    @FXML
    private DatePicker dateInput;

    @FXML
    private RadioButton fulltimeButton;

    @FXML
    private ToggleGroup employeeGroup;

    @FXML
    private RadioButton parttimeButton;

    @FXML
    private RadioButton managementButton;

    @FXML
    private TextField salaryInput;

    @FXML
    private TextField hoursInput;

    @FXML
    private TextField rateInput;

    @FXML
    private RadioButton managerButton;

    @FXML
    private ToggleGroup roleGroup;

    @FXML
    private RadioButton deptHeadButton;

    @FXML
    private RadioButton directorButton;

    @FXML
    private TextField nameInput;

    @FXML
    private Button clearButton;

    @FXML
    private Button addButton;

    @FXML
    private Button removeButton;

    @FXML
    private Button setHoursButton;

    @FXML
    private TextArea textArea;

}
