import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadTxt {

    /*
     * This method will return a boolean value based on the data from the file.
     * 
     * @param data the data from the file
     * @return a boolean value based on the data from the file
     */
    public boolean isEmpty(String data){
        if (data == "."){
            return true;
        }
        else if (data == "o"){
            return false;
        }
        return false;
    }

    /*
     * This method will read the file and fill the 2D array with the data from the file.
     * 
     * @param filename the name of the file to be read
     * @throws FileNotFoundException if the file is not found
     * @return the 2D array filled with the data from the file
     */
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