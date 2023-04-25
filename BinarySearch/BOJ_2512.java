package BinarySearch;

import java.util.*;
import java.io.*;
import java.lang.*;

public class BOJ_2512 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = arr[arr.length - 1];

        while(left <= right) {
            int mid = (left + right) / 2;

            int sum = 0;
            for(int i = 0; i < n; i++) {
                if (arr[i] < mid) {
                    sum += arr[i];
                } else {
                    sum += mid;
                }
            }
            if(sum > m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }

        }

        System.out.println(right);

    }

}
