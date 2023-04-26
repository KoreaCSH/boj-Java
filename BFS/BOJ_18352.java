package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.util.*;

public class BOJ_18352 {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] distance;
    static int n, m, k, x;

    public static void main(String[] args) throws IOException  {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        graph = new ArrayList[n+1];
        distance = new int[n+1];
        for(int i = 1; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
        }

        bfs(x);
        int count = 0;

        for(int i = 1; i < n+1; i++) {
            if(distance[i] == k) {
                System.out.println(i);
                count++;
            }
        }

        if(count == 0) {
            System.out.println(-1);
        }

    }

    static void bfs(int v) {
        visited[v] = true;
        Queue<Integer> q = new LinkedList<>();
        distance[v] = 0;
        q.offer(v);
        while(!q.isEmpty()) {
            int next = q.poll();
            for(int node : graph[next]) {
                if(!visited[node]) {
                    q.offer(node);
                    visited[node] = true;
                    distance[node] = distance[next] + 1;
                }
            }
        }
    }

}
