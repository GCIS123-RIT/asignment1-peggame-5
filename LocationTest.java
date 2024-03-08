import static org.junit.jupiter.api.Assertions.*;

import javax.tools.DocumentationTool.Location;

import org.junit.jupiter.api.Test;
@Testable
public class LocationTest {

    @Test
    void testConstructorAndGetters() {
        Location expecteLocation = new Location(2, 3);
        Integer ActualRow = 2;
        Integer ActualColumn = 3;
        assertEquals(ActualRow, excpectedlocation.getRow()); // testing if the expected and the actual Row value are the same
        assertEquals(ActualColumn, expectedlocation.getCol()); //testing if the expected and the actual col value are the same
    }

    @Test
    void testToString() {
        Location expected = new Location(4, 5);
        String Actual = "Row: 4 Col: 5";
        assertEquals(Actual, expected.toString());
        
    }

    @Test
    void testEquals() {
        Location location1 = new Location(2, 3);
        Location location2 = new Location(2, 3);
        Location location3 = new Location(3, 2);

        assertTrue(location1.equals(location2)); // Testing if the the boolean function of the Location file will correctly return true for two locations with same row and col value 
        assertFalse(location1.equals(location3)); // Different row and col value should be returned as false
    }
}

