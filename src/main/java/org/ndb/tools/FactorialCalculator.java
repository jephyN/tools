package org.ndb.tools;

import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FactorialCalculator {

    private static final Logger logger = Logger.getLogger(FactorialCalculator.class.getName());

    /**
     * Calculates the factorial of a given integer n (0 <= n <= 100).
     * The factorial of a non-negative integer n is the product of all positive integers less than or equal to n.
     *
     * @param n the non-negative integer for which the factorial is to be calculated, must be in the range 0 to 100
     * @return the factorial of n as a {@code BigInteger}
     * @throws IllegalArgumentException if n is outside the range 0 to 100
     */
    public static BigInteger factorial(int n) {
        if (n < 0 || n > 100) {
            throw new IllegalArgumentException("The number must be between 0 and 100");
        }

        if( n > 0)
            return BigInteger.valueOf(n).multiply(factorial(n - 1));
        else
            return BigInteger.ONE;
    }

    public static void main(String[] args) {
        try {
            int n = 10;
            BigInteger factorialResult = factorial(n);
            logger.log(Level.INFO, "The factorial of {0} is : {1}", new Object[]{n, factorialResult});
        } catch (IllegalArgumentException e) {
            logger.severe(e.getMessage());
        }
    }
}
