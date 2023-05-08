package Graph.dijkstra;

import java.io.*;
import java.lang.*;
import java.util.*;

class Node implements Comparable<Node> {

    int vertex;
    int value;

    Node(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }

    @Override
    public int compareTo(Node n) {
        if(this.value > n.value) {
            return 1;
        }
        else {
            return -1;
        }
    }

}

public class BOJ_1753 {

    static int n, m;
    static ArrayList<Node> graph[];
    static boolean[] visited;
    static int[] distance;
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        distance = new int[n+1];
        visited = new boolean[n+1];
        graph = new ArrayList[n+1];
        for(int i = 1; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }
        pq = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        distance[start] = 0;

        // 최단 거리 배열은 시작 정점을 제외하고 무한대로 초기화
        for(int i = 1; i < n+1; i++) {
            if(i != start) {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }

        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            int now = pq.poll().vertex;
            if(visited[now]) continue;
            visited[now] = true;
            for(Node next : graph[now]) {
                // 인접한 모든 노드에 대해서 relax 를 해야 한다.
                distance[next.vertex] = Math.min(distance[next.vertex], distance[now] + next.value);
                pq.add(new Node(next.vertex, distance[next.vertex]));
            }
        }

        for(int i = 1 ; i < n+1; i++) {
            if(distance[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            }
            else {
                System.out.println(distance[i]);
            }
        }

    }

}
