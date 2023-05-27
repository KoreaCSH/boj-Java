package Backtracking;

import java.io.*;
import java.util.*;
import java.lang.*;

class Node {

    int r;
    int c;

    Node(int r, int c) {
        this.r = r;
        this.c = c;
    }

}

public class BOJ_15686 {

    static int n, m;
    static int[][] map;
    static boolean[] visited;
    static ArrayList<Node> chicken = new ArrayList<>();
    static ArrayList<Node> house = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
                if(map[i][j] == 1) {
                    house.add(new Node(i, j));
                }
            }
        }

        visited = new boolean[chicken.size()];

        for(int i = 0; i < chicken.size(); i++) {
            visited[i] = true;
            dfs(i, 1);
            visited[i] = false;
        }

        System.out.println(min);

    }

    static void dfs(int index, int depth) {

        if(depth == m) {

            int sum = 0;

            for(Node now : house) {
                int distance = Integer.MAX_VALUE;
                for(int i = 0; i < visited.length; i++) {
                    if(visited[i]) {
                        int diff = Math.abs(now.r - chicken.get(i).r) + Math.abs(now.c - chicken.get(i).c);
                        distance = Math.min(distance, diff);
                    }
                }

                sum += distance;
            }

            min = Math.min(min, sum);
            return;
        }

        for(int i = index; i < chicken.size(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i+1, depth+1);
                visited[i] = false;
            }
        }

    }

}
