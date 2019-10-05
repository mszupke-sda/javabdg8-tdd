import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class AssertionsDemo {

    private Person person = new Person("Ja", "Kowalski");

    @Test
    @DisplayName("test poprawności imienia i nazwiska")
    void testImieNazwisko() {
        assertEquals(person.getFirstName(), "Jan");
        assertEquals(person.getLastName(), "Kowalski");

        // assertAll?

    }

    @Test
    @DisplayName("test poprawności imienia i nazwiska z assertAll")
    void testAssertAllImieNazwisko() {
        assertAll("person",
                () -> assertEquals(person.getFirstName(), "Jan"),
                () -> assertEquals(person.getLastName(), "Kowalski")
        );


    }

    @Test
    void depndantAssertions() {
        assertAll("properties",
                () -> {
                    assertEquals(person.getFirstName(), "Jan");
                    assertEquals(person.getLastName(), "Kowalski");

                    System.out.println("pierwsza grupa");
                },
                () -> {
                    assertEquals(person.getFirstName(), "Ja");
                    assertEquals(person.getLastName(), "Kowalski");

                    System.out.println("druga grupa");
                },
                () -> {
                    assertNotNull(person);
                });
    }

    @Test
    void timeoutTest() {
        // Duration.ofMillis(10)


    }

    @Test
    void timeoutNotExceeded() {
        assertTimeout(Duration.ofMillis(100), () -> {
            // ...
        });
    }

    @Test
    void timeoutNotExceededWithResult() {
        String result = assertTimeout(Duration.ofMillis(100), () -> "result");
        assertEquals(result, "result");
    }

    @Test
    void timeoutNotExceededWithMethod() {

        // uruchamia metodę i czeka na jej zakończenie

        final Calculator calculator = new Calculator();

        assertTimeout(Duration.ofMillis(10), () -> {
            calculator.add(1, 1);
        });
        // execution exceeded timeout of 10 ms by 93 ms
        //
    }

    @Test
    void timeoutPreemptivelyNotExceededWithMethod() {

        // uruchamia metodę i kończy sprawdzania natychmiast po przekroczeniu limitu czasu

        final Calculator calculator = new Calculator();

        assertTimeoutPreemptively(Duration.ofMillis(10), () -> {
            calculator.add(1, 1);
        });
        // execution timed out after 10 ms

    }

    @Test
    void failTest() {

        Person person = null;

        assertNull(person);

        person = new Person(null, null);



        assertNotNull(null);
        assertNotNull(new Object());
        fail();
        assertNotNull(new Object());
    }

    private static String greetings() {
        return "Hello, world!";
    }
}
