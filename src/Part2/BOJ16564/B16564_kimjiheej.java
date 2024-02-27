package Part2.BOJ16564;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class B16564_kimjiheej {

    static long arr[];

    static int a;
    static long b;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());

        arr = new long[a];


        for(int i=0; i<a; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        long start = 1;
        //long end = arr[a-1] + b; // 이 범위 설정이 문제였음.
        long end = Integer.MAX_VALUE;
        long result =0;


        // 일단 level 을 정해야 한다.

        while(start<=end){

            long middle = (start+end)/2;
            if((check( middle)) <= b){
                result = middle;
                start = middle + 1;
            }
            else // 클 때에는 바로 줄여주어야 한다 아예 안들어가는거야 체크 포인트에
            {
                end = middle -1;
            }
        }
        System.out.println(result);
    }

    public static long check(long k){ // level 안에서 만족하는지 체크해준다

        long count= 0;

        for(int i=0; i<a; i++){
            if(arr[i] < k){ // level에서 값을 뺀 것이다.
                count += k - arr[i];
            }
        }
        return count;

    }
}
