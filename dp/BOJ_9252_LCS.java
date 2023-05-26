package dp;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_9252_LCS {

    static char[] A;
    static char[] B;
    static int[][] dp;
    static ArrayList<Character> ans = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        A = br.readLine().toCharArray();
        B = br.readLine().toCharArray();

        dp = new int[A.length+1][B.length+1];

        for(int i = 1; i < A.length + 1; i++) {
            for(int j = 1; j < B.length + 1; j++) {

                if(A[i-1] == B[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }

        System.out.println(dp[A.length][B.length]);
        getAns(A.length, B.length);
        for(int i = ans.size() - 1; i >= 0; i--) {
            System.out.print(ans.get(i));
        }

    }

    static void getAns(int r, int c) {
        if(r == 0 || c == 0) {
            return;
        }
        if(A[r-1] == B[c-1]) {
            ans.add(A[r-1]);
            getAns(r-1, c-1);
        }
        else {
            if(dp[r-1][c] > dp[r][c-1]) {
                getAns(r-1, c);
            }
            else {
                getAns(r, c-1);
            }
        }
    }

}
