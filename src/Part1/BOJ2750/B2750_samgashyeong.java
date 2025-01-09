import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B2750_samgashyeong {
    public static void main(String[] args) throws Exception {
        //BufferedReader로 입력 더 빠르게 하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(br.readLine());
        ArrayList<Integer> a = new ArrayList<>();
        for(int i =0;i<size;i++){
            a.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(a);

        for(int a1 : a){
            System.out.println(a1);
        }
    }
}
