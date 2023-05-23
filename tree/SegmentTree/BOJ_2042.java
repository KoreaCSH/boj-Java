package tree.SegmentTree;

import java.io.*;
import java.util.*;
import java.lang.*;

// 세그먼트 트리 문제
public class BOJ_2042 {

    static int n, m, k;
    static long[] tree;
    static int treeSize;
    static int treeHeight;
    static int leftNodeStartIndex;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int tmp = n;
        while(tmp != 0) {
            tmp /= 2;
            treeHeight++;
        }

        treeSize = (int) Math.pow(2, treeHeight + 1);
        leftNodeStartIndex = treeSize/2 - 1;

        tree = new long[treeSize];

        for(int i = leftNodeStartIndex + 1; i <= leftNodeStartIndex + n; i++) {
            st = new StringTokenizer(br.readLine());
            tree[i] = Long.parseLong(st.nextToken());
        }

        setTree(treeSize - 1);

        for(int i = 0; i < m+k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a == 1) {
                // 리프노드가 기존 배열의 요소들!
                changeVal(b + leftNodeStartIndex, c);
            }
            else if(a == 2) {
                b += leftNodeStartIndex;
                c += leftNodeStartIndex;
                System.out.println(getSum(b, (int)c));
            }
            else {
                return;
            }
        }

    }

    static long getSum(int s, int e) {
        long partSum = 0;
        while(s <= e) {
            if(s % 2 == 1) {
                partSum += tree[s];
                s++;
            }
            if(e % 2 == 0) {
                partSum += tree[e];
                e--;
            }

            s /= 2;
            e /= 2;

        }
        return partSum;
    }

    static void changeVal(int index, long val) {
        long diff = val - tree[index];
        while(index > 0) {
            tree[index] += diff;
            index /= 2;
        }
    }

    static void setTree(int i) {
        while(i != 1) {
            tree[i / 2] += tree[i];
            i--;
        }
    }

}
