package DFS;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1987 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] map;
    static boolean[] visited;
    static int n, m, max;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[26];

        for(int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = tmp.charAt(j);
            }
        }

        dfs(0, 0, 1);
        System.out.println(max);

    }

    static void dfs(int x, int y, int count) {
        visited[map[x][y] - 'A'] = true;
        max = (max < count) ? count : max;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[map[nx][ny] - 'A']) {
                dfs(nx, ny, count + 1);
            }
        }
        visited[map[x][y] - 'A'] = false;
    }

}
