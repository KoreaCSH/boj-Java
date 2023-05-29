package DFS;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_1260 {

    static int n, m, v;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder ans1 = new StringBuilder();
    static StringBuilder ans2 = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }

        visited = new boolean[n+1];
        dfs(v);
        visited = new boolean[n+1];
        bfs(v);

        System.out.println(ans1.toString());
        System.out.println(ans2.toString());

    }

    static void dfs(int vertex) {

        if(visited[vertex]) {
            return;
        }

        ans1.append(vertex).append(" ");
        visited[vertex] = true;

        Collections.sort(graph[vertex]);
        for(int next : graph[vertex]) {
            if(!visited[next]) {
                dfs(next);
            }
        }

    }

    static void bfs(int vertex) {
        Queue<Integer> q = new LinkedList<>();
        q.add(vertex);
        while (!q.isEmpty()) {
            int now = q.poll();
            if(visited[now]) continue;
            ans2.append(now).append(" ");
            visited[now] = true;
            Collections.sort(graph[now]);
            for(int next : graph[now]) {
                if(!visited[next]) {
                    q.add(next);
                }
            }
        }
    }

}
