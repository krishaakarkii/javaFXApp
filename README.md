
# JavaFX Multi-App

This is a **JavaFX-based Multi-App Application** that combines several small applications into a single platform. It is built using JavaFX, Maven, and adheres to modular programming practices. Each app within the platform has its own dedicated UI and logic.

## Features

The application currently includes the following mini-apps:

1. **Calculator** - Perform basic arithmetic operations.
2. **To-Do List** - Manage tasks with a simple to-do list.
3. **Tic Tac Toe** - A classic two-player game.
4. **Weather Checker** - Check the weather for different locations.
5. **Recipe Manager** - Manage and organize your favorite recipes.
6. **Chat Application** - A basic chat interface.

## Project Structure

# The project is structured as follows:

src/
├── main/
│   ├── java/
│   │   └── com/example/
│   │       ├── App.java # Main application entry point
│   │       ├── MainMenuController.java # Controller for the main menu
│   │       ├── calculator/ # Calculator app files
│   │       ├── chat/ # Chat app files
│   │       ├── recipe/ # Recipe manager files
│   │       ├── ticTacToe/ # Tic Tac Toe files
│   │       ├── todolist/ # To-Do list files
│   │       └── weather/ # Weather checker files
│   ├── resources/
│   │   └── com/example/
│   │       ├── MainMenu.fxml # Main menu layout
│   │       ├── calculator/Calculator.fxml # Calculator UI
│   │       ├── chat/Chat.fxml # Chat UI
│   │       ├── recipe/Recipe.fxml # Recipe Manager UI
│   │       ├── ticTacToe/TicTacToe.fxml # Tic Tac Toe UI
│   │       ├── todolist/ToDoList.fxml # To-Do List UI
│   │       └── weather/Weather.fxml # Weather Checker UI
└── test/
    └── java/
        └── com/example/AppTest.java # Tests for the application
```

## How to Run the Project

### Prerequisites
- **JDK 17 or higher**: Ensure you have Java 17 or later installed.
- **Maven**: Install Maven to manage dependencies and build the project.

### Steps
1. Clone the repository:
   ```bash
   git clone git@github.com:krishaakarkii/javaFXApp.git
   cd javaFXApp
   ```

2. Build and run the application:
   ```bash
   mvn clean install
   mvn javafx:run
   ```

## Screenshots

### Main Menu
The main menu allows you to navigate to the individual apps:

### Calculator
Simple arithmetic operations:

### Tic Tac Toe
Enjoy the classic game:



## Future Improvements
- Add more interactive features to the apps.
- Improve UI/UX design.
- Integrate external APIs for real-time weather updates and chat functionality.

## Contributions
Contributions are welcome! Feel free to open issues and submit pull requests.

## License
This project is licensed under the name Krisha Karki.


