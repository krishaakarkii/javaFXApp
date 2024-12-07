package com.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainMenuController {

    @FXML
    private void handleCalculator(ActionEvent event) {
        System.out.println("Calculator clicked!");
    }

    @FXML
    private void handleToDoList(ActionEvent event) {
        System.out.println("To-Do List clicked!");
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
