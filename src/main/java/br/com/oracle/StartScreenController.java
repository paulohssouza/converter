package br.com.oracle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class StartScreenController implements Initializable {

    @FXML
    public ListView<CurrencyQuote> listCurrencyQuote;
    @FXML
    public Button currencyConverter;
    @FXML
    public Button measurementConverter;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadCurrencyQuotes();
    }

    public void loadCurrencyQuotes() {
        List<CurrencyQuote> currencyQuoteList = ExtractorCurrencyQuotes.extractorCurrencies();
        ObservableList<CurrencyQuote> currencyQuoteObservableList = FXCollections.observableList(currencyQuoteList);
        listCurrencyQuote.setItems(currencyQuoteObservableList);
    }
}
