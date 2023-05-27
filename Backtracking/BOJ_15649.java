package Backtracking;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_15649 {

    static int n, m;
    static int[] arr;
    static boolean visited[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        arr = new int[m];

        dfs(0);

    }

    static void dfs(int depth) {

        if(depth == m) {
            for(int i : arr) {
                System.out.print(i + " ");
            }
            System.out.println();

            return;
        }

        for(int i = 0; i < n; i++) {

            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i + 1;
                dfs(depth+1);
                visited[i] = false;
            }

        }

    }

}
