package com.matthewzhang.kata;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Matthew Zhang
 * Date: 12-12-31
 * Time: 下午8:14
 */
public class ShufflerTest {
    private static int DataSize = 100;
    private int[] originalData;
    private int[] shuffledData;

    @Before
    public void setUp() throws Exception {
        originalData = new int[DataSize];
        for (int i = 0; i < DataSize; i++) {
            originalData[i] = i;
        }
        shuffledData = Arrays.copyOf(originalData, originalData.length);
    }

    @After
    public void tearDown() throws Exception {
        originalData = null;
        shuffledData = null;
    }

    //TODO: test shuffled data are the same data with different order of data to shuffle

    @Test
    public void testShuffleOnce() throws Exception {
        Shuffler.shuffle(shuffledData);
        System.out.println(Arrays.toString(shuffledData));
        Assert.assertTrue(!Arrays.equals(originalData, shuffledData));
    }

    @Test
    public void testShuffleDistribution1k10(){
        testShuffleDistribution(1000, 10);
    }

    @Test
    public void testShuffleDistribution1k05(){
        testShuffleDistribution(1000, 5);
    }

    @Test
    public void testShuffleDistribution1k01(){
        testShuffleDistribution(1000, 1);
    }

    @Test
    public void testShuffleDistribution100_1(){
        testShuffleDistribution(100, 1);
    }

    private void testShuffleDistribution(int shuffleFactor, double rangeFactor) {
        //TODO: notice, this test depends on the fact that originalData value equals array index
        int shuffleRounds = originalData.length * shuffleFactor;
        int distributionCountUpperRange = (int)(shuffleFactor * (1+ rangeFactor));
        int distributionCountLowerRange = (int)(shuffleFactor * (1- rangeFactor));
        int[][] valuePositionDistributionCount = new int[originalData.length][originalData.length];

        for (int i = 0; i < shuffleRounds; i++) {
            shuffledData = Arrays.copyOf(originalData, originalData.length);
            Shuffler.shuffle(shuffledData);
            for (int position = 0; position < shuffledData.length; position++) {
                int value = shuffledData[position];
                valuePositionDistributionCount[value][position]++;
            }
        }

        for (int position = 0; position < originalData.length; position++) {
            for (int value = 0; value < originalData.length; value++) {
                int count = valuePositionDistributionCount[value][position];
                Assert.assertTrue(position + " found " + count + " times", count >= distributionCountLowerRange && count <= distributionCountUpperRange);
            }
        }
    }
}
