package Part2.BOJ2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2805_llocr {
    static int N;
    static int M;
    static int[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);

        int start = 0;
        int end = tree[N-1];
        int result = 0;

        while(start <= end) {
            int mid = (start + end) / 2;
            long sum = 0;

            for(int i = 0; i<N; i++) {
                if(tree[i] > mid) {
                    sum += tree[i] - mid;
                }
            }

            if(sum < M) { //나무를 자른 것들의 합이 M보다 작다 -> 나무를 더 자르자!
                end = mid - 1;
            } else { //나무를 자른 것들의 합이 M보다 크다 -> 나무를 덜 자르자!
                result = mid;
                start = mid + 1;
            }
        }

        System.out.println(result);
    }
}

/*
* 이진탐색을 함수로 빼서 처리하려다가 그게 더 복잡시렵게 될 것 같아서 그냥 Main 내에서 다 처리를 했다
* */