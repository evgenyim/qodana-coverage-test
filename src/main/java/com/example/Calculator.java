package com.example;

/**
 * A simple calculator class to demonstrate code coverage.
 * Extended with additional mathematical functions.
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

    /**
     * Calculates the power of a number.
     *
     * @param base the base
     * @param exponent the exponent (must be non-negative)
     * @return base raised to the power of exponent
     * @throws IllegalArgumentException if exponent is negative
     */
    public long power(int base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Exponent must be non-negative");
        }

        if (exponent == 0) {
            return 1;
        }

        if (exponent == 1) {
            return base;
        }

        // Optimization for even exponents
        if (exponent % 2 == 0) {
            long halfPower = power(base, exponent / 2);
            return halfPower * halfPower;
        } else {
            return base * power(base, exponent - 1);
        }
    }

    /**
     * Calculates the greatest common divisor (GCD) of two integers.
     *
     * @param a first integer
     * @param b second integer
     * @return the greatest common divisor of a and b
     * @throws IllegalArgumentException if both a and b are zero
     */
    public int gcd(int a, int b) {
        // Handle negative numbers by using absolute values
        a = abs(a);
        b = abs(b);

        // GCD is not defined when both numbers are 0
        if (a == 0 && b == 0) {
            throw new IllegalArgumentException("GCD is not defined for (0, 0)");
        }

        // GCD(0, b) = b and GCD(a, 0) = a
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }

        // Euclidean algorithm
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }

    /**
     * Checks if a number is prime.
     *
     * @param n the number to check
     * @return true if the number is prime, false otherwise
     */
    public boolean isPrime(int n) {
        // Handle special cases
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }

        // Check divisibility by numbers of form 6k ± 1
        int i = 5;
        while (i * i <= n) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
            i += 6;
        }

        return true;
    }

    /**
     * Calculates the nth Fibonacci number.
     * The sequence starts with 0, 1, 1, 2, 3, 5, ...
     *
     * @param n the position in the Fibonacci sequence (0-based)
     * @return the nth Fibonacci number
     * @throws IllegalArgumentException if n is negative
     */
    public long fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Position must be non-negative");
        }

        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        long prev = 1;
        long curr = 1;
        long next;

        for (int i = 3; i <= n; i++) {
            next = prev + curr;
            prev = curr;
            curr = next;
        }

        return curr;
    }

    /**
     * Calculates the sum of digits in a number.
     *
     * @param number the number
     * @return the sum of digits
     */
    public int sumOfDigits(int number) {
        // Handle negative numbers by using absolute value
        number = abs(number);

        // Base case
        if (number < 10) {
            return number;
        }

        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        return sum;
    }

    /**
     * Calculates the digital root of a number.
     * The digital root is the recursive sum of all the digits in a number.
     *
     * @param number the number
     * @return the digital root
     */
    public int digitalRoot(int number) {
        // Handle negative numbers by using absolute value
        number = abs(number);

        // Base case
        if (number < 10) {
            return number;
        }

        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        // Recursively sum until we get a single digit
        if (sum >= 10) {
            return digitalRoot(sum);
        }

        return sum;
    }

    /**
     * Checks if a number is a palindrome.
     * A palindrome reads the same backward as forward.
     *
     * @param number the number to check
     * @return true if the number is a palindrome, false otherwise
     */
    public boolean isPalindrome(int number) {
        // Handle negative numbers
        if (number < 0) {
            return false;
        }

        // Single digit numbers are palindromes
        if (number < 10) {
            return true;
        }

        // Find the reverse of the number
        int original = number;
        int reverse = 0;

        while (number > 0) {
            int digit = number % 10;
            reverse = reverse * 10 + digit;
            number /= 10;
        }

        return original == reverse;
    }
}
