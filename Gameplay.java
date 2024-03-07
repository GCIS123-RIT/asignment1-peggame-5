package main.java.Assignment_1;

import java.util.Collection;

public class Gameplay implements PegGame
{
    public int BOARD_SIZE;
    //Rows and columns are numbered beginning with 0.
    public int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
    public Location current_pos = new Location();

    public GameState current_status;


    public Collection<Move> getPossibleMoves()
    {
        Location leftmove = new Location(current_pos.row, current_pos.col - 2);
        Location rightmove = new Location(current_pos.row, current_pos.col + 2);
        Location upmove = new Location(current_pos.row - 2, current_pos.col);
        Location downmove = new Location(current_pos.row + 2, current_pos.col);
        Location upleftmove = new Location(current_pos.row - 2, current_pos.col - 2);
        Location uprightmove = new Location(current_pos.row - 2, current_pos.col + 2);
        Location downleftmove = new Location(current_pos.row + 2, current_pos.col - 2);
        Location downrightmove = new Location(current_pos.row + 2, current_pos.col + 2);

        Move[] possible_moves = 
        {
            new Move(current_pos, leftmove), 
            new Move(current_pos, rightmove),
            new Move(current_pos, upmove),
            new Move(current_pos, downmove),
            new Move(current_pos, upleftmove),
            new Move(current_pos, uprightmove),
            new Move(current_pos, downleftmove),
            new Move(current_pos, downrightmove)
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
        
    }
}