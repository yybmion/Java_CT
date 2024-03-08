import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2504_samgashyeong {

    //2일 동안 고민하면서 별의 별 짓을 다 해봐도 안되서 결국에는 정답을 봤던 문제 수학 법칙 중에 분배법칙을 떠올렸으면 진짜 쉽게 풀 수 있을 문제였는데 안 떠올라서 못 풀었던 문제
    public static void main(String[] args) throws Exception{
        //BufferedReader로 입력 더 빠르게 하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        
        Stack<Character> stk = new Stack<>();

        int count = 1;
        int result = 0;
        for(int j=0;j<str.length();j++){
            if(str.charAt(j) == ')' && stk.size() != 0 && stk.peek() == '('){
                stk.pop();
                if(str.charAt(j-1) == '('){
                    result += count;
                }
                count/=2;
            }
            else if(str.charAt(j) == ']' && stk.size() != 0 && stk.peek() == '['){
                stk.pop();
                if(str.charAt(j-1) == '['){
                    result += count;
                }
                count/=3;
            }
            else if(str.charAt(j) == '('){
                stk.push(str.charAt(j));
                count = count*2;
            }
            else if(str.charAt(j) == '['){
                stk.push(str.charAt(j));
                count = count*3;
            }
            else{
                stk.push(str.charAt(j));
            }
        }

        if(stk.size() == 0){
            System.out.println(result);
        }
        else{
            System.out.println("0");
        }
    }
}