package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_13023 {

    static List<Integer>[] list;
    static boolean visited[];
    static boolean flag;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        list = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
            list[e].add(s);
        }

        int count = 1;

        for(int i = 0; i < n; i++) {
            dfs(i, count);
            if(flag) {
                break;
            }
        }

        if(flag) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }

    }

    static void dfs(int num, int count) {
        if(count == 5 || flag) {
            flag = true;
            return;
        }
        visited[num] = true;
        for(int i : list[num]) {
            if(!visited[i]) {
                dfs(i, count + 1);
            }
        }
        visited[num] = false;
    }

}
