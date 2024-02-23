package Part1.BOJ2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2750_99hyeon {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int[] list = new int[num];

        for(int i = 0; i < num; i++){
            list[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(list);

        for(int i = 0; i < num; i++){
            System.out.println(list[i]);
        }

        br.close();
    }
}

/**
 * sort 함수 사용
 */
