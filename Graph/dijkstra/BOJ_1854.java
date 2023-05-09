package Graph.dijkstra;

import java.io.*;
import java.util.*;
import java.lang.*;

class Node3 implements Comparable<Node3> {

    int vertex;
    int value;
    Node3(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }

    @Override
    public int compareTo(Node3 n) {
        if(this.value > n.value) {
            return 1;
        } else {
            return -1;
        }
    }

}

public class BOJ_1854 {

    static int n, m, k;
    // static boolean[] visited; - 여러번 방문할 수 있기 때문에 visited[]를 검사할 필요가 없다.
    static PriorityQueue<Integer>[] distance;
    static PriorityQueue<Node3> pq = new PriorityQueue<>();
    static ArrayList<Node3>[] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        distance = new PriorityQueue[n+1];
        for(int i = 1; i < n+1; i++) {
            distance[i] = new PriorityQueue<>(k, new Comparator<Integer>() {
                public int compare(Integer i1, Integer i2) {
                    return i1 > i2 ? -1 : 1;
                }
            });
        }

        graph = new ArrayList[n+1];
        for(int i = 1; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node3(v, w));
        }

        pq.add(new Node3(1, 0));
        distance[1].add(0);
        while(!pq.isEmpty()) {
            Node3 now = pq.poll();
            for(Node3 next : graph[now.vertex]) {
                if(distance[next.vertex].size() < k) {
                    distance[next.vertex].add(now.value + next.value);
                    pq.add(new Node3(next.vertex, now.value + next.value));
                }
                else if(distance[next.vertex].size() == k && distance[next.vertex].peek() > now.value + next.value) {
                    distance[next.vertex].poll();
                    distance[next.vertex].add(now.value + next.value);
                    pq.add(new Node3(next.vertex, now.value + next.value));
                }
            }
        }

        for(int i = 1; i < n+1; i++) {
            if(distance[i].size() == k) {
                System.out.println(distance[i].peek());
            } else {
                System.out.println("-1");
            }
        }

    }

}
