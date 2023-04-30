package Graph.unionfind;

import java.util.*;
import java.io.*;
import java.lang.*;

public class BOJ_1043 {

    static int[] parent;
    static int[][] arr;
    static int truth;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i = 1; i < n+1; i++) {
            parent[i] = i;
        }
        arr = new int[m][];

        st = new StringTokenizer(br.readLine());
        int tn = Integer.parseInt(st.nextToken());
        if(tn != 0) {
            truth = Integer.parseInt(st.nextToken());
            parent[truth] = truth;
        }
        for(int i = 1; i < tn; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            parent[tmp] = truth;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int pn = Integer.parseInt(st.nextToken());
            arr[i] = new int[pn];
            for(int j = 0; j < pn; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }

            for(int j = 1; j < pn; j++) {
                union(arr[i][j - 1], arr[i][j]);
            }
        }

        int count = 0;
        for(int i = 0; i < m; i++) {
            int flag = 0;
            for(int j : arr[i]) {
                if(find(j) == truth) {
                    flag = 1;
                    break;
                }
            }
            if(flag == 0) {
                count++;
            }
        }

        System.out.println(count);

    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if(a != b) {
            if(a == truth) {
                parent[a] = b;
            }
            else if(b == truth) {
                parent[b] = a;
            }
            else {
                parent[b] = a;
            }
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
