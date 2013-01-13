package com.matthewzhang.kata;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Matthew Zhang
 * Date: 13-1-2
 * Time: 下午8:47
 */
public class NumberPadWordGeneratorTest {
    @Test
    public void testGetWordsOf1() {
        int[] digits = {1};
        List<String> words = NumberPadWordGenerator.getWords(digits);
        Assert.assertNotNull(words);
        Assert.assertEquals(words.size(), 0);
    }

    @Test
    public void testGetWordsOf2(){
        int[] digits = {2};
        List<String> words = NumberPadWordGenerator.getWords(digits);
        Assert.assertEquals(words.size(), 3);
        String[] wordsExpected = {"A", "B", "C"};
        String[] wordsGot = words.toArray(new String[words.size()]);
        Assert.assertArrayEquals(wordsExpected, wordsGot);
    }

    @Test
    public void testGetWords23() {
        int[] digits = {2, 3};
        List<String> words = NumberPadWordGenerator.getWords(digits);
        Assert.assertNotNull(words);

        String[] wordsExpected = new String[]{"AD", "AE", "AF", "BD", "BE", "BF", "CD", "CE", "CF"};
        Assert.assertEquals(words.size(), wordsExpected.length);

        String[] wordsGot = words.toArray(new String[words.size()]);
        Assert.assertArrayEquals(wordsGot, wordsExpected);
    }

    @Test
    public void testGetWords123() {
        int[] digits = {1, 2, 3};
        List<String> words = NumberPadWordGenerator.getWords(digits);
        Assert.assertNotNull(words);

        String[] wordsExpected = new String[]{"AD", "AE", "AF", "BD", "BE", "BF", "CD", "CE", "CF"};
        Assert.assertEquals(words.size(), wordsExpected.length);

        String[] wordsGot = words.toArray(new String[words.size()]);
        Assert.assertArrayEquals(wordsGot, wordsExpected);
    }
}
