package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for Calculator to demonstrate code coverage.
 */
public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testAdd() {
        assertEquals(5, calculator.add(2, 3), "2 + 3 should equal 5");
        assertEquals(0, calculator.add(-2, 2), "-2 + 2 should equal 0");
        assertEquals(-5, calculator.add(-2, -3), "-2 + -3 should equal -5");
    }

    @Test
    void testSubtract() {
        assertEquals(-1, calculator.subtract(2, 3), "2 - 3 should equal -1");
        assertEquals(-4, calculator.subtract(-2, 2), "-2 - 2 should equal -4");
        assertEquals(1, calculator.subtract(-2, -3), "-2 - -3 should equal 1");
    }

    @Test
    void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3), "2 * 3 should equal 6");
        assertEquals(-4, calculator.multiply(-2, 2), "-2 * 2 should equal -4");
        assertEquals(6, calculator.multiply(-2, -3), "-2 * -3 should equal 6");
    }

    @Test
    void testDivide() {
        assertEquals(2, calculator.divide(6, 3), "6 / 3 should equal 2");
        assertEquals(-2, calculator.divide(-6, 3), "-6 / 3 should equal -2");
        assertEquals(2, calculator.divide(-6, -3), "-6 / -3 should equal 2");
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(6, 0),
                "Dividing by zero should throw ArithmeticException");
    }

    @ParameterizedTest
    @CsvSource({
            "5, 3, 5",
            "3, 5, 5",
            "-5, -3, -3",
            "0, 0, 0"
    })
    void testMax(int a, int b, int expected) {
        assertEquals(expected, calculator.max(a, b), a + " max " + b + " should equal " + expected);
    }

    @Test
    void testIsPositive() {
        assertTrue(calculator.isPositive(5), "5 should be positive");
        assertFalse(calculator.isPositive(0), "0 should not be positive");
        assertFalse(calculator.isPositive(-5), "-5 should not be positive");
    }

    @Test
    void testAbs() {
        assertEquals(5, calculator.abs(5), "abs(5) should equal 5");
        assertEquals(5, calculator.abs(-5), "abs(-5) should equal 5");
        assertEquals(0, calculator.abs(0), "abs(0) should equal 0");
    }

    @Test
    void testFactorial() {
        assertEquals(1, calculator.factorial(0), "0! should equal 1");
        assertEquals(1, calculator.factorial(1), "1! should equal 1");
        assertEquals(120, calculator.factorial(5), "5! should equal 120");
    }

    @Test
    void testFactorialWithNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-1),
                "Factorial of negative number should throw IllegalArgumentException");
    }
}