package Part1.BOJ9663;

import java.util.Scanner;

public class B9663_llocr {
    static int[] q;
    static int n;
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();   //퀸의 개수
        q = new int[n];     //퀸을 놓을 배열

        Nqueen(0);

        System.out.println(answer);
    }

    public static void Nqueen(int num) {
        //퀸을 다 놓았으면 정답 증가
        if (num == n) {
            answer++;
            return;
        }

        //q[num]에 0에서부터 n까지 놓아보기
        for(int i = 0; i<n; i++) {
            q[num] = i;
            if(check(num)) { //퀸을 놓은 후, 이 자리가 유효한지 체크
                //놓아도 되는 자리라면, num+1 하여 다시 재귀 호출
                Nqueen(num+1);
            }
        }

    }

    public static boolean check(int num) {
        for(int i = 0; i<num; i++) {
            if(q[i] == q[num]) return false;
            //방금 놓은 퀸과 같은 행에 있는 퀸이 있는지 점검

            if(Math.abs(num-i) == Math.abs(q[num] - q[i])) return false;
            //대각선에 있는지 점검
        }

        return true;
    }
}

/*
* 체스를 모르기 때문에 퀸에게 공격을 받지 않는 방법에 대해서 참고하였다..!
* 참고 : https://velog.io/@dongchyeon/%EB%B0%B1%EC%A4%80-9663%EB%B2%88-N-Queen
*
* 1. 같은 행에 위치하면 안 된다.
* 2. 같은 열에 위치하면 안 된다.
* 3. 대각선상에 위치하면 안 된다.
*
* 문제를 풀면서 나는 컴퓨팅 사고력이 딸리는 것은 아닌지 의심하고 있다 🥹
* 좀 더 다양한 문제를 풀어볼 필요가 있는 것 같다
* */