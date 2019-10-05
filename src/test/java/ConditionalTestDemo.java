import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class ConditionalTestDemo {

    @Test
    @EnabledOnOs(OS.MAC)
    void enabledOnOs() {

    }

    @Test
    @DisabledOnOs({ OS.WINDOWS, OS.LINUX })
    void disabledOnOs() {

    }

    @Test
    @EnabledOnJre(JRE.JAVA_12)
    void enabledOnJre() {

    }

    @Test
    @DisabledOnJre({ JRE.JAVA_9, JRE.JAVA_12 })
    void disableOnJre() {

    }

    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64*.")
    void EnabledIfSystemProperty() {

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = ".*develop*.")
    void EnabledIfEnvironmentVariable() {

    }

    @Test
    @EnabledIf("2 * 3 == 7")
    void EnabledIf() {

    }
}
