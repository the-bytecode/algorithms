package com.algorithms.search;

import java.util.Arrays;

/**
 * Created by chandrashekar.v on 4/25/2017.
 */
public class IcecreamParlorUsingBinarySearch {

    public static void main(String[] args) {
        int[] menu = {1, 3, 5, 3, 4, 8, 10};
        int money = 10;
        int[] indices = findIcecreamChoices(menu, money);
        for (int i=0; i< indices.length; i++) {
            System.out.println(menu[indices[i]]);
        }
    }

    private static int[] findIcecreamChoices(int[] menu, int money) {

        int[] sortedMenu = menu.clone();
        Arrays.sort(sortedMenu);

        for (int i = 0; i < sortedMenu.length; i++) {
            int complement = money - menu[i];
            int location = Arrays.binarySearch(sortedMenu, i + 1, sortedMenu.length, complement);
            if (location >= 0 && location < sortedMenu.length && sortedMenu[location] == complement) {
                int[] indices = getIndicesFromValues(menu, complement, sortedMenu[i]);
                return indices;
            }
        }

        return null;
    }

    private static int[] getIndicesFromValues(int[] menu, int complement, int value1) {

        int index1 = getIndexOf(value1, menu, -1);
        int index2 = getIndexOf(complement, menu, index1);
        int[] indices = {Math.min(index1, index2), Math.max(index1, index2)};
        return indices;
    }

    private static int getIndexOf(int value, int[] menu, int excludedIndex) {
        for(int i=0; i<menu.length; i++) {
            if(menu[i] == value && excludedIndex != i)
                return i;
        }

        return -1;
    }
}
