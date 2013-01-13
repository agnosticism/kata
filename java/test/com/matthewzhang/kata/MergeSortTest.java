package com.matthewzhang.kata;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Matthew Zhang
 * Date: 13-1-12
 * Time: 下午7:56
 */
public class MergeSortTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testMergeSort() throws Exception {
        int[] testData = generateTestData();
        int[] sortedData = MergeSort.mergeSort(testData);

        Assert.assertTrue("returned data length not equal to input", testData.length == sortedData.length);

        HashMap<Integer, Integer> testDataElementCount = countElements(testData);
        HashMap<Integer, Integer> sortedDataElementCount = countElements(sortedData);
        Assert.assertEquals(testDataElementCount, sortedDataElementCount);

        for(int i=0; i<sortedData.length-1; i++){
            Assert.assertTrue("not ASC sorted", sortedData[i] <= sortedData[i+1]);
        }
    }

    @Test
    public void testMergeSort100Times() throws Exception {
        for(int i=0; i<100; i++){
            testMergeSort();
        }
    }

    private static HashMap<Integer, Integer> countElements(int[] data) {
        HashMap<Integer, Integer> elementCount = new HashMap();
        for(int i=0; i<data.length; i++){
            int element = data[i];
            if(elementCount.containsKey(element)){
                elementCount.put(element, elementCount.get(element)+1);
            }else{
                elementCount.put(element, 1);
            }
        }
        return elementCount;
    }

    private int[] generateTestData() {
        int dataSize = (int) (Math.random() * 10000);
        int[] data = new int[dataSize];
        for(int i=0;i<data.length;i++){
            data[i] = (int) (Math.random() * 100000);
        }
        return data;
    }
}
