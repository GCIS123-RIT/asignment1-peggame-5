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

    public void setFrom(Location from) {
        this.from = from;
    }

    public Location getTo() {
        return this.to;
    }

    @Override
    public String toString() {
        return "Move from " + this.from + " to " + this.to;
    }

    @Override
    public int hashCode() {
        return this.from.hashCode() + this.to.hashCode();
    }
}
