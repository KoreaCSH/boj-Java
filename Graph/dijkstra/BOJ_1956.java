package Graph.dijkstra;

import java.util.*;
import java.io.*;
import java.lang.*;

class City implements Comparable<City> {

    int v;
    int w;

    City(int v, int w) {
        this.v = v;
        this.w = w;
    }

    public int compareTo(City city) {
        return this.w - city.w;
    }

}

public class BOJ_1956 {

    static int n, m;
    static PriorityQueue<Integer>[] distance;
    static int[] ans;
    static int min = Integer.MAX_VALUE;
    static ArrayList<City>[] graph;
    static PriorityQueue<City> pq;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ans = new int[n+1];

        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[s].add(new City(e, w));
        }

        for(int i = 1; i <= n; i++) {
            dijkstra(i);
        }

        for(int i = 1; i <= n ; i++) {
            if(ans[i] == 0) {
                continue;
            }
            if(ans[i] < min) {
                min = ans[i];
            }

        }


        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
        }

    }

    static void dijkstra(int start) {
        distance = new PriorityQueue[n+1];
        for(int i = 1; i < n+1; i++) {
            distance[i] = new PriorityQueue<>(2, new Comparator<Integer> () {
                public int compare(Integer i1, Integer i2) {
                    return i2 - i1;
                }
            });
        }

        pq = new PriorityQueue<>();
        pq.add(new City(start, 0));
        distance[start].add(0);

        while(!pq.isEmpty()) {
            City now = pq.poll();

            for(City next : graph[now.v]) {
                if(distance[next.v].size() < 2) {
                    distance[next.v].add(next.w + now.w);
                    pq.add(new City(next.v, next.w + now.w));
                }
                else if(distance[next.v].size() == 2 && distance[next.v].peek() > next.w + now.w) {
                    distance[next.v].poll();
                    distance[next.v].add(next.w + now.w);
                    pq.add(new City(next.v, next.w + now.w));
                }
            }
        }

        ans[start] = distance[start].poll();

    }

}
