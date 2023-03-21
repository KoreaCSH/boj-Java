package BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Rgb {
    int x;
    int y;
    char color;

    Rgb(int x, int y, char color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
}

public class BOJ_10026 {

    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Rgb> queue = new LinkedList<>();
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());

        char[][] arr = new char[n][];
        char[][] arr2 = new char[n][];
        visited = new boolean[n][];

        for(int i = 0; i < n; i++) {
            arr[i] = new char[n];
            arr2[i] = new char[n];
            visited[i] = new boolean[n];
        }

        for(int i = 0; i < n; i++) {
            String tmp = br.readLine();
            for(int j = 0; j < n; j++) {
                arr[i][j] = tmp.charAt(j);
            }
        }

        int count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    bfs(new Rgb(i, j, arr[i][j]), arr);
                    count++;
                }
            }
        }

        sb.append(count).append(" ");

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(arr[i][j] == 'R') {
                    arr2[i][j] = 'G';
                } else {
                    arr2[i][j] = arr[i][j];
                }
                visited[i][j] = false;
            }
        }

        count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j]) {
                    bfs(new Rgb(i, j, arr2[i][j]), arr2);
                    count++;
                }
            }
        }

        sb.append(count);

        System.out.println(sb);
    }

    static void bfs(Rgb rgb, char[][] arr) {
        queue.offer(rgb);
        visited[rgb.x][rgb.y] = true;
        while (!queue.isEmpty()) {
            Rgb now = queue.poll();
            for(int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < n && !visited[nx][ny] && arr[nx][ny] == now.color) {
                    queue.offer(new Rgb(nx, ny, arr[nx][ny]));
                    visited[nx][ny] = true;
                }
            }
        }
    }

}
