package com.algorithms.dynamicprogramming;

/**
 * Created by chandrashekar.v on 4/26/2017.
 */
public class Knapsack {

    public static void main(String[] args) {
        int values[] = {1000, 200, 3000, 400, 500};
        int weights[] = {10, 20, 30, 40, 50};

        int knapsackCapacity = 50;

        System.out.println("Max Values: " + knapsackSolutionDP(values, weights, knapsackCapacity));

        System.out.println("Max Values Recursive: " + knapsackSolutionRecursive(values, weights, knapsackCapacity));

    }

    private static int knapsackSolutionRecursive(int[] values, int[] weights, int knapsackCapacity) {
        int valuesLength = values.length;
        return knapsackR(values, weights, knapsackCapacity, valuesLength);
    }

    private static int knapsackR(int[] values, int[] weights, int knapsackCapacity, int valuesLength) {

        // Base Case
        if (valuesLength == 0 || knapsackCapacity == 0)
            return 0;

        // If weight of the nth item is more than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        if (weights[valuesLength - 1] > knapsackCapacity)
            return knapsackR(values, weights, knapsackCapacity, valuesLength - 1);

        else
            // return maximum nth item included and not included.
            return Math.max(values[valuesLength - 1] + knapsackR(values, weights,
                    knapsackCapacity - weights[valuesLength - 1], valuesLength - 1), knapsackR(values, weights, knapsackCapacity, valuesLength - 1));
    }

    private static int knapsackSolutionDP(int[] values, int[] weights, int knapsackCapacity) {
        int rows = values.length;
        int columns = knapsackCapacity;
        int[][] dp = new int[rows + 1][columns + 1];

        for (int i = 0; i <= rows; i++) {
            for (int j = 0; j <= columns; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (j < weights[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
            }
        }
        return dp[rows][columns];
    }
}
