package main.java.Assignment_1;

import java.util.Collection;

public class Gameplay implements PegGame
{
    public int BOARD_SIZE;
    public int pegs = BOARD_SIZE * BOARD_SIZE - 1;
   
    public Location board [][];

    public Location current_pos = new Location();

    public GameState current_status;

    /*this setups individual location values for each psoition on the board
    * @return void
    */
    public void setupBoard()
    {
        for (int i = 0; i < BOARD_SIZE; i++)
        {
            for (int j = 0; j < BOARD_SIZE; j++)
            {
                board[i][j] = new Location(i, j);
            }
        }
    }




    public Collection<Move> getPossibleMoves()
    {
        Location left_loc = new Location(current_pos.row, current_pos.col - 2);
        Location right_loc = new Location(current_pos.row, current_pos.col + 2);
        Location up_loc = new Location(current_pos.row - 2, current_pos.col);
        Location down_loc = new Location(current_pos.row + 2, current_pos.col);
        Location upleft_loc = new Location(current_pos.row - 2, current_pos.col - 2);
        Location upright_loc = new Location(current_pos.row - 2, current_pos.col + 2);
        Location downleft_loc = new Location(current_pos.row + 2, current_pos.col - 2);
        Location downright_loc = new Location(current_pos.row + 2, current_pos.col + 2);



        Move[] possible_moves = 
        {
            new Move(current_pos, left_loc), 
            new Move(current_pos, right_loc),
            new Move(current_pos, up_loc),
            new Move(current_pos, down_loc),
            new Move(current_pos, upleft_loc),
            new Move(current_pos, upright_loc),
            new Move(current_pos, downleft_loc),
            new Move(current_pos, downright_loc)
        };

        for (int i = 0; i < possible_moves.length; i++)
        {
            if (possible_moves[i].row < 0 || possible_moves[i].row >= BOARD_SIZE || possible_moves[i].col < 0 || possible_moves[i].col >= BOARD_SIZE)
            {
                possible_moves[i] = null;
            }
        }

        return possible_moves;
    }

    public GameState getGameState()
    {
        return current;
    }

    public void makeMove(Move move) throws PegGameException
    {
        boolean MoveMade = false;
        Collection<Move> possible_moves = getPossibleMoves();
        
        if (MoveMade == true){
            current_status = GameState.IN_PROGRESS;}

    }
    

    /*
     * You will need to implement a toString() that can be used to display the board. Use "-" (hyphen) 
     * to represent empty holes and "o" (lowercase o) to represent pegs on
     * the board.
     * 
     * @return a string representation of the board
     */
    // !!!! incomplete
    @Override
    public String toString()
    {
        String board_string = "";
        for (int i = 0; i < BOARD_SIZE; i++)
        {
            for (int j = 0; j < BOARD_SIZE; j++)
            {
                if (board[i][j] == null)
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
    // !!!! incomplete
}