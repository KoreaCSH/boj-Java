package dp;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_1904 {

    static int n;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        if(n == 1) {
            System.out.println(1);
            return;
        }
        dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[1] = 1;
        dp[2] = 2;

        System.out.println(recur(n));
    }

    static int recur(int num) {

        if(dp[num] == -1) {
            dp[num] = (recur(num-1) + recur(num-2)) % 15746;
        }

        return dp[num];
    }

}
