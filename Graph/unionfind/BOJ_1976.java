package Graph.unionfind;

import java.io.*;
import java.lang.*;
import java.util.*;

public class BOJ_1976 {

    static int[] parent;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for(int i = 1; i < n+1; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 1; i < n+1; i++) {
            arr = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < n+1; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
                if(arr[j] == 1) {
                    union(i, j);
                }
            }
        }

        arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int check = find(arr[0]);
        for(int i = 1; i < m; i++) {
            if(find(arr[i]) != check) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");

    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            parent[b] = a;
        }
    }

    static int find(int a) {
        if(a == parent[a]) {
            return a;
        }
        else {
            return parent[a] = find(parent[a]);
        }
    }

}
