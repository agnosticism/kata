package com.matthewzhang.kata;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Matthew Zhang
 * Date: 12-12-27
 * Time: 下午8:07
 */
public class TestPrimeNumberGenerator {
    public static void main(String[] args) {
        PrimeNumberGenerator pmg = new PrimeNumberGenerator();
        long startTime = System.currentTimeMillis();
        List<Integer> primeNumbers = pmg.generate(10);
        long endTime = System.currentTimeMillis();
        System.out.println(primeNumbers.size() + " prime numbers found in " + (endTime - startTime) + " ms");
        for (int i = 0; i < primeNumbers.size(); i++) {
            System.out.println(i + ":" + primeNumbers.get(i));
        }
    }
}
