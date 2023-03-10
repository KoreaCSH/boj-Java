package Prefixsum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_16139 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String str = st.nextToken();

        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());

        int[][] sum = new int[str.length() + 1][26];

        for(int i = 1; i < str.length() + 1; i++) {
            char ch = str.charAt(i-1);
            for(int j = 0; j < 26; j++) {
                int before = sum[i - 1][j];
                if(j == ch - 'a') {
                    sum[i][j] = before + 1;
                } else {
                    sum[i][j] = before;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(sum[end + 1][ch - 'a'] - sum[start][ch - 'a']).append("\n");
        }
        System.out.println(sb);
    }

}
