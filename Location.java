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

    @Override
    public string toString() {
        return "Row: " + this.row + " Col: " + this.col;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) 
        {
            return false;
        }
        if (!Location.class.isAssignableFrom(obj.getClass())) 
        {
            return false;
        }

        final Location other = (Location) obj;
        if (this.row != other.row) 
        {
            return false;
        }
        if (this.col != other.col) 
        {
            return false;
        }
        return true;
    }

}
