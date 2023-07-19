package br.com.oracle.controller;

import br.com.oracle.utils.DialogBoxExeptions;
import br.com.oracle.utils.ExtractorCurrencyQuotes;
import br.com.oracle.model.CurrencyQuote;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.*;

public class ConversorCurrencyScreenController implements Initializable {
    public TextField textFiledReal;
    public ComboBox<String> comboBoxCurrencies;
    public Label labelResultCurrencyConvert;
    public Button buttonCurrencyConvert;

    private final List<CurrencyQuote> currencyQuoteList = ExtractorCurrencyQuotes.extractorCurrencies();
    public Label labelResultRealConvert;
    public ComboBox<String> comboBoxCurrencies2;
    public TextField textFiledCurrency;
    public Button buttonRealConvert;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadComboBox();
    }

    private void loadComboBox() {
        List<String> comboBoxStrings = new ArrayList<>();
        currencyQuoteList.forEach(currencyQuote -> comboBoxStrings.add(currencyQuote.getCode()));
        ObservableList<String> currencyQuoteObservableList = FXCollections.observableList(comboBoxStrings);
        comboBoxCurrencies.setItems(currencyQuoteObservableList);
        comboBoxCurrencies2.setItems(currencyQuoteObservableList);
    }

    public void currencyConvert() {
        try {
            System.out.println(comboBoxCurrencies.getValue());
            if (comboBoxCurrencies.getValue() == null) throw new Exception();
            else {
                String currencyGet = comboBoxCurrencies.getValue();
                Double valueTextField = Double.parseDouble(textFiledReal.getText());
                Double currencyQuoteValue = 0.0;
                for (CurrencyQuote currencyQuote : currencyQuoteList) {
                    if (Objects.equals(currencyQuote.getCode(), currencyGet)) {
                        currencyQuoteValue = currencyQuote.getBid();
                        break;
                    }
                }
                labelResultCurrencyConvert.setText(currencyGet + " " + (valueTextField * currencyQuoteValue));
            }
        } catch (NumberFormatException exception) {
            DialogBoxExeptions.TextFieldException();
            exception.printStackTrace();
        } catch (Exception exception) {
            DialogBoxExeptions.NullPointerException();
            exception.printStackTrace();
        }
    }

    public void realConvert() {
        try {
            if (comboBoxCurrencies2.getValue() == null) throw new Exception();
            else {
                String currencyGet = comboBoxCurrencies2.getValue();
                Double valueTextField = Double.parseDouble(textFiledCurrency.getText());
                Double currencyQuoteValue = 0.0;
                for (CurrencyQuote currencyQuote : currencyQuoteList) {
                    if(Objects.equals(currencyQuote.getCode(), currencyGet)) {
                        currencyQuoteValue = currencyQuote.getBid();
                        break;
                    }
                }
                labelResultRealConvert.setText("R$ " + (valueTextField / currencyQuoteValue));
            }
        } catch (NumberFormatException exception) {
            DialogBoxExeptions.TextFieldException();
            exception.printStackTrace();
        } catch (Exception exception) {
            DialogBoxExeptions.NullPointerException();
            exception.printStackTrace();
        }
    }

    public void fieldValidation(KeyEvent keyEvent) {
        try {
            if(keyEvent.getText().matches("[a-zA-Z_-]")) throw new Exception();
        } catch (Exception exception) {
            DialogBoxExeptions.TextFieldException();
            textFiledCurrency.clear();
            exception.printStackTrace();
        }
    }

    public void fieldValidation2(KeyEvent keyEvent) {
        try {
            if(keyEvent.getText().matches("[a-zA-Z_-]")) throw new Exception();
        } catch (Exception exception) {
            DialogBoxExeptions.TextFieldException();
            textFiledReal.clear();
            exception.printStackTrace();
        }
    }
}
