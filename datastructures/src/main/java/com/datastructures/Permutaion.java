package com.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by chandrashekar.v on 4/28/2017.
 */
public class Permutaion {

    public static void main(String[] args) {
        String s1 = "addbbaxxyyzs";
        String s2 = "szyxyxababda";
       // System.out.println(isPermutation(s1, s2));
        System.out.println(isPermutationAlphabetApproach(s1,s2));
    }

    private static boolean isPermutationAlphabetApproach(String s1, String s2) {
        char[] char1 = s1.toLowerCase().toCharArray();
        char[] char2 = s2.toLowerCase().toCharArray();

        int[] alphabetIndeaS1 = new int[26];
        int[] alphabetIndeaS2 = new int[26];


        int offset = (int)'a';
        for(int i=0; i<char1.length; i++) {
            alphabetIndeaS1[(int)char1[i]-offset]++;
            alphabetIndeaS2[(int)char2[i]-offset]++;
        }

        for(int i=0; i<alphabetIndeaS1.length; i++) {
           if(alphabetIndeaS1[i] != alphabetIndeaS2[i])
               return false;
        }
        return  true;
    }

    private static String isPermutation(String s1, String s2) {
        try {

            Map<Character, Integer> charMap = new TreeMap<>();
            char[] StringToCharArry = s1.toCharArray();
            for (char ch : StringToCharArry) {
                charMap.compute(ch, (k, v) -> {
                    if (v == null)
                        return 1;
                    else return v + 1;
                });
            }

            char str[] = new char[charMap.size()];
            int count[] = new int[charMap.size()];
            int index = 0;

            for (Map.Entry<Character, Integer> entry : charMap.entrySet()) {
                str[index] = entry.getKey();
                count[index] = entry.getValue();
                index++;
            }

            List<String> results = new ArrayList<>();
            char result[] = new char[StringToCharArry.length];
            permute(str, count, result, 0, results);

            if(results.contains(s2))
                return "yes";
            else
                return "no";

        } catch(Exception ex) {
            throw new UnsupportedOperationException("isPermutation(String input1,String input2)");
        }
    }

    public static void permute(char str[], int[] count, char[] result, int level, List<String> results) {
        if (level == result.length) {
            results.add(new String(result));
            return;
        }
        for (int i = 0; i < str.length; i++) {
            if (count[i] == 0) {
                continue;
            }
            result[level] = str[i];
            count[i]--;
            permute(str, count, result, level + 1, results);
            count[i]++;
        }
    }
}