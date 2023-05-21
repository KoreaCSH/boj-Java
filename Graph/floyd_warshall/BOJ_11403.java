package Graph.floyd_warshall;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_11403 {

    static int n;
    static int[][] graph;
    final static int MAX = 100001;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        graph = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 0) {
                    graph[i][j] = MAX;
                }
                else {
                    graph[i][j] = num;
                }
            }
        }

        for(int k = 0; k < n; k++) {
            for(int s = 0; s < n; s++) {
                for(int e = 0; e < n; e++) {
                    graph[s][e] = Math.min(graph[s][e], graph[s][k] + graph[k][e]);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(graph[i][j] == MAX) {
                    System.out.print("0 ");
                }
                else {
                    System.out.print("1 ");
                }
            }
            System.out.println();
        }

    }

}
