import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        //BufferedReader로 입력 더 빠르게 하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        
        int c = Integer.parseInt(br.readLine());

        for(int i =0;i<c;i++){
            
            //입력들을 배열에 넣고 변수에 넣기
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            ArrayList<Integer> scores = new ArrayList<>();
            int sum = 0;
            while (st.hasMoreTokens()) {
                int score = Integer.parseInt(st.nextToken());
                scores.add(score);
                sum += score;
            }

            //평균설정
            float aver = (float)sum/num;
            
            //Collections을 활용해 리스트 정렬
            Collections.sort(scores);

            //평균을 넘은 점수 중에 가장 낮은 점수의 인덱스
            int overAverIndex = num;
            for(int j=0;j<num;j++){
                //평균 넘으면 인덱스 설정하고 break
                if((float)scores.get(j)>aver){
                    overAverIndex = j;
                    break;
                }
            }

            //결과값 출력
            System.out.println(String.format("%.3f", ((float)(num-overAverIndex)/num)*100)+"%");
        }
    }
}
