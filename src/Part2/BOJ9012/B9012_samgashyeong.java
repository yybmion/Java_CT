import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B9012_samgasheong {

    //
    public static void main(String[] args) throws Exception{
        //BufferedReader로 입력 더 빠르게 하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        

    
        for(int i =0;i<size;i++){
            String s = br.readLine();
    
            Stack<Character> stack = new Stack<>();

            for(int j = 0;j<s.length();j++){
                // 만약 문자가 '(' 면 계속 스택에 집어넣고 ')' 인 문자는 stack.peek()를 통해 수를 끄집어 내서 '('이면 바로 pop()을 씀.
                if(stack.size() != 0 && s.charAt(j) == ')' && stack.peek() == '('){
                    stack.pop();
                }
                else{
                    stack.push(s.charAt(j));
                }
            }

            if(stack.size() != 0){
                System.out.println("NO");
            }
            else{
                System.out.println("YES");
            }
        }
    }
}
