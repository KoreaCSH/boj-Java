package Backtracking;

import java.util.*;
import java.io.*;

public class BOJ_15666 {

    static int n, m;
    static int[] arr, tmp;
    static LinkedHashSet<String> ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        tmp = new int[m];
        ans = new LinkedHashSet<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        backtracking(0);
        ans.forEach(System.out::println);
    }

    static void backtracking(int depth) {

        if(depth == m) {
            StringBuilder sb = new StringBuilder();
            for(int v : tmp) {
                sb.append(v).append(" ");
            }
            ans.add(sb.toString());
            return;
        }

        for(int i = 0; i < n; i++) {
            if(depth == 0) {
                tmp[depth] = arr[i];
                backtracking(depth+1);
            }
            else if(tmp[depth-1] <= arr[i]) {
                tmp[depth] = arr[i];
                backtracking(depth+1);
            }

        }

    }

}
