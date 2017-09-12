package com.algorithms.dynamicprogramming.coinchange;

import java.util.HashMap;

/**
 * Created by chandrashekar.v on 4/25/2017.
 */
public class NumberOfWays {

    public static void main(String[] args) {
        int[] coins = {50, 25, 10, 5, 1};
        int sum = 79;
        System.out.println("Total No.Of ways: "+calculateWays(coins, sum, 0, new HashMap<String, Long>()));
    }

    private static long calculateWays(int[] coins, int sum, int index, HashMap<String, Long> memo) {

        int amountWithCoins = 0;
        long ways = 0;
        if(sum == 0)
            return 1;
        if(index >= coins.length)
            return 0;

        String key = sum+"_"+index;
        if(memo.containsKey(key))
            return memo.get(key);

        while(amountWithCoins <= sum) {
            int remainingAmount = sum-amountWithCoins;
            ways += calculateWays(coins, remainingAmount, index + 1, memo);
            amountWithCoins +=coins[index];
            memo.put(key, ways);
        }
        return ways;
    }
}
