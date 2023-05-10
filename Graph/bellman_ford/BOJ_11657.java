package Graph.bellman_ford;

import java.io.*;
import java.lang.*;
import java.util.*;

class Edge {

    int start;
    int end;
    int weight;

    Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

}

public class BOJ_11657 {

    // 벨만 포드
    // 1. distance[] 배열
    // 2. 에지리스트
    // 3. visited 여부 필요없이 모든 에지를 v-1 번 확인하며 distance 업데이트
    // 4. v 번 째에 distance 변화 있으면 음수 사이클 존재하는 것
    // 5. distance 배열은 시작 노드는 0, 나머지는 무한대로 채워야 한다.
    // 6. relax 할 때 distance[start] 가 무한대면 안 된다.

    static int n, m;
    static long[] distance;
    static Edge[] edge;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        distance = new long[n+1];
        edge = new Edge[m];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edge[i] = new Edge(s, e, w);
        }

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[1] = 0;

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < m; j++) {
                Edge now = edge[j];
                if(distance[now.start] != Integer.MAX_VALUE &&
                    distance[now.end] > distance[now.start] + now.weight) {
                    distance[now.end] = distance[now.start] + now.weight;
                }
            }
        }

        boolean isCycle = false;
        for(int i = 0; i < m; i++) {
            Edge now = edge[i];
            if(distance[now.start] != Integer.MAX_VALUE &&
                    distance[now.end] > distance[now.start] + now.weight) {
                isCycle = true;
            }
        }

        if(!isCycle) {
            for(int i = 2; i < n+1; i++) {
                if(distance[i] == Integer.MAX_VALUE) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(distance[i]);
                }
            }
        } else {
            System.out.println(-1);
        }

    }

}
