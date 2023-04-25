package Implementation;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_2420 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());

        System.out.println(Math.abs(n - m));

    }

}
