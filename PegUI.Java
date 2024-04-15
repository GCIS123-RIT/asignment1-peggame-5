package PegGame;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class PegUI extends Application {

    static Stage MainStage;
    static Button load;
    static Button  save;
    static Button exist;



    @Override
    public void start(Stage MainStage) {
        this.MainStage = MainStage;
        MainStage.setTitle("Peg Game ");
        

        //  labels and Buttons 
        Rectangle rect = new Rectangle(200, 200);
        rect.setFill(Color.LAVENDERBLUSH);
        rect.setStroke(Color.BLACK);
        // title 

        Label titleLabel = new Label("Welcome To the Peg Game ");
        titleLabel.setStyle("-fx-font-size: 45px; -fx-font-weight: bold;");
        // rules
        Label rules = new Label("Rules are as follows:\n" +
                "1. The game board is a square with pegs in all holes except one.\n" +
                "2. Only vertical and horizontal jumps allowed.\n" +
                "3. The game is over when no more moves can be made.");
        // load, exit, save
        Button load = new Button("Load Game");
        Button exit = new Button("Exit");
        Button save = new Button("Save Game");
        save.setVisible(false); // this button shouldnt initially show 

         

        

        load.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        exit.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        save.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

       


        

        // Create VBox for title, rules, and buttons
        VBox vbox = new VBox(20); // Adjust spacing between nodes
        vbox.setAlignment(Pos.CENTER); // Center align content
        vbox.getChildren().addAll(titleLabel, rules, load);

        // Create VBox for exit button
        VBox ButtomVBox = new VBox(20);
        ButtomVBox.getChildren().addAll( save, exit);

        // Create BorderPane for layout
        BorderPane root = new BorderPane();
        root.setTop(vbox); // Center VBox with title, rules, and buttons
        root.setBottom(ButtomVBox); // Align Exit button to the bottom

        root.setStyle("-fx-background-color: lightblue;");

        // Set up the scene
        Scene scene = new Scene(root, 800, 600); // Adjusted scene size for visibility
        MainStage.setScene(scene);
        MainStage.show();

        // Setting the event handelers
        load.setOnAction(e -> {PEG_GUI.loadGame();});
        exit.setOnAction(e -> {PEG_GUI.exitGame();});
        save.setOnAction(e -> {PEG_GUI.saveGame();});
    }

    public  static Stage getMainStage() {
        return MainStage;
    }
    // viisbility setter
    public static void setVisibility(Button b , boolean v){
        if (v == true)
        b.setVisible(true);
        else
        b.setVisible(false);
        }

    // getters   
    public static Button getLoad() {
        return load; 
    }

   
    public static Button getSave() {
        return save; 
    }

    
    public static void main(String[] args) {
        launch(args);
    }
}