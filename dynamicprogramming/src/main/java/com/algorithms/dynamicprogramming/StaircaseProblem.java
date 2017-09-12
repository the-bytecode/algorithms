package com.algorithms.dynamicprogramming;

import java.util.concurrent.Executors;

/**
 * Created by chandrashekar.v on 4/25/2017.
 */
public class StaircaseProblem {

    public static void main(String[] args) {

        new Thread() {
            @Override
            public void run() {
                final long startTime = System.currentTimeMillis();
                System.out.println("count:" + countPathsRecursion(10) + " in " + (System.currentTimeMillis() - startTime));
            }
        }.start();

        long startTime = System.currentTimeMillis();
        System.out.println("count using memoization:" + countPathsMemoWrapper(1000) + " in " + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        System.out.println("count using tabulation:" + countPathsDP(100000000) + " in " + (System.currentTimeMillis() - startTime));

        startTime = System.currentTimeMillis();
        System.out.println("count using space optimized tabulation:" + countPathsOptimizedSpaceDP(100000000) + " in " + (System.currentTimeMillis() - startTime));
    }

    private static long countPathsOptimizedSpaceDP(int steps) {
        if (steps < 0)
            return 0;
        else if (steps <= 1)
            return 1;

        long[] dp = {1, 1, 2};
        for (int i = 3; i <= steps; i++) {
            long count = dp[2] + dp[1] + dp[0];
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = count;
        }
        return dp[2];
    }

    private static long countPathsDP(int steps) {
        if (steps < 0)
            return 0;
        else if (steps <= 1)
            return 1;

        long[] dp = new long[steps + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= steps; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[steps];
    }

    private static long countPathsMemoWrapper(int steps) {
        return countPathsMemo(steps, new long[steps + 1]);
    }

    private static long countPathsMemo(int steps, long[] memo) {
        if (steps < 0)
            return 0;
        else if (steps == 0)
            return 1;

        if (memo[steps] == 0) {
            memo[steps] = countPathsMemo(steps - 1, memo)
                    + countPathsMemo(steps - 2, memo)
                    + countPathsMemo(steps - 3, memo);
        }
        return memo[steps];

    }

    /**
     * Normal recursive approach. Exponential time. O(3^n).
     *
     * @param steps
     * @return
     */
    private static int countPathsRecursion(int steps) {

        if (steps < 0)
            return 0;
        else if (steps == 0)
            return 1;

        return countPathsRecursion(steps - 1) + countPathsRecursion(steps - 2) + countPathsRecursion(steps - 3);


    }

}
