package dp;

import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_1463 {

    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];

        // dp 점화식
        // top-down (재귀) ? bottom-up (반복문) ?

        dp[1] = 0;

        System.out.println(recur(n));

        br.close();

    }

    static int recur(int num) {
        if(num == 1) {
            return dp[1];
        }

        if(dp[num] == 0) {

            if(num % 6 == 0) {
                dp[num] = Math.min(recur(num-1), Math.min(recur(num/3), recur(num/2))) + 1;
            }

            else if(num % 3 == 0) {
                dp[num] = Math.min(recur(num-1), recur(num/3)) + 1;
            }

            else if(num % 2 == 0) {
                dp[num] = Math.min(recur(num-1), recur(num/2)) + 1;
            }

            else {
                dp[num] = recur(num - 1) + 1;
            }

        }

        return dp[num];

    }

}
