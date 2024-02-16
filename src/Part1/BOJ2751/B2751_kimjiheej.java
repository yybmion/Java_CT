import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class B2751_kimjiheej {

    public static void main(String[] args) throws IOException {

        // 오름차순으로 정렬하여라

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int c = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<c; i++){
            int a = Integer.parseInt(br.readLine());
            list.add(a);
        }

        Collections.sort(list);

        for(int a : list){
            sb.append(a+"\n");
        }
        System.out.println(sb.toString());
    }
}
/*
 Arrays.sort 는 시간 복잡도가 너무 커서 안된다.
 Collections.sort 를 사용하면 된다.
 생각을 해야 하는 부분이 Collections.sort 를 사용하게 되면
 list 계열의 배열들을 사용해 주어야 한다.
 또한 시간 복잡도를 줄이기 위해서 StringBuilder 를 사용해주자
 */
