package Part2.BOJ2504;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class B2504_yybmion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        /**
         * 초기 생각
         */
        // 연속으로 (( [[ 나오면 x2, x3 준비
        // 아니면 그냥 2,3 계산
        // 연속으로 나온 개수만큼 ),] 나오길 기다림
        // 만약 ( 나오고 [,] 이런게 나왔는데 바로 다음 ) 로 닫아버리면 0반환

        /**
         * 하지만 위와 같이 하면 안된다.
         * 구현도 복잡해지고 답이 애초에 나오질 않는다.
         * 그래서 힌트를 얻은것이 바로 분배법칙!!
         * 분배법칙은 나중에 나오는 값들을 더해서 x2, x3을 하는 것이 아닌 그때 그때 곱을 해서 더해주어도 같은 답이 나온다.
         * 따라서 이 방법을 이용하면 된다.
         */

        String str = br.readLine();
        Stack<Character> strStack = new Stack<>();

        int tmp = 1;            // 값 곱해주기 위한 값
        int result = 0;         // 최종값 출력을 위한 result


        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);            // 괄호 하나씩 뽑아올것이다.

            if (ch == '(') {                    // ( 가 나올때는 x2를 그떄그떄 해줌 물론 스택에도 넣어줌
                tmp *= 2;
                strStack.add('(');
            } else if (ch == '[') {             // [ 나올때는 x3을 해주고 스택에 넣어줌
                tmp *= 3;
                strStack.add('[');
            } else {
                if (ch == ')') {                // 이제 여기가 분기점인데 , 바로 뒤가 (일때는 지금까지의 값을 더해줘 result에 넣어주고 tmp를 /2해준다.
                    if (strStack.isEmpty() || strStack.peek() != '(') {         // 여기는 이제 스택이 비어있거나 위에 뽑았을때 (가 아니라면 오류라 0을 반환
                        result = 0;
                        break;
                    }
                    if (str.charAt(i-1) == '(') {
                        result += tmp;
                    }
                    strStack.pop();
                    tmp /= 2;                   // 나누기 2를 처음에 왜 하는지 몰랐는데 생각해보자. 밑에 주석을 보자!!!
                } else if (ch == ']') {         // ] 도 ) 와 같은 방법
                    if (strStack.isEmpty() || strStack.peek() != '[') {
                        result = 0;
                        break;
                    }
                    if (str.charAt(i-1) == '[') {
                        result += tmp;
                    }
                    strStack.pop();
                    tmp /= 3;
                }else{
                    result =0;
                    break;
                }
            }


        }
        if (!strStack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(result);
        }
    }

    /**
     * 자 여기로 왔다
     * 왜 나누기 2,3 을 하느냐??
     * 우리는 앞서 분배법칙이란 힌트를 얻어 (,[가 오면 그 즉시 x2,x3을 해주었다.
     *
     * 예를 들어보자 (()[[]])([])
     * 이게 예제라면 해당 연산은 2*(2+ 3*3) + 2*3 이라고 볼 수 있다.
     *
     * ),]가  올때 바로 전의 스택이 (나[일때 지금까지의 값을 더해준다.
     * 보면 (( 다음 ) 가 나올때 분배법칙으로 곱해주면 되는것을 볼 수 있다.
     * 그리고 앞서 곱해준 x2는 다음 분배법칙 연산을 위해서 /2를 해주는 것이다.
     *
     * https://loosie.tistory.com/349
     */
}


