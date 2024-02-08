import java.io.*;
import java.util.StringTokenizer;

public class Pt1_4344_김지희 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());

            int[] array = new int[a];

            float total = 0;
            for(int j=0; j<a; j++){
                array[j] = Integer.parseInt(st.nextToken());
                total += array[j];
            }

            // 평균을 계산해주어야 한다

            float avg = total / a;
            int count = 0;

            for(int k=0; k<a; k++){
                if(array[k] > avg)
                    count++;
            }
            float result = ((float)count/a) * 100;

            bw.write(String.format("%.3f",result));
            bw.write("%");
            bw.newLine();
        }

        bw.close();
    }
}
/*
 햇갈렸던 포인트는
     float result = ((float)count/a) * 100;
     이 부분이다. 정수끼리 나눗셈을 해버리면 나머지가 없을 때에 소수점이하의 값이 버려지기 때문에 !!
     count 나 a 둘중 하나를 무조건 float 로 해야한다.

     그리고 bw.write 을 사용하여 String.format 으로 소수점 3재짜리 까지 출력할 수 있다.
     bw.newLine() 은 줄바꿈이다.
 */
