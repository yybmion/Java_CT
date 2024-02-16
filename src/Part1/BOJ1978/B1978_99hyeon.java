package Part1.BOJ1978;

import java.io.*;
import java.util.StringTokenizer;

public class B1978_99hyeon {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int check;  //check가 2면 소수
        int count = 0;  //소수 갯수 count

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < num; i++){
            int number = Integer.parseInt(st.nextToken());

            check = 0;
            for(int j = 1; j <= number; j++){
                if(number % j == 0){
                    check++;
                }
                else{
                    continue;
                }
            }

            if(check == 2){
                count++;
            }
        }

        bw.write(count + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}

/**
 *
 *입력값들을 배열에 저장하지 않고 입력 받자마자 소수인지 판별하도록 구성하였다
 *소수는 공약수가 1과 자기자신만 있어야 하므로
 * 입력 값을 1부터 자기자신까지 1씩 증가하여 나눴을 때
 * 나머지가 0이 되는 빈도수를 계산하여 소수를 판별하였다
 * 그 빈도수를 2로 설정하면 자연스럽게 1을 제외하며 소수를 추려낼 수 있어서
 * check가 2이면 소수의 갯수를 세는 변수인 count를 1씩 증가하였다.
 *
 */