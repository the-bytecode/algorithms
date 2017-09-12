package com.algorithms.dynamicprogramming.lcs;

/**
 * Created by chandrashekar.v on 4/25/2017.
 *
 * Following is a tabulated implementation for the LCS problem.
 *
 * Time Complexity of this implementation is O(mn)
 * which is much better than the worst case time complexity of Naive Recursive implementation.
 */
public class LCSTabulation {

    private static int lcs(char[] seq1, char[] seq2) {

        int m = seq1.length;
        int n = seq2.length;
        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i<= m; i++) {
            for (int j = 0; j<= n; j++) {
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (seq1[i-1] == seq2[j-1])
                    dp[i][j] = dp[i-1][j-1] + 1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

                /*System.out.println("After i: "+i + " j:"+j);
                System.out.printf("%4s", "*");
                for(int k = 0; k<n; k++) {
                    System.out.printf("%4s", seq2[k]);
                }
                System.out.println();*/

                /*for (int a = 0; a<= m; a++) {
                    if(a==0)
                        System.out.print("*");
                    else
                        System.out.print(seq1[a-1]);

                    for (int b = 0; b<= n; b++) {
                        System.out.printf("%4d", dp[a][b]);
                    }
                    System.out.println();
                }*/
            }
        }

      /* System.out.println();
        for (int i = 0; i<= m; i++) {
            for (int j = 0; j<= n; j++) {
                System.out.printf("%4d", dp[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i<= m; i++) {
            for (int j = 0; j<= n; j++) {
                System.out.printf("%4d", dp[i][j]);
            }
            System.out.println();
        }*/

        char[] result = new char[dp[m][n]];
        int i = m;
        int j = n;
        int matchCount = 0;
        while(dp[i][j] != 0) {
            if(dp[i][j] == Math.max(dp[i-1][j], dp[i][j-1])) {
                // move to matched location.
                if(dp[i][j] == dp[i-1][j]) {
                    i = i - 1;
                } else if(dp[i][j] == dp[i][j-1]) {
                    j = j-1;
                }
            } else {
                matchCount ++;
                result[result.length - matchCount] = seq1[i-1];
                //Move diagonally
                i = i - 1;
                j = j - 1;
            }
        }
        for(int z = 0; z< result.length; z++) {
            System.out.printf("%1s",result[z]);
        }
        return dp[m][n];


    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        char[] seq1 = "AGGTABNJHJSDYUYSDNKCUJJJASLLASJLKNKCGXTXAYBKJHKJASHIUWYIUWNCJAJSHHSKJAALSKLNCKJLVJBYTTYSDYFYASBCMNCNLKJASOIIIUBBHBHAJSJKNASKJNJNCJHJSAGYAGSYKJTFDFGAVSHHJASHJBASIIFFARSEQAMNMZXBNYKHHASKSJJAKLNCNKAJHKJSHUHIUHKJASKJNCKJNKJAHSKJANKJNCKJNKJAHSKJNAKJNKJNCKJNAUSYTWYTYJNMSNCMNCKJHKULSJLSA".toCharArray();
        char[] seq2 = "GXTXAYBKJHKJASHIUWYIUWNCJAJSHHSKJAALSKLNCKJLVJBYTTYSDYFYASBCMNCNGXTXAYBKJHKJASHIUWYIUWNCJAJSHHSKJAALSKLNCKJLVJBYTTYSDYFYASBCMNCNLKJASOIIIUBBHBHAJSJKNASKJNJNCJHJSAGYAGSYKJTFDFGAVSHHJASHJBASIIFFARSEQAMNMZXBNYLKJASOIIIUBBHBHAJSJKNASKJNJNCJHJSAGYAGSYKJTFDFGAVSHHJASHJBASIIFFARSEQAMNMZXBNY".toCharArray();

        /*char[] seq1 = "AGGTAB".toCharArray();
        char[] seq2 = "GXTXAYB".toCharArray();*/

        System.out.println("\nLength of Longest Common Subsequence (LCS) is : "+ lcs(seq1,seq2));
        System.out.println("Time:"+ (System.currentTimeMillis() - start));
    }

}
