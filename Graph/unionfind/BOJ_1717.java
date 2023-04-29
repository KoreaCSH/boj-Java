package Graph.unionfind;

import java.util.*;
import java.io.*;
import java.lang.*;

public class BOJ_1717 {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(t == 0) {
                union(a, b);
            }

            else if(t == 1) {
                System.out.println(check(a, b));
            }
        }

    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[b] = a;
        }
    }

    static int find(int n) {
        if(n == parent[n]) {
            return n;
        }
        else {
            return parent[n] = find(parent[n]);
        }
    }

    static String check(int a, int b) {
        a = find(a);
        b = find(b);

        if(a == b) {
            return "YES";
        }
        else {
            return "NO";
        }
    }

}
