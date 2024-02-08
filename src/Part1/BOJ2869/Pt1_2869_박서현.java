package Part1.BOJ2869;

import java.io.*;
import java.util.StringTokenizer;

public class Pt1_2869_박서현 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());   //낮 동안 올라갈 수 있는 미터
        int B = Integer.parseInt(st.nextToken());   //밤 동안 미끄러지는 미터
        int V = Integer.parseInt(st.nextToken());   //막대기의 높이

        if((V-A) % (A - B) != 0){
            bw.write((V-A) / (A - B) + 2 + "\n");
        }
        else{
            bw.write((V-A) / (A - B) + 1 + "\n");
        }

//        int location = 0;
//        int day = 0;
//        while((location += A) < V){
//            location -= B;
//            day++;
//        }

        bw.flush();
        br.close();
        bw.close();
    }
}

/**
 * 한 번 막대기의 높이에 도달하면 더 이상 떨어지지 않는다.
 * 이 말은 올라가는 횟수와 미끄러지는 횟수가 다르다는 의미이다.
 *
 * 막대기의 높이에서 A를 뺀 만큼의 길이까지는 올라가는 횟수와 떨어지는 횟수가 같다.
 * 그러므로 막대기의 높이까지 올라가는 일수는 (막대기의 높이에서 A를 뺀 만큼의 길이까지 올라가는 일수 +1)이 된다.
 * 이것을 이용하면
 * A = 2, B = 1, V = 5인 경우
 * (V - A)인 5 - 2 = 3
 * 높이가 3까지 올라가는 일 수는 3 / (A - B) = 3 /(2 - 1) = 3 3일이 걸린다.
 * 그 다음날 낮동안 A(=2)만큼 올라가면 막대기의 높이에 다다른다.
 * 따라서 총 걸리는 횟수는 3일 + 1일인 4일이 나온다.
 *
 * 하지만 (V - A)의 높이까지 딱 맞게 올라갈 수 없는 경우도 존재한다.
 * A = 5, B = 1, V = 6인 경우
 * (V - A)인 6 - 5 = 1
 * 높이가 1까지 올라가는 일 수는 1 / (A - B) = 1 /(5 - 1) = 0으로
 * 몫이 0이 나온다. 따라서 나머지가 있는 경우에는 몫에 +1을 해준다.
 * 그리고 다음날 다시 A(=5)만큼 올라가면 막대기의 높이인 V에 도달 할 수 있다.
 * 따라서 수식으로 정리하면 if 조건문안에 +2를 해준다.
 *
 * ---------------------------------------------------------------------
 *
 * 처음에는 주석달린 코드로 돌렸더니 시간 초과가 발생하였다.
 * 그래서 반복문을 돌리면 안된다는 것을 깨닫고 코드를 어떻게 바꿔야할지 고민을 많이했다.
 * 하지만 코드보다도 수학적 지식이 더 필요했던 문제였다....
 * 이번 문제는 나의 고정관념이랄까...
 * 나의 생각을 더 유연하게 만들어주었다
 * 나름 재밌었다
 * 달팽이 녀석... 잘 땐 왜 떨어졌니
 * 나뭇잎에 붙어서 자지그랬니..ㅎ
 *
 */
