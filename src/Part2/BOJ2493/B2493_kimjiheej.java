import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
class Info {
    int height;
    int index;
    Info(int height, int index) {
        this.height = height;
        this.index = index;
    }
}
public class B2493_kimjiheej {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int[] arr = new int[N];
        String s = bf.readLine();
        StringTokenizer st = new StringTokenizer(s, " ");
        Stack<Info> top = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            while(!top.isEmpty() && top.peek().height < arr[i]) {
                top.pop();
            }
            if(top.isEmpty())
            {
                System.out.print("0 ");
            }
            else
            {
                System.out.print(top.peek().index + " ");
            }
            top.push(new Info(arr[i], i + 1));
        }
    }
}
/*
  생각을 해주어야 할 점은 새롭게 들어온 값을 앞의 값들과 비교하여야 한다.
  비교를 하면서 현재 들어온 값보다 작으면 pop 을 해준다.
  어차피 필요가 없기 때문이다.
  그 후에 만약 스택이 비어있으면 들어온 값보다 다 작으므로 레이더가 도달하지 못하므로
  0 을 출려해주고 그것이 아니라면 peek 해서 인덱스를 출력해준다.
  그 후 마지막에는 새로 들어온 값을 스택에 넣어준다. 다음값과 비교해야 하기 때문이다.
 */




