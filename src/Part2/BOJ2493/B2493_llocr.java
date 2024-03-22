package Part2.BOJ2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493_llocr {
    static class Node{
        int height;
        int index;

        public Node(int value, int index) {
            this.height = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        Stack<Node> stack = new Stack<>();

        for(int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            while(!stack.isEmpty() && stack.peek().height < arr[i]) {
                stack.pop();
            }

            if(stack.isEmpty()) {
                sb.append(0).append(" ");
            } else {
                sb.append(stack.peek().index + 1).append(" ");
            }

            stack.push(new Node(arr[i], i));
            //그 전의 값들보다 arr[i]가 크기 때문에 작은 값들은 추가해주지 않아도 된다. 어차피 arr[i]가 레이저를 수신할 것임
            //stack에 height 값만 저장하려고 했으나, 그렇게 하면 반례가 있어서 클래스 만들어서 적용
        }
        System.out.println(sb);

        /*
        첫번째 시도였지만? 역시나 시간제한에 걸렸다 ^^
        스택문제이기 때문에 스택을 활용해서 풀어보자! 하고 다른 방식으로 접근해보았다

        int[] arr = new int[n];
        boolean[] check = new boolean[n];
        for(int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=n-1; i>0; i--) {
            for(int j=i-1; j>=0; j--) {
                if(arr[i] < arr[j] && !check[i]) {
                    sb.append(j+1).append(" ");
                    check[i] = true;
                    break;
                }
            }
            if(check[i] == false) {
                sb.append(0).append(" ");
            }
        }

        sb.append(0);

        System.out.println(sb.reverse().toString());*/
    }


}
