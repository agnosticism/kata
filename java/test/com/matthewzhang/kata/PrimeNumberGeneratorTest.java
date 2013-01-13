package com.matthewzhang.kata;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Matthew Zhang
 * Date: 12-12-27
 * Time: 下午9:00
 */
public class PrimeNumberGeneratorTest {

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGenerateInvalidRange(){
        Assert.assertTrue(PrimeNumberGenerator.generate(-1).size() == 0);
        Assert.assertTrue(PrimeNumberGenerator.generate(0).size() == 0);
        Assert.assertTrue(PrimeNumberGenerator.generate(1).size() == 0);
    }

    @Test
    public void testGenerateFirst4PrimeNumbers(){
        Assert.assertArrayEquals(PrimeNumberGenerator.generate(2).toArray(new Integer[1]), new Integer[]{2});
        Assert.assertArrayEquals(PrimeNumberGenerator.generate(3).toArray(new Integer[2]), new Integer[]{2, 3});
        Assert.assertArrayEquals(PrimeNumberGenerator.generate(5).toArray(new Integer[3]), new Integer[]{2, 3, 5});
        Assert.assertArrayEquals(PrimeNumberGenerator.generate(6).toArray(new Integer[3]), new Integer[]{2, 3, 5});
        Assert.assertArrayEquals(PrimeNumberGenerator.generate(7).toArray(new Integer[3]), new Integer[]{2, 3, 5, 7});
        Assert.assertArrayEquals(PrimeNumberGenerator.generate(8).toArray(new Integer[3]), new Integer[]{2, 3, 5, 7});
    }

    @Test
    public void testGenerateTo10() throws Exception {
        int range = 10;
        List<Integer> primeNumbersTo10 = PrimeNumberGenerator.generate(range);
        Assert.assertTrue(primeNumbersTo10.size() == 4);
        Assert.assertArrayEquals(primeNumbersTo10.toArray(new Integer[primeNumbersTo10.size()]), new Integer[]{2, 3, 5, 7});
    }

    @Test
    public void testGenerateTo100() throws Exception{
        int range = 100;
        List<Integer> primeNumbersTo100 = PrimeNumberGenerator.generate(range);
        Assert.assertTrue(primeNumbersTo100.size() == 25);
        Assert.assertArrayEquals(primeNumbersTo100.toArray(new Integer[primeNumbersTo100.size()]), new Integer[]{
                2, 3, 5, 7, 11,
                13, 17, 19, 23, 29,
                31, 37, 41, 43, 47,
                53, 59, 61, 67, 71,
                73, 79, 83, 89, 97,
        });
    }

    @Test
    public void testGenerateMany(){
        PrimeNumberGenerator.generate(1000);
        PrimeNumberGenerator.generate(10000);
        PrimeNumberGenerator.generate(100000);
        PrimeNumberGenerator.generate(1000000);
        PrimeNumberGenerator.generate(10000000);
        //PrimeNumberGenerator.generate(100000000); //about 5s on my laptop, disable it as it's too slow
    }
}
