package com.datastructures.arrays;

/**
 * Created by chandrashekar.v on 4/26/2017.
 */
public class LonelyIntegerInRepeatedDuplicatesNTimes {

    public static void main(String[] args) {
        int[] numbers = {5, 5, 4, 8, 4, 5, 8, 9, 4, 8, 9, 9, 5, 5, 4, 8, 4, 5, 8, 9, 4, 8, 9, 9, 5, 5, 4, 8, 4, 5, 8, 9, 4, 8, 9, 9, 5, 5, 4, 8, 4, 5, 8, 9, 4, 8, 9, 9, 5, 5, 4, 8, 4, 5, 8, 9, 4, 8, 9, 9, 5, 5, 4, 8, 4, 5, 8, 9, 4, 8, 9, 9, 5, 5, 4, 8, 4, 5, 8, 9, 4, 8, 9, 9, 5, 5, 4, 8, 4, 5, 8, 9, 4, 8, 9, 9, 5, 5, 4, 8, 4, 5, 8, 9, 4, 8, 9, 9, 10};
        int N = 27;
        findLonelyInteger(numbers, N);
    }

    private static void findLonelyInteger(int[] numbers, int n) {

        int countSetBit[] = new int[32];
        for (int i = 0; i < numbers.length; i++) {
            for (int k = 0; k < 32; k++) {

                // Find the set bits in the current element.
                int kthBitSet = 1 << k;

                // If the kth bit is set, then increment the count of countSetBit[k].
                if ((numbers[i] & kthBitSet) == kthBitSet) {
                    countSetBit[k]++;
                }
            }
        }

        int occurredOnce = 0;

        /*
        *  Find the remainder of each element with N so as to see what is
        *  the representation of the single occurred element.
        */
        for (int k = 0; k < 32; k++) {
            countSetBit[k] = countSetBit[k] % n;

             /*
             * After mod operation, each element of countSetBit represent bits
             * of required element(occurredOnce). Therefore, set ith bit in
             * occurredOnce if countSetBit[i] is 1.
             */
            if (countSetBit[k] == 1)
                occurredOnce = occurredOnce | (1 << k);
        }

        System.out.println("Lonely Integer:" + occurredOnce);
    }
}