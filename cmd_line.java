import java.util.Collection;

public class cmd_line implements PegGame {
    
    public int BOARD_SIZE;
    public int pegs = BOARD_SIZE * BOARD_SIZE - 1;
   
    public Location board [][];
    public boolean EmptyHole[][];

    public int start_row = 3;
    public int start_col = 1;
    public Location current_pos = new Location(start_row, start_col);

    public boolean MoveMade = false;
    public GameState current_status;

    public Collection<Move> getPossibleMoves(){
        return null;
    }

    public GameState getGameState(){
        return null;
    }

    public void makeMove(Move move) throws PegGameException{
        return;
    }

    //Include a static method that, given any instance of the PegGame interface will allow a user to enter commands into standard input and play until completion or until they quit.
    public static void main(String[] args){
        return;
    }
}
