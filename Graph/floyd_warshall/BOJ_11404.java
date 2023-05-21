package Graph.floyd_warshall;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_11404 {

    static int n, m;
    static int[][] distance;
    static final int MAX = 10000001;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
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
            if(distance[s][e] > w) {
                distance[s][e] = w;
            }
        }

        // distance[s][e] = Math.min(distance[s][e], distance[s][k] + distance[k][e])
        // O(V^3) 이다.

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    if(distance[j][k] > distance[j][i] + distance[i][k]) {
                        distance[j][k] = distance[j][i] + distance[i][k];
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(distance[i][j] == MAX) {
                    System.out.print("0 ");
                }
                else {
                    System.out.print(distance[i][j] + " ");
                }
            }
            System.out.println();
        }

    }
}
