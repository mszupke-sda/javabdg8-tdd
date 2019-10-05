import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class ParametrizedTestDemo {

    @ParameterizedTest
    @ValueSource(strings = { "a", "b", "c" })
    void test(String value) {
        assertTrue(Arrays.asList(new String[] {"a", "c"}).contains(value));
    }

    @ParameterizedTest
    @NullSource
    @EmptySource
    @NullAndEmptySource
    void nullOrEmpty(String value) {

    }

    @ParameterizedTest
    @NullAndEmptySource
    void nullAndEmpty(String value) {

    }

    @ParameterizedTest
    @EnumSource(value = Enum.class, names = { "A", "B" }, mode = EnumSource.Mode.EXCLUDE)
    void enumSourceTest(Enum e) {

    }

    @ParameterizedTest
    @MethodSource("stringProvider")
    void stringProviderTest(String value) {

    }

    @ParameterizedTest
    @MethodSource
    void stringProvider(String value) {

    }

    static Stream<String> stringProvider() {
        return Stream.of("str1", "str2");
    }

    enum Enum {
        A,
        B,
        C,
        D,
        E
    }
}
