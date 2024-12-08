package com.example.recipe;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
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

    @FXML
    private void initialize() {
        // Set up the table columns
        nameColumn.setCellValueFactory(data -> data.getValue().nameProperty());
        ingredientsColumn.setCellValueFactory(data -> data.getValue().ingredientsProperty());

        // Make columns editable
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        ingredientsColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        // Populate the table with sample data
        recipes.add(new Recipe("New Recipe", "Ingredients..."));
        recipeTable.setItems(recipes);

        // Enable table editing
        recipeTable.setEditable(true);
    }

    @FXML
    private void handleAddRecipe(ActionEvent event) {
        recipes.add(new Recipe("New Recipe", "Ingredients..."));
    }

    @FXML
    private void handleEditRecipe(ActionEvent event) {
        Recipe selectedRecipe = recipeTable.getSelectionModel().getSelectedItem();
        if (selectedRecipe != null) {
            selectedRecipe.setName("Edited Recipe Name");
            selectedRecipe.setIngredients("Edited Ingredients");
        } else {
            showAlert("No Recipe Selected", "Please select a recipe to edit.");
        }
    }

    @FXML
    private void handleDeleteRecipe(ActionEvent event) {
        Recipe selectedRecipe = recipeTable.getSelectionModel().getSelectedItem();
        if (selectedRecipe != null) {
            recipes.remove(selectedRecipe);
        } else {
            showAlert("No Recipe Selected", "Please select a recipe to delete.");
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
