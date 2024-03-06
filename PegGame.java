package main.java.Assignment_1;

public interface PegGame {
    public static final int BOARD_SIZE = 5;

    public abstract void getPossibleMoves(Location loc);

    public GameState getGameState();

    public void makeMove(Move move);

}
