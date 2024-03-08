package Part2.BOJ2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class B2164_yybmion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Integer> queue =  new LinkedList<>();
        int N = Integer.parseInt(br.readLine());

        for(int i=1;i<N+1;i++){
            queue.add(i);                   // 카드 순서대로 큐 삽입
        }

        while(N>1){                         // 카드가 하나 남을때까지 큐 맨 앞의 수 remove하고
            queue.remove();
            Integer intPoll = queue.poll(); // 그다음 것 뽑아서
            queue.add(intPoll);             // 맨 뒤 큐에 삽입
            N--;
        }

        System.out.println(queue.peek());   // 마지막 남은 숫자카드 출력

    }
}


/**
 * 큐 문제 그냥 문제에 하라는 순서대로 코드 적어주면 완료
 */
