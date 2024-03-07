package main.java.Assignment_1;

import java.util.Collection;

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

        // 8 possible moves
        Move move_left = new Move(current_pos, left_loc);
        Move move_right = new Move(current_pos, right_loc);
        Move move_up = new Move(current_pos, up_loc);
        Move move_down = new Move(current_pos, down_loc);
        Move move_upleft = new Move(current_pos, upleft_loc);
        Move move_upright = new Move(current_pos, upright_loc);
        Move move_downleft = new Move(current_pos, downleft_loc);
        Move move_downright = new Move(current_pos, downright_loc);

        Move[] possible_moves = 
        {
            move_left, 
            move_right, 
            move_up, 
            move_down, 
            move_upleft, 
            move_upright, 
            move_downleft, 
            move_downright
        };

        for (int i = 0; i < possible_moves.length; i++)
        {
            if (possible_moves[i].getTo().getRow() < 0 || 
            possible_moves[i].getTo().getRow() > BOARD_SIZE || 
            possible_moves[i].getTo().getCol() < 0 || 
            possible_moves[i].getTo().getCol() > BOARD_SIZE || 
            EmptyHole[possible_moves[i].getTo().getRow()][possible_moves[i].getTo().getCol()] == false)
            {
                possible_moves[i] = null;
            }
        }

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
            current_status = GameState.WON;}

        else if (pegs > 1){
            current_status = GameState.LOST;}

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