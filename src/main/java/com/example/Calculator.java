package com.example;

/**
 * A simple calculator class to demonstrate code coverage.
 */
public class Calculator {

    /**
     * Adds two numbers.
     *
     * @param a first number
     * @param b second number
     * @return the sum of a and b
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Subtracts the second number from the first.
     *
     * @param a first number
     * @param b second number
     * @return a minus b
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Multiplies two numbers.
     *
     * @param a first number
     * @param b second number
     * @return the product of a and b
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Divides the first number by the second.
     *
     * @param a first number
     * @param b second number
     * @return a divided by b
     * @throws ArithmeticException if b is zero
     */
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    /**
     * Returns the maximum of two numbers.
     *
     * @param a first number
     * @param b second number
     * @return the maximum of a and b
     */
    public int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    /**
     * Checks if a number is positive.
     *
     * @param number the number to check
     * @return true if the number is positive, false otherwise
     */
    public boolean isPositive(int number) {
        return number > 0;
    }

    /**
     * Returns the absolute value of a number.
     *
     * @param number the number
     * @return the absolute value of the number
     */
    public int abs(int number) {
        if (number < 0) {
            return -number;
        }
        return number;
    }

    /**
     * Calculates the factorial of a non-negative integer.
     *
     * @param n the non-negative integer
     * @return the factorial of n
     * @throws IllegalArgumentException if n is negative
     */
    public long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}