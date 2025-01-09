package Part1.BOJ9663;

import java.io.*;

public class B9663_99hyeon {

    static int num;
    static int[] board;
    static int count = 0;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());
        board = new int[num];

        Nqueen(0);

        System.out.println(count);
        br.close();

    }

    private static void Nqueen(int order){

        if(order == num){
            count++;
            return;
        }

        for(int i = 0; i < num; i++){
            board[order] = i;

            if(posibility(order)){
                Nqueen(order + 1);
            }
        }

    }

    private static boolean posibility(int setting){
        for(int i = 0; i < setting; i++){

            //같은 행에 있는지 체크
            if(board[setting] == board[i]){
                return false;
            }

            //대각선 방향으로 있는지 체크
            else if(Math.abs(setting - i) == Math.abs(board[setting] - board[i])){
                return false;
            }
        }

        return true;
    }
}

/**
 *
 * 1차원 배열을 사용하여 배열의 인덱스는 열 배열의 값은 그 열에 있는 퀸의 자리 즉 행을 뜻한다.
 * 따라서 0번째 열에 위치한 퀸을 기준으로 다른 퀸들을 세팅하였다.
 *
 * Nqeen 함수는 모든 퀸들이 다 세팅되었다면 수를 카운트하고
 * 나머지 퀸들을 재귀호출하여 세팅하는 함수이다.
 *
 * posibility 함수는 퀸을 세팅할 때 다른 퀸들의 공격을 받지 않는지 체크한다.
 * 배열 값이 행을 뜻하므로 배열 값이 같으면 세팅하지 못하고
 * 배열값의 차이는 행간의 거리를 뜻하고 인덱스 값의 차이는 열간의 거리를 뜻하므로
 * 배열값의 차와 인덱스 값의 차가 같으면 같은 대각선상에 위치한 것이므로 퀸을 세팅하지 못한다.
 *
 * ------------------------------------------------------------------------------------
 *
 * 어휴....
 * 오늘 다시 풀어봤지만 그래도
 * 내일 한 번 다 지우고 다시 풀어봐야겠다.
 *
 * 참고 사이트
 * https://st-lab.tistory.com/118
 */
