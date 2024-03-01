package Part1.BOJ10819;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10819_99hyeon {

    static int n;
    static int[] arrA;
    static int[] result;
    static int max = Integer.MIN_VALUE;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arrA = new int[n];
        visit = new boolean[n];
        result = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        back(0);
        System.out.println(max);
    }

    static void back(int depth) {
        if (depth == n) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(result[i] - result[i + 1]);
            }
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[depth] = arrA[i];
                back(depth + 1);
                visit[i] = false;
            }
        }
    }
}

/**
 * 이해 중... 추후 추가
 */
