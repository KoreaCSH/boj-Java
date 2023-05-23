package tree.SegmentTree;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_10868 {

    static int n, m;
    static long[] tree;
    static int treeSize;
    static int treeHeight;
    static int LeftStartIndex;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int tmp = n;
        while(tmp != 0) {
            tmp /= 2;
            treeHeight++;
        }

        treeSize = (int) Math.pow(2, treeHeight + 1);
        tree = new long[treeSize];
        Arrays.fill(tree, Integer.MAX_VALUE);

        LeftStartIndex = treeSize / 2 - 1;
        for(int i = 1 + LeftStartIndex; i <= n + LeftStartIndex; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        setTree(treeSize - 1);

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            System.out.println(getMin(s + LeftStartIndex, e + LeftStartIndex));
        }

    }

    static long getMin(int s, int e) {
        long min = Long.MAX_VALUE;
        while(s <= e) {
            if(s % 2 == 1) {
                min = Math.min(min, tree[s]);
                s++;
            }
            if(e % 2 == 0) {
                min = Math.min(min, tree[e]);
                e--;
            }
            s /= 2;
            e /= 2;
        }

        return min;
    }

    static void setTree(int i) {
        while(i != 1) {
            if(tree[i/2] > tree[i]) {
                tree[i / 2] = tree[i];
            }
            i--;
        }
    }

}
