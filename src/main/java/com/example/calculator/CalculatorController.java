package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CalculatorController {

    @FXML
    private TextField display;

    private double operand1 = 0;
    private String operator = "";
    private boolean start = true;

    @FXML
    private void handleNumber(ActionEvent event) {
        if (start) {
            display.clear();
            start = false;
        }
        String value = ((javafx.scene.control.Button) event.getSource()).getText();
        display.appendText(value);
    }

    @FXML
    private void handleOperator(ActionEvent event) {
        String value = ((javafx.scene.control.Button) event.getSource()).getText();
        if (!"=".equals(value)) {
            if (!operator.isEmpty()) return;

            operator = value;
            operand1 = Double.parseDouble(display.getText());
            display.clear();
        } else {
            if (operator.isEmpty()) return;

            double operand2 = Double.parseDouble(display.getText());
            double result = calculate(operand1, operand2, operator);
            display.setText(String.valueOf(result));
            operator = "";
            start = true;
        }
    }

    @FXML
    private void handleClear(ActionEvent event) {
        display.clear();
        operator = "";
        start = true;
    }

    @FXML
    private void handleBack(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/MainMenu.fxml"));
            Parent mainMenuRoot = fxmlLoader.load();
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(mainMenuRoot));
            stage.setTitle("Main Menu");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private double calculate(double operand1, double operand2, String operator) {
        switch (operator) {
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            case "*":
                return operand1 * operand2;
            case "/":
                if (operand2 != 0) return operand1 / operand2;
                return 0;
            default:
                return 0;
        }
    }
}
