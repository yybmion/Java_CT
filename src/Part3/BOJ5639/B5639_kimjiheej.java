import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5639_kimjiheej {
    static class Node {
        int num;
        Node left, right;

        Node(int num) {
            this.num = num;
        }

        Node(int num, Node left, Node right) {
            this.num = num;
            this.left = left;
            this.right = right;
        }

        void insert(int n) { // 이 부분이 가장 중요하다
            if (n < this.num) {
                if (this.left == null)
                    this.left = new Node(n);
                else this.left.insert(n);
            } else {
                if (this.right == null)
                    this.right = new Node(n);
                else this.right.insert(n);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));
        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.equals(""))
                break;
            root.insert(Integer.parseInt(input));
        }

        postOrder(root);
    }

    static void postOrder(Node node) { // 후위 순회
        if (node == null) // 여기도 잘 기억하자
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.num);
    }
}
/*
  이 문제는 로직은 정확하게 잘 생각해 내었다. 일단 전위 순회의 결과를 insert 해주면서 다시
  bst 를 만들어 주면 된다. 그치만 구현 하는 것을 잘 못해서 블로그를 참고하면서 했다.
  bst 를 만드는 것을 잘 익혀두자 !!

  출처 : https://girawhale.tistory.com/59


 */