package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_4963 {

    static int w;
    static int h;
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");

        }

        System.out.println(sb);

    }

    static void dfs(int x, int y) {
        map[x][y] = 0;
        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < h && ny < w && map[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }

}
