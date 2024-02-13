package Part1.BOJ4344;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B4344_llocr {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i<testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()); //학생수
            int[] student = new int[num];               //학생들 점수
            int sum = 0;                                //점수 총합

            for(int j=0; j<num; j++) {                  //점수 입력
                student[j] = Integer.parseInt(st.nextToken());
                sum += student[j];
            }

            double avg = (double) sum / num;            //평균 구하기
            int more = 0;                               //평균 넘은 학생 수

            for(int j = 0; j<num; j++) {                //평균 넘은 학생 수 구하
                if(student[j] > avg) {
                    more++;
                }
            }

            double ratio = (double) more / num * 100;   //평균 넘은 비율
            System.out.printf("%.3f%%\n", ratio);       //출력
        }

    }
}
