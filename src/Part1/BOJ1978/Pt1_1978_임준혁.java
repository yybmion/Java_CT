package Part1.BOJ1978;

import java.util.Scanner;

public class Pt1_1978_임준혁 {

    public static int N=0, sum=0;

    public static final int MAX_COUNT = 1005;

    public static boolean isPrime[] = new boolean[MAX_COUNT];

    public static Scanner sc = new Scanner(System.in);

    public static void calPrime() {
        isPrime[2] = true;
        isPrime[3] = true;
        for(int n=4; n<MAX_COUNT; ++n) {
            boolean nIsPrime = true;
            for(int j=2; j*j<=n; ++j) {
                if(n % j == 0) {
                    nIsPrime = false;
                    break;
                }
            }
            isPrime[n] = nIsPrime;
        }
    }

    public static void main(String args[]) {
        N = sc.nextInt();

        calPrime();

        for(int i=0; i<N; ++i) {
            int num; num = sc.nextInt();
            if(isPrime[num]) sum += 1;
        }

        System.out.println(sum);
    }
}
