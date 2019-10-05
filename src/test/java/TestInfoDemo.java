import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("TestInfo demo")
public class TestInfoDemo {

    public TestInfoDemo(TestInfo testInfo) {
        assertEquals("TestInfo demo", testInfo.getDisplayName());
    }

    @Test
    @Tag("my-tag")
    @DisplayName("test")
    void test(TestInfo testInfo) {
        assertEquals("test", testInfo.getDisplayName());
        assertTrue(testInfo.getTags().contains("my-tag"));
    }


}
