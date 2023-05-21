package Graph.mst;

import java.io.*;
import java.util.*;
import java.lang.*;

class Edge implements Comparable<Edge> {

    int s;
    int e;
    int w;

    Edge(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }

    public int compareTo(Edge edge) {
        return this.w - edge.w;
    }

}

public class BOJ_1197 {

    static int n, m;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            pq.add(new Edge(s, e, w));
        }

        int count = 0;
        int weight = 0;
        while(count < n-1) {
            Edge now = pq.poll();
            if(find(now.s) != find(now.e)) {
                union(now.s, now.e);
                weight += now.w;
                count++;
            }
        }

        System.out.println(weight);

    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[b] = a;
        }
    }

    static int find(int a) {
        if(a == parent[a]) {
            return a;
        }
        else {
            return parent[a] = find(parent[a]);
        }
    }

}
