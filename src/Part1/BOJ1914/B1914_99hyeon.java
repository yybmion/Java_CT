package Part1.BOJ1914;

import java.io.*;
import java.math.BigInteger;

public class B1914_99hyeon {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        BigInteger count = new BigInteger("2");

        bw.write(count.pow(num).subtract(new BigInteger("1")) + "\n");  //이동횟수 2^num - 1

        if(num <= 20){
            hanoi(num, 1, 2, 3);
        }

        bw.flush();
        bw.close();
        br.close();

    }

    private static void hanoi(int n, int from, int via, int to) throws IOException{

        if(n == 1){
            bw.write(from + " " + to + "\n");
        }
        else{
            hanoi(n-1, from, to, via);  // n-1개의 원판 1 -> 2 옮김
            bw.write(from + " " + to + "\n");   //제일 밑 원반 1 -> 3 옮김
            hanoi(n-1, via, from, to);  //n-1개의 원판 2 -> 3 옮김
        }
    }
}

/**
 * 하노이탐의 이동 횟수 = 2^N - 1 (N은 원판 갯수)
 *
 * 하노이 탑 기둥을 1(from), 2(via), 3(to)이라고 하고 원판의 갯수를 4개로 가정했을 경우
 * 원판 4를 1 -> 3으로 옮길려면
 * 원판 1,2,3을 1->2로 옮기고 원판 4를 1->3으로 옮기면 된다.
 * 그리고 원판이 1개만 있으면 바로 1->3으로 옮기면 된다.
 *
 * 그래서 else문의 첫번째 hanoi함수의 파라미터들은
 * 원판 1,2,3을 1->2로 옮겨야 한다.
 * 이 경우 1(from), 2(to), 3(via)가 되어 hanoi(n-1, from, to, via)로 설정해야한다
 *
 * 그 후 원판 4를 1->3으로 옮겨야 하므로 bw에 쓰고
 *
 * 옮겨진 원판 1,2,3을 2->3으로 옮겨야 하므로
 * 2 = from, 3 = to, 1 = via가 된다.
 * 따라서 hanoi(n-1, via, from, to)로 설정할 수 있다.
 *
 * ------------------------------------------------------------------------------------
 *
 * 이번에는 너무 어려웠다.
 * 내가 하노이 탑을 옮기는 상황을 컴퓨터로 적용시키는게 힘들었다.
 * 컴퓨터가 진짜 물리적으로 옮기는 것이 아닌데
 * 물리적으로 옮기는 것에 초점이 맞춰져있어서 구현하기 어려웠던 것 같다.
 * 사이트들을 참고하고 이해하고 다시 혼자 코드를 짜봐도 틀렸었다.
 * 그래도 사이트 참고하고 그냥 넘어가는 것보다 다시 짜보는게 훨씬 도움된다는 것을
 * 알고는 있었지만 더 몸소 느낄 수 있었던 것 같다.
 * 어려웠지만 새로운 것을 알게되어 성장했음을 느낀 하루였다. ㅎㅎ
 *
 * 참고사이트
 * https://devtitch.tistory.com/15
 */