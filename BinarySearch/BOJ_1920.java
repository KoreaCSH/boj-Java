package BinarySearch;

import java.util.*;
import java.io.*;

public class BOJ_1920 {

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

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            boolean find = false;
            int start = 0;
            int end = arr.length - 1;

            while(start <= end) {
                int mid = (start + end) / 2;
                if(arr[mid] < target) {
                    start = mid + 1;
                }
                else if(arr[mid] > target) {
                    end = mid - 1;
                }
                else {
                    find = true;
                    break;
                }
            }

            if(find) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }

        }

    }

}
