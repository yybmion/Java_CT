package Part1.BOJ10871;

import java.util.Scanner;

public class B10871_MinhoJJang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int X = sc.nextInt();

        int k;

        for (int i = 0; i < N; i++) {
            k = sc.nextInt();
            if (k < X) {
                System.out.print(k + " ");
            }
        }
    }
}
