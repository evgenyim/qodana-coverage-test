#!/bin/bash

# Script to run tests with coverage

echo "Running tests with JaCoCo coverage..."
mvn clean test

echo ""
echo "JaCoCo coverage report generated at: target/site/jacoco/index.html"
echo ""
echo "To view the report, open the above file in a web browser."
echo ""
echo "For IntelliJ IDEA coverage, open the project in IntelliJ IDEA and run the"
echo "'CalculatorTest with Coverage' run configuration."