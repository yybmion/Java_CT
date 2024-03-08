package Part2.BOJ11866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11866_yybmion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stt = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        int N = Integer.parseInt(stt.nextToken());
        int which = Integer.parseInt(stt.nextToken());

        for(int i=1;i<N+1;i++){
            queue.add(i);
        }

        int count =which-1;

        System.out.print("<");

        while(N>1){
            while(count>0){
                queue.add(queue.remove());
                count--;
            }
            Integer intPoll = queue.poll();
            System.out.print(intPoll+", ");
            N--;
            count=which-1;
        }

        System.out.print(queue.poll() + ">");
    }
}
