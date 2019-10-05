import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.EmptyStackException;
import java.util.Stack;

@DisplayName("Stack pop and peek tests")
public class StackPopAndPeekTests {

    private Stack<Object> stack;
    private String element = "element";

    @BeforeEach
    void beforeEach() {
        stack = new Stack<>();
    }

    @Test
    void emtpyStackTestOnPop() {
        assertThrows(EmptyStackException.class, stack::pop);
    }

    @Test
    void emptyStackTestOnPeek() {
        assertThrows(EmptyStackException.class, stack::peek);
    }

    @Nested
    class AfterNew {

        @BeforeEach
        void beforeEach() {
            stack.push(element);
        }

        @Test
        void popTest() {
            assertEquals(stack.pop(), element);
            assertTrue(stack.empty());
        }

        @Test
        void peekTest() {
            assertEquals(stack.peek(), element);
            assertFalse(stack.empty());
        }
    }
}
