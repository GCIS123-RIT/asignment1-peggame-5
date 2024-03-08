import java.util.Scanner;
public class Project1Main {
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
