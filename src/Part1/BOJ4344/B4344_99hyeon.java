package Part1.BOJ4344;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B4344_99hyeon {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        float avg;
        int numOver = 0;

        for(int i = 0; i < num; i++){
            ArrayList<Integer> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int studentNum = Integer.parseInt(st.nextToken());

            avg = 0;
            numOver = 0;
            for(int j = 0; j < studentNum; j++){
                list.add(Integer.parseInt(st.nextToken()));
                avg += list.get(j);
            }
            avg /= studentNum;

            for(int j = 0; j < studentNum; j++){
                if(list.get(j) > avg) {
                    numOver++;
                }
            }
            System.out.printf("%.3f%%\n", numOver/(float)studentNum*100);
        }

        br.close();
    }
}

/**
 * 
 * 동적 배열을 사용해서 사람들의 성적을 저장하였다.
 * 변수가 j인 첫번째 for루프에서는 학생들의 성적 평균을 계산하였고
 * 두번째 for루프에서는 평균을 넘는 사람들의 수를 카운트하였다.
 * 평소에 BufferedWriter를 사용하여 화면에 출력했지만
 * 소수점 셋째자리까지 그 함수를 사용해 하는 법을 몰라
 * 이번에는 다르게 출력하였다.
 * 
 * 처음에 로직을 짰을땐 출력값이 계속 이상하였는데 내가 조건을 잘 못 달았었다.
 * 평균보다 높은 사람인데 평균 이상인 사람으로 설정을 하여서
 * 값이 계속 이상하였다....ㅠ
 * 
 * 그리고 또 바보같은 실수를 하였다
 * 코드를 백준에 복붙할 때 라이브러리들을 빼고 복붙하여 컴파일 에러가 났다
 * 이런 바보같은 실수를 하다니!!!
 * 이번 문제는 잡다한 실수가 많았던것 같다...큐큐
 * 
 */
