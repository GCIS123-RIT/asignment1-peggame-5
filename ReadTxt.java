import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadTxt {

    public boolean isEmpty(string data){
        if (data == "."){
            return true;
        }
        else if (data == "o"){
            return false;
        }
    }

    public static void main(String[] args) {
        try {
            File myObj = new File("/workspaces/asignment1-peggame-5/fiveByFive.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
            }
            myReader.close();

            //convert first line of data from the file into an integer
            int size = Integer.parseInt(data);
            
            //create a 2D array of the size of the board
            Location board[][] = new Location[size][size];
            boolean EmptyHole[][] = new boolean[size][size];
            
            //fill the array with the data from the file
            for (int i = 0; i < size; i++){
                for (int j = 0; j < size; j++){
                    if (isEmpty(data)){
                        EmptyHole[i][j] = true;
                    }
                    else{
                        EmptyHole[i][j] = false;
                    }
                }
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
