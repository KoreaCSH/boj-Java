package Implementation;

import java.util.*;
import java.io.*;

public class BOJ_9085 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());

        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int sum = 0;

            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                sum += tmp;
            }

            System.out.println(sum);
        }

    }

}
