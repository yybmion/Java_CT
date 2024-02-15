import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class B2869_samgashyeong {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());


        //(a-b) 길이로 갈 수 있는 임계치
        int limit = v-a;
        //임계치를 기준으로 했을 때 몇 일 날 갈 수 있는지 표현
        int count = (int)limit/(a-b);

        //만약 임계치와 하루에 갈 수 있는 길이가 나누어 떨어졌을 때 +1 아닐때 +2 
        if(limit%(a-b) == 0){
            System.out.println(count+1);
        }
        else{
            System.out.println(count+2);
        }
    }
}
