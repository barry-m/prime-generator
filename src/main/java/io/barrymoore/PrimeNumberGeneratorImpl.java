package io.barrymoore;

import org.apache.commons.math3.primes.Primes;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumberGeneratorImpl implements PrimeNumberGenerator {

    public List<Integer> generate(int x, int y) {
        return IntStream.rangeClosed(x, y)
                .filter(n -> Primes.isPrime(n))
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public boolean isPrime(int n) {
        return Primes.isPrime(n);
    }
}
