package Part1.BOJ9663;

import java.util.Scanner;

public class Pt1_9663_임준혁 {

    public static final int MAX_GRID_LENGTH = 20;

    public static int N;

    public static int answer;

    public static boolean grid[][] = new boolean[MAX_GRID_LENGTH][MAX_GRID_LENGTH];

    public static Scanner sc = new Scanner(System.in);

    // pruning
    public static boolean isPromising(int rowBoundary) {
        if(rowBoundary == 0) return true;

        int currentRow = rowBoundary - 1;
        int currentCol = 0;
        for(int col=0; col<N; ++col) {
            if(grid[currentRow][currentCol]) {
                currentCol = col;
                break;
            }
        }

        for(int comparingRow=0; comparingRow<currentRow; ++comparingRow) {
            int targetCol=0;
            for(int col=0; col<N; ++col) {
                if(grid[comparingRow][col]) {
                    targetCol = col;
                    break;
                }
            }
            if(currentCol == targetCol) return false;
        }

        return true;
    }

    // 기본적으로 backtracking 은 dfs + pruning
    public static void dfs(int row) {

        // 모두 고려가 정상적으로 끝났다면 정답 + 1
        if(row > N) {
            answer += 1;
            return;
        }

        // 현재 queen 을 놓은 지점이 더 이상 진행에 의미가 없는 경우 종료 (pruning)
        if(!isPromising(row)) return;

        for(int col=0; col<N; ++col) {
            grid[row][col] = true;
            dfs(row+ 1);
            grid[row][col] = false;
        }

    }

    public static void main(String args[]) {

        N = sc.nextInt();

        dfs(0);

        System.out.println(answer);

    }

}
