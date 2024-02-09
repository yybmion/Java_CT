package Part1.BOJ10872;

import java.util.Scanner;

public class Pt1_10872_임준혁 {

    public static int N;

    public static Scanner sc = new Scanner(System.in);

    public static int getFactorial(int n) {
        if(n < 2) return 1;
        else return n * getFactorial(n-1);
    }

    public static void main(String[] args) {
        N = sc.nextInt();
        System.out.println(getFactorial(N));
    }
}
