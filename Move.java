package main.java.Assignment_1;

public class Move {
    public Location from;
    public Location to;

    public Move(Location from, Location to) {
        this.from = from;
        this.to = to;
    }

    public Location getFrom() {
        return this.from;
    }
    
    public Location getTo() {
        return this.to;
    }
    
}
