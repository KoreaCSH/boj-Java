package NumberTheory;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_4134 {

    static int t;
    static long n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            n = Long.parseLong(br.readLine());
            if(n == 0) {
                System.out.println(2);
            }
            else if(n == 1) {
                System.out.println(2);
            }
            else {
                System.out.println(getPrime(n));
            }
        }


    }

    static long getPrime(long num) {

        long tmp = num;
        long prime = 0;

        while(true) {

            boolean isPrime = true;
            for(int i = 2; i <= Math.sqrt(tmp); i++) {
                if(tmp % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) {
                prime = tmp;
                break;
            }

            else {
                tmp++;
            }

        }

        return prime;
    }

}
