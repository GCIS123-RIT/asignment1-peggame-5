import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class cmd_line implements PegGame {
    
    public int BOARD_SIZE;
    public int pegs;
   
    public Location board [][];
    public boolean EmptyHole[][];

    public boolean MoveMade = false;
    public GameState current_status;

    public Location current_pos = new Location();



    /*
     * This method will return a collection of all possible moves that can be made on the board.
     * 
     * @return a collection of all possible moves that can be made on the board
     */
    public Collection<Move> getPossibleMoves(){
        // 8 locations to check for possible moves
        Location left_loc = new Location(current_pos.row, current_pos.col - 2);
        Location right_loc = new Location(current_pos.row, current_pos.col + 2);
        Location up_loc = new Location(current_pos.row - 2, current_pos.col);
        Location down_loc = new Location(current_pos.row + 2, current_pos.col);
        Location upleft_loc = new Location(current_pos.row - 2, current_pos.col - 2);
        Location upright_loc = new Location(current_pos.row - 2, current_pos.col + 2);
        Location downleft_loc = new Location(current_pos.row + 2, current_pos.col - 2);
        Location downright_loc = new Location(current_pos.row + 2, current_pos.col + 2);
        
        Location[] possible_locs = {left_loc, right_loc, up_loc, down_loc, upleft_loc, upright_loc, downleft_loc, downright_loc};


        ArrayList<Move> possible_moves = new ArrayList<Move>();

        //checks if the possible moves are valid
        for (int i = 0; i < possible_locs.length; i++)
        {
            if (possible_locs[i].getRow() < 0 || 
            possible_locs[i].getRow() > BOARD_SIZE || 
            possible_locs[i].getCol() < 0 || 
            possible_locs[i].getCol() > BOARD_SIZE || 
            EmptyHole[possible_locs[i].getRow()][possible_locs[i].getCol()] == false)
            {
                possible_moves.add(new Move(current_pos, possible_locs[i]));
            }
        }

        //returns the possible moves as a collection
        return possible_moves;
    }

    /*
     * This method will return the current state of the game.
     * 
     * @return the current state of the game
     */
    public GameState getGameState(){
        if (MoveMade == false){
            current_status = GameState.NOT_STARTED;}

        else if (MoveMade == true){
            current_status = GameState.IN_PROGRESS;}
        
        else if (pegs == 1){
            current_status = GameState.WIN;}

        else if (pegs > 1){
            current_status = GameState.STALEMATE;}

        return current_status; 
    }

    /*
     *This method will make a move on the board.
     * 
     * @param move the move to be made
     * @throws PegGameException if the move is invalid
     */
    public void makeMove(Move move) throws PegGameException{
        Collection<Move> possible_moves = getPossibleMoves(); 
        move = new Move(current_pos, move.getTo());

        if (possible_moves.contains(move))
        {
            //
            Location from = move.getFrom();
            Location to = move.getTo();
            Location middle = new Location((from.getRow() + to.getRow()) / 2, (from.getCol() + to.getCol()) / 2);
            
            EmptyHole[from.getRow()][from.getCol()] = true;
            EmptyHole[to.getRow()][to.getCol()] = false;
            EmptyHole[middle.getRow()][middle.getCol()] = true;
            
            pegs--;
            MoveMade = true;
            current_pos = to;

        }
        else
        {
            throw new PegGameException("Invalid move");
        }
    }


    /*
     * This method will return the current state of the game.
     * 
     * @param args the command-line arguments
     */
    public static void userInterface(){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        
        while (!quit) {
            System.out.print("Enter a command: ");
            String command = scanner.nextLine();
            
            String[] commandParts = command.split(" ");
            
            switch (commandParts[0]) {
                case "move":
                    if (commandParts.length != 5) {
                        System.out.println("Invalid move command. Usage: move r1 c1 r2 c2");
                        break;
                    }
                    
                    int r1 = Integer.parseInt(commandParts[1]);
                    int c1 = Integer.parseInt(commandParts[2]);
                    int r2 = Integer.parseInt(commandParts[3]);
                    int c2 = Integer.parseInt(commandParts[4]);
                    
                    try {
                        cmd_line game = new cmd_line(); // Create an instance of the cmd_line class
                        Move move = new Move(new Location(r1, c1), new Location(r2, c2));
                        game.makeMove(move); // Invoke the makeMove method on the instance
                        
                        GameState gameState = game.getGameState(); // Use the instance to get the game state
                        if (gameState == GameState.WIN) {
                            System.out.println("Congratulations! You won the game.");
                            quit = true;
                        } else if (gameState == GameState.STALEMATE) {
                            System.out.println("Game over. It's a stalemate.");
                            quit = true;
                        }
                    } catch (PegGameException e) {
                        System.out.println("Invalid move: " + e.getMessage());
                    }
                    
                    break;
                    
                case "quit":
                    System.out.println("Goodbye!");
                    quit = true;
                    break;
                    
                default:
                    System.out.println("Invalid command.");
                    break;
            }
        }
        
        scanner.close();
    }
}
