import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.*;


public class B1655_kimjiheej {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb  = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Queue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> minQ = new PriorityQueue<>();

        for(int i=0; i<n; i++){
            int a  = Integer.parseInt(br.readLine());
            if(maxQ.size() == minQ.size()){
                maxQ.add(a);

                if(!minQ.isEmpty() && maxQ.peek() > minQ.peek()){
                    minQ.add(maxQ.poll());
                    maxQ.add(minQ.poll());
                }
            }

            else {
                minQ.add(a);

                if(maxQ.peek() > minQ.peek()){
                    minQ.add(maxQ.poll());
                    maxQ.add(minQ.poll());
                }
            }
           sb.append(maxQ.peek()+"\n");
        }

        System.out.println(sb.toString());

    }

}
/*
   블로그를 참고했다 !
   이렇게 하면 자동으로 쭉 정렬이 되고 마지막으로 max 힙에서 하나만 빼주면 중간값이 된다
   참고 : https://gh402.tistory.com/32
 */
