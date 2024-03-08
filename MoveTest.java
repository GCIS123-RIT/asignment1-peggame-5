import  org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
@Testable
public class MoveTest {

    @Test
    void testConstructorAndGetters() {
        Location from = new Location(1, 2);
        Location to = new Location(3, 4);
        Move move = new Move(from, to);
        
        assertThat( move.getFrom(), equalTo(from)); //From location should match the expected value
        assertThat( move.getTo(), equalTo(to)); //To location should match the expected value
    }

    @Test
    void testToString() {
        Location from = new Location(1, 2);
        Location to = new Location(3, 4);
        Move move = new Move(from, to);
        
        assertThat(
                move.toString(), equalTo("Move from Row: 1 Col: 2 to Row: 3 Col: 4")); //" Testing to check that string representation match the expected format"
    }

    @Test
    void testHashCode() {
        Location from1 = new Location(1, 2);
        Location to1 = new Location(3, 4);
        Location from2 = new Location(1, 2);
        Location to2 = new Location(3, 4);

        // Creating two idential moves with the same starting location that is 'from' and final location which is two and then comapring them

        Move move1 = new Move(from1, to1); 
        Move move2 = new Move(from2, to2);

        assertThat("Hash codes should be equal for equal objects", move1.hashCode(), equalTo(move2.hashCode()));
    }
}

