package it.milani.p02;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {
    /*
        Modeling pegs as vector X = [x_1, x_2, ..., x_n],
        modeling gears as vector Y = [y_1, y_2, ..., y_n]
        and knowing that last gear has to be double of the first one,
        the problem can be reduced to the solution of the following linear system:
        __
        | x_1 + x_2 = y_2 - y_1
        | x_2 + x_3 = y_3 - y_2
        | ...
        | x_n-1 + x_n = y_n - y_n-1
        | y_n = y_1 / 2
        --
        Given:
            s = +1 for n even; -1 for n odd
            m = 2/3 for n even; 2 for n odd
        the system has the following solution:
            y_1 = m * { - x_1 + 2 * ( x_2 - x_3 + x_4 - x_5 + ... + (1 for index even; -1 for index odd) * x_n-1 ] + s * x_n }
     */
    public static int[] solution(int[] pegs) {
        // pegs list with less than 2 values are not allowed
        if (pegs.length < 2)
            return new int[]{-1, -1};
        // calculate the sum of middle values with alternating signs
        final AtomicInteger index = new AtomicInteger();
        final int middleValue = Arrays.stream(pegs, 1, pegs.length - 1)
                .map(r -> index.getAndIncrement() % 2 == 0 ? r : -r)
                .sum();
        final boolean hasEvenValues = pegs.length % 2 == 0;
        final int differanceBetweenFirstAndLastRadius = (-pegs[0] + 2 * middleValue + (hasEvenValues ? 1 : -1) * pegs[pegs.length - 1]);
        final Fraction radius = new Fraction(2 * differanceBetweenFirstAndLastRadius, hasEvenValues ? 3 : 1);
        // verify radius values in the middle if are compatibles with given constraints
        if (!verifyResult(pegs, radius))
            return new int[]{-1, -1};
        return new int[]{radius.getNumerator(), radius.getDenominator()};
    }

    private static boolean verifyResult(int[] pegs, Fraction initialRadius) {
        // radius must be greater than/equals 1
        if (!initialRadius.subtract(new Fraction(1,1)).isPositiveOrZero())
            return false;
        // when length is less than 2 I've finished
        if (pegs.length < 2)
            return true;
        final Fraction nextRadius = new Fraction(pegs[1] - pegs[0], 1).subtract(initialRadius);
        return verifyResult(Arrays.copyOfRange(pegs, 1, pegs.length), nextRadius);
    }

    public static class Fraction {

        private int numerator;
        private int denominator;

        public Fraction(int num, int den) {
            numerator = num;
            denominator = den;
            reduce();
        }

        public int getNumerator() {
            return numerator;
        }

        public int getDenominator() {
            return denominator;
        }

        public boolean isPositiveOrZero() {
            return numerator * denominator > 0;
        }

        public static int gcd(int numerator, int denominator) {
            if (numerator % denominator == 0) {
                return denominator;
            }
            return gcd(denominator, numerator % denominator);
        }

        void reduce() {
            int gcd = gcd(numerator, denominator);
            numerator /= gcd;
            denominator /= gcd;
        }

        public Fraction add(Fraction fractionTwo) {
            int num = (numerator * fractionTwo.getDenominator()) +
                    (fractionTwo.getNumerator() * denominator);
            int den = denominator * fractionTwo.getDenominator();
            return new Fraction(num, den);
        }

        public Fraction subtract(Fraction fractionTwo) {
            int newNumerator = (numerator * fractionTwo.denominator) -
                    (fractionTwo.numerator * denominator);
            int newDenominator = denominator * fractionTwo.denominator;
            return new Fraction(newNumerator, newDenominator);
        }

    }
}