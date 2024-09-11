# JavaMiniTester

## Overview

The `FunctionTester` class is designed to help users test functions in Java. It takes in a list of input values, expected results, and a function to test. The class then applies the function to each input and compares the result to the expected output. If the results match, the test passes; otherwise, it fails.

## Class Definition

```java
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
```
## How to Use

Step 1: Create Input and Expected Output Lists
Define a list of inputs and a list of expected results. The input list contains the values that will be passed to the function, and the expected result list contains the corresponding expected outputs.

Step 2: Define the Function to Test
Create a function using Java's Function<T, R> interface. This function will be tested with the input values.

Step 3: Instantiate FunctionTester
Pass the input list, expected results list, and function to the FunctionTester constructor.

Step 4: Run Tests
Call the testFunction() method to run the test. It will print whether each test passed or failed.

##Example
Below is an example of how to use the FunctionTester class to test a function that squares an integer:

```java
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        // Define inputs
        List<Integer> inputs = Arrays.asList(1, 2, 3, 4, 5);

        // Define expected outputs
        List<Integer> expectedResults = Arrays.asList(1, 4, 9, 16, 25);

        // Define the function to test: square a number
        Function<Integer, Integer> squareFunction = (n) -> n * n;

        // Create a FunctionTester instance
        FunctionTester<Integer, Integer> tester = new FunctionTester<>(inputs, expectedResults, squareFunction);

        // Run the test
        tester.testFunction();
    }
}
```
# Output
```
Test passed for input 1. Expected result: 1, Actual result: 1
Test passed for input 2. Expected result: 4, Actual result: 4
Test passed for input 3. Expected result: 9, Actual result: 9
Test passed for input 4. Expected result: 16, Actual result: 16
Test passed for input 5. Expected result: 25, Actual result: 25
```

# Testing Other Functions
You can easily swap out the function you want to test. For example, to test a function that returns the length of a string:

```java
List<String> inputs = Arrays.asList("apple", "banana", "cherry");
List<Integer> expectedResults = Arrays.asList(5, 6, 6);
Function<String, Integer> lengthFunction = (s) -> s.length();

FunctionTester<String, Integer> stringTester = new FunctionTester<>(inputs, expectedResults, lengthFunction);
stringTester.testFunction();
```
# Output:
```
Test passed for input apple. Expected result: 5, Actual result: 5
Test passed for input banana. Expected result: 6, Actual result: 6
Test passed for input cherry. Expected result: 6, Actual result: 6
```

# Non-lambda styled functions

"Usual" functions can be tested to, for example:

```java

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
```

# Output

```
Test passed for input 1.0. Expected result: 1.0, Actual result: 1.0
Test passed for input 2.0. Expected result: 4.0, Actual result: 4.0
Test passed for input 3.0. Expected result: 9.0, Actual result: 9.0
Test passed for input 4.0. Expected result: 16.0, Actual result: 16.0
Test passed for input 5.0. Expected result: 25.0, Actual result: 25.0
```
