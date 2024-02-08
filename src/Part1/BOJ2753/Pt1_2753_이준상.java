import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        //BufferedReader로 입력 더 빠르게 하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        

        if((a%4==0 && a%100!=0) || (a%4==0 && a%400==0)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
}
