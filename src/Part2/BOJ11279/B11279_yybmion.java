package Part2.BOJ11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B11279_yybmion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pQueue = new PriorityQueue<>((a, b) -> b - a);       // Comparator 정의 람다식으로

        for(int i=0;i<N;i++){
            int arrValue = Integer.parseInt(br.readLine());
            if(arrValue==0){
                if(pQueue.isEmpty()){
                    System.out.println(0);
                }else {
                    System.out.println(pQueue.poll());
                }
            }else{
                pQueue.add(arrValue);
            }

        }
    }
}
/**
 * 최대 힙 문제이다.
 * 자바에서는 최대힙을 물론 직접 구현할수도 있지만 그냥 PriorityQueue를 이용해서 최대힙을 구현할 수 있다.
 * 이때 주의할 점은 PriorityQueue에서 힙을 구현하기 위해서는 Comparator을 정의해줘야한다는 것이다.
 *
 * 그래서 나는 람다식으로 구현해주었다.
 * 최대힙이므로 a-b가 아닌 b-a로 정렬하였다.
 */
