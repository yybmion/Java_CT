package Part1.BOJ10872;

import java.io.*;

public class B10872_99hyeon {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        bw.write(factorial(num) + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    public static int factorial(int num){
        if(num == 0){
            return 1;
        }else {
            return num * factorial(num - 1);
        }
    }
}

/**
 *
 * 0팩토리얼은 1이므로 조건문을 사용하여 따로 빼주었고
 * 1이상의 숫자는 1까지 곱하기 때문에
 * 재귀함수를 호출하여서 1씩 작은 수를 곱하도록 하였다.
 *
 * 재귀함수... 이론으로 배울땐 쉬웠는데
 * 막상 내가 생각해서 구상할려하니
 * 약간은 머리 띵--
 * 하핫
 *
 */
