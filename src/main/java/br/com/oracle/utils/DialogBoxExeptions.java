package br.com.oracle.utils;

import javafx.scene.control.Alert;

public class DialogBoxExeptions {

    public static void NullPointerException() {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("Entrada inválida!");
        errorAlert.setContentText("Você deve selecionar uma opção!");
        errorAlert.showAndWait();
    }

    public static void TextFieldException() {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setHeaderText("Entrada inválida!");
        errorAlert.setContentText("No campo só devem ser digitados números.");
        errorAlert.showAndWait();
    }

}
