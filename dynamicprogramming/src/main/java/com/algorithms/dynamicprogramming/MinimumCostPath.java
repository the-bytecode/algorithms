package com.algorithms.dynamicprogramming;

import java.util.HashMap;

/**
 * Created by chandrashekar.v on 4/26/2017.
 */
public class MinimumCostPath {


    public static void main(String[] args) {
        int[][] array = {{1, 2, 10, 14}, {1, 5, 8, 12}, {8, 5, 12, 10}};
        findMinCostAndPath(array, 2, 3);
        final int[][] array1 = {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
        findMinCostAndPath(array1, 2, 2);

        usingRecusrion(array1, 2, 2);
    }

    private static void usingRecusrion(int[][] array1, int m, int n) {
        System.out.println("Using recusrion: " + findMinCostAndPathUsingRecusrion(array1, m, n, new HashMap<>()));
    }

    private static int findMinCostAndPathUsingRecusrion(int[][] array1, int m, int n, HashMap<String, Integer> map) {
        if (m < 0 || n < 0)
            return Integer.MAX_VALUE;
        else if (m == 0 && n == 0)
            return array1[m][n];
        else {
            String key = m + "_" + n;
            if (map.containsKey(key))
                return map.get(key);
            int val = array1[m][n] + Math.min(
                    Math.min(findMinCostAndPathUsingRecusrion(array1, m - 1, n - 1, map),
                            findMinCostAndPathUsingRecusrion(array1, m - 1, n, map))
                    , findMinCostAndPathUsingRecusrion(array1, m, n - 1, map));
            map.put(key, val);
            return val;
        }

    }

    private static void findMinCostAndPath(int[][] array, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        dp[0][0] = array[0][0];

        // fill first column of dp array
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] + array[i][0];
        }

        // fill first row of dp array
        for (int i = 1; i <= n; i++) {
            dp[0][i] = dp[0][i - 1] + array[0][i];
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = array[i][j] + Math.min(dp[i - 1][j - 1], (Math.min(dp[i - 1][j], dp[i][j - 1])));
            }
        }
        System.out.println(dp[m][n]);
    }

    private static void print(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.printf("%4d", dp[i][j]);
            }
            System.out.println();
        }
    }
}
