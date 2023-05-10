package Graph.dijkstra;

import java.io.*;
import java.util.*;
import java.lang.*;

class Node4 implements Comparable<Node4> {

    int vertex;
    int value;

    Node4(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }

    public int compareTo(Node4 n) {
        return this.value - n.value;
    }

}

public class BOJ_1504 {

    // distance[] - 시작 정점은 0, 나머지는 무한대
    // 시작 정점에서 시작, distance 가 낮은 정점으로 이동하기 위해 우선순위 큐를 사용한다.
    // 방문한 노드를 재방문할 수 없다면 visited[] 를 둬야 한다.

    static int n, m;
    static int[] distance;
    static ArrayList<Node4>[] graph;
    static PriorityQueue<Node4> pq;
    static final int INF = 200000001;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i = 1; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[s].add(new Node4(e, w));
            graph[e].add(new Node4(s, w));
        }

        st = new StringTokenizer(br.readLine());
        int second = Integer.parseInt(st.nextToken());
        int third = Integer.parseInt(st.nextToken());

        int res1 = 0;
        res1 += dijkstra(1, second);
        res1 += dijkstra(second, third);
        res1 += dijkstra(third, n);

        int res2 = 0;
        res2 += dijkstra(1, third);
        res2 += dijkstra(third, second);
        res2 += dijkstra(second, n);

        int ans = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);

        System.out.println(ans);
    }

    static int dijkstra(int start, int end) {
        pq = new PriorityQueue<>();
        distance = new int[n+1];
        Arrays.fill(distance, INF);
        distance[start] = 0;
        pq.add(new Node4(start, 0));

        while(!pq.isEmpty()) {
            Node4 now = pq.poll();
            for(Node4 next : graph[now.vertex]) {
                if(distance[next.vertex] > distance[now.vertex] + next.value) {
                    distance[next.vertex] = distance[now.vertex] + next.value;
                    pq.add(new Node4(next.vertex, distance[next.vertex]));
                }
            }
        }

        return distance[end];
    }

}
