package tree.SegmentTree;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_11505 {

    static long[] tree;
    static int n, m, k;
    static int treeHeight, treeSize, LeftStartIndex;
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
        tree = new long[treeSize];
        Arrays.fill(tree, 1);

        LeftStartIndex = treeSize / 2 - 1;
        for(int i = 1 + LeftStartIndex; i <= n + LeftStartIndex; i++) {
            tree[i] = Long.parseLong(br.readLine());
        }

        setTree(treeSize - 1);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(a == 1) {
                changeVal(b + LeftStartIndex, c);
            }
            else if(a == 2) {
                sb.append(getMul(b + LeftStartIndex, (int) c + LeftStartIndex)).append('\n');
            }
            else {
                return;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static long getMul(int s, int e) {
        long partMul = 1;
        while(s <= e) {
            if(s % 2 == 1) {
                partMul = partMul * tree[s] % MOD;
                s++;
            }
            if(e % 2 == 0) {
                partMul = partMul * tree[e] % MOD;
                e--;
            }
            s /= 2;
            e /= 2;
        }
        return partMul % MOD;
    }

    static void changeVal(int index, long val) {
        tree[index] = val;
        while(index > 0) {
            index /= 2;
            tree[index] = ((tree[index * 2] % MOD) * (tree[index * 2 + 1] % MOD)) % MOD;
        }
    }

    static void setTree(int i) {
        while(i != 1) {
            tree[i/2] = tree[i/2] * tree[i] % MOD;
            if(i % 2 == 0) {
                tree[i/2] = tree[i/2] % MOD;
            }
            i--;
        }
    }

}
