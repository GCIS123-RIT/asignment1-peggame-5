package main.java.Assignment_1;

public class Location {
    
    public int row;
    public int col;

    public Location(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Location() {
        this.row = 0;
        this.col = 0;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }
}
