package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @Test
    void testPowerBaseCases() {
        assertEquals(1, calculator.power(5, 0), "Any number raised to 0 should be 1");
        assertEquals(5, calculator.power(5, 1), "Any number raised to 1 should be the number itself");
        assertEquals(25, calculator.power(5, 2), "5^2 should be 25");
    }

    @Test
    void testPowerWithNegativeExponent() {
        assertThrows(IllegalArgumentException.class, () -> calculator.power(2, -1),
                "Power with negative exponent should throw IllegalArgumentException");
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 8",
            "2, 10, 1024",
            "3, 4, 81",
            "5, 3, 125",
            "10, 0, 1"
    })
    void testPowerWithVariousInputs(int base, int exponent, long expected) {
        assertEquals(expected, calculator.power(base, exponent),
                base + " raised to " + exponent + " should equal " + expected);
    }

    @Test
    void testGcdBaseCases() {
        assertEquals(5, calculator.gcd(0, 5), "GCD(0, 5) should be 5");
        assertEquals(5, calculator.gcd(5, 0), "GCD(5, 0) should be 5");
        assertEquals(1, calculator.gcd(7, 13), "GCD of coprime numbers should be 1");
    }

    @Test
    void testGcdWithBothZeros() {
        assertThrows(IllegalArgumentException.class, () -> calculator.gcd(0, 0),
                "GCD(0, 0) should throw IllegalArgumentException");
    }

    @ParameterizedTest
    @CsvSource({
            "12, 18, 6",
            "48, 36, 12",
            "101, 103, 1",
            "15, 25, 5",
            "-12, 18, 6",
            "12, -18, 6",
            "-12, -18, 6"
    })
    void testGcdWithVariousInputs(int a, int b, int expected) {
        assertEquals(expected, calculator.gcd(a, b),
                "GCD(" + a + ", " + b + ") should be " + expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31})
    void testIsPrimeWithPrimeNumbers(int number) {
        assertTrue(calculator.isPrime(number), number + " should be identified as prime");
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18, 20, 21})
    void testIsPrimeWithNonPrimeNumbers(int number) {
        assertFalse(calculator.isPrime(number), number + " should be identified as non-prime");
    }

    @Test
    void testFibonacciBaseCases() {
        assertEquals(0, calculator.fibonacci(0), "fibonacci(0) should be 0");
        assertEquals(1, calculator.fibonacci(1), "fibonacci(1) should be 1");
        assertEquals(1, calculator.fibonacci(2), "fibonacci(2) should be 1");
    }

    @Test
    void testFibonacciWithNegativeInput() {
        assertThrows(IllegalArgumentException.class, () -> calculator.fibonacci(-1),
                "Fibonacci of negative position should throw IllegalArgumentException");
    }

    @ParameterizedTest
    @CsvSource({
            "3, 2",
            "4, 3",
            "5, 5",
            "6, 8",
            "7, 13",
            "8, 21",
            "9, 34",
            "10, 55"
    })
    void testFibonacciSequence(int position, long expected) {
        assertEquals(expected, calculator.fibonacci(position),
                "fibonacci(" + position + ") should be " + expected);
    }

    @Test
    void testSumOfDigitsBasicCases() {
        assertEquals(5, calculator.sumOfDigits(5), "Sum of digits of 5 should be 5");
        assertEquals(9, calculator.sumOfDigits(9), "Sum of digits of 9 should be 9");
        assertEquals(6, calculator.sumOfDigits(123), "Sum of digits of 123 should be 6");
        assertEquals(10, calculator.sumOfDigits(1234), "Sum of digits of 1234 should be 10");
    }

    @Test
    void testSumOfDigitsWithNegativeNumber() {
        assertEquals(6, calculator.sumOfDigits(-123), "Sum of digits of -123 should be 6");
    }

    // Note: Intentionally not testing some cases to demonstrate coverage gaps

    @Test
    void testDigitalRootBasicCases() {
        assertEquals(5, calculator.digitalRoot(5), "Digital root of 5 should be 5");
        assertEquals(9, calculator.digitalRoot(9), "Digital root of 9 should be 9");
        assertEquals(6, calculator.digitalRoot(123), "Digital root of 123 should be 6");
        assertEquals(1, calculator.digitalRoot(1234), "Digital root of 1234 should be 1");
    }

    // Note: Intentionally not testing negative numbers and recursive cases to demonstrate coverage gaps

    @Test
    void testIsPalindromeBasicCases() {
        assertTrue(calculator.isPalindrome(121), "121 should be a palindrome");
        assertTrue(calculator.isPalindrome(12321), "12321 should be a palindrome");
        assertFalse(calculator.isPalindrome(123), "123 should not be a palindrome");
    }

    // Note: Intentionally not testing negative numbers and single-digit numbers to demonstrate coverage gaps
}
