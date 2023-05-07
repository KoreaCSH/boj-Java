package Graph.topologySort;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_2252 {

    static ArrayList<Integer>[] graph;
    static int[] indegree;
    static Queue<Integer> q;
    static StringBuilder ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        for(int i = 1; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }
        indegree = new int[n + 1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            indegree[e]++;
        }

        q = new LinkedList();
        ans = new StringBuilder();

        for(int i = 1; i < n+1; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int now = q.poll();
            ans.append(now).append(' ');
            for(int next : graph[now]) {
                indegree[next]--;
                if(indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        System.out.println(ans.toString());

    }

}
