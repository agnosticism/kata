package com.matthewzhang.kata;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Matthew Zhang
 * Date: 13-1-12
 * Time: 下午7:53
 */
public class MergeSort {
    public static int[] mergeSort(int[] data) {
        if(data == null) return null;
        if (data.length == 1) {
            return data;
        }
        if (data.length == 2) {
            if (data[0] < data[1]) {
                return data;
            }
            int[] sorted = new int[]{data[1], data[0]};
            return sorted;
        }

        int splitPosition = data.length / 2;
        int[] firstHalf = Arrays.copyOfRange(data, 0, splitPosition);
        int[] lastHalf = Arrays.copyOfRange(data, splitPosition, data.length);

        int[] firstHalfSorted = mergeSort(firstHalf);
        int[] lastHalfSorted = mergeSort(lastHalf);

        int[] sorted = merge(firstHalfSorted, lastHalfSorted);
        return sorted;
    }

    private static int[] merge(int[] data1, int[] data2) {
        int[] merged = new int[data1.length + data2.length];
        int i = 0, j = 0, k = 0;
        while (i < data1.length && j < data2.length) {
            if (data1[i] <= data2[j]) {
                merged[k] = data1[i];
                i++;
            } else {
                merged[k] = data2[j];
                j++;
            }
            k++;
        }
        if (i < data1.length) {
            for (; i < data1.length; i++, k++) {
                merged[k] = data1[i];
            }
        }
        if (j < data2.length) {
            for (; j < data2.length; j++, k++) {
                merged[k] = data2[j];
            }
        }
        return merged;
    }
}
