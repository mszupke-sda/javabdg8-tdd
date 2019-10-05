public class Calculator {

    int add(int a, int b) {

        try {
            Thread.sleep(100);
        } catch (Exception e ) {
            // don't do that
        }

        return a + b;
    }

    int minus(int a, int b) {
        return a - b;
    }

    int multiply(int a, int b) {
        return a * b;
    }

    int divide(int a, int b) {
        return a / b;
    }
}
