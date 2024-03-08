import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadTxt {
    public static cmd_line createGameFromFile(String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            int BOARD_SIZE = scanner.nextInt();
            boolean[][] EmptyHole = new boolean[BOARD_SIZE][BOARD_SIZE];

            // Read the board configuration
            for (int i = 0; i < BOARD_SIZE; i++) {
                String row = scanner.next();
                for (int j = 0; j < row.length(); j++) {
                    if (row.charAt(j) == 'o') {
                        EmptyHole[i][j] = false;
                    }
                    else if (row.charAt(j) == '.') {
                        EmptyHole[i][j] = true;
                    }
                }
            }
            cmd_line game = new cmd_line(BOARD_SIZE, EmptyHole);
            scanner.close();
            return game;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }


}