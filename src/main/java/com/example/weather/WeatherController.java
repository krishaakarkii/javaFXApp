package com.example.weather;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class WeatherController {

    @FXML
    private TextField cityInput;
    @FXML
    private Button fetchWeatherButton;
    @FXML
    private Label weatherOutput;

    private static final String API_KEY = "e3920faf359289df687dee98705f7111"; // Replace with your actual API key

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
        weatherOutput.setText("Error navigating back to Main Menu.");
    }
}


    @FXML
    private void handleFetchWeather(ActionEvent event) {
        String cityName = cityInput.getText().trim();
        if (cityName.isEmpty()) {
            weatherOutput.setText("Please enter a city name.");
            return;
        }

        try {
            String weatherData = fetchWeatherData(cityName);
            if (weatherData != null) {
                parseAndDisplayWeather(weatherData);
            } else {
                weatherOutput.setText("Could not fetch weather data. Try again later.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            weatherOutput.setText("Error fetching weather data.");
        }
    }

    private String fetchWeatherData(String city) throws Exception {
        String apiUrl = String.format(
            "http://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&appid=%s",
            city, API_KEY
        );

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            return response.toString();
        } else {
            return null;
        }
    }

    private void parseAndDisplayWeather(String jsonData) {
        // Parse JSON using Gson
        JsonObject jsonObject = JsonParser.parseString(jsonData).getAsJsonObject();

        String cityName = jsonObject.get("name").getAsString();
        JsonObject main = jsonObject.getAsJsonObject("main");
        double temp = main.get("temp").getAsDouble();
        String description = jsonObject.getAsJsonArray("weather").get(0).getAsJsonObject().get("description").getAsString();

        weatherOutput.setText(
            String.format("City: %s\nTemperature: %.2f°C\nDescription: %s", cityName, temp, description)
        );
    }
}
