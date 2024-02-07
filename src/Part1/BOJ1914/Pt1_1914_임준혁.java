package Part1.BOJ1914;

import java.math.BigInteger;
import java.util.Scanner;

public class Pt1_1914_임준혁 {

    public static int MAX_CNT = 105;

    public static int N;

    public static BigInteger dp[] = new BigInteger[MAX_CNT];

    public static Scanner sc = new Scanner(System.in);

    public static void hanoiString (int cnt, int from, int by, int to) {
        if(cnt < 2) {
            System.out.println(from + " " + to);
            return;
        } else {
            hanoiString(cnt-1, from, to, by);
            System.out.println(from + " " + to);
            hanoiString(cnt-1, by, from ,to);
        }
    }

    public static BigInteger hanoiDP (int cnt) {
        if(cnt < 2) return dp[cnt] = BigInteger.valueOf(1);
        else {
            return dp[cnt] = (dp[cnt-1] == null ? hanoiDP(cnt-1) : dp[cnt-1]).multiply(BigInteger.valueOf(2)).add(BigInteger.valueOf(1));
        }
    }

    public static void main(String[] args) {
        N = sc.nextInt();
        
        System.out.println(hanoiDP(N));

        if(N > 20) return;
        else hanoiString(N, 1, 2, 3);
    }

}
