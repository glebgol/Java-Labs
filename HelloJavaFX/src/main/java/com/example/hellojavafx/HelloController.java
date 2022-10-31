package com.example.hellojavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField inputLine;
    @FXML
    protected void onCalculateButtonClick() {
        var inputText = inputLine.getCharacters().toString();
        var result = SumOfString.GetSumOfNumbersRegEx(inputText);
        welcomeText.setText("Sum of string numbers: " + result);
    }
}