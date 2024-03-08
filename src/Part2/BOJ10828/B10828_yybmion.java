package Part2.BOJ10828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10828_yybmion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int j=0;


        while(N>0) {
            N--;
            StringTokenizer stt = new StringTokenizer(br.readLine());
                String res = stt.nextToken();
                if (res.equals("push")) {                       // push 일때는 뒤에 값도 한번 더 나오니 nextToken 한번 더 해준다.
                    int obj = Integer.parseInt(stt.nextToken());
                    arr[j] = obj;
                    j++;
                } else {
                    if (res.equals("pop")) {                    // 그외에는 배열의 인덱스만 잘 조절해서 값을 출력해주면 된다.
                        if (j == 0) {
                            System.out.println(-1);
                        } else {
                            j--;
                            System.out.println(arr[j]);
                            arr[j] = 0;
                        }
                    } else if (res.equals("size")) {
                        System.out.println(j);
                    } else if (res.equals("top")) {
                        if (j == 0) {
                            System.out.println(-1);
                        } else {
                            j--;
                            System.out.println(arr[j]);
                            j++;
                        }
                    } else if (res.equals("empty")) {
                        if (j == 0) {
                            System.out.println(1);
                        } else {
                            System.out.println(0);
                        }
                    }
                }
        }
    }
}

/**
 * 스택을 직접 구현하는 문제이다.
 * 두가지방법이 있다. 배열로 구현하느냐 링크드리스트로 구현하느냐이다.
 * 쉬운 배열로 구현하였다.
 *
 * pop,push 등등 모두 그냥 배열의 인덱스만 잘 조절해 주면 쉽게 값을 출력할 수 있다.
 */
