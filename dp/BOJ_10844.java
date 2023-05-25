package dp;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_10844 {

    static int n;
    static long dp[][];
    static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new long[n+1][10];

        for(int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], -1L);
        }

        for(int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        long result = 0;
        for(int i = 1; i < 10; i++) {
            result += recur(n, i);
        }

        System.out.println(result % MOD);

    }

    static long recur(int digit, int num) {

        if(dp[digit][num] == -1) {

            if(num == 0) {
                dp[digit][num] = recur(digit-1, 1);
            }

            else if(num == 9) {
                dp[digit][num] = recur(digit-1, 8);
            }

            else {
                dp[digit][num] = recur(digit-1, num-1) + recur(digit-1, num+1);
            }

        }

        return dp[digit][num] % MOD;

    }

}
