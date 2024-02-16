import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.*;


public class B10989_kimjiheej {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int a = Integer.parseInt(br.readLine());

        int[] arr = new int[a];

        for(int i=0; i<a; i++){

            arr[i] = Integer.parseInt(br.readLine());

        }

        Arrays.sort(arr);

        for(int k : arr){
            sb.append(k+"\n");
        }

        System.out.println(sb.toString());


    }
}

/*

  어렵지는 않지만 StringBuilder 써주면 된다.
  코딩테스트에서는 그냥 Arrays.sort사용 하면 됨
  근데 왜 Collections.sort 는 에러가 나는 거지...?

 */
