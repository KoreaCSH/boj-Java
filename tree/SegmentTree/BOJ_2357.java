package tree.SegmentTree;

import java.io.*;
import java.util.*;
import java.lang.*;

public class BOJ_2357 {

    static int n;
    static int m;
    static int treeSize;
    static int treeHeight;
    static int LeftStartIndex;
    static int[] minTree;
    static int[] maxTree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int tmp = n;
        while(tmp != 0) {
            tmp /= 2;
            treeHeight++;
        }

        treeSize = (int) Math.pow(2, treeHeight + 1);
        LeftStartIndex = treeSize / 2 - 1;

        minTree = new int[treeSize];
        Arrays.fill(minTree, Integer.MAX_VALUE);

        maxTree = new int[treeSize];
        Arrays.fill(maxTree, 0);

        for(int i = 1 + LeftStartIndex; i <= n + LeftStartIndex; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            minTree[i] = num;
            maxTree[i] = num;
        }

        setMinTree(treeSize - 1);
        setMaxTree(treeSize - 1);

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(getMin(s + LeftStartIndex, e + LeftStartIndex))
                    .append(" ")
                    .append(getMax(s + LeftStartIndex, e + LeftStartIndex)).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void setMinTree(int i) {

        while(i != 1) {
            minTree[i / 2] = Math.min(minTree[i / 2], minTree[i]);
            i--;
        }

    }

    static void setMaxTree(int i) {

        while(i != 1) {
            maxTree[i / 2] = Math.max(maxTree[i / 2], maxTree[i]);
            i--;
        }

    }

    static int getMin(int s, int e) {
        int partMin = Integer.MAX_VALUE;
        while(s <= e) {
            if(s % 2 == 1) {
                partMin = Math.min(partMin, minTree[s]);
                s++;
            }

            if(e % 2 == 0) {
                partMin = Math.min(partMin, minTree[e]);
                e--;
            }

            s /= 2;
            e /= 2;

        }

        return partMin;
    }

    static int getMax(int s, int e) {
        int partMax = 0;
        while(s <= e) {
            if(s % 2 == 1) {
                partMax = Math.max(partMax, maxTree[s]);
                s++;
            }

            if(e % 2 == 0) {
                partMax = Math.max(partMax, maxTree[e]);
                e--;
            }

            s /= 2;
            e /= 2;

        }

        return partMax;
    }

}
