package main.java.Assignment1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

public class Peg_GUI extends Application {

    private GUI_Game game;
    private GridPane boardPane;
    private VBox vb;
    private Label statusLabel;
    private Label instructionLabel;
    private Stage primaryStage;
    private Button loadButton;
    private Button saveButton;
    private Button exitButton;
    private Button resetButton;

    @Override
    public void start(Stage stage) {
    
    }

    
    public static void main(String[] args) 
    {
        launch(args);    
    }

    
}
