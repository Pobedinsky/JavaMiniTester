import java.util.List;
import java.util.function.Function;

public class FunctionTester<T, R> {
    private List<T> inputs;
    private List<R> expectedResults;
    private Function<T, R> functionToTest;

    public FunctionTester(List<T> inputs, List<R> expectedResults, Function<T, R> functionToTest) {
        this.inputs = inputs;
        this.expectedResults = expectedResults;
        this.functionToTest = functionToTest;
    }
    

    public void testFunction() {
        for (int i = 0; i < inputs.size(); i++) {
            T input = inputs.get(i);
            R expectedResult = expectedResults.get(i);
            R actualResult = functionToTest.apply(input);

            if (actualResult.equals(expectedResult)) {
                System.out.println("Test passed for input " + input + ". Expected result: " + expectedResult + ", Actual result: " + actualResult);
            } else {
                System.out.println("Test failed for input " + input + ". Expected result: " + expectedResult + ", Actual result: " + actualResult);
            }
        }
    }
}
