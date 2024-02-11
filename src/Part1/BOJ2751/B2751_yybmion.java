package Part1.BOJ2751;

import java.io.*;
import java.util.*;

public class B2751_yybmion {
    /**
     * 첫번째 풀이
     */
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        int N = Integer.parseInt(br.readLine());
//        LinkedList<Integer> list = new LinkedList<>();
//
//        for(int i=0;i<N;i++) {
//            StringTokenizer stt = new StringTokenizer(br.readLine());
//            list.add(Integer.parseInt(stt.nextToken()));
//        }
//
//        Collections.sort(list);
//
//        for (Integer res : list) {
//            bw.write(res+"\n");
//        }
//
//        bw.flush();
//    }

    /**
     * 두번째 풀이
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        boolean[] arr = new boolean[2000001];

        for(int i=0;i<N;i++) {
            arr[Integer.parseInt(br.readLine())] = true;
        }

        for(int i = 0; i < arr.length; i++) {
            if(arr[i]) {
                sb.append(i).append('\n');
            }
        }
        System.out.print(sb);
    }
}

/**
 * 먼저 시간초과의 힌트를 얻어 앞서 정렬1에서 사용한 Arrays.sort는 뭔가 사용하면 안될것 같았다.
 * 역시 찾아보니 최악의 경우 O(N^2)이라는 결과가 나온다.
 * 그래서 정렬 라이브러리 중에서 시간복잡도가 더 적게 걸리는 정렬방법이 있는지 찾아보니
 * Collections.sort는 O(NLOG_N)으로 Arrays.sort보다 빠르다. 그래서 List collection을 만들어서
 * Collections.sort에 넣어서 정답은 맞았지만 생각보다 메모리와 시간이 많이 나왔다.
 *
 * 그래서 더 줄일 수 있는 방법이 있나 하고 풀이를 좀 찾아봤는데 Counting sort를 통해 풀면 시간이 많이 줄일 수 있었다.
 * 참고한 블로그는 다음과 같다.  https://st-lab.tistory.com/106
 *
 * 여기서 설명한 방법은 " boolean[] 배열에 입력 받은 값을 index로 쓰면 되는데, 아무래도 직접 비교 정렬이 아니므로 시간복잡도는 O(n) 으로 매우 빠른 방법이다."
 * 라고 한다.
 * 여기서 주의할 점은 문제에서 수의 절대값이 1,000,000 보다 작거나 같은 정수이므로 -1,000,000 부터 1,000,000를 boolean 인덱스를 해주어
 * boolean[] arr = new boolean[20000001] 를 만들어야한다.
 * 그래서 arr에 입력값에 true를 넣어주고 출력할때 true인 부분의 인덱스를 뽑아주면 된다.
 * 그외에 주의할 점은 없다.
 */


