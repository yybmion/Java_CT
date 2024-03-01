package Part2.BOJ9012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B9012_yybmion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack<>();

        /**
         * stack 괄호 넣기
         */
        for(int i=0;i<N;i++){
            String res = br.readLine();         // 한줄 뽑기
            for(int j=0;j<res.length();j++){
                char ret = res.charAt(j);       // 해당 줄에서의 괄호 하나만 추출
                if (ret == 40) {                // 괄호가 `(`라면 stack에 추가
                    stack.add("(");
                }else{
                    if(stack.contains("(")){    // `)`일때 혹시 `(`가 있을때만 pop하고 empty면 그냥 스택에 `)`추가
                        stack.pop();
                    }else{
                        stack.add(")");
                    }

                    }
                }
            if(stack.empty()){                  // 판단
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

            stack.clear();                      // 마지막 clear
            }

        }

}


/**
 * '('일때만 add해주고 `)`일때는 적절한 조건문을 통해 pop해줄지 의미없는 `)`넣어줄지 판단한다.
 * 의미없는 `)`는 나중에 stack.empty에서 걸리지 않기 위해 하는것이며
 * 애초에 empty일때 `)`을 넣으면 그냥 바로 NO로 반환한다.
 */
