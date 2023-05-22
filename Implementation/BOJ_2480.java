package Implementation;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_2480 {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        arr = new int[7];

        for(int i = 0; i < 3; i++) {
            arr[Integer.parseInt(st.nextToken())]++;
        }

        int max = 0;
        int index = 0;
        for(int i = 1; i <= 6; i++) {
            if(max <= arr[i]) {
                max = arr[i];
                index = i;
            }
        }

        if(max == 1) {
            System.out.println(100 * index);
        }
        else if(max == 2) {
            System.out.println(1000 + index * 100);
        }
        else {
            System.out.println(10000 + index * 1000);
        }

    }

}
