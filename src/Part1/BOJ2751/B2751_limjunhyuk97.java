package Part1.BOJ2751;

import java.util.Scanner;

public class B2751_limjunhyuk97 {

    public static final int OFFSET = 1000001;
    public static final int MAX_N = 2000005;

    public static int N;

    public static boolean arr[] = new boolean[MAX_N];

    public static Scanner sc = new Scanner(System.in);

    public static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) {
        N = sc.nextInt();

        for(int i=0; i<N; ++i) {
            int target = sc.nextInt();
            arr[target + OFFSET] = true;
        }

        for(int i=0; i<MAX_N; ++i) {
            if(!arr[i]) continue;
            answer.append(i-OFFSET).append("\n");
        }

        System.out.println(answer);
    }

}

/**
 *
 * [최적화] 1. 출력 / System.out -> String (X)
 *
 * [최적화] 2. 출력 / String -> StringBuilder (O)
 *
 * [결론] System.out 로 하나씩 출력, String 으로 붙여서 출력, StringBuilder 로 붙여서 출력 : 3가지 모두 차이 존재
 *
 * [String concatenation] String += literal
 * - String 은 immutable 한 객체 임
 * - 따라서 다음과 같은 String 간 '+' 연산 과정은 "부수적인 String 객체 생성 과정에서의 메모리, CPU 낭비" 를 일으킨다.
 *
 *  String str;
 *  str += "hello";
 *
 * - 위의 경우에서 다음의 불필요한 과정들이 수반된다.
 *      - "hello" 리터럴을 String 객체로 만들고
 *      - str 과 이를 붙여서 새로운 String 객체를 생성하고
 *      - 이를 str 에 할당하고
 *      - 임시로 생성된 객체들을 가비지 컬렉터가 제거하는
 *
 * [String concatenation] StringBuilder, StringBuffer
 * - StringBuilder 를 사용하면 mutable 한 String 을 생성하여 이런 불필요한 연산 소요를 줄일 수 있다.
 * - StringBuffer 도 마찬가지로 작용하는데, multithreading 환경에서 thread safe 한 연산이 필요할 경우 사용한다.
 *
 */