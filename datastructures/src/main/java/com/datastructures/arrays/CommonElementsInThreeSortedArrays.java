package com.datastructures.arrays;

/**
 * Created by chandrashekar.v on 4/26/2017.
 */
public class CommonElementsInThreeSortedArrays {

    public static void main(String[] args) {
        int[] a = {1, 2};
        int[] b = {1, 2, 3, 9, 9, 9};
        int[] c = {1, 9, 3, 4, 5, 6};
        commonElements(a, b, c);
    }

    private static void commonElements(int[] a, int[] b, int[] c) {

        int i = 0;
        int j = 0;
        int k = 0;
        int n1 = a.length;
        int n2 = b.length;
        int n3 = c.length;
        while (i < a.length) {
            int x = a[i];
            int y = b[i];
            int z = c[i];

            if (x == y && x == z) {
                System.out.println(x);
                i++;
                j++;
                k++;
            } else if (x < y)
                i++;
            else if (y < z)
                j++;
            else if (x > y && y > z)
                k++;
        }

    }
}
