package BFS;

import java.io.*;
import java.util.*;

public class BOJ_1167 {

    static ArrayList<Node>[] list;
    static boolean visited[];
    static int distance[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        list = new ArrayList[v + 1];
        for(int i = 1; i < v+1; i++) {
            list[i] = new ArrayList<Node>();
        }
        visited = new boolean[v + 1];
        distance = new int[v + 1];

        for(int i = 1; i < v + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while(true) {
                int e = Integer.parseInt(st.nextToken());
                if(e == -1) {
                    break;
                }
                int w = Integer.parseInt(st.nextToken());
                list[s].add(new Node(e, w));
            }
        }

        bfs(1);
        int max = 0;
        int index = 0;
        for(int i = 1; i < v+1; i++) {
            if(max < distance[i]) {
                max = distance[i];
                index = i;
            }
        }

        visited = new boolean[v + 1];
        distance = new int[v + 1];
        bfs(index);
        max = 0;
        for(int i = 1; i < v+1; i++) {
            if(max < distance[i]) {
                max = distance[i];;
            }
        }
        System.out.println(max);
    }

    static void bfs(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;
        distance[v] = 0;
        while(!q.isEmpty()) {
            int now = q.poll();
            for(Node node : list[now]) {
                if(!visited[node.num]) {
                    q.offer(node.num);
                    visited[node.num] = true;
                    distance[node.num] = distance[now] + node.weight;
                }
            }
        }
    }

}

class Node {

    public int num;
    public int weight;

    Node(int num, int weight) {
        this.num = num;
        this.weight = weight;
    }

}
