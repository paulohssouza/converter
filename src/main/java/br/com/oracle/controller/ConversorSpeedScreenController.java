package br.com.oracle.controller;

import br.com.oracle.model.Speed;
import br.com.oracle.utils.DialogBoxExeptions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class ConversorSpeedScreenController implements Initializable {
    public ComboBox<String> comboBoxUnit1;
    public ComboBox<String> comboBoxUnit2;
    public TextField textFieldValueSpeed;
    public Button buttonSpeedConvert;
    public Label labelResultSpeed;

    private Speed speed = new Speed();

    public void loadComboBox() {
        List<String> unitsList = new ArrayList<>();
        unitsList = Arrays.asList(speed.getUnits().getItems());
        ObservableList<String> observableList = FXCollections.observableList(unitsList);
        comboBoxUnit1.setItems(observableList);
        comboBoxUnit2.setItems(observableList);
    }
    public void speedConverter() {
        try {
            if(comboBoxUnit1.getValue() == null || comboBoxUnit2.getValue() == null) throw new Exception();
            else {
                speed.setValue(Double.parseDouble(textFieldValueSpeed.getText()));
                speed.setUnitSelected(comboBoxUnit1.getValue());
                switch (comboBoxUnit2.getValue()){
                    case "Km/h" -> speed.convertToKilometerPerHour();
                    case "m/s" -> speed.convertToMeterPerSecond();
                    case "Mph" -> speed.convertToMilesPerHour();
                }
                labelResultSpeed.setText(speed.toString());
            }
        } catch (Exception exception) {
            DialogBoxExeptions.NullPointerException();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadComboBox();
    }

    public void fieldValidation(KeyEvent actionEvent) {
        try {
            if(actionEvent.getText().matches("[a-zA-Z_-]")) throw new Exception();
        } catch (Exception exception) {
            DialogBoxExeptions.TextFieldException();
            textFieldValueSpeed.clear();
            exception.printStackTrace();
        }
    }
}
