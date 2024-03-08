package Part2.BOJ2493;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493_yybmion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        /**
         * 일단 스택을 쌓고
         * 그다음 스택오는 것들이 작으면 해당 스택이 수신
         * 그다음값과 빼기를 할때 -면 수신 못함
         * +면 수신할 수 있다는 의미
         */

        int N = Integer.parseInt(br.readLine());
        Stack<Node> stack = new Stack<>();
        int[] arr = new int[N];

        StringTokenizer stt = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++){

            arr[i]= Integer.parseInt(stt.nextToken());

            while(!stack.isEmpty() && stack.peek().value<arr[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                bw.write(0 + " ");
            }else{
                bw.write(stack.peek().index + " ");
            }


            stack.push(new Node(arr[i],i+1));
        }
        bw.flush();
    }

        static class Node{

            int value;
            int index;

            public Node(int value, int index) {
                this.value = value;
                this.index = index;
            }
        }


}

/**
 * 추후 작성 예정
 * https://velog.io/@qodlstjd12/%EB%B0%B1%EC%A4%80-2493-%ED%83%91-Java
 */


