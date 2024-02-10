package Part1.BOJ9663;

import java.util.Scanner;

public class B9663_limjunhyuk97 {

    public static final int MAX_GRID_LENGTH = 20;

    public static int N;

    public static int answer;

    public static int queens[] = new int[MAX_GRID_LENGTH];

    public static Scanner sc = new Scanner(System.in);

    // pruning
    public static boolean isPromising(int target) {
        if(target <= 0) return true;

        for(int row=0; row<target; ++row) {
            if(queens[row] == queens[target]) return false;
            if(Math.abs(queens[row]-queens[target]) == Math.abs(row-target)) return false;
        }

        return true;
    }

    // 기본적으로 backtracking 은 dfs + pruning
    public static void dfs(int row) {

        // 현재 queen 을 놓은 지점이 더 이상 진행에 의미가 없는 경우 종료 (pruning)
        if(!isPromising(row-1)) return;

        // 모두 고려가 정상적으로 끝났다면 정답 + 1
        if(row >= N) {
            answer += 1;
            return;
        }

        for(int col=0; col<N; ++col) {
            queens[row] = col;
            dfs(row+ 1);
        }

    }

    public static void main(String args[]) {

        N = sc.nextInt();

        dfs(0);

        System.out.println(answer);

    }

}
