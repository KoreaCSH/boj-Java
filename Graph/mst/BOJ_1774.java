package Graph.mst;

import java.util.*;
import java.lang.*;
import java.io.*;

class Star {

    int num;
    int x;
    int y;

    Star(int num, int x, int y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }

}

class Path implements Comparable<Path> {

    int s;
    int e;
    double w;

    Path(int s, int e, double w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }

    public int compareTo(Path p) {
        if(this.w > p.w) {
            return 1;
        }
        else {
            return -1;
        }
    }

}

public class BOJ_1774 {

    static int n, m;
    static Star[] stars;
    static PriorityQueue<Path> pq = new PriorityQueue<>();
    static int edgeCount;
    static double ans;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        stars = new Star[n+1];
        parent = new int[n+1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars[i] = new Star(i, x, y);
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            union(s, e);
            edgeCount++;
        }

        for(int i = 1; i <= n; i++) {
            Star now = stars[i];
            for(int j = 1; j <= n; j++) {
                Star next = stars[j];
                pq.add(new Path(now.num, next.num, Math.sqrt(Math.pow(now.x - next.x, 2) + Math.pow(now.y - next.y, 2))));
            }
        }

        while(!pq.isEmpty()) {
            Path p = pq.poll();
            if(find(p.s) != find(p.e)) {
                union(p.s, p.e);
                edgeCount++;
                ans += p.w;
            }
        }

        System.out.printf("%.2f", ans);

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
