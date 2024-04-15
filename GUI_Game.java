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

    /**
     * constructor for GUI_Game
     * 
     * @param gui
     * @param board
     * @param boardPane
     * @param statusLabel
     * @param instructionLabel
     * @param selectedLocation
     * @param loadButton
     * @param saveButton
     * @param exitButton
     * @param resetButton
     */
    public GUI_Game(Peg_GUI gui, GridPane boardPane, Label statusLabel, Label instructionLabel, Location selectedLocation, Button loadButton, Button saveButton, Button exitButton, Button resetButton) {
        this.gui = gui;
        this.game = null;
        this.board = null;
        this.boardPane = boardPane;
        this.statusLabel = statusLabel;
        this.instructionLabel = instructionLabel;
        this.selectedLocation = selectedLocation;
        this.loadButton = loadButton;
        this.saveButton = saveButton;
        this.exitButton = exitButton;
        this.resetButton = resetButton;
    }

    /**
     * Loads a game from a file.
     */
    public void loadGame() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(gui.getPrimaryStage());
        if (file != null) {
            ReadTxt reader = new ReadTxt(file.getAbsolutePath());
            try {
                board = reader.readFromFile(); //from ReadTxt.java
            } catch (Exception e) {
                gui.showErrorDialog("Error loading game file. Please make sure the file is a valid .txt file and not empty or formatted wrong");
            }
        }
    }

    /**
     * Saves the current game state to a file.
     */
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

    /**
     * writes game data into a file
     * 
     * @param file
     * @throws IOException
     */
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

    /**
     * Resets the game state and prompts the user for confirmation if the game is in progress.
     * If no game is loaded or the user confirms the reset, the game state is reset to the initial state.
     */
    public void resetGame() {
        if (game != null && saveButton.isVisible()) {
            gui.showExitConfirmation();
        } else {
            resetGameState();
        }
    }

    /**
     * Resets the game state to the initial state.
     * Clears the game board, resets the UI labels and buttons, and hides the game board.
     */
    public void resetGameState() {
        game = null;
        selectedLocation = null;
        boardPane.getChildren().clear();
        statusLabel.setText("Game not started. Select a file to start the game.");
        instructionLabel.setText("");
        loadButton.setVisible(true);
        saveButton.setVisible(false);
        boardPane.setVisible(false);
        exitButton.setVisible(true);
        resetButton.setVisible(false);
    }

    /**
     * Exits the program by closing the primary stage.
     */
    public void exitProgram() {
        gui.getPrimaryStage().close();
    }

    /**
     * Handles a move by the user.
     * 
     * @param row
     * @param col
     */
    public void handledMove (int row, int col){
        Location clickedLocation = new Location(row, col);

        if (selectedLocation == null) {
            if (board[row][col] == true) {
                selectedLocation = clickedLocation;
                instructionLabel.setText("Select a hole to move to.");
            } else {
                statusLabel.setText("Please select a peg to move.");
            }
        } else {
            Move move = new Move(selectedLocation, clickedLocation);
            try {
                game.makeMove(move);
                board = game.getBoard();
                if (game.current_status == GameState.WIN) {
                    statusLabel.setText("Game over! You won!");
                    instructionLabel.setText("");
                    saveButton.setVisible(true);
                } else {
                    instructionLabel.setText("Select a peg to move.");
                }
            } catch (PegGameException e) {
                statusLabel.setText(e.getMessage());
            }
            selectedLocation = null;
        }
    }

    /**
     * Updates the game status label based on the current game state.
     * Displays the appropriate message for each game state (in progress, stalemate, won).
     */
    private void updateStatus() {
        if (game == null) {
            statusLabel.setText("Game not started. Select a file to start the game.");
        } else {
            GameState state = game.getGameState();
            switch (state) {
                case IN_PROGRESS:
                    statusLabel.setText("Game in progress");
                    break;
                case STALEMATE:
                    statusLabel.setText("Game over. Stalemate!");
                    break;
                case WIN:
                    statusLabel.setText("Congratulations! You won!");
                    break;
            }
        }
    }
}
