package tree;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_1068 {

    static int n;
    static int loot;
    static int deleteNode;
    static int ans;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp == -1) {
                loot = i;
            }
            else {
                graph[i].add(tmp);
                graph[tmp].add(i);
            }
        }

        st = new StringTokenizer(br.readLine());
        deleteNode = Integer.parseInt(st.nextToken());

        dfs(loot);

        if(deleteNode == loot) {
            System.out.println(0);
        } else {
            System.out.println(ans);
        }

    }

    static void dfs(int v) {
        visited[v] = true;
        int leaf = 0;

        for(int next : graph[v]) {
            if(!visited[next] && next != deleteNode) {
                leaf++;
                dfs(next);
            }
        }

        if(leaf == 0) {
            ans++;
        }

    }

}
