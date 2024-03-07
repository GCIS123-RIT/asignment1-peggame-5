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
    
    @Override
    public String toString() {
        return "From: " + this.from + " To: " + this.to;
    }

    /*
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !Move.class.isAssignableFrom(obj.getClass()) || ) 
        {
            return false;
        }

        final Move other = (Move) obj;
        if (!this.from.equals(other.from)) 
        {
            return false;
        }
        if (!this.to.equals(other.to)) 
        {
            return false;
        }
        return true;
    }
    */
}
