import  org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MoveTest {
    @Test
    void testHashCode() {
        Location from1 = new Location(1, 3);
        Location to1 = new Location(3, 4);
        Location from2 = new Location(1, 3);
        Location to2 = new Location(3, 4);

        // Creating two idential moves with the same starting location that is 'from' and final location which is two and then comapring them

        Move move1 = new Move(from1, to1); 
        Move move2 = new Move(from2, to2);

        assertThat( move1.hashCode(), equalTo(move2.hashCode())); //the hash codes for equal object should be identical 
    }
}

