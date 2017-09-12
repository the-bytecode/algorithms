package com.algorithms.dynamicprogramming.lcs;

/**
 * Created by chandrashekar.v on 4/25/2017.
 *
 * One important observation in LCSTabulation implementation is, in each iteration of outer loop we only,
 * need values from all columns of previous row. So there is no need of storing all rows in our DP matrix,
 * we can just store two rows at a time and use them, in that way used space will be reduced from L[m+1][n+1] to L[2][n+1].
 *
 */
public class LCSTabulationSpaceOptimized {

    private static int lcs(char[] seq1, char[] seq2) {

        int m = seq1.length;
        int n = seq2.length;
        int[][] dp = new int[2][n+1];

        int biIndex = 0;

        for (int i = 0; i<= m; i++) {
            for (int j = 0; j<= n; j++) {
                biIndex = i&1;

                if(i == 0 || j == 0)
                    dp[biIndex][j] = 0;
                else if (seq1[i-1] == seq2[j-1])
                    dp[biIndex][j] = dp[1-biIndex][j-1] + 1;
                else
                    dp[biIndex][j] = Math.max(dp[1-biIndex][j], dp[biIndex][j-1]);

            }
        }
        return dp[biIndex][n];


    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        char[] seq1 = "AGGTABNJHJSDYUYSDNKCUJJJASLLASJLKNKCGXTXAYBKJHKJASHIUWYIUWNCJAJSHHSKJAALSKLNCKJLVJBYTTYSDYFYASBCMNCNLKJASOIIIUBBHBHAJSJKNASKJNJNCJHJSAGYAGSYKJTFDFGAVSHHJASHJBASIIFFARSEQAMNMZXBNYKHHASKSJJAKLNCNKAJHKJSHUHIUHKJASKJNCKJNKJAHSKJANKJNCKJNKJAHSKJNAKJNKJNCKJNAUSYTWYTYJNMSNCMNCKJHKULSJLSA".toCharArray();
        char[] seq2 = "GXTXAYBKJHKJASHIUWYIUWNCJAJSHHSKJAALSKLNCKJLVJBYTTYSDYFYASBCMNCNGXTXAYBKJHKJASHIUWYIUWNCJAJSHHSKJAALSKLNCKJLVJBYTTYSDYFYASBCMNCNLKJASOIIIUBBHBHAJSJKNASKJNJNCJHJSAGYAGSYKJTFDFGAVSHHJASHJBASIIFFARSEQAMNMZXBNYLKJASOIIIUBBHBHAJSJKNASKJNJNCJHJSAGYAGSYKJTFDFGAVSHHJASHJBASIIFFARSEQAMNMZXBNY".toCharArray();

        System.out.println("\nLength of Longest Common Subsequence (LCS) is : "+ lcs(seq1,seq2));
        System.out.println("Time:"+ (System.currentTimeMillis() - start));
    }
}
