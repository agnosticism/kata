package com.matthewzhang.kata;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Matthew Zhang
 * Date: 12-12-27
 * Time: 下午8:02
 */
public class PrimeNumberGenerator {
    private static boolean CHECKED = true;   //TODO, make a enum instead of this
    private static boolean UNCHECKED = false;
    private static int rangeTo;

    public static List<Integer> generate(int rangeTo) {
        PrimeNumberGenerator.rangeTo = rangeTo;
        List<Integer> primeNumbers = new LinkedList<>();
        if (rangeTo < 2) return primeNumbers;

        boolean[] checkTable;
        checkTable = new boolean[rangeTo + 1];
        checkTable[0] = CHECKED;
        checkTable[1] = CHECKED;
        int currentCheckFactor = 2;
        int maxPossibleFactor = (int) Math.sqrt(rangeTo);

        for (; currentCheckFactor <= maxPossibleFactor; currentCheckFactor++) {
            if (checkTable[currentCheckFactor] == CHECKED) continue;
            primeNumbers.add(currentCheckFactor);
            //System.out.println("added " + currentCheckFactor);
            for (int i = currentCheckFactor; i <= rangeTo; i += currentCheckFactor) {
                checkTable[i] = CHECKED;
            }
        }

        for (int i = currentCheckFactor; i <= rangeTo; i++) {
            if (checkTable[i] == UNCHECKED) {
                primeNumbers.add(i);
                //System.out.println("after check added " + i);
            }
        }
        return primeNumbers;
    }
}
