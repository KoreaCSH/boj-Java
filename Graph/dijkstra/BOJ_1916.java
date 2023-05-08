package Graph.dijkstra;

import java.io.*;
import java.lang.*;
import java.util.*;

class Node2 implements Comparable<Node2> {

    int vertex;
    int value;

    Node2(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }

    @Override
    public int compareTo(Node2 n) {
        if(this.value > n.value) {
            return 1;
        }
        else {
            return -1;
        }
    }

}

public class BOJ_1916 {

    static int n, m;
    static boolean[] visited;
    static int[] distance;
    static ArrayList<Node2>[] graph;
    static PriorityQueue<Node2> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        distance = new int[n+1];
        graph = new ArrayList[n+1];
        for(int i = 1; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());

        // graph 채우기
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node2(v, w));
        }

        // start, end 받고 distance 채우기
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i < n+1; i++) {
            if(i == start) {
                distance[i] = 0;
            }
            else {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        // start 에서부터 다익스트라 시작
        pq.add(new Node2(start, 0));
        while(!pq.isEmpty()) {
            int now = pq.poll().vertex;
            if(visited[now]) continue;
            visited[now] = true;
            // 인접한 모든 에지에 대해 relax 를 실행
            for(Node2 next : graph[now]) {
                distance[next.vertex] = Math.min(distance[next.vertex], distance[now] + next.value);
                pq.add(new Node2(next.vertex, distance[next.vertex]));
            }
        }

        System.out.println(distance[end]);

    }

}
