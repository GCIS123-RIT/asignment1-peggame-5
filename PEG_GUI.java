package main.java.Assignment1;
import java.io.File;
import java.io.FileWriter;

import javafx.stage.FileChooser;

public class PEG_GUI {

    public static boolean[][] board = {{false,true},
                                       {true,false},
                                       };
    public static cmd_line game = new cmd_line(board);
    public static Location selectedLocation;

    /**
     * This method will load a game from a file using the FileChooser and readFromFile method from ReadTxt.java
     * 
     * @throws IOException if the file is not found
     */
    public static void loadGame (){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Peg Game File");
        File selectedFile = fileChooser.showOpenDialog(PegUI.getMainStage());
        if (selectedFile != null) {
            try {
                ReadTxt read = new ReadTxt(selectedFile.getAbsolutePath());
                board = read.readFromFile(); //from ReadTxt.java
                game = new cmd_line(board);
                PegUI.UpdateBoard(PegUI.boardPane, board);
                PegUI.setVisibility(PegUI.load , false); // updating the button state 
                PegUI.setVisibility(PegUI.save , true);  // updating the button state so the save shows 
                game.current_status = GameState.IN_PROGRESS;
            } catch (Exception e) {
                PegUI.PopUp("Error loading game File.","error");
            }
        }
    } 

    /**
     * This method will save a game to a file using the FileChooser and FileWriter
     * 
     * @throws IOException if the file is not found
     */
    public static void  saveGame(){

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Game File");
        File selectedFile = fileChooser.showSaveDialog(PegUI.getMainStage());
        if (selectedFile != null){    
            try (FileWriter writer = new FileWriter(selectedFile)) {
                
                int BoardSize = game.BOARD_SIZE;
                writer.write(String.valueOf(BoardSize) + "\n");

                for (int row = 0; row < BoardSize; row++) {
                    StringBuilder line = new StringBuilder();
                    for (int col = 0; col < BoardSize; col++) {
                        if (board[row][col] == true) {
                            line.append("o");
                        } else {
                            line.append(".");
                        }
                    }
                    writer.write(line.toString() + "\n");
                }
                writer.close();
                PegUI.PopUp("Game saved successfully.","Success");
            }catch (Exception e) {
                PegUI.PopUp("Error saving game file.","error");
            }
        }
    }

    public static void select_peg(int row, int col){
        Location clickedLocation = new Location(row, col);
        if (selectedLocation == null) {
            if (game.board[row][col] == true) {   
                selectedLocation = clickedLocation;
                PegUI.UpdateBoard(PegUI.boardPane, game.board);
            }
        } else {
            try {
                game.setCurrentPosition(clickedLocation);
                Move move = new Move(game.getCurrentPosition(), clickedLocation);
                game.makeMove(move);
                PegUI.UpdateBoard(PegUI.boardPane, game.board);
            } catch (PegGameException e) {
                PegUI.PopUp("Invalid move. " + e.getMessage(),"error");
                selectedLocation = null;
                PegUI.UpdateBoard(PegUI.boardPane, game.board);
            }
        }
    }

    /**
     * This method will exit the game
     */
    public static void exitGame (){
        PegUI.getMainStage().close();
    } 
}
