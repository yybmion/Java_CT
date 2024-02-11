package Part1.BOJ10872;

import java.io.*;

public class B10872_yybmion {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int ret = factorial(N);

        if(N == 0) ret=1;

        bw.write(ret+"");
        bw.flush();

    }

    public static int factorial(int N) {

        if(N>0) {
            return N * factorial(N - 1);
        }else{
            return 1;
        }

    }

}

/**
공포의 재귀함수의 시작이다.
재귀함수는 종료주건과 프레임을 줄여나가는 것이 중요하다고 배웠다.
그래서 위의 문제에서의 종료조건은 N이 0이 되면 종료하고
그전까지는 N의 값을 줄여나가며 재귀를 호출해주었다.
그래서 입력값 5를 예로 들면 5 * 4 * 3 * 2 * 1 로 return 될것이다.
**/
