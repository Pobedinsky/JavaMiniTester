import java.util.Arrays;
import java.util.List;

public class Main {

    public double squareFunction(double x) {
        return x * x;
    }

    public static void main(String[] args) {
        Main mainObj = new Main();

        List<Double> inputs = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);
        List<Double> expectedResults = Arrays.asList(1.0, 4.0, 9.0, 16.0, 25.0);

        FunctionTester<Double, Double> tester = new FunctionTester<>(
                inputs,
                expectedResults,
                mainObj::squareFunction
        );

        tester.testFunction();
    }
}
