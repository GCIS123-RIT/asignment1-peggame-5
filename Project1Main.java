import java.util.Scanner;
public class Project1Main {
    /*
     * This is the main method that will read in a file and play the game.
     * 
     * @param args the command line arguments
     * 
     * @throws FileNotFoundException if the file is not found
     * @throws PegGameException if the move is invalid
     * 
     * @return the current state of the game
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a filename: ");
        String filename = scanner.nextLine();
        
        cmd_line game = ReadTxt.createGameFromFile(filename);
        
        if (game == null) {
            System.out.println("Error reading file");
        }

        cmd_line.playGame(game);
        
        scanner.close();
    }
}
