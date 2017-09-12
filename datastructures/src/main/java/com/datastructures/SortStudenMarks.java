package com.datastructures;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by chandrashekar.v on 4/28/2017.
 */
public class SortStudenMarks {

    public static void main(String[] args) {

        int n = 3;
        int s = 5;
        int[][] marks = {
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1}
        };
        sortStudents(n, s, marks);
    }

    private static int[] sortStudents(int input1, int input2, int[][] input3) {

        if(input1 != input3.length || input3 == null)
            return null;

        int[] result = new int[input1];

        for(int i = 0; i< input1; i++) {
            result[i] = 0;
        }
        int[] totalBySub = new int[input2];
        for(int i = 0; i< input2; i++) {
            totalBySub[i] = 0;
        }
        for(int i=0; i<input1; i++) {
            for(int j=0; j<input2; j++) {
                result[i] +=input3[i][j];
                totalBySub[j] += input3[i][j];
            }
        }

        int index = 0;
        int count = 1;
        for(int i=1; i<totalBySub.length; i++) {
            if(totalBySub[index]> totalBySub[i])
                index = i;
            else if (totalBySub[index] == totalBySub[i])
                count++;
        }
        if(count != totalBySub.length)
        for(int i = 0; i<result.length; i++) {
            result[i] =  result[i]- input3[i][index];

        }
        Arrays.sort(result);

        int sorted[] = IntStream.range(0, result.length).map(i->result[result.length-i-1]).toArray();
        for(int i = 0; i<sorted.length; i++) {
            System.out.println(sorted[i]);
        }
        return sorted;
    }
}
