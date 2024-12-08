package com.example.chat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ChatController {

    @FXML
    private ListView<String> chatDisplay;
    @FXML
    private TextField messageInput;

    @FXML
    private void handleSendMessage(ActionEvent event) {
        String userMessage = messageInput.getText().trim();
        if (userMessage.isEmpty()) {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Empty Message");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a message before sending.");
            alert.showAndWait();
            return;
        }

        // Display user's message
        chatDisplay.getItems().add("You: " + userMessage);
        messageInput.clear();

        // Simulate bot response
        chatDisplay.getItems().add("Bot: " + generateBotResponse(userMessage));
    }

    private String generateBotResponse(String userMessage) {
        // Basic bot logic (can be expanded)
        if (userMessage.equalsIgnoreCase("hello")) {
            return "Hi there!";
        } else if (userMessage.equalsIgnoreCase("how are you")) {
            return "I'm just a bot, but I'm doing great!";
        } else {
            return "I didn't understand that. Could you rephrase?";
        }
    }

    @FXML
    private void handleBack(ActionEvent event) {
        try {
            javafx.fxml.FXMLLoader fxmlLoader = new javafx.fxml.FXMLLoader(getClass().getResource("/com/example/MainMenu.fxml"));
            javafx.scene.Parent mainMenuRoot = fxmlLoader.load();
            javafx.stage.Stage stage = (javafx.stage.Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new javafx.scene.Scene(mainMenuRoot));
            stage.setTitle("Main Menu");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
