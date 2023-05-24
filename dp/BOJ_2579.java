package dp;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_2579 {

    static int n;
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        dp = new int[n+1];

        for(int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = arr[1];

        System.out.println(recur(n));

        br.close();

    }

    static int recur(int num) {

        if(dp[num] == -1) {
            if(num > 2) {
                dp[num] = Math.max(arr[num-1] + recur(num-3), recur(num-2)) + arr[num];
            }
            else {
                dp[num] = Math.max(arr[num-1] + recur(num-2), recur(num-2)) + arr[num];
            }
        }

        return dp[num];
    }

}
