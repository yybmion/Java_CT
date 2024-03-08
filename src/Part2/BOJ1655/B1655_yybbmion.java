package Part2.BOJ1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B1655_yybbmion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2-o1); // Comparator.reverseOrder 내림차순
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(); // 올림차순

        int N = Integer.parseInt(br.readLine());


        for(int i=0;i<N;i++){
            int qValue = Integer.parseInt(br.readLine());

            if(maxQueue.size() == minQueue.size()){         //max 힙과 min힙을 나누어서 사이즈가 같다면 max힙에 수를 넣어준다.
                maxQueue.add(qValue);                       // 그 이유는 중간값을 찾기 위해 두개의 힙에 사이즈를 같게 유지해야하기 때문이다.

                if(!minQueue.isEmpty() && maxQueue.peek() > minQueue.peek()){   // min힙에 비어있지 않고, 만약 max힙의 노드값이 min힙 노드값보다 클때 서로 바꿔줘야한다.
                    minQueue.add(maxQueue.poll());
                    maxQueue.add(minQueue.poll());
                }
            }else{
                minQueue.add(qValue);                   // 아닐때는 min힙에 그냥 add하면된다.

                if(maxQueue.peek() > minQueue.peek()){  // 여기에서도 비교를 해줘야한다.
                    minQueue.add(maxQueue.poll());
                    maxQueue.add(minQueue.poll());
                }
            }

            sb.append(maxQueue.peek()+"\n");
        }
        System.out.println(sb.toString());  // sb.append 안하고 sout로 하니까 시간초과로 틀렸다 ;;

    }
}
/**
 * 일단 두개의 힙으로 나눠야한다는 개념을 생각하지 못했다.
 * 당연하지만 그냥 배열로 중간값을 찾으면 시간초과가 난다. (0.1초)
 * 그래서 중간값에 대해 이야기를 더하지면
 * 123456이 있다고 해보자
 * 123 | 456
 *
 * 이렇게 중간값은 왼쪽 부분의 최대값, 오른쪽 부분의 최소값 둘중 하나다.
 * 이경우는 3이 중간값이다.
 *
 * 이와 같이 값들을 작은쪽, 큰쪽으로 나누면 작은 쪽의 최대값(노드)이 항상 중간값이라는 것을 알 수 있다.
 * 왼쪽이 최대힙, 오른쪽이 최소힙이다.
 *
 * https://javachoi.tistory.com/432
 */
