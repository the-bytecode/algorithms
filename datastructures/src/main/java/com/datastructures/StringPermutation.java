package com.datastructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by chandrashekar.v on 9/6/2017.
 */
public class StringPermutation {
    public static void main(String[] args) {
        permute(new Character[]{'A', 'B', 'C'}).forEach(System.out::println);
    }

    public static List<String> permute(Character[] input) {

        List<String> resultList = new ArrayList<>();
        Map<Character, Long> countMap = Arrays.stream(input)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        char[] str = new char[countMap.size()];
        long[] count = new long[countMap.size()];

        int index = 0;
        for (Map.Entry<Character, Long> entry : countMap.entrySet()) {
            str[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }

        char[] result = new char[input.length];
        permUtil(str, count, result, 0, resultList);
        return resultList;

    }

    private static void permUtil(char[] str, long[] count, char[] result, int level, List<String> resultList) {

        // Check exit condition
        if (level == result.length) {
            resultList.add(new String(result));
            return;
        }


        for (int i = 0; i < str.length; i++) {
            if (count[i] == 0)
                continue;

            result[level] = str[i];
            count[i]--;
            permUtil(str, count, result, level + 1, resultList);
            count[i]++;

        }
    }
}
