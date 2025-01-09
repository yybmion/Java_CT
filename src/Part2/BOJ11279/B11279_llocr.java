package Part2.BOJ11279;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class B11279_llocr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        //높은 수가 우선인 우선순위큐 선언!
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0; i<n; i++) {
            int num = Integer.parseInt(br.readLine()); //숫자 받기

            if(num == 0) {
                if(queue.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(queue.poll()).append("\n");
                }
            } else {
                queue.offer(num);
            }
        }

        System.out.println(sb);
    }
}

/*
* Comparator를 정의해주는 부분에 대한 지식이 약해서,, 그 부분에 대해서 더 공부해보아야 할 것 같다!
* 다른 부분은 easy..~
* */