package Part2.BOJ10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class B10828_99hyeon {
    static StringTokenizer st;
    static Stack<Number> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++){
            st = new StringTokenizer(br.readLine());
            checkCommand(st);
        }
        br.close();

        System.out.println(sb);
    }

    static void checkCommand(StringTokenizer st){
        String command = st.nextToken();

        if(command.equals("push")){ //push
            stack.push(Integer.parseInt(st.nextToken()));
        }else if(command.equals("pop")){    //pop
            if(stack.empty()){
                sb.append(-1).append("\n");
            }else{
                sb.append(stack.pop()).append("\n");
            }
        }else if(command.equals("size")){   //size
            sb.append(stack.size()).append("\n");
        }else if(command.equals("empty")){  //empty
            if(stack.empty()){
                sb.append(1).append("\n");
            }else{
                sb.append(0).append("\n");
            }
        }else{  //top
            if(stack.empty()){
                sb.append(-1).append("\n");
            }else{
                sb.append(stack.peek()).append("\n");
            }
        }
    }
}

/**
 * 자바가 stack 클래스를 제공하고 있어서 쉽게 풀었다.
 * 명령을 입력받고 그 명령에 따라 나눠서 수행하는 방식으로 했다.
 * 시간제한이 0.5초라서 혹시몰라 StringBuilder를 사용하였다.
 */