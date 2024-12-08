package com.example.ticTacToe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TicTacToeController {

    @FXML
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9;
    @FXML
    private Label statusLabel;

    private boolean isXTurn = true;
    private boolean gameActive = true;

    @FXML
    private void handleButtonClick(ActionEvent event) {
        if (!gameActive) return;

        Button clickedButton = (Button) event.getSource();
        if (!clickedButton.getText().isEmpty()) return;

        clickedButton.setText(isXTurn ? "X" : "O");

        if (checkWin()) {
            statusLabel.setText((isXTurn ? "Player X" : "Player O") + " Wins!");
            gameActive = false;
        } else if (isDraw()) {
            statusLabel.setText("It's a Draw!");
            gameActive = false;
        } else {
            isXTurn = !isXTurn;
            statusLabel.setText("Player " + (isXTurn ? "X" : "O") + "'s Turn");
        }
    }

    @FXML
    private void handleRestart(ActionEvent event) {
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
        isXTurn = true;
        gameActive = true;
        statusLabel.setText("Player X's Turn");
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

    private boolean checkWin() {
        String[][] board = {
            {button1.getText(), button2.getText(), button3.getText()},
            {button4.getText(), button5.getText(), button6.getText()},
            {button7.getText(), button8.getText(), button9.getText()}
        };

        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]) && !board[i][0].isEmpty()) {
                return true;
            }
            if (board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]) && !board[0][i].isEmpty()) {
                return true;
            }
        }
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].isEmpty()) {
            return true;
        }
        if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[0][2].isEmpty()) {
            return true;
        }

        return false;
    }

    private boolean isDraw() {
        return button1.getText().isEmpty() == false &&
               button2.getText().isEmpty() == false &&
               button3.getText().isEmpty() == false &&
               button4.getText().isEmpty() == false &&
               button5.getText().isEmpty() == false &&
               button6.getText().isEmpty() == false &&
               button7.getText().isEmpty() == false &&
               button8.getText().isEmpty() == false &&
               button9.getText().isEmpty() == false;
    }
}
