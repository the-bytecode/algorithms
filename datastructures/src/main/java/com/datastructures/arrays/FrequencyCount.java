package com.datastructures.arrays;

/**
 * Created by chandrashekar.v on 4/26/2017.
 */
public class FrequencyCount {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 10};
        countFrequencies(input, 10);
    }

    private static void countFrequencies(int[] input, int n) {
        int[] counter = new int[n];

        for (int i = 0; i < n; i++) {
            counter[i] = 0;
        }
        for (int i = 0; i < input.length; i++) {
            counter[input[i] - 1]++;
        }

        for (int i = 0; i < n; i++) {
            System.out.println(i + 1 + ": " + counter[i]);
        }
    }
}
