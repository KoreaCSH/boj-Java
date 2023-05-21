package Graph.mst;

import java.io.*;
import java.util.*;
import java.lang.*;

class Point {

    int num;
    double x;
    double y;

    Point(int num, double x, double y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }

}

class Edge2 implements Comparable<Edge2> {

    int s;
    int e;
    double w;

    Edge2(int s, int e, double w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }

    public int compareTo(Edge2 edge) {

        if(this.w > edge.w) {
            return 1;
        } else {
            return -1;
        }
    }

}

public class BOJ_4386 {

    static int n;
    static PriorityQueue<Edge2> pq = new PriorityQueue<>();
    static Point[] nodes;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        nodes = new Point[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            nodes[i] = new Point(i, x, y);
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                double distance = Math.sqrt(Math.pow(nodes[i].x - nodes[j].x, 2) + Math.pow(nodes[i].y - nodes[j].y, 2));
                pq.add(new Edge2(i, j, distance));
            }
        }

        double ans = 0;
        int count = 0;
        while(count < n-1) {
            Edge2 now = pq.poll();
            if(find(now.s) != find(now.e)) {
                union(now.s, now.e);
                ans += now.w;
                count++;
            }
        }

        System.out.println(ans);

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
