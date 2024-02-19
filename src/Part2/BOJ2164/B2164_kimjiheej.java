import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class B2164_kimjiheej {

    static int arr[];


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>(); // 큐는 이렇게 구현한다.

        //처음에 큐에 값 넣어주기.

        for(int i = 1; i<=n; i++){
            q.add(i);
        }

        int b = 0;
        int a = 0;
        int k = 0;

        while(q.size() > 1){

            q.remove();
            a = q.peek();
            q.remove();
            q.add(a);
        }

        System.out.println(q.peek());

    }
}

/*
  q.remove() 는 요소를 제거하면서 예외를 발생시킨다.
  q.poll() 은 비어있는 큐에서 null 을 반환한다.
 */
