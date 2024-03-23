package Part2.BOJ1629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1629_99hyeon {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());   // A를
        int B = Integer.parseInt(st.nextToken());   // B번 곱한 수를
        int C = Integer.parseInt(st.nextToken());   // C로 나눈 나머지 출력

        br.close();

        System.out.println(calculate(A, B, C));
    }

    public static long calculate(int A, int B, int C){

        if(B == 1){
            return A % C;
        }

        long tmp = calculate(A, B/2, C);

        //지수가 홀수인 경우
        if(B % 2 == 1){
            return (tmp * tmp % C) * A % C;
        }

        //지수가 짝수인 경우
        return tmp * tmp % C;
    }
}

/**
 * 지수를 분할하고 합칠때 값을 곱하고 나머지를 연산하는 방식으로 풀었다.
 * 분할하는 것은 지수가 1일 때까지 분할한다.
 * 지수가 홀수인 경우에는 예를 들어 2^5은 반으로 나누면 (2^4 * 2^4 * 2)이 되기 때문에
 * 합칠 때 2즉 A를 한 번 곱해주면서 합친다.
 * 짝수인 경우에는 본인을 두 번 곱해주면서 합친다.
 *
 * 그리고 문제에 숫자 범위 제한이 있기 때문에 연산 중간에 나머지를 구해준다.
 * 이때 모듈로연산 공식인 (A*B)modC = (A mod C) * (B mod C)를 이용한다.
 * 그래서 calculate 함수의 모든 return 값에 %C를 해주고
 * 지수가 홀수인 경우에는 숫자가 너무 커질 수 있기 때문에
 * 모듈로연산 공식을 사용해서 tmp*tmp*A % C를 (tmp * tmp % C) * A % C로 바꿔준다.
 *
 * ---------------------------------------------------------------------------
 *
 * 처음에는 모듈로 연산을 생각하지 못하고 재귀로 냅다 풀어서 시간초과가 났다.
 * 모듈로 연산을 이번 기회에 다시 상기시킬 수 있었다.
 *
 * 참고: https://st-lab.tistory.com/237
 */
