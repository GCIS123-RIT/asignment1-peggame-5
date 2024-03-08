import static org.junit.jupiter.api.Assertions.*;

import javax.tools.DocumentationTool.Location;

import org.junit.jupiter.api.Test;
@Testable
public class LocationTest {

    @Test
    void testConstructorAndGetters() {
        Location expecteLocation = new Location(2, 3);
        Integer ExpectedRow = 2;
        Integer ExpectedColumn = 3;
        assertEquals(ExpectedRow, excpectedlocation.getRow());
        assertEquals(ExpectedColumn, expectedlocation.getCol());
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

        assertTrue(location1.equals(location2)); // Same row and col
        assertFalse(location1.equals(location3)); // Different row and col
    }
}

