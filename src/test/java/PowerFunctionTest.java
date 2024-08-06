import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PowerFunctionTest {

    private final PowerFunction powerFunction = new PowerFunction();

    @Test
    public void testPositiveBasePositiveExponent() {
        assertEquals(8.0, powerFunction.computePower(2.0, 3.0), 1e-6);
    }

    @Test
    public void testPositiveBaseZeroExponent() {
        assertEquals(1.0, powerFunction.computePower(2.0, 0.0), 1e-6);
    }

    @Test
    public void testPositiveBaseNegativeExponent() {
        assertEquals(0.25, powerFunction.computePower(2.0, -2.0), 1e-6);
    }

    @Test
    public void testFractionalExponent() {
        assertEquals(1.414213562, powerFunction.computePower(2.0, 0.5), 1e-6);
    }

    @Test
    public void testNegativeBaseThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            powerFunction.computePower(-2.0, 3.0);
        });
        assertEquals("Base x must be a positive real number.", exception.getMessage());
    }
}
