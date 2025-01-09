import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B10828_kimjiheej {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int a = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<>(); // 이 부분 스택의 선언 잘 기억해주기 !!

        for(int i=0; i<a; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String c = st.nextToken();


            switch(c){
                case "push" :
                    int k = Integer.parseInt(st.nextToken());
                    s.push(k);
                    break;
                case "top":
                    if(s.isEmpty())
                        sb.append("-1\n");
                    else
                        sb.append(s.peek()+"\n");
                    break;
                case "size":
                    sb.append(s.size()+"\n");
                    break;
                case "pop":
                    if(s.isEmpty())
                        sb.append("-1\n");
                    else
                    {
                        sb.append(s.peek()+"\n");
                        s.pop();
                    }
                    break;
                case "empty" :
                    if(s.isEmpty())
                        sb.append("1\n");
                    else sb.append("0\n");
                    break;

            }
        }

        System.out.println(sb.toString());

    }
}
/*
  Stack 을 선언하는 부분을 잘 익혀보자....
  더불어 스텍의 여러 기능들을 잘 기억하자.
 */
