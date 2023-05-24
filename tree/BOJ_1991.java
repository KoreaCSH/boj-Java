package tree;

import java.io.*;
import java.lang.*;
import java.util.*;

class Node {

    char v;
    Node left;
    Node right;

    Node(char v, Node left, Node right) {
        this.v = v;
        this.left = left;
        this.right = right;
    }

}

public class BOJ_1991 {

    static int n;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(st.nextToken());

        Node tree = new Node('A', null, null);

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char s = st.nextToken().charAt(0);
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);

            Node now = search(s, tree);
            if(l != '.') {
                now.left = new Node(l, null, null);
            }
            if(r != '.') {
                now.right = new Node(r, null, null);
            }
        }

        preOrder(tree);
        sb.append('\n');
        inOrder(tree);
        sb.append('\n');
        postOrder(tree);
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();

    }

    static void preOrder(Node node) {
        if(node == null) {
            return;
        }
        sb.append(node.v);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(Node node) {
        if(node == null) {
            return;
        }
        inOrder(node.left);
        sb.append(node.v);
        inOrder(node.right);
    }

    static void postOrder(Node node) {
        if(node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.v);
    }

    static Node search(char v, Node node) {
        if(node != null) {
            if(node.v == v) {
                return node;
            }
            else {
                Node left = search(v, node.left);
                if(left != null) {
                    return left;
                }
                return search(v, node.right);
            }
        }
        return null;
    }

}
