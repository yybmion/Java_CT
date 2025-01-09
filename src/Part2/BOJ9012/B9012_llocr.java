package Part2.BOJ9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B9012_llocr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i<t; i++) {
            char[] arr = br.readLine().toCharArray();
            int n = arr.length;
            Stack<Character> stack = new Stack<>();

            for(int j=0; j<n; j++) {
                if(arr[j] == ')') { //들어온 문자열이 )일 때만 판단
                    if(stack.empty()) { //만약 비어있다면, 그냥 push
                        stack.push(')');
                    } else if(stack.peek() == '(') { //stack의 가장 위에 있는 괄호가 ( 이라면 pop
                        stack.pop();
                    } else {    //아무 것도 아니면, 그냥 ) push
                        stack.push(')');
                    }
                } else {
                    stack.push('(');
                }
            }

            if(stack.empty()) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }
}

/*
* 학교에서 stack 설명할 때 풀어본 문제,, 괜히 반갑고 막 그런
*
* 문제 구현은 했는데,
    if(arr[j] == ')') {
        if(stack.empty()) {
            stack.push(')');
        } else if(stack.peek() == '(') {
            stack.pop();
        } else {
            stack.push(')');
        }
    } else {
        stack.push('(');
    }
* 이 부분이 너무 지저분해서 다른 분들 코드를 참고해봐야겠다 :(
* */