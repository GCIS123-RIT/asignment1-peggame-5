package main.java.Assignment1;

import java.io.File;
import java.io.FileWriter;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;
import java.io.IOException;

public class GUI_Game {
    private Peg_GUI gui;
    private cmd_line game;
    private boolean[][] board;
    private GridPane boardPane;
    private Label statusLabel;
    private Label instructionLabel;
    private Location selectedLocation;
    private Button loadButton;
    private Button saveButton;
    private Button exitButton;
    private Button resetButton;

    public GUI_Game(Peg_GUI gui, boolean[][] board, GridPane boardPane, Label statusLabel, Label instructionLabel, Location selectedLocation, Button loadButton, Button saveButton, Button exitButton, Button resetButton) {
        this.gui = gui;
        this.game = new cmd_line(board);
        this.board = board;
        this.boardPane = boardPane;
        this.statusLabel = statusLabel;
        this.instructionLabel = instructionLabel;
        this.selectedLocation = selectedLocation;
        this.loadButton = loadButton;
        this.saveButton = saveButton;
        this.exitButton = exitButton;
        this.resetButton = resetButton;
    }

    public void loadGame() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(gui.getPrimaryStage());
        if (file != null) {
            ReadTxt reader = new ReadTxt(file.getAbsolutePath());
            try {
                board = reader.readFromFile();
            } catch (Exception e) {
                gui.showErrorDialog("Error loading game file. Please make sure the file is a valid .txt file and not empty or formatted wrong");
            }
        }
    }

    public void saveGame() {
        if (game == null) {
            statusLabel.setText("No game loaded to save.");
            return;
        }
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Save Game File");
                fileChooser.setInitialDirectory(new File("/Users/Alligator/Downloads"));
                File file = fileChooser.showSaveDialog(gui.getPrimaryStage());
                if (file != null) {
                    try {
                        saveGameToFile(file);
                        statusLabel.setText("Game saved successfully.");
                    } catch (IOException e) {
                        statusLabel.setText("Error saving game file.");
                    }
                }
        }

    private void saveGameToFile(File file) throws IOException {
        try (FileWriter writer = new FileWriter(file)) {
            int boardSize = game.BOARD_SIZE;
            writer.write(String.valueOf(boardSize) + "\n");

            for (int row = 0; row < boardSize; row++) {
                StringBuilder line = new StringBuilder();
                for (int col = 0; col < boardSize; col++) {
                    if (board[row][col] == true) {
                        line.append("o");
                    } else {
                        line.append(".");
                    }
                }
                writer.write(line.toString() + "\n");
            }
        }
    }

}
