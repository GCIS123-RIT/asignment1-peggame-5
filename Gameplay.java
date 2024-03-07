import java.util.Collection;
import java.util.ArrayList;

public class Gameplay implements PegGame
{
    public int BOARD_SIZE;
    public int pegs = BOARD_SIZE * BOARD_SIZE - 1;
   
    public Location board [][];
    public boolean EmptyHole[][];

    public int start_row = 3;
    public int start_col = 1;
    public Location current_pos = new Location(start_row, start_col);

    public boolean MoveMade = false;
    public GameState current_status;

    /*this setups individual location values for each psoition on the board
    * @return void
    */
    public void setupBoard()
    {
        for (int i = 0; i <= BOARD_SIZE; i++)
        {
            for (int j = 0; j <= BOARD_SIZE; j++)
            {
                board[i][j] = new Location(i, j);
                EmptyHole[i][j] = false;
            }
        }

        EmptyHole[current_pos.getRow()][current_pos.getCol()] = true;
    }

    /*
     * This method will return a collection of all possible moves that can be made on the board.
     * 
     * @return a collection of all possible moves that can be made on the board
     */
    public Collection<Move> getPossibleMoves()
    {
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
    public GameState getGameState()
    {
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
     * This method will make a move on the board.
     * 
     * @param move the move to make
     * @throws PegGameException if the move is invalid
     */
    public void makeMove(Move move) throws PegGameException
    {
        Collection<Move> possible_moves = getPossibleMoves();
        
        if (possible_moves.contains(move))
        {
            Location from = move.getFrom();
            Location to = move.getTo();
            Location middle = new Location((from.getRow() + to.getRow()) / 2, (from.getCol() + to.getCol()) / 2);
            EmptyHole[from.getRow()][from.getCol()] = true;
            EmptyHole[to.getRow()][to.getCol()] = false;
            EmptyHole[middle.getRow()][middle.getCol()] = true;
            pegs--;
            current_pos = to;
            MoveMade = true;
        }
        else
        {
            throw new PegGameException("Invalid move");
        }
    }
    
    /*
     * You will need to implement a toString() that can be used to display the board. Use "-" (hyphen) 
     * to represent empty holes and "o" (lowercase o) to represent pegs on
     * the board.
     * 
     * @return a string representation of the board
     */
    @Override
    public String toString()
    {
        String board_string = "";
        for (int i = 0; i < BOARD_SIZE; i++)
        {
            for (int j = 0; j < BOARD_SIZE; j++)
            {
                if (EmptyHole[i][j] == true)
                {
                    board_string += "-";
                }
                else
                {
                    board_string += "o";
                }
            }
            board_string += "\n";
        }
        return board_string;
    }
}