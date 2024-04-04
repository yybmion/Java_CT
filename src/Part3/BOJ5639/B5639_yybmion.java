package Part3.BOJ5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B5639_yybmion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));              // 루트 노드 객체를 생성한다. 입력값이 전위순위라 맨 처음 입력값이 무조건 루트다.

        while(true){                                                        // 그걸 이용해서 처음에 루트값 value를 계속해서 입력값과 비교해가며 오른쪽에 넣을지 왼쪽에 넣을지 코드를 짠다.
            String value = br.readLine();

            if(value == null || value.equals("")) break;                    // 입력개수가 주어지지 않아 이렇게 작성한다.
            root.addNode(new Node(Integer.parseInt(value)));                // root. 이라 무조건 처음 this.은 root 값이다!!!
        }                                                                   // 진짜 중요하다!!! this는 객체의 값이다!!!

        postOrder(root);
    }

    public static void postOrder(Node node){            // 후위순위 출력

        if(node == null){
            return;
        }

            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);      // 루트

    }

    public static class Node{

        int data=0;
        Node left=null;
        Node right=null;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public void addNode(Node newNode){          // 오른쪽에 왼쪽에 삽입할지 정할거다.
            if(this.data>newNode.data){             // 이제 봐보자 처음 root.addNode로 했으니 this는 루트값이다. 그것이 새로 addNode한 newNode의 값과 비교하여 크면
                if(this.left == null) {             // 루트가 더 크다는 의미이니 newNode의 value는 일단 왼쪽으로 가야하는건 확실하다.
                    this.left = newNode;            // 근데 여기서 루트의 left는 일단 추가한적이 없으니 null일 것이다. 그러므로 newNode, 새로 들어온것과 루트와 left에 연결해준다.
                }else{
                    this.left.addNode(newNode);     // 이건 이미 연결되어있으면 this(루트).left(연결된 left 노드)에서 addNode를 한다. 여기서 addNode를 하면 this는 다음 노드의 value값이 된다.
                }                                   // 어쨋든 이렇게 비교하다 만약 this보다 작은 값이 들어오면 밑에 else로 들어가 오른쪽에 노드를 만들어주는데 이것의 반복이다.
            }else{
                if(this.right == null) {
                    this.right = newNode;
                }else{
                    this.right.addNode(newNode);
                }
            }

        }
    }
}

/**
 * 삽입과정이 어려웠다.
 * 생각은 했는데 어떻게 구현할지 감이 전혀 안잡혔다.
 * https://pepperminttt.tistory.com/78
 */


