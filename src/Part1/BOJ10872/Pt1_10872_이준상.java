import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static int f(int a){
        if(a == 0 || a == 1){
            return 1;
        }
        else{
            return a*f(a-1);
        }

    }
    public static void main(String[] args) throws Exception {
        //BufferedReader로 입력 더 빠르게 하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.println(f(Integer.parseInt(br.readLine())));
    }
}
