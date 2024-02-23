package Part1.BOJ2750;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2750_llocr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //숫자 개수 입력 받기
        int[] arr = new int[n];

        for(int i = 0; i<n; i++) { //배열에 숫자 입력
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr); //오름차순으로 sort

        for(int i = 0; i<n; i++){ //순서대로 출력
            System.out.println(arr[i]);
        }
    }
}
