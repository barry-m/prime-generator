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
    PrimeGenerator pm;

    @Before
    public void setup(){
        pm = new PrimeGenerator();
    }

    @Test
    public void Basic() {
        int rangeStart = 11;
        int rangeEnd = 12;
        List<Integer> primes = pm.getPrimeNumbers(rangeStart,rangeEnd);
        Assert.assertTrue(primes.size() == 1);
        Assert.assertTrue(primes.get(0) == 11);
    }

    @Test
    public void SingleValueRange() {
        int rangeStart = 11;
        int rangeEnd = 11;
        List<Integer> primes = pm.getPrimeNumbers(rangeStart,rangeEnd);
        Assert.assertTrue(primes.size() == 1);
        Assert.assertTrue(primes.get(0) == 11);
    }

    @Test
    public void SmallRange() {
        int rangeStart = 0;
        int rangeEnd = 15;
        List<Integer> primes = pm.getPrimeNumbers(rangeStart,rangeEnd);
        Assert.assertTrue(primes.size() == 6);
        Assert.assertTrue(primes.containsAll(Arrays.asList(2,3,5,7,11,13)));
    }
}
