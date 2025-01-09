package Part1.BOJ10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B10989_limjunhyuk97 {

    public static final int MAX_LEN = 10005;

    public static int N;

    // 수를 다 받아서 정렬하는 것이 아니라,
    // 어짜피 들어오는 수의 범위가 1 - 10000 로 정해져 있으니, 여기에 갯수만 넣고 작은 수부터 출력하면 됨
    public static int arr[] = new int[MAX_LEN];

    // [최적화] Scanner 로 했다가 시간초과 나서 BufferedReader 로 변경
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // [최적화] String 간의 '+' 연산이 아니라 StringBuilder 간의 append 연산으로 변경
    public static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N ; ++i) {
            int tmp; tmp = Integer.parseInt(br.readLine());
            arr[tmp] += 1;
        }

        for(int i=0; i<MAX_LEN; ++i) {
            if(arr[i] == 0) continue;
            for(int j=0; j<arr[i]; ++j) {
                answer.append(i).append('\n');
            }
        }

        System.out.println(answer);
    }

}

/**
 *
 * [최적화] Scanner vs BufferedReader
 *
 * Scanner
 * - InputStream(Byte) -> Scanner
 * - 입력 스트림 으로 부터 직접 데이터를 읽어오기 때문에 buffering 의 이점이 없다
 *      - 입력 스트림으로부터 직접 데이터를 읽어오는 것은 더 많은 I/O Interrupt, 더 많은 수의 OS mode 변경 (kernel <-> user mode)을 일으킨다는 것.
 *      - 따라서 Scanner 를 사용하여 많은 수의 입력을 받아들일 경우, 속도가 더 오래걸림
 * - nextXXX 메서드를 사용할 때 정규표현식을 통한 파싱이 수행됨
 *      - 속도가 느려질 여지가 있음
 *
 * BufferedReader (https://docs.oracle.com/javase/8/docs/api/java/io/BufferedReader.html)
 * - InputStream(Byte) -> InputStreamReader(Character) -> BufferedReader(Buffer)
 * - buffer 를 사용하여 데이터에 대한 I/O 작업 속도를 높일 수 있음
 *      - Buffering 없이는 file(입력 스트림) 으로 부터 byte 를 읽고, 문자로 바꾸고, return 시킨다.
 *      - Buffering 수행하면 buffer 로 부터 문자를 읽어들인다.
 *      - 구체적으로는, 더 적은 수의 I/O Interrupt 를 일으키며, 더 적은 수의 OS mode 변경 (kernel <-> user mode)을 일으킨다는 것.
 *      - 따라서 BufferedReader 를 사용하여 많은 수의 입력을 받아들일 경우, 속도 단축시킬 수 있음
 * - readLine() 메서드를 사용할 경우 그냥 문장 단위 (line seperator : \n, \r) 로 buffer 의 문자열 스트림을 읽어들임
 *      - 속도가 더 빠름
 */