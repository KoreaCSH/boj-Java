package Graph.floyd_warshall;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_1956_floyd_warshall {

    static int n, m;
    static int[][] distance;
    static final int MAX = 500000000;

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
                    distance[i][j] = MAX;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            distance[s][e] = w;
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n ; i++) {
                for(int j = 1; j <= n; j++) {
                    if(i == j) {
                        continue;
                    }
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        int ans = MAX;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) continue;
                if(distance[i][j] != MAX && distance[j][i] != MAX) {
                    ans = Math.min(ans, distance[i][j] + distance[j][i]);
                }
            }
        }

        if(ans == MAX) {
            System.out.println(-1);
        }
        else {
            System.out.println(ans);
        }

    }

}
