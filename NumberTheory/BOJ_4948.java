package NumberTheory;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_4948 {

    static int n;
    static int[] arr = new int[250000];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr[1] = 0;
        for(int i = 2; i < 250000; i++) {
            arr[i] = i;
        }

        for(int i = 2; i <= Math.sqrt(250000); i++) {
            if(arr[i] == 0) continue;
            for(int j = i * 2; j < 250000; j += i) {
                arr[j] = 0;
            }
        }

        while(true) {
            n = Integer.parseInt(br.readLine());
            if(n == 0) {
                break;
            }

            int count = 0;
            for(int i = n+1; i <= 2*n; i++) {
                if(arr[i] != 0) {
                    count++;
                }
            }

            System.out.println(count);
        }

    }

}
