package DFS;

import java.util.*;
import java.io.*;

public class BOJ_2468 {

    static int n;
    static int[][] map;
    static boolean visited[][];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new boolean[n][n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = -1;

        for(int k = 1; k <= 100; k++) {
            int count = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(!visited[i][j] && map[i][j] >= k) {
                        dfs(i, j, k);
                        count++;
                    }
                }
            }
            max = (max < count) ? count : max;
            visited = new boolean[n][n];
        }

        System.out.println(max);

    }

    static void dfs(int x, int y, int k) {
        visited[x][y] = true;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < n && ny < n && map[nx][ny] >= k && !visited[nx][ny]) {
                dfs(nx, ny, k);
            }
        }
    }

}
