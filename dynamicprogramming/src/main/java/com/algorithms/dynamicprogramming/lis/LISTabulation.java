package com.algorithms.dynamicprogramming.lis;

/**
 * Created by chandrashekar.v on 4/25/2017.
 */
public class LISTabulation {
    public static void main(String[] args) {

        int arr[] = {3,4,-1,0,2,6,3};
        calculateLIS(arr);
    }

    private static void calculateLIS(int[] arr) {
        int n = arr.length;
        int[] lis = new int[n];

        for (int i = 0; i < n; i++) {
            lis[i] = 1;
        }


        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                }
            }
        }

        int max = -1;
        for (int i = 0; i < lis.length; i++) {
            if (lis[i] > max)
                max = lis[i];
        }

        int temp = max;
        int[] arrFinal = new int[max];
        int matchCount = 0;
        for (int i = lis.length - 1; i >= 0; i--) {
            if (lis[i] == temp) {
                matchCount++;
                arrFinal[arrFinal.length-matchCount] = arr[i];
                temp--;
            }
        }
        System.out.println("Longest Increasing Sequence (LIS) length: " + max);

        for (int i=0; i<arrFinal.length; i++)
            System.out.printf("%4d", arrFinal[i]);
    }
}
