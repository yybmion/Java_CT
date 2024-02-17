import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1629_kimjiheej {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long  a = Long.parseLong(st.nextToken());
        long  b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        long check = calculate(a,b,c);
        System.out.println(check);

    }

    public static long calculate(long a, long b, long c) {

        // 우선 재귀를 끝낼 수 있는 조건에 대해서 생각해 보아야 한다.

        if(b == 1)
            return a % c;
        long half = calculate(a,b/2,c); // 즉 이것은 a 의 b 승의 반을 c 로 나눈 나머지이다.

        long result = half * half % c;

        if(b % 2 ==0){
            return result;
        }
          else {
            return result * a % c; // 분배 법칙이니까 옆에도 나누어 주어야 한다
        }
    }
}
/*
  분배법칙을 잘 생각해 보면 된다.
  각각 지수를 반반으로 나누고 나눈 것의 나머지를 구한 후에 그 나머지에 계산을 해도 된다.
  
 */
