import org.junit.jupiter.api.*;

@DisplayName("Testy wielokrotne")
public class RepeatedTestDemo {

    @BeforeEach
    void beforeEach(
            TestInfo testInfo,
            RepetitionInfo repetitionInfo,
            TestReporter testReporter) {

        int currentRepetition = repetitionInfo.getCurrentRepetition();
        int totalRepetitions = repetitionInfo.getTotalRepetitions();
        String methodName = testInfo.getDisplayName();

        testReporter.publishEntry(
                String.format("About to execute repetition %d of %d for %s",
                currentRepetition,
                totalRepetitions,
                methodName));
    }

    @RepeatedTest(10)
    void repeatedTest() {

    }

    @RepeatedTest(value = 2, name = "{displayName}")
    @DisplayName("Repeat!")
    void customDisplayNameTest(TestInfo testInfo, TestReporter testReport) {
        testReport.publishEntry(testInfo.getDisplayName());
    }
}
