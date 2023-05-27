package Backtracking;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_14889 {

    static int n;
    static int[][] map;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        map = new int[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);

    }

    static void dfs(int index, int depth) {

        if(depth == n / 2) {

            int start = 0;
            int link = 0;

            for(int i = 0; i < n-1; i++) {
                for(int j = i+1; j < n; j++) {

                    if(visited[i] && visited[j]) {
                        start += map[i][j];
                        start += map[j][i];
                    }

                    else if(!visited[i] && !visited[j]) {
                        link += map[i][j];
                        link += map[j][i];
                    }

                }
            }

            int diff = Math.abs(start - link);
            min = Math.min(diff, min);

            return;
        }

        for(int i = index; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i+1, depth+1);
                visited[i] = false;
            }
        }

    }

}
