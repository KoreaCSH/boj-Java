package dp;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_9251 {

    static char[] A;
    static char[] B;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = br.readLine().toCharArray();
        B = br.readLine().toCharArray();

        dp = new int[A.length+1][B.length+1];

        for(int i = 1; i <= A.length; i++) {
            for(int j = 1; j <= B.length; j++) {
                if(A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[A.length][B.length]);

    }

}