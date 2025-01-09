package Part2.BOJ13334;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B13334_yybmion {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Coord[] arr = new Coord[N];

        int max = -1;

        for (int i = 0; i < N; i++) {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            arr[i] = new Coord(Integer.parseInt(stt.nextToken()), Integer.parseInt(stt.nextToken()));
        }

        int d = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for(int i=0;i<N;i++){
            pQueue.add(arr[i].left);

            /**
             * pQueue.peek() < arr[i].right - d 는 i번째 선분의 우칙 점을 철도
             * 여기서 priorityQueue를 이용했으니 left를 add하고 peek나 poll을 했을때 순서를 주의해야한다!!
             * right에서 철로 길이를 뺀것이 left보다 크다?? 이러면 철로가 담을 수 없는 길이라는 것이다.
             * 그래서 방금 들어온 거 poll해준다.
             * 계속 말하지만 PrioityQueue는 add할때 순서가 바뀔 수 있다는 것을 유의한다.
             */
            while(!pQueue.isEmpty() && pQueue.peek() < arr[i].right - d){
                pQueue.poll();
            }
            max = Math.max(max,pQueue.size());
        }

        bw.write(max + "");
        bw.flush();
        bw.close();
    }

}

class Coord implements Comparable<Coord>{       // Coord 클래스 left기준으로 정렬하기 위한 comrarable
    int left;
    int right;

    public Coord(int left, int right) {    // 집과 사물실의 좌표를 맞추기 위해서!(집,사무실) (사무실,집) 이런게 있다.
        this.left = Math.min(left, right);
        this.right = Math.max(left, right);
    }

    @Override
    public int compareTo(Coord o) {
        return Integer.compare(right,o.right);
    }
}

/**
 * 해당 블로그에 아주 자세하게 기술되어있으니 참고하자
 * https://blog.naver.com/occidere/221085858307
 */
