package Graph.mst;

import java.io.*;
import java.util.*;
import java.lang.*;

class Node implements Comparable<Node> {

    int v;
    int w;

    Node(int v, int w) {
        this.v = v;
        this.w = w;
    }

    public int compareTo(Node node) {
        return this.w - node.w;
    }

}

public class BOJ_1197_prim {

    static int n, m;
    static boolean[] visited;
    static ArrayList<Node>[] graph;
    static PriorityQueue<Node> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[s].add(new Node(e, w));
            graph[e].add(new Node(s, w));
        }

        int ans = 0;

        pq.add(new Node(1, 0));
        while(!pq.isEmpty()) {
            Node now = pq.poll();
            if(visited[now.v]) continue;

            visited[now.v] = true;
            ans += now.w;

            for(Node next : graph[now.v]) {
                pq.add(new Node(next.v, next.w));
            }
        }

        System.out.println(ans);

    }

}
