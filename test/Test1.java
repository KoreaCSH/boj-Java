package test;

import java.io.*;
import java.util.*;
import java.lang.*;

class Standard implements Comparable<Standard> {
    char a;
    int order;
    int count;

    Standard(char a, int order, int count) {
        this.a = a;
        this.order = order;
        this.count = count;
    }

    public int compareTo(Standard standard) {
        if(count == standard.count) {
            return standard.order - order;
        }
        else {
            return standard.count - count;
        }
    }

}

public class Test1 {

    static PriorityQueue<Standard> pq = new PriorityQueue<>();
    static int[] arr = new int[26];
    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String tmp = br.readLine();
            String[] tmp2 = tmp.split(" ");
            if(tmp2.length == 2) {
                char alpha = tmp2[1].charAt(0);
                arr[alpha - 'A']++;
                pq.add(new Standard(alpha, i, arr[alpha - 'A']));
            }
            else {
                if(pq.isEmpty()) {
                    System.out.print("* ");
                }
                else {
                    char ans = pq.poll().a;
                    arr[ans - 'A']--;
                    System.out.print(ans + " ");
                }
            }
        }

    }

}
