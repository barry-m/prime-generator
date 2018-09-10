package io.barrymoore;

import io.barrymoore.predicates.PrimeTestPredicates;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Unit Function1 for simple App.
 */
public class AppTest {

    @Test
    public void Function1Test1() {
        PrimeNumberGenerator pm = new PrimeNumberGeneratorImpl();
        int rangeStart = 11;
        int rangeEnd = 12;
        List<Integer> primes = pm.generate(rangeStart,rangeEnd);
        Assert.assertTrue(primes.size() == 1);
        Assert.assertTrue(primes.get(0) == 11);
    }

    @Test
    public void Function1Test2() {
        PrimeNumberGenerator pm = new PrimeNumberGeneratorImpl();
        int rangeStart = 11;
        int rangeEnd = 11;
        List<Integer> primes = pm.generate(rangeStart,rangeEnd);
        Assert.assertTrue(primes.size() == 1);
        Assert.assertTrue(primes.get(0) == 11);
    }

    @Test
    public void Function1Test3() {
        PrimeNumberGenerator pm = new PrimeNumberGeneratorImpl();
        int rangeStart = 0;
        int rangeEnd = 15;
        List<Integer> primes = pm.generate(rangeStart,rangeEnd);
        Assert.assertTrue(primes.size() == 6);
        Assert.assertTrue(primes.containsAll(Arrays.asList(2,3,5,7,11,13)));
    }

    @Test
    public void Function1Test4() {
        PrimeNumberGenerator pm = new PrimeNumberGeneratorImpl();
        int rangeStart = 7900;
        int rangeEnd = 7920;
        List<Integer> primes = pm.generate(rangeStart,rangeEnd);
        Assert.assertTrue(primes.size() == 3);
        Assert.assertTrue(primes.containsAll(Arrays.asList(7901, 7907, 7919)));
    }

    @Test
    public void Function1IsPrimeTrue() {
        PrimeNumberGenerator pm = new PrimeNumberGeneratorImpl();
        Assert.assertTrue(pm.isPrime(7));
    }

    @Test
    public void Function1IsPrimeFalse() {
        PrimeNumberGenerator pm = new PrimeNumberGeneratorImpl();
        Assert.assertFalse(pm.isPrime(9));
    }

    @Test
    public void Function2Test1() {
        PrimeNumberGenerator pm = new PrimeNumberGeneratorImpl(PrimeTestPredicates.Function2);
        int rangeStart = 11;
        int rangeEnd = 12;
        List<Integer> primes = pm.generate(rangeStart,rangeEnd);
        Assert.assertTrue(primes.size() == 1);
        Assert.assertTrue(primes.get(0) == 11);
    }

    @Test
    public void Function2Test2() {
        PrimeNumberGenerator pm = new PrimeNumberGeneratorImpl(PrimeTestPredicates.Function2);
        int rangeStart = 11;
        int rangeEnd = 11;
        List<Integer> primes = pm.generate(rangeStart,rangeEnd);
        Assert.assertTrue(primes.size() == 1);
        Assert.assertTrue(primes.get(0) == 11);
    }

    @Test
    public void Function2Test3() {
        PrimeNumberGenerator pm = new PrimeNumberGeneratorImpl(PrimeTestPredicates.Function2);
        int rangeStart = 0;
        int rangeEnd = 15;
        List<Integer> primes = pm.generate(rangeStart,rangeEnd);
        Assert.assertTrue(primes.size() == 6);
        Assert.assertTrue(primes.containsAll(Arrays.asList(2,3,5,7,11,13)));
    }

    @Test
    public void Function2Test4() {
        PrimeNumberGenerator pm = new PrimeNumberGeneratorImpl(PrimeTestPredicates.Function2);
        int rangeStart = 7900;
        int rangeEnd = 7920;
        List<Integer> primes = pm.generate(rangeStart,rangeEnd);
        Assert.assertTrue(primes.size() == 3);
        Assert.assertTrue(primes.containsAll(Arrays.asList(7901, 7907, 7919)));
    }

    @Test
    public void Function2IsPrimeTrue() {
        PrimeNumberGenerator pm = new PrimeNumberGeneratorImpl(PrimeTestPredicates.Function3);
        Assert.assertTrue(pm.isPrime(7));
    }

    @Test
    public void Function2IsPrimeFalse() {
        PrimeNumberGenerator pm = new PrimeNumberGeneratorImpl(PrimeTestPredicates.Function3);
        Assert.assertFalse(pm.isPrime(9));
    }

    @Test
    public void Function3Test1() {
        PrimeNumberGenerator pm = new PrimeNumberGeneratorImpl(PrimeTestPredicates.Function3);
        int rangeStart = 11;
        int rangeEnd = 12;
        List<Integer> primes = pm.generate(rangeStart,rangeEnd);
        Assert.assertTrue(primes.size() == 1);
        Assert.assertTrue(primes.get(0) == 11);
    }

    @Test
    public void Function3Test2() {
        PrimeNumberGenerator pm = new PrimeNumberGeneratorImpl(PrimeTestPredicates.Function3);
        int rangeStart = 11;
        int rangeEnd = 11;
        List<Integer> primes = pm.generate(rangeStart,rangeEnd);
        Assert.assertTrue(primes.size() == 1);
        Assert.assertTrue(primes.get(0) == 11);
    }

    @Test
    public void Function3Test3() {
        PrimeNumberGenerator pm = new PrimeNumberGeneratorImpl(PrimeTestPredicates.Function3);
        int rangeStart = 0;
        int rangeEnd = 15;
        List<Integer> primes = pm.generate(rangeStart,rangeEnd);
        Assert.assertTrue(primes.size() == 6);
        Assert.assertTrue(primes.containsAll(Arrays.asList(2,3,5,7,11,13)));
    }

    @Test
    public void Function3Test4() {
        PrimeNumberGenerator pm = new PrimeNumberGeneratorImpl(PrimeTestPredicates.Function3);
        int rangeStart = 7900;
        int rangeEnd = 7920;
        List<Integer> primes = pm.generate(rangeStart,rangeEnd);
        Assert.assertTrue(primes.size() == 3);
        Assert.assertTrue(primes.containsAll(Arrays.asList(7901, 7907, 7919)));
    }

    @Test
    public void Function3IsPrimeTrue() {
        PrimeNumberGenerator pm = new PrimeNumberGeneratorImpl(PrimeTestPredicates.Function3);
        Assert.assertTrue(pm.isPrime(7));
    }

    @Test
    public void Function3IsPrimeFalse() {
        PrimeNumberGenerator pm = new PrimeNumberGeneratorImpl(PrimeTestPredicates.Function3);
        Assert.assertFalse(pm.isPrime(9));
    }
}
