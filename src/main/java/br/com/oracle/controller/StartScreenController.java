package br.com.oracle.controller;

import br.com.oracle.utils.ExtractorCurrencyQuotes;
import br.com.oracle.model.CurrencyQuote;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
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

    public void currencyConverterAction() {
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/conversor-currency-screen.fxml")));
            Scene scene = new Scene(root);
            stage.setTitle("Conversor de Moedas");
            stage.setScene(scene);
            stage.show();

        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }

    public void speedConverterAction() {
        try{
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/conversor-speed-screen.fxml")));
            Scene scene = new Scene(root);
            stage.setTitle("Conversor de Velocidade");
            stage.setScene(scene);
            stage.show();

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
