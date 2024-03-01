package Part1.BOJ10872;

import java.util.Scanner;

public class B10872_llocr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(factorial(n));
    }

    public static int factorial(int n) {
        if(n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }
}

/*
* 오랜만에 풀어보는 팩토리얼 문제 :)
* n에서부터 1이 될 때까지 각 값을 재귀를 통해 곱해서 나아가기
* */
