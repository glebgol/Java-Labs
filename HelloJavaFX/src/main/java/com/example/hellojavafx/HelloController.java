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
    private Label welcomeText;
    @FXML
    private TextField inputLine;
    @FXML
    private Label resultLabel;
    @FXML
    protected void onCalculateButtonClick() {
        var inputText = inputLine.getCharacters().toString();
        var result = SumOfString.GetSumOfNumbersRegEx(inputText);
        ShowResultMessage(result);
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
}