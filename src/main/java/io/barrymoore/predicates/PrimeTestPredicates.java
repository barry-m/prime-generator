package io.barrymoore.predicates;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

public class PrimeTestPredicates {
    static List<Integer> smallPrimes = Arrays.asList(
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
            97, 101);

    // Default algorithm
    public static Function<Integer, Boolean> Function1 = new Function<Integer, Boolean>() {
        @Override
        public Boolean apply(Integer n) {
            if (n <= 1)
                return false;
            else if (n <= 3)
                return true;
            else if (n % 2 == 0 || n % 3 == 0)
                return false;

            int i = 5;
            while ((i * i) <= n) {
                if ((n % i == 0) || (n % (i + 2) == 0))
                    return false;
                i = i + 6;
            }
            return true;
        }
    };

    public static Function<Integer, Boolean> Function2 = new Function<Integer, Boolean>() {
        @Override
        public Boolean apply(Integer n) {
            if (n == 1) return false;
            if (n == 2) return true;
            if (n % 2 == 0) return false;

            for (int d = 3; d <= (int) Math.sqrt(n); d++)
                if (n % d == 0)
                    return false;
            return true;
        }
    };

    public static Function<Integer, Boolean> Function3 = new Function<Integer, Boolean>() {
        /**
         * Function to calculate (a ^ b) % c
         **/
        private long modPow(long a, long b, long c) {
            long res = 1;
            for (int i = 0; i < b; i++) {
                res *= a;
                res %= c;
            }
            return res % c;
        }

        /**
         * Function to calculate (a * b) % c
         **/
        private long mulMod(long a, long b, long mod) {
            return BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)).mod(BigInteger.valueOf(mod)).longValue();
        }

        @Override
        public Boolean apply(Integer n) {
            int iteration = 50;

            /** base case **/
            if (n == 0 || n == 1)
                return false;
            /** base case - 2 is prime **/
            if (n == 2)
                return true;
            /** an even number other than 2 is composite **/
            if (n % 2 == 0)
                return false;

            long s = n - 1;
            while (s % 2 == 0)
                s /= 2;

            Random rand = new Random();
            for (int i = 0; i < iteration; i++) {
                long r = Math.abs(rand.nextLong());
                long a = r % (n - 1) + 1, temp = s;
                long mod = modPow(a, temp, n);
                while (temp != n - 1 && mod != 1 && mod != n - 1) {
                    mod = mulMod(mod, mod, n);
                    temp *= 2;
                }
                if (mod != n - 1 && temp % 2 == 0)
                    return false;
            }
            return true;
        }
    };
}