package Graph.dijkstra;

import java.io.*;
import java.util.*;
import java.lang.*;

class Vertex implements Comparable<Vertex> {

    int v;
    int w;

    Vertex(int v, int w) {
        this.v = v;
        this.w = w;
    }

    public int compareTo(Vertex v) {
        return this.w - v.w;
    }

}

public class BOJ_9370 {

    static int T, n, m, t, s, g, h;
    static int[] distance;
    static ArrayList<Vertex>[] graph;
    static PriorityQueue<Vertex> pq;
    static PriorityQueue<Integer> answer;
    static ArrayList<Integer> dst;
    final static int MAX = 50000001;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for(int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n+1];
            for(int j = 1; j < n+1; j++) {
                graph[j] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            for(int j = 0; j < m; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                graph[a].add(new Vertex(b, w));
                graph[b].add(new Vertex(a, w));
            }

            dst = new ArrayList<>();
            for(int j = 0; j < t; j++) {
                st = new StringTokenizer(br.readLine());
                dst.add(Integer.parseInt(st.nextToken()));
            }

            answer = new PriorityQueue<>();

            for(int j = 0; j < dst.size(); j++) {

                int tmp = dst.get(j);
                int res2 = dijkstra(s, h) + dijkstra(h, g) + dijkstra(g, tmp);
                int res1 = dijkstra(s, g) + dijkstra(g, h) + dijkstra(h, tmp);
                int res3 = dijkstra(s, tmp);

                if(Math.min(res1, res2) == res3) {
                    answer.add(tmp);
                }
            }

            while(!answer.isEmpty()) {
                System.out.print(answer.poll() + " ");
            }

            System.out.println();

        }

    }

    static int dijkstra(int start, int end) {
        distance = new int[n+1];
        Arrays.fill(distance, MAX);
        distance[start] = 0;

        pq = new PriorityQueue<>();
        pq.add(new Vertex(start, 0));

        while(!pq.isEmpty()) {
            Vertex now = pq.poll();
            for(Vertex next : graph[now.v]) {
                if(distance[next.v] > distance[now.v] + next.w) {
                    distance[next.v] = distance[now.v] + next.w;
                    pq.add(new Vertex(next.v, distance[next.v]));
                }
            }
        }

        return distance[end];
    }

}
