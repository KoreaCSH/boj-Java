package DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2023 {

    static int n;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for(int i = 2 ; i < 10; i++) {
            dfs(i, 1);
        }

        System.out.println(sb);

    }

    static boolean isPrime(int num) {
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void dfs(int num, int count) {
        if(isPrime(num)) {
            if(count >= n) {
                sb.append(num).append("\n");
                return;
            }
            for(int i = 0; i < 10; i++) {
                dfs(num * 10 + i, count + 1);
            }
        }
    }

}
