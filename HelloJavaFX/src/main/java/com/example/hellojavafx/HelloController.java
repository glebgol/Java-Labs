package com.example.hellojavafx;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;


public class HelloController {
    @FXML
    private TextField inputLine1;
    @FXML
    private TextField inputLine2;
    @FXML
    private Label resultLabel;

    @FXML
    protected void onPlusButtonClick() {
        try {
            var str1 = inputLine1.getCharacters().toString();
            var num1 = Integer.parseInt(str1);
            var str2 = inputLine2.getCharacters().toString();
            var num2 = Integer.parseInt(str2);
            var result = num1 + num2;
            ShowResultMessage(result);
        }
        catch (Exception ex) {
            ShowWarningMessage("Input is null");
        }
    }

    @FXML
    protected void onMinusButtonClick() {
        try {
            var str1 = inputLine1.getCharacters().toString();
            var num1 = Integer.parseInt(str1);
            var str2 = inputLine2.getCharacters().toString();
            var num2 = Integer.parseInt(str2);
            var result = num1 - num2;
            ShowResultMessage(result);
        }
        catch (Exception ex) {
            ShowWarningMessage("Input is null");
        }
    }
    @FXML
    protected void onMultiplyButtonClick() {
        try {
            var str1 = inputLine1.getCharacters().toString();
            var num1 = Double.parseDouble(str1);
            var str2 = inputLine2.getCharacters().toString();
            var num2 = Double.parseDouble(str2);
            var result = num1 * num2;
            ShowResultMessage(result);
        }
        catch (Exception ex) {
            ShowWarningMessage("Input is null");
        }
    }
    @FXML
    protected void onDivideButtonClick() {
        try {
            var str1 = inputLine1.getCharacters().toString();
            var num1 = Double.parseDouble(str1);
            var str2 = inputLine2.getCharacters().toString();
            var num2 = Double.parseDouble(str2);
            if (num2 == 0) {
                ShowWarningMessage("Деление на 0");
                return;
            }
            var result = num1 / num2;
            ShowResultMessage(result);
        }
        catch (Exception ex) {
            ShowWarningMessage("Input is null");
        }
    }

    private void ShowResultMessage(double result) {
        var contentResult = "Sum of string number: " + result;
        var info = new Alert(Alert.AlertType.INFORMATION);
        info.initStyle(StageStyle.DECORATED);
        info.setTitle("Result");
        info.setHeaderText("Successful");
        info.setContentText(contentResult);
        info.showAndWait();
    }

    private void ShowWarningMessage(String message) {
        var warning = new Alert(Alert.AlertType.WARNING);
        warning.initStyle(StageStyle.DECORATED);
        warning.setTitle("Warning");
        warning.setContentText(message);
        warning.showAndWait();
    }
}