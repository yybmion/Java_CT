package Part1.BOJ10819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B10819_llocr {
    static int n;
    static int[] arr;
    static int[] result;
    static int max = Integer.MIN_VALUE;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        visit = new boolean[n];
        result = new int[n];

        // 값 받아내기
        for(int i = 0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void back(int depth) {
        if(depth == n) {
            int sum = 0;
            for(int i = 0 ; i<n-1; i++) {
                sum += Math.abs(result[i] - result[i+1]);
            }
            max = Math.max(max, sum);
            return;
        }
        for(int i = 0; i < n; i++) {
            if(!visit[i]) {
                visit[i] = true;
                result[depth] = arr[i];
                back(depth + 1);
                visit[i] = false;
            }
        }
    }
}

/*
* 백트래킹 문제
* 1. 갯수가 n인 조합을 구한다.
* 2. 백트래킹을 사용하여 depth가 n이 되도록 재귀를 수행하고, 조합의 결과는 result 배열에 저장한다.
* 3. depth가 n일 때 = 갯수가 n인 조합의 경우가 나왔을 때, 차이를 최대로 만드는 공식을 사용해 합을 구한다.
* 4. 합이 최대가 되도록 Math.max함수를 사용해 최댓값을 저장한다.
* */
