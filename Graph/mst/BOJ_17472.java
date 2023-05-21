package Graph.mst;

import java.io.*;
import java.util.*;
import java.lang.*;

class Point2 {

    int x;
    int y;

    Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }

}

class Edge3 implements Comparable<Edge3> {

    int s;
    int e;
    int w;

    Edge3(int s, int e, int w) {
        this.s = s;
        this.e = e;
        this.w = w;
    }

    public int compareTo(Edge3 edge) {
        return this.w - edge.w;
    }

}

public class BOJ_17472 {

    static int n, m;
    static int sNum = 1;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[] parent;
    static ArrayList<Point2> sum;
    static ArrayList<ArrayList<Point2>> sumList = new ArrayList<>();
    static PriorityQueue<Edge3> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        // map 저장
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // dfs 로 섬 찾기
        // 섬은 (x, y)의 정보를 ArrayList 에 저장한다.
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0 || visited[i][j]) continue;
                bfs(i, j);
                sNum++;
                sumList.add(sum);
            }
        }

        // 모든 섬의 모든 지점에서 연결 가능한 간선 찾기
        // 상하좌우 중 한 군데로만 다리가 연결되어야 하고, 길이를 체크해야 한다.
        // 길이는 2이상 이어야 한다.
        for(int i = 0; i < sumList.size(); i++) {
            ArrayList<Point2> nowsum = sumList.get(i);
            for(Point2 now : nowsum) {
                int now_sNum = map[now.x][now.y];
                for(int j = 0; j < 4; j++) {
                    int nx = now.x + dx[j];
                    int ny = now.y + dy[j];
                    int blength = 0;
                    while(nx >= 0 && ny >= 0 && nx < n && ny < m) {
                        if(map[nx][ny] == now_sNum) {
                            break;
                        }
                        else if(map[nx][ny] != 0) {
                            if(blength > 1) {
                                pq.add(new Edge3(now_sNum, map[nx][ny], blength));
                            }
                            break;
                        }
                        else {
                            blength++;
                        }

                        if(dx[j] > 0) nx++;
                        else if(dx[j] < 0) nx--;
                        else if(dy[j] > 0) ny++;
                        else if(dy[j] < 0) ny--;
                    }
                }
            }
        }

        parent = new int[sumList.size() + 1];
        for(int i = 1; i < sumList.size() + 1; i++) {
            parent[i] = i;
        }

        int weight = 0;
        int count = 0;

        while(!pq.isEmpty()) {
            Edge3 now = pq.poll();
            if(find(now.s) != find(now.e)) {
                union(now.s, now.e);
                count++;
                weight += now.w;
            }
        }

        if(count == sumList.size() - 1) {
            System.out.println(weight);
        }
        else {
            System.out.println(-1);
        }

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
        } else {
            return parent[a] = find(parent[a]);
        }
    }

    static void bfs(int a, int b) {
        Queue<Point2> q = new LinkedList<>();
        sum = new ArrayList<>();
        q.add(new Point2(a, b));

        while(!q.isEmpty()) {
            Point2 now = q.poll();
            if(visited[now.x][now.y]) continue;
            visited[now.x][now.y] = true;
            map[now.x][now.y] = sNum;
            sum.add(now);
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && map[nx][ny] != 0) {
                    q.add(new Point2(nx, ny));
                }
            }
        }

    }

}
