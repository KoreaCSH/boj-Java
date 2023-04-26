package BinarySearch;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_6236 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long max = 0;
        long sum = 0;
        long ans = 0;
        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            if(max < arr[i]) {
                max = arr[i];
            }
        }

        long left = max;
        long right = sum;
        while(left <= right) {
            long mid = (left + right) / 2;
            long balance = mid;
            int count = 1;
            for(int i = 0; i < n; i++) {
                if(balance - arr[i] < 0) {
                    count++;
                    balance = mid;
                }
                balance -= arr[i];
            }
            if(count > m) {
                left = mid + 1;
            }
            else {
                // 정확히 M번을 맞추기 위해서 남은 금액이 그날 사용할 금액보다 많더라도
                // 남은 금액은 통장에 집어넣고 다시 K원을 인출할 수 있다.
                ans = mid;
                right = mid - 1;
            }
        }

        System.out.println(ans);

    }

}
