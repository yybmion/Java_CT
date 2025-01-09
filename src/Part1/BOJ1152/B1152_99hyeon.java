package Part1.BOJ1152;

import java.io.*;
import java.util.StringTokenizer;

public class B1152_99hyeon {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        while(st.hasMoreTokens()){
            st.nextToken();
            count++;
        }

        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();

    }
}

/**
 *
 * 우선, 한 줄을 읽어와서
 * StringTokenizer를 이용해 공백단위로 문자열을 토큰화한다.
 * 그리고 토큰화된 단어들을 하나하나 읽어오면서 갯수를 카운트한다.
 * 토큰이 더 이상 존재하지 않을때까지 반복한다.
 *
 * 이번 문제를 통해 hasMoreTokens라는 함수가 존재한다는 것을 알게되었다.
 * 문제를 하나하나 풀 때마다 원래 알던 함수들도
 * 더 자세히 알게되는 느낌쓰?
 * 문제 구성이 아주 좋은 듯 하다
 * 이 문제 구성을 만들어 주신 분도 감사하고
 * 그 글을 찾은 유빙빙님도 감사함당 ^^7
 *
 */