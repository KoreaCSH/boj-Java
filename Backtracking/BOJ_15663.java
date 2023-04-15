package Backtracking;

import java.util.*;
import java.io.*;

public class BOJ_15663 {

    static int n, m;
    static int[] arr, tmp;
    static boolean[] visited;
    static LinkedHashSet<String> ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        tmp = new int[m];
        visited = new boolean[n];
        ans = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        backtracking(0);
        ans.forEach(System.out::println);

    }

    static void backtracking(int depth) {
        // 1. 재귀 탈출 조건
        if(depth == m) {
            StringBuilder sb = new StringBuilder();
            for(int v : tmp) {
                sb.append(v).append(" ");
            }
            ans.add(sb.toString());
            return;
        }

        // arr 의 모든 요소가 ans 의 첫 번째 원소로 들어갈 수 있도록 for 문 작성
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                tmp[depth] = arr[i];
                backtracking(depth + 1);
                visited[i] = false;
            }

        }

    }

}
