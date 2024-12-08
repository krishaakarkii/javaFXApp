package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenuController {

    @FXML
    private void handleCalculator(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/calculator/Calculator.fxml"));
            Parent calculatorRoot = fxmlLoader.load();
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(calculatorRoot));
            stage.setTitle("Calculator");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
private void handleToDoList(ActionEvent event) {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/todolist/ToDoList.fxml"));
        Parent toDoListRoot = fxmlLoader.load();
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(toDoListRoot));
        stage.setTitle("To-Do List");
        stage.show();
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    @FXML
    private void handleTicTacToe(ActionEvent event) {
        System.out.println("Tic Tac Toe clicked!");
    }

    @FXML
    private void handleWeatherChecker(ActionEvent event) {
        System.out.println("Weather Checker clicked!");
    }

    @FXML
    private void handleRecipeManager(ActionEvent event) {
        System.out.println("Recipe Manager clicked!");
    }

    @FXML
    private void handleChatApp(ActionEvent event) {
        System.out.println("Chat Application clicked!");
    }
}
