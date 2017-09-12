package com.datastructures;

/**
 * Created by chandrashekar.v on 4/25/2017.
 * Given two strings how many characters need to be removed to make them anagrams.
 */
public class Anagram {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "billion";

        int count = calculate(str1, str2);
        System.out.println("Count:" + count);
    }

    private static int calculate(String str1, String str2) {
        int[] charCount1 = getCharCount(str1);
        int[] charCount2 = getCharCount(str2);
        return getDelta(charCount1, charCount2);
    }

    private static int getDelta(int[] charCount1, int[] charCount2) {
        if (charCount1.length != charCount2.length)
            return -1;

        int delta = 0;
        for (int i = 0; i < charCount1.length; i++) {
            delta += Math.abs(charCount1[i] - charCount2[i]);
        }
        return delta;
    }

    private static final int NUMBER_LETTERS = 26;
    private static final int OFFSET = (int) 'a';

    private static int[] getCharCount(String str1) {
        int[] charCounts = new int[NUMBER_LETTERS];
        for (int i = 0; i < str1.length(); i++) {
            int code = str1.charAt(i) - OFFSET;
            charCounts[code]++;
        }
        return charCounts;
    }
}
