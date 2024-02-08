import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pt1_2869_김지희 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        long result = c - b; // destination
        long cal = a - b; // dist

        long a1 = result / cal;
        long b1 = result % cal;

        int count = 0;
        if(b1 != 0)
        {
            System.out.println(a1+1);
        }
        else
        {
            System.out.println(a1);
        }
    }
}
/*
  브론즈이지만 조금 햇갈렸던 문제이다 !!
  밑의 페이지를 참고해서 풀었습니다... 그리고 길이를 long 으로 하는 것도 잊지 않기...
  https://velog.io/@lifeisbeautiful/Java-%EB%B0%B1%EC%A4%80-2869%EB%B2%88-%EB%8B%AC%ED%8C%BD%EC%9D%B4%EB%8A%94-%EC%98%AC%EB%9D%BC%EA%B0%80%EA%B3%A0-%EC%8B%B6%EB%8B%A4-%EC%9E%90%EB%B0%94
 */