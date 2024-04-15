package main.java.Assignment1;
import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PEG_GUI {

    public static void loadGame (){

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Peg Game File");
        File selectedFile = fileChooser.showOpenDialog(PegUI.getMainStage());
        if (selectedFile != null) {
            ReadTxt reader = new ReadTxt(selectedFile.getAbsolutePath()); // Create an instance of ReadTxt
            try {
                boolean[][] board = reader.readFromFile(); //from ReadTxt.java
                cmd_line game = new cmd_line(board);
                PegUI.setVisibility(PegUI.getLoad() , false); // updating the button state 
                PegUI.setVisibility(PegUI.getSave() , true);  // updating the button state so the save shows 
            } catch (Exception e) {
                Label statusLabel = new Label();
                statusLabel.setText("Error loading game file.");
                
            }
        }
        // Now you can use selectedFile to access the chosen file
    } 

    public static void  saveGame(){
       
        
    }

    public static void exitGame (){
        System.exit(0);
    } 
}
