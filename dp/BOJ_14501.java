package dp;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_14501 {

    static int n;
    static int[] t;
    static int[] p;
    static int[] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        t = new int[n+1];
        p = new int[n+1];
        dp = new int[n+2];

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            t[i] = a;
            p[i] = b;
        }

        t[0] = 0;
        p[0] = 0;
        dp[0] = 0;

        for(int i = 1; i <= n; i++) {

            dp[i] = Math.max(dp[i], dp[i-1]);

            if(i + t[i] <= n + 1) {
                dp[i + t[i]] = Math.max(dp[i + t[i]], dp[i] + p[i]);
            }
            else {
                dp[i] = Math.max(dp[i], dp[i-1]);
            }

        }

        System.out.println(Math.max(dp[n], dp[n+1]));

    }

}
