package com.matthewzhang.kata;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Matthew Zhang
 * Date: 13-1-2
 * Time: 下午8:46
 */
public class NumberPadWordGenerator {
    private static String[][] PAD_LAYOUT = {
            {"W", "X", "Y", "Z"}, //0
            {}, //1
            {"A", "B", "C"}, //2
            {"D", "E", "F"}, //3
            {"G", "H", "I"}, //4
            {"J", "K", "L"}, //5
            {"M", "N", "O"}, //6
            {"P", "Q", "R", "S"}, //7
            {"T", "U", "V"}, //8
    };

    public static List<String> getWords(int[] digits) {
        List<String> words = new LinkedList<>();
        if (digits == null || digits.length == 0) return words;
        int digit = digits[0];
        if (digit < 0 || digit > 9) {
            throw new IllegalArgumentException(digit + " is not a valid digit");
        }

        if (digits.length == 1) {
            for (int i = 0; i < PAD_LAYOUT[digit].length; i++) {
                words.add(PAD_LAYOUT[digit][i]);
            }
            return words;
        }

        //recursive call
        int[] subDigits = Arrays.copyOfRange(digits, 1, digits.length);
        List<String> subWords = getWords(subDigits);
        if (PAD_LAYOUT[digit].length > 0) {
            for (int i = 0; i < PAD_LAYOUT[digit].length; i++) {
                for (Iterator it = subWords.iterator(); it.hasNext(); ) {
                    words.add(PAD_LAYOUT[digit][i] + it.next());
                }
            }
        } else {
            words = subWords;
        }


        return words;
    }
}
