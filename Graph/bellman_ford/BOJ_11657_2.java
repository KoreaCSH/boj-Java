package Graph.bellman_ford;

import java.io.*;
import java.util.*;
import java.lang.*;

class Edge5 {

    int s;
    int e;
    int w;

    Edge5(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }

}

public class BOJ_11657_2 {

    static int n, m;
    static Edge5[] edges;
    static long[] distance;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        distance = new long[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;

        edges = new Edge5[m];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge5(s, e, w);
        }

        for(int i = 0; i < n-1; i++) {
            for(Edge5 now : edges) {
                if(distance[now.e] > distance[now.s] + now.w && distance[now.s] != Integer.MAX_VALUE) {
                    distance[now.e] = distance[now.s] + now.w;
                }
            }
        }

        boolean isCycle = false;
        for(Edge5 now : edges) {
            if(distance[now.e] > distance[now.s] + now.w && distance[now.s] != Integer.MAX_VALUE) {
                isCycle = true;
            }
        }

        if(isCycle) {
            System.out.println("-1");
        }
        else {
            for(int i = 2; i <= n; i++) {
                if(distance[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                }
                else {
                    System.out.println(distance[i]);
                }
            }
        }

    }

}
