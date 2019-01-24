package com.datastructures.arrays;

/**
 * An array contains n numbers ranging from 0 to n-2. There is exactly one number duplicated in the array.
 * How do you find the duplicated number? For example, if an array with length 5 contains numbers {0, 2, 1, 3, 2}, the duplicated number is 2
 */
public class DuplicateElementInArray {

    public static void main(String[] args) {
        int n = 5;
        int array[] = {0, 2, 1, 3, 2}; // 0 to n-2 numbers

        findDuplicate(array);


    }

    private static void findDuplicate(int[] array) {
        int arraySum = 0;
        for (int i = 0; i < array.length; i++) {

            if (array[i] < 0 || array[i] > array.length - 2) {
                System.out.println("Invalid number found:" + array[i]);
                return;
            }
            arraySum += array[i];
        }

        int sum2 = (array.length - 1) * (array.length - 2) / 2; // using sum of first n numbers n(n+1)/2
        System.out.println("Duplicate Number:" + (arraySum - sum2));
    }
}
