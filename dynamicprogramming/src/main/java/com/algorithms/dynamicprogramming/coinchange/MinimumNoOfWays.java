package com.algorithms.dynamicprogramming.coinchange;

/**
 * Created by chandrashekar.v on 4/26/2017.
 */
public class MinimumNoOfWays {

    public static void main(String[] args) {
        int[] coins = {7, 2, 3, 6,1,4,5,8,9,10,11};
        int total = 327;
        System.out.println("Min Number of coins required :" + findMinNumberOfWays(coins, total));
    }

    private static int findMinNumberOfWays(int[] coins, int total) {
        int[] totalArray = new int[total + 1];
        int[] coinIndexAllocationArray = new int[total + 1];

        int[] dp = new int[total + 1];
        totalArray[0] = 0;
        for (int i = 1; i < totalArray.length; i++) {
            totalArray[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < coinIndexAllocationArray.length; i++) {
            coinIndexAllocationArray[i] = -1;
        }

        for (int i = 0; i < coins.length; i++) {
            for (int totalIndex = 1; totalIndex < totalArray.length; totalIndex++) {
                if (totalIndex >= coins[i]) {
                    int temp = totalArray[totalIndex];
                    if (totalArray[totalIndex - coins[i]] != Integer.MAX_VALUE) {
                        totalArray[totalIndex] = Math.min(totalArray[totalIndex], 1 + totalArray[totalIndex - coins[i]]);
                        if(temp != totalArray[totalIndex])
                            coinIndexAllocationArray[totalIndex] = i;
                    }
                }
            }
        }
        final int result = totalArray[total];
        int i = total;
        while(coinIndexAllocationArray[i] != -1) {
            int val = coins[coinIndexAllocationArray[i]];
            System.out.println(val);
            i = total - val;
            total = i;
        }

        return result;
    }

}
