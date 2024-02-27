import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;



public class B1914_samgashyeong {

    //원래 풀었던 문제라서 낯설진 않았지만, 큰 정수를 다룰 때 어떻게 다뤄야되는지 몰랐던 상태라 삽질을 좀 했던 문제.
    public static ArrayList<String> sarr = new ArrayList<>();

    public static void f(int start, int mid, int end, int num){
        if(num == 1){
            sarr.add(start+ " " + end);
            return;
        }

        f(start, end, mid, num-1);
        sarr.add(start+ " " + end);
        f(mid, start, end, num-1);

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int a = Integer.parseInt(br.readLine());

    
        BigInteger count = new BigInteger("2");
        
        

        //처음에 long썼다가 100을 입력했을 때 원하는 값이 안 나와서 삽질을 좀 했다. 검색을 하다가 BigInteger라는 라이브러리가 있길래 빠르게 공부하고 써봤다.
        System.out.println(count.pow(a).subtract(new BigInteger("1")));

        if(a<=20){
            f(1, 2, 3, a);
            for(String str : sarr){
                System.out.println(str);
            }
        }
    }
}
