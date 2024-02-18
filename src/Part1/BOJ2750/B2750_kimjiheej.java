import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2750_kimjiheej {

    public static void main(String[] args) throws IOException {


        // 오름차순으로 정렬하여라

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int c = Integer.parseInt(br.readLine());

        int[] array = new int[c];

        for(int i=0; i<c; i++){
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        for(int a : array){
            System.out.println(a);
        }

    }
}
/*
  sort 함수 사용하면 된다...!
 */
