package com.matthewzhang.kata;

/**
 * Created with IntelliJ IDEA.
 * User: Matthew Zhang
 * Date: 12-12-31
 * Time: 下午8:11
 */
public class Shuffler {
    public static void shuffle(int[] dataToShuffle) {
        for (int i = 0; i < dataToShuffle.length; i++) {
            int positionToSwap = (int) ((Math.random() * (dataToShuffle.length - i))) + i;
            int temp = dataToShuffle[positionToSwap];
            dataToShuffle[positionToSwap] = dataToShuffle[i];
            dataToShuffle[i] = temp;
        }
    }
}
