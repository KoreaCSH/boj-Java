package Graph.bellman_ford;

import java.io.*;
import java.lang.*;
import java.util.*;

class Edge2 {

    int s;
    int e;
    int w;

    Edge2(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }

}

public class BOJ_1219 {

    static int n, m, start, end;
    static long[] cost;
    static long[] money;
    static Edge2[] edge;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cost = new long[n];
        Arrays.fill(cost, Long.MIN_VALUE);
        cost[start] = 0;
        money = new long[n];
        edge = new Edge2[m];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edge[i] = new Edge2(s, e, w);
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        cost[start] += money[start];

        for(int i = 0; i < n+100; i++) {
            for(int j = 0; j < m; j++) {
                Edge2 now = edge[j];
                if(cost[now.s] == Long.MIN_VALUE) {
                    continue;
                }
                else if(cost[now.s] == Long.MAX_VALUE) {
                    cost[now.e] = Long.MAX_VALUE;
                }
                else if(cost[now.e] < cost[now.s] - now.w + money[now.e]) {
                    cost[now.e] = cost[now.s] - now.w + money[now.e];
                    if(i >= n-1) {
                        cost[now.e] = Long.MAX_VALUE;
                    }
                }
            }
        }

        if(cost[end] == Long.MIN_VALUE) {
            System.out.println("gg");
        }
        else if(cost[end] == Long.MAX_VALUE) {
            System.out.println("Gee");
        }
        else {
            System.out.println(cost[end]);
        }

    }

}
