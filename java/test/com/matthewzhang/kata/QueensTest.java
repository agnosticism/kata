package com.matthewzhang.kata;

import javafx.util.Pair;
import junit.framework.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Matthew Zhang
 * Date: 13-1-17
 * Time: 下午5:33
 */
public class QueensTest {
    @Test
    public void testCellStatus(){
        Assert.assertFalse(Queens.CellStatus.EMPTY == Queens.CellStatus.FILLED);
        Assert.assertFalse(Queens.CellStatus.EMPTY.equals(Queens.CellStatus.FILLED));
    }

    @Test
    public void testResolve() throws Exception {
        int n = 4;
        List<Pair<Integer, Integer>[]> results = Queens.resolve(n);
        Assert.assertTrue(results.size() > 0);
        for (int i = 0; i < results.size(); i++) {
            Pair<Integer, Integer>[] result = results.get(i);
            Assert.assertTrue(Queens.isValidAnswer(result, n));
        }
    }

    @Test
    public void testIsValidAnswer() {
        int n = 4;
        Pair[] answer1 = new Pair[]{
                new Pair(1, 0),
                new Pair(3, 1),
                new Pair(0, 2),
                new Pair(2, 3)};
        Assert.assertTrue(Queens.isValidAnswer(answer1, 4));

        Pair[] answer2 = new Pair[]{
                new Pair(1, 0),
                new Pair(3, 1),
                new Pair(2, 3)};
        Assert.assertTrue(!Queens.isValidAnswer(answer2, 4));

        Pair[] answer3 = new Pair[]{
                new Pair(1, 0),
                new Pair(3, 1),
                new Pair(1, 2),
                new Pair(2, 3)};
        Assert.assertTrue(!Queens.isValidAnswer(answer3, 4));

    }
}
