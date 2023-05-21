package Graph.floyd_warshall;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_1389 {

    static int n, m;
    static int[][] distance;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        distance = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) {
                    distance[i][j] = 0;
                }
                else {
                    distance[i][j] = 1000000;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            distance[s][e] = 1;
            distance[e][s] = 1;
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                }
            }
        }

        int sum = 1000000;
        int ans = 0;

        for(int i = 1; i <= n; i++) {
            int tmp = 0;
            for(int j = 1; j <= n; j++) {
                tmp += distance[i][j];
            }
            if(tmp < sum) {
                sum = tmp;
                ans = i;
            }
        }

        System.out.println(ans);

    }

}
