import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B9012_kimjiheej {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(br.readLine());

        boolean isValid;

        for(int i=0; i<a; i++){

            isValid = true;

            Stack<Character> k = new Stack<>();

            String s = br.readLine();

            char[] array = s.toCharArray(); // 문자열의 요소를 하나하나 문자로 만들어주는 함수

            for(int j=0; j<array.length; j++){
                if(array[j] == '(')
                {
                    k.push('(');
                }
                else {
                    if(k.isEmpty() || k.peek() != '(') {
                        isValid = false;
                        break;
                    }

                    k.pop();
                }
            }

            if(!k.isEmpty())
                isValid = false;

            if(isValid)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }

        System.out.println(sb.toString());
    }
}
/*

  괄호가 붙어있기 때문에 toCharArray 를 사용해준다.
 */
