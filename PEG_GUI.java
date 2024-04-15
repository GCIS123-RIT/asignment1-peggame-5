package main.java.Assignment1;
import java.io.File;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class PEG_GUI {

    public static void loadGame (){

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Peg Game File");
        File selectedFile = fileChooser.showOpenDialog(PegUI.getMainStage());
        
        // Now you can use selectedFile to access the chosen file
    } 

    public static void exitGame (){
        System.exit(0);
    } 
}
