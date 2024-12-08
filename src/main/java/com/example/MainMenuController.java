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
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/ticTacToe/TicTacToe.fxml"));
        Parent ticTacToeRoot = fxmlLoader.load();
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(ticTacToeRoot));
        stage.setTitle("Tic Tac Toe");
        stage.show();
    } catch (Exception e) {
        e.printStackTrace();
    }
}


@FXML
private void handleWeatherChecker(ActionEvent event) {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/weather/Weather.fxml"));
        Parent weatherRoot = fxmlLoader.load();
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(weatherRoot));
        stage.setTitle("Weather Checker");
        stage.show();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    @FXML
private void handleRecipeManager(ActionEvent event) {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/recipe/Recipe.fxml"));
        Parent recipeRoot = fxmlLoader.load();
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(recipeRoot));
        stage.setTitle("Recipe Manager");
        stage.show();
    } catch (Exception e) {
        e.printStackTrace();
    }
}


@FXML
private void handleChatApp(ActionEvent event) {
    try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/chat/Chat.fxml"));
        Parent chatRoot = fxmlLoader.load();
        Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(chatRoot));
        stage.setTitle("Chat Application");
        stage.show();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
