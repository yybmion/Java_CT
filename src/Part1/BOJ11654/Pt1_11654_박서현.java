package Part1.BOJ11654;

import java.io.*;

public class Pt1_11654_박서현 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char input = br.readLine().charAt(0);
        int num = input;

        bw.write(num + "\n");
        //        bw.write(input - 65 + 65 + "\n");
        bw.flush();

        bw.close();
        br.close();
    }
}

/**
 *
 * 입력 예제를 보니 문자 1개씩만 주어져서 char로 입력을 받았다.
 * char를 int형으로 변환하면 ASCII로 나타낼 수 있다.
 *
 * 처음엔 어떻게 바꿀지 몰라 char로 입력받고
 * 그대로 출력해봤다.
 * 역시나 문자 그대로 출력되었다.
 * 그래서 도저히 모르겠어서 구글링을 해보니
 * char를 int형으로 변환시켜주면 아스키 코드 값으로 출력가능하다고 하였다.
 *
 * 코멘트를 적다가 순간적으로
 * 10진 숫자에 65를 더해 문자를 출력했었던 예전기억이 떠올랐다.
 * 그래서 입력받은 문자에 65를 빼고 65를 더해보았다.(코드에 주석처리된 부분)
 * ...된다
 * WoW~
 * 입력받은 문자에서 숫자를 빼려고 하자 문자에 해당되는 아스키코드 값이 사용되어
 * 연산이 돼서 아스키코드값이 출력되는건 아닌가싶다.
 *
 */
