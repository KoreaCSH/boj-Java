package BFS;

import java.io.*;
import java.util.*;
import java.lang.*;

class Node2 {
    int vertex;
    int value;

    Node2(int vertex, int value) {
        this.vertex = vertex;
        this.value = value;
    }

}

public class BOJ_13549 {

    static int n, k;
    static boolean[] visited = new boolean[100001];
    static int[] distance = new int[100001];
    static ArrayList<Node2>[] graph = new ArrayList[100001];
    static Queue<Node2> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= 100000; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Node2(1, 1));
        graph[1].add(new Node2(0, 1));
        graph[1].add(new Node2(2, 0));
        for(int i = 2; i < 100000; i++) {
            graph[i].add(new Node2(i - 1, 1));
            graph[i].add(new Node2(i + 1, 1));
            if(i <= 50000) {
                graph[i].add(new Node2(i * 2, 0));
            }
        }
        graph[100000].add(new Node2(99999, 1));

        q.add(new Node2(n, 0));
        while(!q.isEmpty()) {
            Node2 now = q.poll();
            visited[now.vertex] = true;
            for(Node2 next : graph[now.vertex]) {
                if(!visited[next.vertex] || distance[next.vertex] > distance[now.vertex] + next.value) {
                    distance[next.vertex] = distance[now.vertex] + next.value;
                    q.add(new Node2(next.vertex, distance[next.vertex]));
                    visited[next.vertex] = true;
                }
            }
        }

        System.out.println(distance[k]);

    }

}
