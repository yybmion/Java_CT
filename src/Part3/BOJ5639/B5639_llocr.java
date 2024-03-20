package Part3.BOJ5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5639_llocr {
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        void insert(int n) {
            if(n < this.value) {
                if(this.left == null) {
                    this.left = new Node(n);
                } else {
                    this.left.insert(n);
                }
            } else {
                if(this.right == null) {
                    this.right = new Node(n);
                } else {
                    this.right.insert(n);
                }
            }
        }
    }
    private static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.value).append("\n");
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));

        while(true) {
            String num = br.readLine();
            if(num == null || num.equals("")) break;
            root.insert(Integer.parseInt(num));
        }

        postOrder(root);
        System.out.println(sb.toString());
    }
}
