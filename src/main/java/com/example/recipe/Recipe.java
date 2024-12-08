package com.example.recipe;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Recipe {
    private final StringProperty name;
    private final StringProperty ingredients;

    public Recipe(String name, String ingredients) {
        this.name = new SimpleStringProperty(name);
        this.ingredients = new SimpleStringProperty(ingredients);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty ingredientsProperty() {
        return ingredients;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getIngredients() {
        return ingredients.get();
    }

    public void setIngredients(String ingredients) {
        this.ingredients.set(ingredients);
    }
}
