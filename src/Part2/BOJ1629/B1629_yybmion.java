package Part2.BOJ1629;

import java.io.*;
import java.util.StringTokenizer;

public class B1629_yybmion {

    public static long C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stt = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(stt.nextToken());
        long B = Integer.parseInt(stt.nextToken());
        C = Long.parseLong(stt.nextToken());

        System.out.println(powRemind(A,B));

    }

    static long powRemind(long A, long B){
        if(B==1){ // 종료 조건 : 지수가 1이면 나머지 구하기.
            return A % C;
        }

        long temp = powRemind(A,B/2);  // 분할, 계속해서 2로 나누기 지수를

        if(B%2==1){ // 만약 지수가 홀수일때는 A를 한번 더 곱해줘야한다.
            return (temp * temp % C) * (A%C);
        }

        return (temp * temp)%C ;   // 짝수일때는 그냥 두개 곱해주기
    }
}

/**
 * 분할정복 문제다.
 * 어떻게 풀지 감도 안왔다... 당연히 그냥 A를 B번 곱하고 C를 모듈러 연산을 하는것을 아닐테니...
 *
 * 해당 문제에서는 수학 개념이 2가지 적용되었다.
 * 첫번쨰, 지수법칙이다.
 * 예로들어 a^8 같은 경우는 a^4 * a^4로 나타낼 수 있다는 것은 알것이다.
 * 이것이 분할정복 중 분할의 시작점이다.
 * 저렇게 반을 나누면 다른 하나의 값은 계산하지 않아도 정복할때 그저 같은 값을 곱해주면 된다.
 * 즉, 쓸대없는 계산을 하지 않아도 된다는 장점이 있다.
 *
 * 두번째, 모듈러 연산이다.
 * 예를 들어보면 10^11%12  다음과 같은 연산이 있다고 해보자
 * 이는 (10^5 x 10^6) %12 로 나타낼 수 있다는 것은 첫번째 지수법칙에서 알았을 것이다.
 * 이후 모듈러 공식중 하나를 적용하면 ((10^5%12) x (10^6%12)) %12 위의 식은 이와 같이 나타낼 수 있다.
 * 즉, 연산할때마다 모듈러 연산을 붙여도 상관없다는 것이다.
 *
 * 마지막으로 당연히 숫자 범위가 큰 만큼 long 타입으로 선언한다. 모듈러 연산을 마지막에 하지 않고 연산 중간중간에 해주는 이유도
 * overflow때문이다. 아무리 long 타입이여도 모듈러 연산을 해주지 않으면 overflow나기 때문이다.
 *
 * https://jumping-to-the-water.tistory.com/141
 */
