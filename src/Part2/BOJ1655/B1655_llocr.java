package Part2.BOJ1655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class B1655_llocr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 0; i<n; i++) {
            int num = Integer.parseInt(br.readLine());

            if(minQueue.size() == maxQueue.size()) {
                maxQueue.offer(num);
            } else {
                minQueue.offer(num);
            }

            if(!minQueue.isEmpty()) {
                if(minQueue.peek() < maxQueue.peek()) {
                    int temp = minQueue.poll();
                    minQueue.offer(maxQueue.poll());
                    maxQueue.offer(temp);
                }
            }

            sb.append(maxQueue.peek()).append("\n");
        }

        System.out.println(sb);
    }
}

/*
* 참고 : https://gh402.tistory.com/32
* 여러 설명을 보아도 왜 힙을 두 개로 나누어서 코드를 진행시키는 건지 이해가 되지 않았는데, 위 블로그의 그림을 보니 이해가 딱..!!
* 최대 힙의 값 < 최소 힙의 값
* 이 구조가 되면 최대 힙의 값을 peek() 하면 무조건 중간 숫자겠구나!! 했다!!
* 나의 컴퓨팅적 사고가 부족함을 또 한 번 느낀다..^^
* */