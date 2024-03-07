package main.java.Assignment_1;

public class MainGame implements PegGame
{
    public static final int BOARD_SIZE = 4;
    //row and col are equal to 0
    public Location Default = new Location();
    public Location[][] board = new Location[BOARD_SIZE][BOARD_SIZE];
    public GameState current = GameState.NOT_STARTED;


    public Collection<Move> getPossibleMoves()
    {
        return null;
    }

    public GameState getGameState()
    {
        return null;
    }

    public void makeMove(Move move) throws PegGameException
    {
        return;
    }
    

    public string toString()
    {
        return null;
    }
}