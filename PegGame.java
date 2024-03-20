package main.java.Assignment1;

import java.util.Collection;

public interface PegGame {

    public Collection<Location> getPossibleMoves();

    public GameState getGameState();

    public void makeMove(Move move) throws PegGameException;

}