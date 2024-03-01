package Part2.BOJ16564;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B16564_llocr {
    static int[] c;
    static int n;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());   //캐릭터의 개수
        k = Integer.parseInt(st.nextToken());   //올릴 수 있는 레벨 총합
        c = new int[n];

        for(int i = 0; i<n; i++) {
            c[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(c);

        long start = c[0];
        long end = c[n-1] + k;
        long result = 0;

        while(start <= end) {
            long mid = (start + end) / 2;

            if(check(mid) <= k) {
                result = mid;
                start = mid+1;
            } else {
                end = mid-1;
            }
        }

        System.out.println(result);
    }

    public static long check(long mid) {
        long count = 0;

        for(int i = 0; i<n; i++) {
            if(c[i] < mid) {
                count += mid - c[i];
            }
        }

        return count;
    }
}

/*
* 인텔리제이에서 실행할 때는 예제가 맞는데, 백준에 제출하기만 하면 틀렸습니다! 이러길래
* 대체 뭐가 틀렸다는 걸까... 하며 다른 답안들과 코드를 비교해봐도 비슷한 플로우...
*
* 알고보니
* long count = 0;
* 이 부분을 int로 처리해둬서 그랬던 거였다...!!
* 큰 숫자 다룰 때는 자료형 꼭꼭 신경써야겠다 :)
* */