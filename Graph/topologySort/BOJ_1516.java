package Graph.topologySort;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_1516 {

    static int n;
    static ArrayList<Integer>[] graph;
    static int[] indegree;
    static int[] time;
    static int[] ans;
    static Queue<Integer> q;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n+1];
        for(int i = 1; i < n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        indegree = new int[n+1];
        time = new int[n+1];
        ans = new int[n+1];

        for(int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            int buildTime = Integer.parseInt(st.nextToken());
            time[i] = buildTime;

            while(true) {
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp == -1) {
                    break;
                }
                graph[tmp].add(i);
                indegree[i]++;
            }

        }

        q = new LinkedList<>();
        for(int i = 1; i < n+1; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        while(!q.isEmpty()) {
            int now = q.poll();
            for(int next : graph[now]) {
                indegree[next]--;
                ans[next] = Math.max(ans[next], ans[now] + time[now]);
                if(indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        for(int i = 1; i < n+1; i++) {
            System.out.println(ans[i] + time[i]);
        }

    }

}
