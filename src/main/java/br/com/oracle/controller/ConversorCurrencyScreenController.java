package br.com.oracle.controller;

import br.com.oracle.utils.ExtractorCurrencyQuotes;
import br.com.oracle.model.CurrencyQuote;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.*;

public class ConversorCurrencyScreenController implements Initializable {
    public TextField textFiledReal;
    public ComboBox<String> comboBoxCurrencies;
    public Label labelResultCurrencyConvert;
    public Button buttonCurrencyConvert;

    private final List<CurrencyQuote> currencyQuoteList = ExtractorCurrencyQuotes.extractorCurrencies();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadComboBox();
    }

    private void loadComboBox() {
        List<String> comboBoxStrings = new ArrayList<>();
        currencyQuoteList.forEach(currencyQuote -> {
            comboBoxStrings.add(currencyQuote.getCode());
        });
        ObservableList<String> currencyQuoteObservableList = FXCollections.observableList(comboBoxStrings);
        comboBoxCurrencies.setItems(currencyQuoteObservableList);
    }

    public void currencyConvert(ActionEvent actionEvent) {
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
}
