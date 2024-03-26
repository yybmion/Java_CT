package Part2.BOJ1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1629_llocr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(multiple(A, B, C));
    }

    public static long multiple(long a, long b, long c) {
        if(b == 1) {
            return a % c;
        }

        long temp = multiple(a, b/2, c);     //계속 더 작은 값으로 분배한다
        temp = (temp * temp) % c;               //값을 곱해주고, 틈틈히 모듈러 연산을 수행해주기

        if(b % 2 != 0) temp = (temp * a) % c;   //홀수일 경우, 곱셈을 한 번 더 해 주기
        return temp;
    }
}

/*
* 나의 알고리즘 지식이 굉장히 형편없다는 것을 느낄 수 있도록 해준 문제 ^^
* 참고 : https://www.youtube.com/watch?v=mzLx_NWpuSY
* 포인트 : 어떻게 하면 문제를 푸는 순서를 줄일 수 있을까?
* - 2의 4승은 2의 2승 * 2의 2승 -> 이걸 문제에 적용해서 풀어야 함!
* - long의 값으로도 담을 수 있는 값이 있기 때문에 곱한 것을 바로 조금씩 모듈러 연산을 해준다
* */