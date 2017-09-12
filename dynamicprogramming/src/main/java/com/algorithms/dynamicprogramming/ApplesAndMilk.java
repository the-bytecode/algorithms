package com.algorithms.dynamicprogramming;

/**
 * Created by chandrashekar.v on 4/28/2017.
 */
public class ApplesAndMilk {

    public static void main(String[] args) {
        int[] apples = {100, 200, 400};
        int[] milk = {2, 10, 1};

        int initialEnergy = 1;

        solve(apples, milk, initialEnergy);

    }

    private static void solve(int[] a, int[] mil, int initialEnergy) {

        int m = a.length;
        int[][] dp = new int[m + 1][m + 1];
        int[] apples = new int[m + 1];
        int milk[] = new int[m + 1];
        for (int i = 0; i < a.length; i++) {
            apples[i + 1] = a[i];
        }

        for (int i = 0; i < mil.length; i++) {
            milk[i + 1] = mil[i];
        }
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;
            }
        }

        dp[0][Math.min(initialEnergy, m)] = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i - 1][j] == -1)
                    continue;
                dp[i][j - 1] = Math.max(dp[i][j - 1], dp[i - 1][j] + apples[i]); // Take apples from the farm.
                System.out.println("i= " + i + " , j= " + j);
                dp[i][Math.min(j + milk[i] - 1, m)] = Math.max(dp[i][Math.min(j + milk[i] - 1, m)], dp[i - 1][j]); // Take Milk from the farm

                print2DArray(m, dp);
            }
            dp[i][0] = Math.max(dp[i][0], dp[i - 1][0]);
            print2DArray(m, dp);
        }
        int max = 0;
        for (int i = 0; i <= m; i++) {
            max = Math.max(max, dp[m][i]);
        }
        System.out.println(max);
    }

    private static void print2DArray(int m, int[][] dp) {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= m; j++) {
                System.out.printf("%4s", dp[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
