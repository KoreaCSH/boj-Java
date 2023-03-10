package SegmentTree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 세그먼트 트리 문제
public class BOJ_2042 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long[] arr = new long[n];
        long[] sum = new long[n];

        for(int i = 0; i < n; i++) {
            long num = Integer.parseInt(br.readLine());
            arr[i] = num;

            if(i == 0) {
                sum[i] = arr[i];
            }
            else {
                sum[i] = sum[i - 1] + arr[i];
            }
        }

        for(int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());

            if( a == 1 ) {
                arr[b-1] = c;
            }
            else {

            }
        }

    }

}
