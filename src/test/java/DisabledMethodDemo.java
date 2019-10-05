import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DisabledMethodDemo {

    @Test
    @Disabled("z powodu buga")
    void test() {

    }

    @Test
    void test2() {

    }
}
