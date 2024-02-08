import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        //BufferedReader로 입력 더 빠르게 하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String b = br.readLine();


        int a2 = a*Integer.parseInt(String.valueOf(b.charAt(2)));
        System.out.println(a2);
        int a1 = a*Integer.parseInt(String.valueOf(b.charAt(1)));
        System.out.println(a1);
        int a0 = a*Integer.parseInt(String.valueOf(b.charAt(0)));
        System.out.println(a0);
        System.out.println(a0*100+a1*10+a2);





    }
}
