package Part2.BOJ2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2630_llocr {
    static int white = 0;
    static int blue = 0;
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        squareCheck(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void squareCheck(int row, int col, int size) {
        if(colorCheck(row, col, size) == true) {
            if(arr[row][col] == 0){
                white++;
            } else {
                blue++;
            }
            return;
        }

        int squareSize = size/2; //분할 정복을 할 수 있도록 새로운 size 구하기 -> 계속 반으로 줄여가면서 탐색

        squareCheck(row, col, squareSize);                                  //2
        squareCheck(row, col+squareSize, squareSize);                   //1
        squareCheck(row+squareSize, col, squareSize);                  //3
        squareCheck(row+squareSize, col+squareSize, squareSize);   //4


    }

    public static boolean colorCheck(int row, int col, int size) {
        int color = arr[row][col];

        for(int i = row; i<row+size; i++) {
            for(int j = col; j<col+size; j++) {
                if(arr[i][j] != color) return false;
            }
        }

        return true;
    }
}

/*
* 짜여진 코드를 보면 쉽게 이해할 수 있는데, 막상 코드를 짜려고 하면 답답하기만 하다 🥹
* 실력이 많이 부족해서 그런 것 같다. 완전 기초부터 탄탄하게 다져가는 작업이 필요할 것 같다!
* */
