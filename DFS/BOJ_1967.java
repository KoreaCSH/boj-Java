package DFS;

import java.util.*;
import java.io.*;

class Node {

    int n;
    int w;

    Node(int n, int w) {
        this.n = n;
        this.w = w;
    }

}

public class BOJ_1967 {

    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for(int i = 1; i < n+1; i++) {
            list[i] = new ArrayList<Node>();
        }
        visited = new boolean[n+1];

        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[s].add(new Node(e, w));
            list[e].add(new Node(s, w));
        }

        for(int i = 1; i < n+1; i++) {
            dfs(i, 0);
            visited = new boolean[n+1];
        }

        System.out.println(max);

    }

    static void dfs(int s, int distance) {
        if(visited[s]) {
            return;
        }
        visited[s] = true;
        for(Node n : list[s]) {
            if(!visited[n.n]) {
                if(max < distance + n.w) {
                    max = distance + n.w;
                }
                dfs(n.n, distance + n.w);
            }
        }
    }

}
