import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TriangleTest {

    @Test
    public void squareTest() {
        assertEquals(6, new Triangle(3, 4, 5).square());
    }

    @Test
    public void negativeSquareTest() {
        assertNotEquals(7, new Triangle(3, 4, 5).square());
    }
}