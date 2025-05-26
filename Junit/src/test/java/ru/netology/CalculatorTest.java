package ru.netology;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CalculatorTest {
    private final Calculator calculator = new Calculator();

    @Test
    void testAdd_validInputs_returnsCorrectResult() {
        // given
        int a = 5;
        int b = 3;

        // when
        int result = calculator.add(a, b);

        // then
        assertEquals(8, result, "Addition should return 8 for 5 + 3");
    }

    @Test
    void testDivide_byZero_throwsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(10, 0);
        });

        String expectedMessage = "Cannot divide by zero";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
