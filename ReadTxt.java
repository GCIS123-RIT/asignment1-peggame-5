import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadTxt {

    public boolean isEmpty(String data){
        if (data == "."){
            return true;
        }
        else if (data == "o"){
            return false;
        }
        return false;
    }

    public void readTxt(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner myReader = new Scanner(file);
            String data = ""; // Declare the data variable outside of the loop

            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            myReader.close();

            //convert first line of data from the file into an integer
            int size = Integer.parseInt(data);

            //create a 2D array of the size of the board
            boolean EmptyHole[][] = new boolean[size][size];
        
        //fill the array with the data from the file
        for (int i = 1; i < size; i++){
            for (int j = 0; j < size; j++){
                if (isEmpty(data) == true){
                    EmptyHole[i][j] = true;
                }
                else if (isEmpty(data) == false)
                {
                    EmptyHole[i][j] = false;
                }
            }
        }
    }

}