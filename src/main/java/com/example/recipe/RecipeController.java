package com.example.recipe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class RecipeController {

    @FXML
    private TableView<Recipe> recipeTable;
    @FXML
    private TableColumn<Recipe, String> nameColumn;
    @FXML
    private TableColumn<Recipe, String> ingredientsColumn;

    private final ObservableList<Recipe> recipes = FXCollections.observableArrayList();

    @FXML
    private void initialize() {
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        ingredientsColumn.setCellValueFactory(cellData -> cellData.getValue().ingredientsProperty());
        recipeTable.setItems(recipes);
    }

    @FXML
    private void handleAddRecipe(ActionEvent event) {
        // Add a placeholder recipe for demonstration
        recipes.add(new Recipe("New Recipe", "Ingredients..."));
    }

    @FXML
    private void handleEditRecipe(ActionEvent event) {
        Recipe selectedRecipe = recipeTable.getSelectionModel().getSelectedItem();
        if (selectedRecipe != null) {
            selectedRecipe.setName("Edited Recipe");
            selectedRecipe.setIngredients("Updated Ingredients...");
            recipeTable.refresh();
        } else {
            showAlert("No Selection", "Please select a recipe to edit.");
        }
    }

    @FXML
    private void handleDeleteRecipe(ActionEvent event) {
        Recipe selectedRecipe = recipeTable.getSelectionModel().getSelectedItem();
        if (selectedRecipe != null) {
            recipes.remove(selectedRecipe);
        } else {
            showAlert("No Selection", "Please select a recipe to delete.");
        }
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

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
