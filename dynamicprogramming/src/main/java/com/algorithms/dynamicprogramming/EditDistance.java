package com.algorithms.dynamicprogramming;

/**
 * Created by chandrashekar.v on 4/25/2017.
 */
public class EditDistance {
    public static void main(String[] args) {
        String str1 = "CARTKJHAJKDHKJSDJBBBKASHKJAS";
        String str2 = "MARCHJHJAHSKJHADKJAKJSKJAKSK";

        calculateEdits(str1.toCharArray(), str2.toCharArray());
    }

    private static void calculateEdits(char[] seq1, char[] seq2) {
        int m = seq1.length;
        int n = seq2.length;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0)
                    dp[i][j] = j;
                else if (j == 0)
                    dp[i][j] = i;

                else if (seq1[i - 1] == seq2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = (Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1])) + 1;
            }
        }
        System.out.println(dp[m][n]);
    }
}
