package io.barrymoore;

import io.barrymoore.predicates.PrimeTestPredicates;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumberGeneratorImpl implements PrimeNumberGenerator {
    Function<Integer, Boolean> func;

    public PrimeNumberGeneratorImpl() {
        this.func = PrimeTestPredicates.Function1;
    }

    public PrimeNumberGeneratorImpl(Function func) {
        this.func = func;
    }

    public List<Integer> generate(int x, int y) {
        int a = x < y ? x : y;
        int b = x > y ? x : y;
        return IntStream.rangeClosed(a, b)
                .filter(n -> func.apply(n))
                .boxed()
                .collect(Collectors.toList());
    }

    public boolean isPrime(int n) {
        return func.apply(n);
    }
}
