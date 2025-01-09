package Part1.BOJ1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1978_llocr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            boolean prime = true;
            if( num == 1) continue;
            if( num == 2) {
                answer++;
                continue;
            }
            for(int i = 2; i < num; i++) {
                if(num % i == 0) {
                    prime = false;
                    break;
                }
            }
            if(prime) answer++;
        }
        System.out.println(answer);
    }
}

/*
* 입력된 값들을 StringTokenizer를 사용해서 뒤에 다른 토큰이 더 있으면 진행하는 방식으로 해결했다
* 해당 값이 소수인지 판별하기 위해서 무식하게 한 개씩 비교하는 방식을 택했는데, 이것보다 더 좋은 방식이 있을 것만 같아서 푸는 내내 찝찝했던 문제이다,, 쩝
* */