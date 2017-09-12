package com.algorithms.dynamicprogramming.lcs;

/**
 * Created by chandrashekar.v on 4/25/2017.
 * <p>
 * LCSRecursion : Longest Common Sequence using recursion.
 * <p>
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 * So a string of length n has 2^n different possible subsequences.
 * <p>
 * It is a classic computer science problem, the basis of diff (a file comparison program that
 * outputs the differences between two files), and has applications in bioinformatics.
 * <p>
 * Examples:
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 * <p>
 * 1) Optimal Substructure:
 * Let the input sequences be X[0..m-1] and Y[0..n-1] of lengths m and n respectively.
 * And let L(X[0..m-1], Y[0..n-1]) be the length of LCS of the two sequences X and Y.
 * Following is the recursive definition of L(X[0..m-1], Y[0..n-1]).
 * <p>
 * If last characters of both sequences match (or X[m-1] == Y[n-1]) then
 * L(X[0..m-1], Y[0..n-1]) = 1 + L(X[0..m-2], Y[0..n-2])
 * <p>
 * If last characters of both sequences do not match (or X[m-1] != Y[n-1]) then
 * L(X[0..m-1], Y[0..n-1]) = MAX ( L(X[0..m-2], Y[0..n-1]), L(X[0..m-1], Y[0..n-2])
 * <p>
 * Examples:
 * 1) Consider the input strings “AGGTAB” and “GXTXAYB”. Last characters match for the strings.
 * So length of LCS can be written as:
 * L(“AGGTAB”, “GXTXAYB”) = 1 + L(“AGGTA”, “GXTXAY”)
 * <p>
 * 2) Consider the input strings “ABCDGH” and “AEDFHR.
 * Last characters do not match for the strings. So length of LCS can be written as:
 * L(“ABCDGH”, “AEDFHR”) = MAX ( L(“ABCDG”, “AEDFHR”), L(“ABCDGH”, “AEDFH”) )
 * So the LCS problem has optimal substructure property as the main problem can be solved
 * using solutions to subproblems.
 * <p>
 * 2) Overlapping Subproblems:
 * <p>
 * Considering the implementation for AGGTAB & GXTXAYB, following is a partial recursion tree
 * for input strings “AXYT” and “AYZX”
 * <p>
 * com.algorithms.dynamicprogramming.lcs("AXYT", "AYZX")
 * /                 \
 * com.algorithms.dynamicprogramming.lcs("AXY", "AYZX")            com.algorithms.dynamicprogramming.lcs("AXYT", "AYZ")
 * /            \                  /               \
 * com.algorithms.dynamicprogramming.lcs("AX", "AYZX") com.algorithms.dynamicprogramming.lcs("AXY", "AYZ")   com.algorithms.dynamicprogramming.lcs("AXY", "AYZ") com.algorithms.dynamicprogramming.lcs("AXYT", "AY")
 * <p>
 * Time complexity of the above naive recursive approach is O(2^n)
 * in worst case and worst case happens when all characters of X and Y mismatch i.e., length of LCS is 0.
 * <p>
 * In the above partial recursion tree, com.algorithms.dynamicprogramming.lcs(“AXY”, “AYZ”) is being solved twice.
 * If we draw the complete recursion tree, then we can see that there are many subproblems
 * which are solved again and again. So this problem has Overlapping Substructure property and recomputation
 * of same subproblems can be avoided by either using Memoization or Tabulation.
 */
public class LCSRecursion {

    private static int lcs(char[] seq1, char[] seq2) {
        return lcs(seq1, seq2, seq1.length, seq2.length);
    }

    private static int lcs(char[] seq1, char[] seq2, int m, int n) {

        if (m == 0 || n == 0)
            return 0;

        if (seq1[m - 1] == seq2[n - 1])
            return 1 + lcs(seq1, seq2, m - 1, n - 1);
        else
            return Math.max(lcs(seq1, seq2, m, n - 1), lcs(seq1, seq2, m - 1, n));
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        char[] seq1 = "AGGTABNJH".toCharArray();
        char[] seq2 = "GXTXAYBKJ".toCharArray();


        System.out.println("Length of Longest Common Subsequence (LCS) is : " + lcs(seq1, seq2));
        System.out.println("Time:" + (System.currentTimeMillis() - start));
    }
}
