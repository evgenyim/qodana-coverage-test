# Qodana Coverage Test

This project demonstrates how to set up and run code coverage for Java projects using both JaCoCo and IntelliJ IDEA coverage tools.

## Project Structure

- `src/main/java/com/example/Calculator.java`: A simple calculator class with various methods to demonstrate code coverage
- `src/test/java/com/example/CalculatorTest.java`: JUnit 5 tests for the Calculator class

## Running Tests with Coverage

### Using Maven and JaCoCo

JaCoCo is configured in the `pom.xml` file. To run tests with JaCoCo coverage:

```bash
mvn clean test
```

Or use the convenience script:

```bash
./run-coverage.sh
```

The JaCoCo coverage report will be generated in the `target/site/jacoco` directory. Open the `index.html` file in a web browser to view the coverage report.

### Using IntelliJ IDEA Coverage

1. Open the project in IntelliJ IDEA
2. Select the "CalculatorTest with Coverage" run configuration
3. Right-click and select "Run 'CalculatorTest with Coverage'"
4. View the coverage results in the Coverage tool window

## Coverage Report Interpretation

Both JaCoCo and IntelliJ IDEA coverage reports provide:

- **Line Coverage**: Percentage of code lines that were executed
- **Branch Coverage**: Percentage of branches (if/else, switch cases) that were executed
- **Method Coverage**: Percentage of methods that were called

## Tips for Improving Coverage

1. Write tests for edge cases (e.g., division by zero)
2. Use parameterized tests for methods with multiple execution paths
3. Test exception handling
4. Ensure all branches in conditional statements are tested
