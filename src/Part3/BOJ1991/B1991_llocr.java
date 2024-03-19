package Part3.BOJ1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1991_llocr {
    public static class Node {
        char value;
        Node left;
        Node right;

        public Node(char value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    static Node[] tree;
    static StringBuilder sb = new StringBuilder();

    // 전위 순회
    public static void preorder(Node node) {
        if(node == null) return;
        sb.append(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위 순회
    public static void inorder(Node node) {
        if(node == null) return;
        inorder(node.left);
        sb.append(node.value);
        inorder(node.right);
    }

    // 후위 순회
    public static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        sb.append(node.value);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int N = Integer.parseInt(br.readLine());
        tree = new Node[N + 1];


        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if(tree[root - 'A'] == null) {
                tree[root - 'A'] = new Node(root);
            }

            if(left != '.') {
                tree[left - 'A'] = new Node(left);
                tree[root - 'A'].left = tree[left - 'A'];
            }

            if(right != '.') {
                tree[right - 'A'] = new Node(right);
                tree[root - 'A'].right = tree[right - 'A'];
            }
        }

        preorder(tree[0]);
        sb.append("\n");

        inorder(tree[0]);
        sb.append("\n");

        postorder(tree[0]);

        System.out.println(sb);
    }
}

/*
* 참고 : https://hoehen-flug.tistory.com/48
* 전위, 중위, 후위 순회를 구현하는 부분은 걱정이 되지 않았는데,
* 트리를 구현하는 것이 너무... 머리가 복잡했다
*
* 배열로도 구현하려고 했고, Node class를 만들어서 구현해보려고도 했는데
* 결국 두 개를 합쳐서 구현해야 했다..!!
* 그리고 배열에 값을 추가하는 부분에서 아스키 코드로 'A'를 빼 줄 생각을 전혀 못 했는데,,
* 이런 생각의 발전까지 이루어지지 않는 내가 미운,, 쩝
*
* 아직 나의 지식이 부족한 것에 한계를 많이 느낀다 :(
* 지속적으로 공부해 나가야겠다!
* */