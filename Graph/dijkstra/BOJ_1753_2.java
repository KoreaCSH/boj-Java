package Graph.dijkstra;

import java.io.*;
import java.util.*;
import java.lang.*;

class Node10 implements Comparable<Node10> {

    int v;
    int w;

    Node10(int v, int w) {
        this.v = v;
        this.w = w;
    }

    public int compareTo(Node10 node) {
        return this.w - node.w;
    }

}

public class BOJ_1753_2 {

    static int n, m, k;
    static int[] distance;
    static boolean[] visited;
    static ArrayList<Node10>[] graph;
    static PriorityQueue<Node10> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        visited = new boolean[n+1];
        graph = new ArrayList[n+1];
        for(int i = 1; i <= n ; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        distance[k] = 0;

        for(int i = 0; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[s].add(new Node10(e, w));
        }

        pq.add(new Node10(k, 0));
        while(!pq.isEmpty()) {
            Node10 now = pq.poll();
            if(visited[now.v]) continue;
            visited[now.v] = true;

            for(Node10 next : graph[now.v]) {
                if(distance[next.v] > distance[now.v] + next.w) {
                    distance[next.v] = distance[now.v] + next.w;
                    pq.add(new Node10(next.v, distance[next.v]));
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            if(distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }

    }

}
