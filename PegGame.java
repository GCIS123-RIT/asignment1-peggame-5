package main.java.Assignment_1;

import java.util.Collection;

public interface PegGame {

    public Collection<Move> getPossibleMoves();

    public GameState getGameState();

    public void makeMove(Move move) throws PegGameException;

}
