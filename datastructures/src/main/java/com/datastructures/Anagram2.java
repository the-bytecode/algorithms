package com.datastructures;

import java.io.*;
import java.util.Arrays;

/**
 * Created by chandrashekar.v on 4/30/2017.
 * <p>
 * Given two strings, check both are anagrams.
 */
public class Anagram2 {

    public static void main(String[] args) throws IOException {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("D:\\sample.txt")));
            String s1 = bufferedReader.readLine();
            String s2 = bufferedReader.readLine();

            long start = System.currentTimeMillis();
            System.out.println(approach1(s1, s2) + " Took : " + (System.currentTimeMillis() - start));
            start = System.currentTimeMillis();
            System.out.println(approach2(s1, s2) + " Took : " + (System.currentTimeMillis() - start));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static boolean approach1(String s1, String s2) {

        s1 = formatString(s1);
        s2 = formatString(s2);
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);

        for (int i = 0; i < s1Chars.length; i++) {
            if (s1Chars[i] != s2Chars[i])
                return false;
        }

        return true;
    }

    private static String formatString(String inputStr) {
        inputStr = inputStr.replaceAll(" ", "");
        inputStr = inputStr.toLowerCase();
        return inputStr;
    }

    private static boolean approach2(String s1, String s2) {

        int[] s1Alphabets = new int[26];
        int[] s2Alphabets = new int[26];
        s1 = formatString(s1);
        s2 = formatString(s2);
        int offset = (int) 'a';
        for (int i = 0; i < s1.length(); i++) {
            s1Alphabets[(int) s1.charAt(i) - offset]++;
            s2Alphabets[(int) s2.charAt(i) - offset]++;
        }

        for (int i = 0; i < s1Alphabets.length; i++) {
            if (s1Alphabets[i] != s2Alphabets[i])
                return false;
        }
        return true;
    }
}
