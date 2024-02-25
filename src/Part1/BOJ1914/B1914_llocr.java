package Part1.BOJ1914;

import java.math.BigInteger;
import java.util.Scanner;

public class B1914_llocr {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger count = new BigInteger("2");
        count = (count.pow(n)).subtract(new BigInteger("1"));

        System.out.println(count);
        if(n <= 20) {
            hanoi(n, 1, 2, 3);
            System.out.println(sb.toString());
        }
    }

    public static void hanoi(int n, int start, int temp , int to) {
        if(n == 1) {
            sb.append(start + " " + to + "\n");
            return;
        }

        hanoi(n - 1, start, to, temp); //1번 막대에서 2번 막대로 n-1개를 옮김

        sb.append(start + " " + to + "\n"); //가장 큰 원판을 목적 지점으로 옮김

        hanoi(n - 1, temp, start, to); //2번 막대에서 3번 막대로 n-1개를 옮김

    }
}

/*
* 참고 : https://velog.io/@younghoondoodoom/%EB%B0%B1%EC%A4%80-11729-%ED%95%98%EB%85%B8%EC%9D%B4-%ED%83%91-%EC%9D%B4%EB%8F%99-%EC%88%9C%EC%84%9C
*
* 일정한 규칙을 찾아야 하는 것 같은데, 그 부분을 접근하기가 힘들었다 :( 결국 고민만 하다가 검색을 통해서 문제를 해결하게 되었다..!
* 진짜 넘흐 어려워서 그냥 이해하는 걸 포기하고 싶었다,,
*
* 하노이탑 문제 점화식
* An = 2^n -1
*
* BigInteger -> 무한대의 숫자를 다룰 때 사용, 문자열이기 때문에 사칙연산 불가능
* "+" : add(BigInteger val) - 더하기
* "-" : subtract(BigInteger val) - 빼기
* "*" : multiply(BigInteger val) - 곱하기
* "/" : divide(BigInteger val) - 나누기
* "%" : remainder(BigInteger val) - 나머지
* 제곱 : pow(int exponent) - n승 (제곱)
* */