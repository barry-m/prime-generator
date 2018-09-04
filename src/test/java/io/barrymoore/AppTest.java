package io.barrymoore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest {
    PrimeNumberGenerator pm;

    @Before
    public void setup(){
        pm = new PrimeNumberGeneratorImpl();
    }

    @Test
    public void Basic() {
        int rangeStart = 11;
        int rangeEnd = 12;
        List<Integer> primes = pm.generate(rangeStart,rangeEnd);
        Assert.assertTrue(primes.size() == 1);
        Assert.assertTrue(primes.get(0) == 11);
    }

    @Test
    public void SingleValueRange() {
        int rangeStart = 11;
        int rangeEnd = 11;
        List<Integer> primes = pm.generate(rangeStart,rangeEnd);
        Assert.assertTrue(primes.size() == 1);
        Assert.assertTrue(primes.get(0) == 11);
    }

    @Test
    public void SmallRange() {
        int rangeStart = 0;
        int rangeEnd = 15;
        List<Integer> primes = pm.generate(rangeStart,rangeEnd);
        Assert.assertTrue(primes.size() == 6);
        Assert.assertTrue(primes.containsAll(Arrays.asList(2,3,5,7,11,13)));
    }

    @Test
    public void SpecialRange() {
        int rangeStart = 7900;
        int rangeEnd = 7920;
        List<Integer> primes = pm.generate(rangeStart,rangeEnd);
        Assert.assertTrue(primes.size() == 3);
        Assert.assertTrue(primes.containsAll(Arrays.asList(7901, 7907, 7919)));
    }

    @Test
    public void IsPrimeBasicTrue() {
        Assert.assertTrue(pm.isPrime(7));
    }

    @Test
    public void IsPrimeBasicFalse() {
        Assert.assertFalse(pm.isPrime(9));
    }
}
