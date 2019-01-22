package com.datastructures.arrays;

/**
 * An array contains n numbers ranging from 0 to n-1. There are some numbers duplicated in the array.
 * It is not clear how many numbers are duplicated or how many times a number gets duplicated. How do you find a duplicated number in the array? For example,
 * if an array of length 7 contains the numbers {2, 3, 1, 0, 2, 5, 3}, the implemented function (or method) should return either 2 or 3.
 */
public class MultipleDuplicatesInArray {

    public static void main(String[] args) {
        int n = 7;
        int a[] = {2, 3, 1, 0, 2, 5, 3};

        findDuplicates(a, n);
        findDuplicates1(a, n);
    }

    private static void findDuplicates1(int[] a, int n) {
        for (int i = 0; i < n; i++) {
            while (a[i] != i) {
                if (a[i] == a[a[i]]) {
                    System.out.println("Duplicate:" + a[i]);
                    break; // Allows to continue with further array traverse and find all duplicates.
                }
                else {
                    //Swap
                    int temp = a[i];
                    a[i] = a[a[i]];
                    a[a[i]] = temp;

                }
            }
        }
    }

    private static void findDuplicates(int[] a, int n) {
        if (n != a.length) {
            System.out.println("Invalid input. Size mismatch.");
            return;
        }

        int i = 0;
        while (i < n) {
            if (a[i] == i) {
                i++;
            } else {
                if (a[i] == a[a[i]]) {
                    System.out.println("Duplicate found:" + a[i]);
                    break;
                }
                while (a[i] != i) {
                    swap(a, i);
                }

            }
        }
    }

    private static void swap(int[] a, int i) {
        int temp = a[a[i]];
        a[a[i]] = a[i];
        a[i] = temp;
    }
}
