package com.matthewzhang.kata;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Matthew Zhang
 * Date: 13-1-17
 * Time: 下午4:15
 */
public class Queens {
    private final int mapSize;
    private CellStatus[][] checkMap = null;

    public Queens(int n) {
        mapSize = n;
        checkMap = new CellStatus[mapSize][mapSize];
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                checkMap[i][j] = CellStatus.EMPTY;
            }
        }
    }

    private boolean isValidAnswer(Pair<Integer, Integer>[] answer) {
        if (answer.length != mapSize) return false;
        for (Pair<Integer, Integer> position : answer) {
            boolean positionIsValid = checkAndMarkQueen(position);
            if (!positionIsValid) return false;
        }
        return true;
    }

    private boolean checkAndMarkQueen(int x, int y) {
        return checkAndMarkQueen(new Pair(x, y));
    }

    private boolean checkAndMarkQueen(Pair<Integer, Integer> queenPosition) {
        int x = queenPosition.getKey();
        int y = queenPosition.getValue();
        if (checkMap[x][y] != CellStatus.EMPTY) {
            return false;
        }
        checkMap[x][y] = CellStatus.FILLED;

        //check and mark row y
        for (int col = 0; col < mapSize; col++) {
            if (col == x) continue;
            if (!checkAndMarkQueenPosition(queenPosition, col, y)) return false;
        }

        //check and mark col x
        for (int row = 0; row < mapSize; row++) {
            if (row == y) continue;
            if (!checkAndMarkQueenPosition(queenPosition, x, row)) return false;
        }

        int distance = 1;
        boolean shouldContinue = true;
        while (shouldContinue) {
            shouldContinue = false;
            int[][] positions = {
                    {x + distance, y + distance},
                    {x + distance, y - distance},
                    {x - distance, y + distance},
                    {x - distance, y - distance},
            };
            for (int i = 0; i < positions.length; i++) {
                int x1 = positions[i][0];
                int y1 = positions[i][1];
                if (x1 >= 0 && x1 < mapSize && y1 >= 0 && y1 < mapSize) {
                    if (!checkAndMarkQueenPosition(queenPosition, x1, y1)) return false;
                    shouldContinue = true;
                }
            }
            distance++;
        }

        return true;
    }

    private boolean checkAndMarkQueenPosition(Pair<Integer, Integer> queenPosition, int x, int y) {
        assert x >= 0 && x < mapSize && y >= 0 && y < mapSize;
        if (checkMap[x][y] == CellStatus.FILLED) return false;
        checkMap[x][y] = CellStatus.UNAVAILABLE;
        return true;
    }

    public static List<Pair<Integer, Integer>[]> resolve(int n) {
        Queens queens = new Queens(n);
        int x = 0, y = 0;
        while(y < n) {
            boolean addSuccess = queens.checkAndMarkQueen(x, y);
            if (addSuccess){
                y++;
                x = 0;
                continue;
            }
            if(x < n-1){
                x++;
            }else{
                queens.unmarkQueen(x, y);
            }
            break;
        }
        return new LinkedList();
    }

    private void unmarkQueen(int x, int y) {
        //To change body of created methods use File | Settings | File Templates.
    }

    public static boolean isValidAnswer(Pair<Integer, Integer>[] answer, int n) {
        Queens queens = new Queens(n);
        return queens.isValidAnswer(answer);
    }

    public enum CellStatus {
        EMPTY(0),
        FILLED(0),
        UNAVAILABLE(1);

        private int value = 0;
        private final int markUnit;

        CellStatus(int markUnit){
            this.markUnit = markUnit;
        }

        void remark(){
            this.value += this.markUnit;
        }

        void unmark(){
            this.value -= this.markUnit;
        }
    }
}
