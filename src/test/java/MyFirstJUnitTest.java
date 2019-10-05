import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test kalkulatora")
public class MyFirstJUnitTest {

    Calculator calculator = new Calculator();

    @DisplayName("test dodawania")
    @Test
    void calculatorAddTest() {
        assertEquals(4, calculator.add(2, 2));
        assertNotEquals(4, calculator.add(2, 3));
    }

    @DisplayName("test odejmowania")
    @Test
    void calculatorMinusTest() {
        assertEquals(2, calculator.minus(4, 2));
    }

    @DisplayName("test możenia")
    @Test
    void calculatorMultiplyTest() {
        assertEquals(4, calculator.multiply(2, 2));
    }

    @DisplayName("test dzielenia")
    @Test
    void calculatorDivideTest() {
        assertEquals(4, calculator.divide(8, 2));
    }

    @Test
    @DisplayName("test dzielenia przez zero")
    void calulatorDivideByZeroTest() {
        Exception exception = assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0));
        // assertEquals(exception.getMessage(), "/ by zero");
        assertTrue(exception instanceof ArithmeticException);
    }

    @Test
    void testCustomException() {
        Exception exception =
                assertThrows(CustomException.class, () -> method());
        assertTrue(exception instanceof CustomException);

        try {
            method();
            assertTrue(false);
        } catch (Exception ex) {
            assertTrue(ex instanceof CustomException);
        }
    }

    private void method() throws CustomException {
        // .....
        // throw new CustomException();
    }

    class CustomException extends Exception {

    }
}
