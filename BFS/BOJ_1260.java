package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1260 {

    static ArrayList<Integer>[] list;
    static boolean visited[];
    static StringBuilder sb;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for(int i = 1; i < n+1; i++) {
            list[i] = new ArrayList<>();
        }

        visited = new boolean[n + 1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
            list[e].add(s);
        }

        sb = new StringBuilder();
        dfs(v);
        System.out.println(sb);

        sb = new StringBuilder();
        visited = new boolean[n + 1];
        bfs(v);
        System.out.println(sb);
    }

    static void dfs(int v) {
        if(visited[v]) {
            return;
        }
        visited[v] = true;
        sb.append(v).append(" ");
        Collections.sort(list[v]);
        for(int i : list[v]) {
            if(!visited[i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int v) {
        q.offer(v);
        visited[v] = true;
        while(!q.isEmpty()) {
            int m = q.poll();
            sb.append(m).append(" ");
            Collections.sort(list[m]);
            for(int i : list[m]) {
                if(!visited[i]) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

}
