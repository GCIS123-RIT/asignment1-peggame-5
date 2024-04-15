package main.java.Assignment1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Peg_GUI extends Application {

    private GridPane boardPane;
    private VBox vb;
    private Stage primaryStage;
    private Button loadButton;
    private Button saveButton;
    private Button exitButton;
    private Button resetButton;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        primaryStage.setTitle("Peg Game");

        // Create the title text
        Text titleText = new Text("PEG GAME");
        titleText.setFont(Font.font("Arial", FontWeight.BOLD, 120));
        titleText.setFill(Color.BLACK);

        // Create the main layout
        VBox root = new VBox(16);
        root.setPadding(new Insets(16));
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #A5DEB3;");

        // Create a GridPane
        boardPane = new GridPane();
        boardPane.setAlignment(Pos.CENTER);
        boardPane.setPadding(new Insets(10, 10, 10, 10));
        boardPane.setHgap(10);
        boardPane.setVgap(10);

        // Create a VBox
        vb = new VBox();
        vb.setAlignment(Pos.CENTER);
        vb.setPadding(new Insets(10, 10, 10, 10));
        vb.setSpacing(10);

        VBox loadExitLayout = new VBox(8);
        loadExitLayout.setAlignment(Pos.CENTER);

        // Create a Button
        loadButton = new Button("Load Game");
        loadButton.setStyle("-fx-font-size: 16px;");

        // Create a Button
        exitButton = new Button("Exit");
        exitButton.setStyle("-fx-font-size: 16px;");

        loadExitLayout.getChildren().addAll(loadButton, exitButton);

        // Create the save and reset button layout
        VBox saveResetLayout = new VBox(8);
        saveResetLayout.setAlignment(Pos.CENTER);

        // Create a Button
        saveButton = new Button("Save Game");
        saveButton.setStyle("-fx-font-size: 16px;");
        saveButton.setVisible(false); // Set the button to be invisible

        // Create a Button
        resetButton = new Button("Reset");
        resetButton.setStyle("-fx-font-size: 16px;");
        resetButton.setVisible(false);

        // Add save and reset buttons to the layout
        saveResetLayout.getChildren().addAll(saveButton, resetButton);

        // Add the rules
        VBox rulesBox = new VBox(8);
        rulesBox.setAlignment(Pos.CENTER);
        TextFlow rulesFlow = new TextFlow();
        Text rulesTitle = new Text("Rules:\n");
        rulesTitle.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        Text start = new Text("The goal is to jump pegs over other pegs to remove them from the board.\n");
        Text rule1 = new Text("1. Every jump must be a jump of a peg over a neighboring peg.\n");
        Text rule2 = new Text("2. There must be a space for the jumping peg to land in.\n");
        Text rule3 = new Text("3. Jumps can be made either on the diagonal or the horizontal lines.\n");
        Text rule4 = new Text("4. The game is over when no more jumps can be made.\n");
        rulesFlow.getChildren().addAll(start,rulesTitle, rule1, rule2, rule3, rule4);
        rulesBox.getChildren().add(rulesFlow);

        // Add the components to the VBox
        vb.getChildren().addAll(rulesBox, loadExitLayout, saveResetLayout);

        // Create a StackPane
        root.getChildren().add(boardPane);
        root.getChildren().add(vb);

        // Create a Scene
        Scene scene = new Scene(root, 800, 800);

        // Set the Scene
        primaryStage.setScene(scene);

        // Show the Stage
        primaryStage.show();
    }
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void showErrorDialog(String message) {
        Stage errorStage = new Stage();
        errorStage.initOwner(primaryStage);
        errorStage.setTitle("Error");

        Label errorLabel = new Label(message);
        errorLabel.setWrapText(true); // Allow text to wrap to multiple lines
        Button okButton = new Button("OK");

        okButton.setOnAction(e -> errorStage.close());

        VBox errorLayout = new VBox(16);
        errorLayout.setAlignment(Pos.CENTER);
        errorLayout.setPadding(new Insets(16));
        errorLayout.getChildren().addAll(errorLabel, okButton);

        Scene errorScene = new Scene(errorLayout);
        errorStage.setScene(errorScene);
        errorStage.sizeToScene(); // Adjust the window size based on the content
        errorStage.showAndWait();
    }

    public static void main(String[] args) 
    {
        launch(args);    
    }   
}
