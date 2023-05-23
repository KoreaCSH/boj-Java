package tree;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_11725 {

    static int n;
    static boolean[] visited;
    static int[] parent;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        graph = new ArrayList[n+1];
        parent = new int[n+1];
        for(int i = 1; i < n+1; i++) {
            parent[i] = i;
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        dfs(1);

        for(int i = 2; i < n+1; i++) {
            System.out.println(parent[i]);
        }

    }

    static void dfs(int v) {
        if(visited[v]) {
            return;
        }

        visited[v] = true;
        for(int next : graph[v]) {
            if(!visited[next]) {
                parent[next] = v;
                dfs(next);
            }
        }

    }

}
