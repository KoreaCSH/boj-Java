package NumberTheory;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_1929 {

    static int n, m;
    static int arr[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m+1];
        for(int i = 2; i <= m; i++) {
            arr[i] = i;
        }

        for(int i = 2; i <= m; i++) {
            if(arr[i] == 0) continue;

            for(int j = 2*i; j <= m; j += i) {
                arr[j] = 0;
            }
        }

        for(int i = n; i <= m; i++) {
            if(arr[i] != 0) {
                System.out.println(arr[i]);
            }
        }

    }

}
